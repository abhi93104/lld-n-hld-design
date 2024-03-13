package LLD.TicTacToe;

import lombok.Data;

import java.util.*;

@Data
public class Game {

    private int size;
    private int emptyCellsLeft;
    private Board board;
    private Deque<Player> playerList;
    private Stack<Move> moveHistory;
    private GameStatus gameStatus;
    private ScoreBoard scoreBoard;
    private Scanner sc;


    List<Map<String, Integer>> rowSymbolCount;
    List<Map<String, Integer>> colSymbolCount;
    Map<String, Integer> mainDiagonalSymbolCount;
    Map<String, Integer> oppDiagonalSymbolCount;

    public Game(int size){
        sc = new Scanner(System.in);
        this.size = size;
        this.emptyCellsLeft = size * size;
        this.board = new Board(size);
        this.moveHistory = new Stack<>();
        this.playerList = new ArrayDeque<>();
        this.scoreBoard = new ScoreBoard();
        this.gameStatus = GameStatus.NOT_STARTED;
        this.rowSymbolCount = new ArrayList<>();
        this.colSymbolCount = new ArrayList<>();
        for(int i = 0; i<size ; i++){
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
        this.mainDiagonalSymbolCount = new HashMap<>();
        this.oppDiagonalSymbolCount = new HashMap<>();
    }


    public void addPlayers(Player p) throws TicTacToeException {
        if(gameStatus.equals(GameStatus.NOT_STARTED)) {
            playerList.add(p);
        }else{
            throw new TicTacToeException("Game already started or finished");
        }
    }

    public void startGame(){
        this.gameStatus = GameStatus.INPROGRESS;
        int retry;
        board.printBoard();
        while(!playerList.isEmpty()){
            if(!gameStatus.equals(GameStatus.INPROGRESS)){
                break;
            }
            Player p = playerList.pollFirst();
            playerList.add(p);
            retry = 3;
            while(retry>0) {
                Thread timer = startTimer();
                Move playerMove = playerInput(p, timer);
                if(timer.isAlive()) {
                    stopTimer(timer);
                }
                try {
                    this.board.markMove(playerMove);
                    this.moveHistory.add(playerMove);
                    this.emptyCellsLeft--;
                    board.printBoard();
                    if(checkIfGameWon(playerMove)){
                        System.out.printf("Congratulations %s won the game", p);
                        scoreBoard.updateScoreBoard(p);
                        endGame();
                        break;
                    }else if(isGameDraw()){
                        System.out.println("No space left to play. Game is draw");
                        endGame();
                        break;
                    }
                    System.out.println("Do you want to undo move? y/n");
                    String resp = sc.nextLine();
                    if(resp.equals("y")) {
                        System.out.println("How many moves you want to undo?");
                        int noOfUndoMoves = sc.nextInt();
                        sc.nextLine();
                        undoListOfMoves(noOfUndoMoves);
                    }
                    break;
                } catch (TicTacToeException e) {
                    System.out.println(e.getMessage());
                    retry--;
                }
            }
        }
    }

    private boolean checkMapForGameWon(Map<String, Integer> map, Symbol symbol){
        int count = 0;
        if(map.containsKey(symbol.name())){
            count = map.get(symbol.name()) + 1;
            map.put(symbol.name(), count);
            if(count == size){
                return true;
            }
        }else{
            map.put(symbol.name(), count+1);
        }
        return false;
    }
    private boolean checkIfGameWon(Move m){
        int row = m.getRow();;
        int col = m.getCol();
        if(checkMapForGameWon(rowSymbolCount.get(row), m.getPlayer().getSymbol())
                || checkMapForGameWon(colSymbolCount.get(col), m.getPlayer().getSymbol())){
            return true;
        }
        if(row == col && checkMapForGameWon(mainDiagonalSymbolCount, m.getPlayer().getSymbol())){
            return true;
        }
        if(row+col == size-1 && checkMapForGameWon(oppDiagonalSymbolCount, m.getPlayer().getSymbol())){
            return true;
        }
        return false;
    }

    private boolean isGameDraw(){
        return emptyCellsLeft <= 0;

    }

    private void endGame(){
        this.board.printBoard();
        this.gameStatus = GameStatus.FINISED;
    }

    public void resetGame(){
        this.gameStatus = GameStatus.NOT_STARTED;
        this.playerList = new ArrayDeque<>();
        this.moveHistory = new Stack<>();
        this.board.resetBoard();
    }

    public Thread startTimer(){
        Thread timer = new Thread(()->{
            int time = Constants.TIMER;
            while(time > 0) {
                try {
                    System.out.printf("%d time left.\n", time);
                    Thread.sleep(10000);
                    time -= 10;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Time up!!");
        });
        timer.start();
        return timer;
    }

    public void stopTimer(Thread timer){
        timer.interrupt();
    }

    private void undoMove(){
        if(! moveHistory.isEmpty()) {
            Move undoMove = moveHistory.pop();
            Symbol symbol = undoMove.getPlayer().getSymbol();
            rowSymbolCount.get(undoMove.getRow()).put(symbol.name(), rowSymbolCount.get(undoMove.getRow()).get(symbol.name()) - 1);
            colSymbolCount.get(undoMove.getCol()).put(symbol.name(), colSymbolCount.get(undoMove.getCol()).get(symbol.name()) - 1);
            if(mainDiagonalSymbolCount.containsKey(symbol.name()))
                mainDiagonalSymbolCount.put(symbol.name(), mainDiagonalSymbolCount.get(symbol.name()) - 1);
            if(oppDiagonalSymbolCount.containsKey(symbol.name()))
                oppDiagonalSymbolCount.put(symbol.name(), oppDiagonalSymbolCount.get(symbol.name()) - 1);
            this.board.undoMoveOnBoard(undoMove.getRow(), undoMove.getCol());
            playerList.addFirst(playerList.pollLast());
            emptyCellsLeft++;
        }
    }

    public void undoListOfMoves(int noOfMoves){
        for(int i=0 ; i<noOfMoves ; i++){
            undoMove();
        }
        board.printBoard();
    }

    public Move playerInput(Player player, Thread timer){
        System.out.printf("PlayerId: %s\nPlayer Name: %s. Select row and columns on the board to make a move.%n", player.getPlayerId(), player.getName());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row and column\n");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Move(row, col, player);

    }



    // TODO: Create UML diagram
    // TODO: Implement timer feature
    // TODO: Create test cases
    // TODO: Upload to github
    public static void main(String[] args) throws TicTacToeException {

        Game game = new Game(4);
        game.addPlayers(new Player("Abhishek", Symbol.O));
        game.addPlayers(new Player("Honey", Symbol.X));
        game.addPlayers(new Player("Shubham", Symbol.A));
        game.startGame();
        game.resetGame();
    }

}
