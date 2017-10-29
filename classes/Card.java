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
    // Local output String variable
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
    // TODO: Compare the three cards and see if they form a set
  }

}
