//package classes;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Ellipse;
//import javafx.scene.paint.Color;
//import javafx.scene.image.Image;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.text.Text;
//import javafx.scene.text.Font;
//import java.util.Random;
//import javafx.geometry.Pos;
//import javafx.geometry.Insets;
//
//
//public class Shapes extends Application {
//    // Instance variables
//    private BorderPane mainLayout;
//    private Scene scene;
//    private GridPane grid;
//
//   @Override
//   public void start(Stage primaryStage) {
//       primaryStage.setTitle("Michael's Program");
//       mainLayout = new BorderPane();
//       CardShape shape = Card.Shape.OVAL;
//       CardColor color = Card.Color.GREEN;
//       CardNumber number = Card.Number.ONE;
//       CardFill fill = Card.Shading.SOLID;
//       Card card = new Card(shape, color, number, fill);
//
//       grid = new GridPane();
//       mainLayout.setCenter(grid);
//
//       // Add to grid
//       grid.add(createCardPane(card, 1, 1));
//
//       scene = new Scene(mainLayout, 400, 400);
//       primaryStage.setScene(scene);
//       primaryStage.show();
//
//   }
//
//   public void createCardPane(Card object, int row, int col) {
//       Pane pane = new Pane();
//       Shape shape = object.SHAPE;
//
//       switch (shape) {
//           case "OVAL" : drawOval(pane, row, col, 1, 1, object);
//
//       }
//
//   }
//
//   public void drawOval(Pane pane, int centerX, int centerY,
//           int radX, int radY, Card object) {
//       Ellipse e = new Ellipse(centerX, centerY, radX, radY);
//       String color = Card.COLOR;
//       String shading = Card.SHADING;
//
//       if (shading == "SOLID") {
//           switch (color) {
//            case "RED": e.setFill(Color.RED);
//            case "PURPLE" : e.setFill(Color.PURPLE);
//            case "GREEN" : e.setFill(Color.GREEN);
//           }
//       }
//
//       if (shading == "OUTLINED") {
//           switch (color) {
//            case "RED" : e.setStroke(Color.RED);
//            case "PURPLE" : e.setStroke(Color.PURPLE);
//            case "GREEN" : e.setStroke(Color.GREEN);
//           }
//       }
//
//       if (shading == "STRIPED") {
//           Image hatch = new Image("../assets/hatch.jpg");
//           e.setFill(new ImagePattern(hatch, 0, 0, 1, 1, false));
//       }
//
//       pane.getChildren().add(e);
//
//
//   }
//
//   public static void main(String [] args) {
//      launch(args);
//   }
//}
