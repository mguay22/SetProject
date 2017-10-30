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

    Deck d = new Deck();
    d.shuffle();
    Board b = new Board(d);
    System.out.println(b);
    System.out.println(b.getCard(0, 0));
    System.out.println(b);
    if (Card.isSet(b.getCard(0, 0), b.getCard(0, 1), b.getCard(0, 2)))
      System.out.println("set");
    else
      System.out.println("not a set");

  }

}
