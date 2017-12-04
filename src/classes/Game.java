/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 11/12/17
 * Date last modified: 12/4/17
 * Description: The class for the game. Ties all of the supporting classes
 * together to allow the user to play.
 */

package classes;

import java.util.ArrayList;

/**
 *
 * @author mguay22
 */
public class Game {
    
    // Instance Variables
    private Deck deck = new Deck();
    protected Board board = new Board(deck);
    private ArrayList<BoardSquare> selected = new ArrayList<>();
    
    /**
     * toString implementation for the game (board)
     * @return 
     */
    @Override
    public String toString() {
        return board.toString();
    }
    
    /**
     * Determine if the deck has any cards in it
     * @return boolean 
     */
    public boolean outOfCards() {
        return deck.isEmpty();
    }
    
    /**
     * Add a board square to the selected array list based off of user provided
     * row and column
     * @param row
     * @param col 
     */
    public void addToSelected(int row, int col) {
        // Subtract one to account for indexing
        BoardSquare boardSquare = board.getBoardSquare(row, col);
        selected.add(boardSquare);
    }
    
    /**
     * Return the number of currently selected board squares
     * @return integer 
     */
    public int numSelected() {
        return selected.size();
    }
    
    /**
     * Tests to see if the three cards in the selected array list are a set.
     * If they are, replace the cards and remove the set from the deck,
     * otherwise just clear out the selected array list
     */
    public boolean testSelected() {
        
        // Local variables
        
        // Get cards
        Card card1 = selected.get(0).getCard();
        Card card2 = selected.get(1).getCard();
        Card card3 = selected.get(2).getCard();
              
        // If a set is formed, add a new card to board squares and remove the set
        // cards from the deck
        if (Card.isSet(card1, card2, card3)) {
            deck.removeCard(card1);
            deck.removeCard(card2);
            deck.removeCard(card3);

            selected.get(0).setCard(deck.getTopCard());
            selected.get(1).setCard(deck.getTopCard()); 
            selected.get(2).setCard(deck.getTopCard());
            
            System.out.println("Set!");
            
            // Clear the selected list
            selected.clear();
            
            // Update the deck size
            deck.setDeckSize();
            
            return true;
        } else {
            // No set, clear the selected array list
            System.out.println("Not a set!");
            selected.clear();
            
            return false;
        }

    }
    
    /**
     * Removes the provided board square from the selected list
     * @param row
     * @param col 
     */
    public void removeSelected(int row, int col) {
        // If any of the selected board squares match the row & col - remove them
        for (int i = 0; i < selected.size(); i++) {
            if (selected.get(i).getRowNumber() == row - 1 && selected.get(i).getColNumber() == col - 1) {
                selected.remove(i);
            }
        }
    }
    
    /**
     * Adds three cards - one to each row
     */
    public void add3() {
        board.add3(deck);
    }
    
    /**
     * Returns the currently selected cards
     * @return 
     */
    public ArrayList getSelected() {
        return selected;
    }
    
    /**
     * Returns the current games board
     * @return 
     */
    public Board getBoard() {
        return board;
    }
    
    /**
     * Return the deck
     * @return 
     */
    public Deck getDeck() {
        return deck;
    }
    
}
