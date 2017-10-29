/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 10/29/17
 * Date last modified: 10/29/17
 * Description: Represents a single card in the game of set and contains
 * a method to check if three cards form a set
 */

package classes;

public class Card {
  // Instance Variables

  // Set up enums to represent each set of features
  protected enum Shape {
    OVAL, SQUIGGLES, DIAMONDS
  }

  protected enum Color {
    RED, PURPLE, GREEN
  }

  protected enum Number {
    ONE, TWO, THREE
  }

  protected enum Shading {
    SOLID, STRIPED, OUTLINED
  }

  // Constants
  private final Shape SHAPE;
  private final Color COLOR;
  private final Number NUMBER;
  private final Shading SHADING;

  /**
   * Card constructor. Intitalizes the instance variables upon instantiation.
   * @param  Shape   shape
   * @param  Color   color
   * @param  Number  number
   * @param  Shading shading
   */
  public Card(Shape shape, Color color, Number number, Shading shading) {
    this.SHAPE = shape;
    this.COLOR = color;
    this.NUMBER = number;
    this.SHADING = shading;
  }

  /**
   * toString implementation of Card class
   * @return String output
   */
  @Override
  public String toString() {
    // Local variables
    String output;

    output = String.format("%s_%s_%s_%s", NUMBER, COLOR, SHAPE, SHADING);
    return output;
  }

  /**
   * Takes three cards as parameters and returns true if they form a set
   * @param  Card card1
   * @param  Card card2
   * @param  Card card3
   * @return boolean
   */
  public static void findSet(Card card1, Card card2, Card card3) {
    // TODO: Check to see if the cards are the same
  }

}
