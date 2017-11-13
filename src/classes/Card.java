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
   * Card constructor. Initializes the instance variables upon instantiation.
   * @param  shape
   * @param  color
   * @param  number
   * @param  shading
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
   * @param  card1
   * @param  card2
   * @param  card3
   * @return boolean
   */
  public static boolean isSet(Card card1, Card card2, Card card3) {
    // Check the color
    if (!((card1.COLOR == card2.COLOR) && (card2.COLOR == card3.COLOR)
        || (card1.COLOR != card2.COLOR) && (card1.COLOR != card3.COLOR) && (card2.COLOR != card3.COLOR))) {
      return false;
    }

    // Check the number
    if (!((card1.NUMBER == card2.NUMBER) && (card2.NUMBER == card3.NUMBER)
        || (card1.NUMBER != card2.NUMBER) && (card1.NUMBER != card3.NUMBER) && (card2.NUMBER != card3.NUMBER))) {
      return false;
    }

    // Check the shading
    if (!((card1.SHADING == card2.SHADING) && (card2.SHADING == card3.SHADING)
        || (card1.SHADING != card2.SHADING) && (card1.SHADING != card3.SHADING) && (card2.SHADING != card3.SHADING))) {
      return false;
    }

    // Check the shape
    if (!((card1.SHAPE == card2.SHAPE) && (card2.SHAPE == card3.SHAPE)
        || (card1.SHAPE != card2.SHAPE) && (card1.SHAPE != card3.SHAPE) && (card2.SHAPE != card3.SHAPE))) {
      return false;
    }

    // If nothing above has been met, then a set has been formed and return true
    return true;
  }

}
