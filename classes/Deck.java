package classes;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
  // Instance Variables
  private ArrayList<Card> deck = new ArrayList<>();
  private Random random = new Random();
  private int deckSize = deck.size();
  private Card topCard;

  /**
   * Default constructor that creates the 81 card deck
   */
  public Deck() {
    // Loop through 81 times to construct the deck. Use Random to generate
    // random card attributes
    for (int i = 0; i <= 81; i++) {
      // Implementation of getting a random value from an enum in java
      // taken from: https://stackoverflow.com/questions/1972392/java-pick-a-random-value-from-an-enum

      // Get a random shape
      int randomShapeInt = random.nextInt(Card.Shape.values().length);
      Card.Shape shape = Card.Shape.values()[randomShapeInt];

      // Get a random color
      int randomColorInt = random.nextInt(Card.Color.values().length);
      Card.Color color = Card.Color.values()[randomColorInt];

      // Get a random number
      int randomNumberInt = random.nextInt(Card.Number.values().length);
      Card.Number number = Card.Number.values()[randomNumberInt];

      // Get a random shading
      int randomShadingInt = random.nextInt(Card.Shading.values().length);
      Card.Shading shading = Card.Shading.values()[randomShadingInt];

      // Create a new card and add it to the deck
      Card card = new Card(shape, color, number, shading);
      deck.add(card);
    }

  }

  /**
   * Shuffles the ArrayList deck
   */
  public void shuffle() {
    for (int i = 0; i < deckSize; i++) {
      // Get a random card
      int randomIndex = random.nextInt(deckSize);
      Card randomCard = deck.get(randomIndex);

      // Replace each index with a random card in the deck
      deck.set(i, randomCard);
    }
  }

  /**
   * Return a string representation of the ArrayList deck
   * @return String output
   */
  @Override
  public String toString() {
    // Local variables
    String output = "";
    int cardNumber = 0;
    for (Card card : deck) {
      output += "Card Number: " + cardNumber + "\n" + card + "\n\n";
      cardNumber++;
    }

    return output;
  }

  /**
   * Checks to see if the current deck is empty
   * @return boolean
   */
  public boolean isEmpty() {
    if (deckSize == 0) {
      return true;
    }

    return false;
  }

  /**
   * Return the card that is on "top" of the deck, or index 0
   * @return Card topCard
   */
  public Card getTopCard() {
    topCard = deck.get(0);
    return topCard;
  }

}
