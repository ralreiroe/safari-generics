package shopping;

import java.time.LocalDate;

public class Store {
  public static void main(String[] args) {
    Pair<String> p = new Pair<>("Fred", "Jones");
    p.setLeft("Frederick!");
//    p.matches(); // Nonsense!!!

    ClothingPair<Glove> pg = new ClothingPair<>(
        new Glove(9, "Red"), new Glove(8, "Red"));
    System.out.println("Left glove is " + pg.getLeft());
    System.out.println("Pair is good " + pg.matches());

    ClothingPair<Glove> pg2 = new ClothingPair<>(
        new Glove(8, "Red-Brown"), new Glove(8, "Red"));
    System.out.println("Pair 2 is good " + pg2.matches());

  }
}
