package LLD.TicTacToe;

import lombok.Data;

@Data
public class Board {

    private int size;
    private Symbol[][] boardSpace;

    public Board(int size) {
        this.size = size;
        this.boardSpace = new Symbol[size][size];
    }

    public void resetBoard(){
        this.boardSpace = new Symbol[size][size];
    }

    public void markMove(Move m) throws TicTacToeException {
        isMoveValid(m);
        boardSpace[m.getRow()][m.getCol()] = m.getPlayer().getSymbol();
    }

    private void isMoveValid(Move m) throws TicTacToeException {
        if(m.getRow() >= 0 && m.getRow() < size && m.getCol() >= 0 && m.getCol() < size){
            if(boardSpace[m.getRow()][m.getCol()] != null){
                throw new TicTacToeException("Cell you chose is already occupied. Please try again\n");
            }
        }else{
            throw new TicTacToeException(String.format("Row or column is out of limit. It should be be within 0 to %d", size-1));
        }
    }

    public void undoMoveOnBoard(int row, int col){
        this.boardSpace[row][col] = null;
    }

    public void printBoard(){
        int counter = 0;
        System.out.print("   ");
        System.out.println();
        for(int i = 0;i < size;i++){
            for(Symbol cell : boardSpace[i]){
                System.out.printf("%s ", cell != null ? cell.name() : "*");
            }
            System.out.println();
        }
    }
}
