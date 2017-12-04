/*
 * By: Michael Guay
 * Class: Java 110
 * Date created: 11/20/17
 * Date last modified: 12/4/17
 * Description: The GUI class that ties in all of the other classes for Set
 */

package classes;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class GUI extends Application {
    // Instance variables
    private Game game;
    private GridPane grid;
    private Scene scene;
    private Board board;
    private ArrayList selected;
    private Button addThree;
    private Button exit;
    private Button hint;
    private Button newGame;
    private Text text;
    
    /**
     * Constructor, initialize all necessary variables
     */
    public GUI() {
       // Init grid and selected list
       grid = new GridPane();  
       selected = new ArrayList<>();
       grid.setStyle("-fx-background-color: white");
               
       // Init Game
       game = new Game();  
       
       // Set the board we're using
       board = game.board;    
    }
    
   /**
    * Start method for GUI
    * @param primaryStage 
    */
   @Override
   public void start(Stage primaryStage) {
       primaryStage.setTitle("Set");
       drawBoard();

       scene = new Scene(grid, 1200, 700);
       primaryStage.setScene(scene);
       primaryStage.show();
       
       // Click Handler
       clickHandler();
   }
   
   /**
    * Method that draws the actual board that the user will interact with
    * also adds shapes and text essential for running the program
    */
   public void drawBoard() {
       int numRows = board.numRows();
       HBox row = new HBox();
       
       // Iterate through each row
       for (int i = 0; i < numRows; i++) {
           // Iterate through each column
           int numCols = board.numCols(i);
           for (int j = 0; j < numCols; j++) {
               // Now lets draw the individual shape
               // First get the current Board Square
               BoardSquare boardSquare = board.getBoardSquare(i, j);
              
               // Generate the row and pass in the data we'll need
               row = drawShape(boardSquare);
               
               // If the BoardSquare doesn't have a card, than skip this node
               if (!row.getChildren().isEmpty()) {
                  // Otherwise add the HBox to the correct part of the grid
                  grid.add(row, j, i); 
               }
               
           }
       }
       
       // Buttons + text
       
       // Add three
       addThree = new Button();
       addThree.setText("Add Three");
       
       grid.add(addThree, 0, 4);
       
       // Hint Button
       hint = new Button();
       hint.setText("Hint");
       
       grid.add(hint, 0, 5);
       
       // Exit button
       exit = new Button();
       exit.setText("Exit");
       
       grid.add(exit, 0, 7);
       
       // New game
       newGame = new Button();
       newGame.setText("New Game");
       
       grid.add(newGame, 0, 6);
       
       // Display remaining cards
       text = new Text();
       text.setText("Remaining cards: " + game.getDeck().deckSize);
       
       // Add remaining cards
       grid.add(text, 1, 4);
       
       // Give some padding to the shapes
       grid.setHgap(80);
       grid.setVgap(30);
       grid.setPadding(new Insets(20, 20, 20, 20));
       
   }
   
   /**
    * Handles the logic for drawing an individual shape based off of the data
    * supplied by an individual BoardSquare
    * @param boardSquare
    * @return 
    */
   public HBox drawShape(BoardSquare boardSquare) {
        // Init the HBox for this shape
        HBox row = new HBox();
        
        // Get the card
        Card card = boardSquare.getCard();
        
        // If no card associated with this BoardSquare, return empty HBox
        if (card == null) {
            return row;
        }
        
        // Get the card's attributes
        Card.Shape cardShape = card.getShape();               
        Card.Color cardColor = card.getColor();
        Card.Number cardNumber = card.getNumber();
        Card.Shading cardShading = card.getShading();
        
        int numShapes = 0;

        // Get the number of shapes we're creating
        switch (cardNumber) {
            case ONE: numShapes = 1;
                       break;
            case TWO: numShapes = 2;
                       break;
            case THREE: numShapes = 3;
                       break;
        }
        
        // Create the correct number of shapes
        for (int i = 0; i < numShapes; i++) {
            
            if (null != cardShape ) switch (cardShape) {
                case OVAL:
                    Ellipse e = new Ellipse(0, 0, 15, 35);
                    if (cardShading == Card.Shading.SOLID) {
                        switch (cardColor) {
                            case RED: e.setFill(Color.RED);
                            break;
                            case PURPLE: e.setFill(Color.PURPLE);
                            break;
                            case GREEN: e.setFill(Color.GREEN);
                            break;
                        }
                    }
                    
                    else if (cardShading == Card.Shading.OUTLINED) {
                        e.setFill(Color.WHITE);
                        
                        switch (cardColor) {
                            case RED: e.setStroke(Color.RED);
                            break;
                            case PURPLE: e.setStroke(Color.PURPLE);
                            break;
                            case GREEN: e.setStroke(Color.GREEN);
                            break;
                        }
                    }   
                    
                    else if (cardShading == Card.Shading.STRIPED) {
                        Image hatch = new Image("images/hatch.png");
                        e.setFill(new ImagePattern(hatch, 1, 1, 10, 10, false));
                        
                        switch (cardColor) {
                            case RED: e.setStroke(Color.RED);
                                      e.setStrokeWidth(3);
                            break;
                            case PURPLE: e.setStroke(Color.PURPLE);
                                         e.setStrokeWidth(3);
                            break;
                            case GREEN: e.setStroke(Color.GREEN);
                                        e.setStrokeWidth(3);
                            break;
                        }
                    }   
                    
                    // Add the shape to the HBox and pass in the BoardSquare data
                    // For later use
                    row.getChildren().add(e);
                    row.setPrefWidth(30);
                    row.setUserData(boardSquare);
                    
                    break;
                case SQUIGGLES:
                    CubicCurve cubic = new CubicCurve();
                    cubic.setStartX(50.0f);
                    cubic.setStartY(0);
                    cubic.setControlX1(25.0f);
                    cubic.setControlY1(0.0f);
                    cubic.setControlX2(75.0f);
                    cubic.setControlY2(100.0f);
                    cubic.setEndX(50.0f);
                    cubic.setEndY(100.0f);
                    if (cardShading == Card.Shading.SOLID) {
                        switch (cardColor) {
                            case RED: cubic.setFill(Color.RED);
                            break;
                            case PURPLE: cubic.setFill(Color.PURPLE);
                            break;
                            case GREEN: cubic.setFill(Color.GREEN);
                            break;
                        }
                    }
                    
                    else if (cardShading == Card.Shading.OUTLINED) {
                        cubic.setFill(Color.WHITE);
                        
                        switch (cardColor) {
                            case RED: cubic.setStroke(Color.RED);
                            break;
                            case PURPLE: cubic.setStroke(Color.PURPLE);
                            break;
                            case GREEN: cubic.setStroke(Color.GREEN);
                            break;
                        }
                    }
                    
                    else if (cardShading == Card.Shading.STRIPED) {
                        Image hatch = new Image("images/hatch.png");
                        cubic.setFill(new ImagePattern(hatch, 1, 1, 10, 10, false));
                        
                        switch (cardColor) {
                            case RED: cubic.setStroke(Color.RED);
                                      cubic.setStrokeWidth(3);
                            break;
                            case PURPLE: cubic.setStroke(Color.PURPLE);
                                         cubic.setStrokeWidth(3);

                            break;
                            case GREEN: cubic.setStroke(Color.GREEN);
                                        cubic.setStrokeWidth(3);
                            break;
                        }
                    }   
                    
                    // Add the shape to the HBox and pass in the BoardSquare data
                    // For later use
                    row.getChildren().add(cubic);
                    row.setPrefWidth(30);
                    row.setUserData(boardSquare);
                    
                    break;
                case DIAMONDS:
                    Rectangle d = new Rectangle();
                    d.setWidth(40);
                    d.setHeight(40);
                    d.setX(50);
                    d.setY(50);
                    d.setRotate(45);
                    if (cardShading == Card.Shading.SOLID) {
                        switch (cardColor) {
                            case RED: d.setFill(Color.RED);
                            break;
                            case PURPLE: d.setFill(Color.PURPLE);
                            break;
                            case GREEN: d.setFill(Color.GREEN);
                            break;
                        }
                    }
                    
                    else if (cardShading == Card.Shading.OUTLINED) {
                        d.setFill(Color.WHITE);
                        
                        switch (cardColor) {
                            case RED: d.setStroke(Color.RED);
                            break;
                            case PURPLE: d.setStroke(Color.PURPLE);
                            break;
                            case GREEN: d.setStroke(Color.GREEN);
                            break;
                        }
                    }
                    
                    else if (cardShading == Card.Shading.STRIPED) {
                        Image hatch = new Image("images/hatch.png");
                        d.setFill(new ImagePattern(hatch, 1, 1, 10, 10, false));
                        
                        switch (cardColor) {
                            case RED: d.setStroke(Color.RED);
                                      d.setStrokeWidth(3);
                            break;
                            case PURPLE: d.setStroke(Color.PURPLE);
                                         d.setStrokeWidth(3);

                            break;
                            case GREEN: d.setStroke(Color.GREEN);
                                        d.setStrokeWidth(3);

                            break;
                        }
                    }   
                        
                    // Add the shape to the HBox and pass in the BoardSquare data
                    // For later use 
                    row.getChildren().add(d);
                    row.setPrefWidth(30);
                    row.setUserData(boardSquare);
                    
                    break;
                default:
                    break;
            }

         }
        
        return row;

   }
   
   /**
    * Handles all user interaction in the program via click handling
    */
   public void clickHandler() {       
        // Iterate through each GridPane child
        grid.getChildren().forEach((node) -> {
            if (!node.equals(addThree) && !node.equals(hint) && !node.equals(exit) && !node.equals(text) && !node.equals(newGame)) {
                node.setOnMouseClicked((MouseEvent event) -> {
                    // Set a background color
                    if (selected.contains(node.getUserData())) {
                        // Reset background and remove from selected
                        node.setStyle("-fx-background-color: white");
                        selected.remove(node.getUserData());
                    } else {
                        // Apply style and add to selected
                        node.setStyle("-fx-background-color: black");
                        selected.add(node.getUserData());
                        testSet();
                    }
                });
            }
        });
        
        // Handle add three
        addThree.setOnAction((ActionEvent event) -> {
            
            // Add three cards
            game.add3();
            
            // Update deck
            game.getDeck().setDeckSize();
           
            // Re-draw board
            redrawBoard();
            
            // Check to see if the user can add additional cards
            // Subtract five to account for buttons + text
            if (grid.getChildren().size() - 5 >= 18 || game.getDeck().deckSize == 0) {
                addThree.setDisable(true);
            }
           
        });
        
        exit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
        hint.setOnAction((ActionEvent event) -> {
            findHint();
        });
        
        newGame.setOnAction((ActionEvent event) -> {
           newGame(); 
        });
        
    }
   
   /**
    * Starts a new game by resetting instance variables
    */
   public void newGame() {
       
        // Start a new game, reset instance variables
        Game newGame = new Game();
        game = newGame;
        board = newGame.board;
        
        // Enable add three button
        addThree.setDisable(false);
        
        // Clear selected
        selected.clear();

        // Redraw board
        redrawBoard();
   }
   
   /**
    * If a set exists on the board, find it and highlight the nodes containing
    * the shapes for the user
    * @return 
    */
   public boolean findHint() { 
       for (int i = 0; i < board.numRows(); i++) {
           for (int j = 0; j < board.numCols(i); j++) {
               for (int k = 0; k < board.numRows(); k++) {
                    for (int t = 0; t < board.numCols(k); t++) {
                        for (int z = 0; z < board.numRows(); z++) {
                            for (int p = 0; p < board.numCols(z); p++) {
                                BoardSquare boardSquare1 = board.getBoardSquare(i, j);
                                BoardSquare boardSquare2 = board.getBoardSquare(k, t);
                                BoardSquare boardSquare3 = board.getBoardSquare(z, p);
                                
                                // Check for empty card
                                if (boardSquare1.getCard() != null && boardSquare2.getCard() != null
                                        && boardSquare3.getCard() != null) {
       
                                    Card card1 = boardSquare1.getCard();
                                    Card card2 = boardSquare2.getCard();
                                    Card card3 = boardSquare3.getCard();

                                    if (Card.isSet(card1, card2, card3)) {
                                        
                                        // Iterate through the board, and find
                                        // Any BoardSquares that have the same card
                                        grid.getChildren().forEach((node) -> {
                                            if (!node.equals(addThree) && !node.equals(hint) && !node.equals(exit) && !node.equals(text) && !node.equals(newGame)) {
                                                BoardSquare boardSquare = (BoardSquare)node.getUserData();
                                                // Check for empty card
                                                if (boardSquare.getCard() != null) {
                                                    Card card = boardSquare.getCard();
                                                    // If this card matches any of the ones that form a set, apply a border
                                                    if (card.equals(card1) || card.equals(card2) || card.equals(card3)) {
                                                        node.setStyle("-fx-border-width: 2; -fx-border-color: black");
                                                    }
                                                }
                                            }

                                        });
                                        
                                        // Set found, we can exit the function
                                        return true;  
                                } 
                               }
                            }
                                
                        }
                    }
                }
           }
       }
       // If the user can still add three cards and no sets are found, tell them
       // To add more
        if (!addThree.isDisabled()) {
            // Show popup
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("No Set Found");
            alert.setContentText("No sets found - try adding more cards.");
            alert.showAndWait();
        }
        
        // No set found, exit the function
        return false;
   }   
   
   /**
    * If three cards have been selected, test to see if they form a set 
    * and perform the necessary steps
    */
   public void testSet() {
       if (selected.size() == 3) {
           // Add each selected to the Game's selected list
           for (int i = 0; i < 3; i++) {
               // Get the current board squares properties 
               BoardSquare currentBoardSquare = (BoardSquare)selected.get(i);
               int row = currentBoardSquare.getRowNumber();
               int col = currentBoardSquare.getColNumber();
               
               // Now add this to the master selected list in game
               // so we can use its methods to determine set
               game.addToSelected(row, col);
           }
           
  
           // See if the user has won
           if (game.getDeck().deckSize == 0  && grid.getChildren().size() - 5 == 0) {
            // Show popup
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("You Win!");
            alert.setContentText("Congratulations! You have won the game.");
            alert.showAndWait();
            System.exit(0);
           }
           
           // If the deck is empty and user forms a set, don't try to replace
           // it's card with a new one, actually remove the card so the board
           // will shrink
           if (game.getDeck().deckSize == 0) {
               BoardSquare boardSquare1 = (BoardSquare)selected.get(0);
               BoardSquare boardSquare2 = (BoardSquare)selected.get(1);
               BoardSquare boardSquare3 = (BoardSquare)selected.get(2);
               
               boardSquare1.removeCard();
               boardSquare2.removeCard();
               boardSquare3.removeCard();

           } else {
            // The deck still has cards and we can replace the BoardSquare with a new card
            game.testSelected();
           }
           
           // Clear the selected list
           selected.clear();
           
           // Go through the board and clear the background
           grid.getChildren().forEach((node) -> {
            if (!node.equals(addThree) && !node.equals(hint) && !node.equals(exit) && !node.equals(text) && !node.equals(newGame)) {
                node.setStyle("-fx-background-color: white");
            }
           });         
           
           // Re-draw the board
           redrawBoard();
           
           // Check to see if the user can add additional cards
           // Subtract five to account for buttons + text
           if (grid.getChildren().size() - 5 < 18 && game.getDeck().deckSize > 0) {
                addThree.setDisable(false);
           } else {
               addThree.setDisable(true);
           }
           
           // Test to see if there any sets left if no cards remain
           if (game.getDeck().deckSize == 0) {
               if (!findHint()) {
                    // Show popup
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Game Over");
                    alert.setContentText("No sets left - game over.");
                    alert.showAndWait();
                    System.exit(0);
               } else {
                   // Remove the black border and allow the user to continue playing
                   grid.getChildren().forEach((node) -> {
                    if (!node.equals(addThree) && !node.equals(hint) && !node.equals(exit) && !node.equals(text) && !node.equals(newGame)) {
                        node.setStyle("-fx-background-color: white");
                    }
                   });     
               }
           }

       }
   }
   
   /**
    * Re-draws the board by clearing the current one, creating a new one,
    * and re-attaching the click handler
    */
   public void redrawBoard() {       
       // Clear current board
       grid.getChildren().clear();
       
       // Re-draw it
       drawBoard();
       
       // Attach click handler
       clickHandler();
   }
   
   /**
    * Main method, fires the GUI
    * @param args 
    */
   public static void main(String [] args) {
      launch(args);
   }


}
