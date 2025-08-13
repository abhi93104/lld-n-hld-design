package LLD.TicTacToe;

public class Demo {

    // TODO: Create UML diagram
    // TODO: Bug fix
    // TODO: Implement timer feature properly
    // TODO: Create more test cases
    public static void main(String[] args) throws TicTacToeException {

        Game game = new Game(4);
        game.addPlayers(new Player("Abhishek", Symbol.O));
        game.addPlayers(new Player("Honey", Symbol.X));
        game.addPlayers(new Player("Shubham", Symbol.A));
        game.startGame();
        game.resetGame();
    }
}
