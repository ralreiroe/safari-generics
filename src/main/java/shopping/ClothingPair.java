package shopping;

public class ClothingPair<E extends /*Object & */Sized & Colored/*, String*/>
    extends Pair<E> {
//  private java.lang.String s = "Hello";
//  private String s = "Hello";
  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean matches() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}
