package classes;

public class BoardSquare {
  // Instance variables
  private Card card;
  private int rowNumber;
  private int colNumber;

  /**
   * Constructor that builds a board square for the card using the given
   * row and column numbers
   * @param  Card card
   * @param  int  rowNumber
   * @param  int  colNumber
   */
  public BoardSquare(Card card, int rowNumber, int colNumber) {
    this.card = card;
    this.rowNumber = rowNumber;
    this.colNumber = colNumber;
  }

  /**
   * Returns a boolean based off of whether or not the current board
   * square matches the one that is passed in
   * @param  int rowNumber
   * @param  int colNumber
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
    return card;
  }

  /**
   * Set the card at the current board square
   * @param Card card
   */
  public void setCard(Card card) {
    this.card = card;
  }

  /**
   * Get the row number for the current board square
   * @return int rowNumber
   */
  public int getRowNumber() {
    return rowNumber;
  }

  /**
   * Set the row number for the current board square
   * @param int rowNumber
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
   * @param int colNumber
   */
  public void setColNumber(int colNumber) {
    this.colNumber = colNumber;
  }
}
