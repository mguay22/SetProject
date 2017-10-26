package classes;

public class Tester {

  public static void main(String [] args ) {
    Card card = new Card(Card.Shape.OVAL, Card.Color.RED, Card.Number.TWO, Card.Shading.SOLID);
    System.out.println(card);
  }

}
