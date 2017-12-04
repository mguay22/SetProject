/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 10/29/17
 * Date last modified: 12/4/17
 * Description: Represents a board square which contains a column a row
 * and a card 
 */

package classes;

public class BoardSquare {
  // Instance variables
  private Card card;
  private int rowNumber;
  private int colNumber;

  /**
   * Constructor that builds a board square for the card using the given
   * row and column numbers
   * @param  card
   * @param  rowNumber
   * @param  colNumber
   */
  public BoardSquare(Card card, int rowNumber, int colNumber) {
    this.card = card;
    this.rowNumber = rowNumber;
    this.colNumber = colNumber;
  }

  /**
   * Returns a boolean based off of whether or not the current board
   * square matches the one that is passed in
   * @param  rowNumber
   * @param  colNumber
   */
  public boolean isSelected(int rowNumber, int colNumber) {
    if (this.rowNumber == rowNumber && this.colNumber == colNumber) {
      return true;
    }

    return false;
  }

  /**
   * Return the card at the current board square
   * @return Card card
   */
  public Card getCard() {
    if (this.card == null) {
        return null;
    }
      
    return card;
  }
  
  /**
   * Removes a card by setting it to tull
   */
  public void removeCard() {
      this.card = null;
  }

  /**
   * Set the card at the current board square
   * @param card
   */
  public void setCard(Card card) {
    this.card = card;
  }

  /**
   * Get the row number for the current board square
   * @return rowNumber
   */
  public int getRowNumber() {
    return rowNumber;
  }

  /**
   * Set the row number for the current board square
   * @param rowNumber
   */
  public void setRowNumber(int rowNumber) {
    this.rowNumber = rowNumber;
  }

  /**
   * Get the column number for the current board square
   * @return int colNumber
   */
  public int getColNumber() {
    return colNumber;
  }

  /**
   * Set the column number for the current board square
   * @param colNumber
   */
  public void setColNumber(int colNumber) {
    this.colNumber = colNumber;
  }
  
  /**
   * BoardSquare toString implementation
   * @return String output
   */
  @Override
  public String toString() {
      String output;
      output = String.format("%s", card);
      return output;
  }
}
