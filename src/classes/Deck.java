/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 10/29/17
 * Date last modified: 10/29/17
 * Description: Represents a deck of 81 cards and contains methods that can be
 * applied to those cards, such as shuffle(), also contains getters and setters
 */

package classes;

import java.util.ArrayList;
import java.util.Collections;
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
      
    for (int number = 0; number < 3; number++) {
        for (int shape = 0; shape < 3; shape ++) {
            for (int shading = 0; shading < 3; shading++) {
                for (int color = 0; color < 3; color++) {
                    Card card = new Card(Card.Shape.values()[shape],
                            Card.Color.values()[color],
                            Card.Number.values()[number],
                            Card.Shading.values()[shading]);
                    
                    deck.add(card);
                }
            }
        }
    }

}

  /**
   * Shuffles the ArrayList deck
   */
  public void shuffle() {
    int newIndex;
    
    // Swap method taken from 
    http://www.java2s.com/Code/Java/Collections-Data-Structure/SwapelementsofJavaArrayList.htm  
    for (int i = 0; i < 81; i++) {
        newIndex = random.nextInt(81);
        Collections.swap(deck, i, newIndex);
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

    // Move the card to the bottom of the deck
    deck.add(deck.remove(0));

    return topCard;
  }
 

}
