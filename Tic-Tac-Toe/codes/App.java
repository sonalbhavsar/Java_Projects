
// import the Board class from board package
import board.Board;

// import Player class from player package
import player.Player;

// import Game class from game package
import game.Game;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("first project -> Tic Tac Toe Game!");

        Board b = new Board(3, '-');
        // b.printBoardCofig();

        // Scanner scn = new Scanner(System.in);
        // System.out.println("Enter the name of the player: ");
        // String name = scn.nextLine();
        // System.out.println("Enter the symbol of the player: ");
        // char symbol = scn.next().charAt(0);

        Player p1 = new Player();
        p1.setPlayerNameandSymbol("sonal", 'O');
        p1.getPlayerNameandSymbol();

        Player p2 = new Player();
        p2.setPlayerNameandSymbol("vidhi", 'X');
        p2.getPlayerNameandSymbol();

        Game game = new Game(new Player[] { p1, p2 }, b);
        game.play();

    }
}
