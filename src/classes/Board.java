/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 10/29/17
 * Date last modified: 12/4/17
 * Description: Represents a board filled with all 12 board squares (initially)
 * and includes a number of methods that can be applied to the board
 */

package classes;

import java.util.ArrayList;

public class Board {
  // Instance variables
  protected ArrayList<ArrayList<BoardSquare>> board = new ArrayList<>();

  /**
   * Default constructor that fills the board with four rows and three columns
   * of BoardSquares, which are assigned a certain card from the deck
   */
  public Board(Deck deck) {
    // Iterate through each row
    for (int i = 0; i < 3; i++) {
      ArrayList<BoardSquare> row = new ArrayList<>();

      // Iterate through each column
      for (int j = 0; j < 4; j++) {
        // Get the next card from the deck and assign it the board square
        Card card = deck.getTopCard();
        BoardSquare boardSquare = new BoardSquare(card, i, j);

        // Add the row of board squares to the "row" array list
        row.add(boardSquare);
      }
      // Add the row to the board array list
      board.add(row);
    }
  }

  /**
   * The toString implementation for the board
   * @return String output
   */
  @Override
  public String toString() {
    // Local variables
    String output = "";

    // Get the current row
    for (int i = 0; i < board.size(); i++) {
      ArrayList<BoardSquare> boardSquareArrayList = board.get(i);
      output += "\n\n";

      // Get the current "column" or current board square
      for (int j = 0; j < boardSquareArrayList.size(); j++) {
        BoardSquare boardSquare = boardSquareArrayList.get(j);

        // Get the card assigned to this board square and add it to output
        Card currentCard = boardSquare.getCard();
        output += String.format("%40s", currentCard);
      }

    }

    return output;
  }

  /**
   * Replace the card at a given row and column, or board square
   * @param card
   * @param row
   * @param col
   */
  public void replaceCard(Card card, int row, int col) {
    // Get the row array list
    ArrayList<BoardSquare> boardSquareArrayList = board.get(row);

    // Get the board square at the column
    BoardSquare boardSquare = boardSquareArrayList.get(col);

    // Replace the card
    boardSquare.setCard(card);
  }

  /**
   * Return the board square at the given row and column
   * @param  row
   * @param  col
   * @return BoardSquare boardSquare
   */
  public BoardSquare getBoardSquare(int row, int col) {
    ArrayList<BoardSquare> boardSquareArrayList = board.get(row);
    BoardSquare boardSquare = boardSquareArrayList.get(col);

    return boardSquare;
  }
  
  /**
   * Add three cards from the deck to the board
   * @param deck
   */
  public void add3(Deck deck) {
    for (int i = 0; i < board.size(); i++) {
      // Get a new card
      Card card = deck.getTopCard();

      // Get the current board square array list
      ArrayList<BoardSquare> boardSquareArrayList = board.get(i);

      // Get the last column
      int col = boardSquareArrayList.size();

      // Create a new board square and add it to the current row
      BoardSquare boardSquare = new BoardSquare(card, i, col);
      boardSquareArrayList.add(boardSquare);

      // Add to the board
      board.set(i, boardSquareArrayList);
    }
  }

  /**
   * Return the card at a given board square
   * @param  row
   * @param  col
   * @return Card card
   */
  public Card getCard(int row, int col) {
    // Local variables
    Card card;

    // Get the row array list
    ArrayList<BoardSquare> boardSquareArrayList = board.get(row);

    // Get the board square at the column and return the card
    BoardSquare boardSquare = boardSquareArrayList.get(col);
    card = boardSquare.getCard();

    return card;
  }
  
  /**
   * Return the number of rows for the board
   * @return int numRows
   */
  public int numRows() {
    // Local variables
    int numRows;

    // Get the size of the board, or the number of rows
    numRows = board.size();

    return numRows;
  }

  /**
   * Return the number of columns for the board
   * @return int numCols
   */
  public int numCols(int row) {
    // Local variables
    int numCols;

    // Get the size of an individual row, or the number of columns
    ArrayList<BoardSquare> boardSquareArrayList = board.get(row);
    numCols = boardSquareArrayList.size();

    return numCols;
  }

}
