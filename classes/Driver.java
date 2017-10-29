/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 10/29/17
 * Date last modified: 10/29/17
 * Description: Driver for the program (includes main method)
 */

package classes;

public class Driver {

  public static void main(String[] args) {

    Deck testDeck = new Deck();
    Board board = new Board(testDeck);

    board.add3(testDeck);
    System.out.println(board);

  }

}
