package erasure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class GetArray {


  // Type erasure: E has no meaning at runtime, ONLY during compiler
  // consistency checks
//  public static <E> E[] toArray(List<E> ls, Class<? extends Object> clazz) {
  public static <E> E[] toArray(List<E> ls, Class<E> clazz) {
    E [] res = (E[])Array.newInstance(clazz, ls.size());
    for (int i = 0; i < res.length; i++) {
      res[i] = ls.get(i);
    }
    return res;
  }

  // ... is an array. For E ... => compiler is forced to make Object[], not E[]
  // therefore possible to break stuff!
  // IF (and please only if!) we're sure we "do it right"
  @SafeVarargs
  public static <E> void doStuff(List<E> l, E ... more) {
  }

//  public static String[] toArray(List<String> ls) {
//    String [] res = new String[ls.size()];
//    for (int i = 0; i < res.length; i++) {
//      res[i] = ls.get(i);
//    }
//    return res;
//  }
  public static void main(String[] args) {
    List<String> ls = Arrays.asList("Fred", "Jim", "Shiela");

    String[] sa = toArray(ls, String.class);
//    sa[0] = new Object();
    for (String s : sa ) {
      System.out.println("> "+ s);
    }
    System.out.println("Type of sa is " + sa.getClass().getName());
    System.out.println("Type of ls is " + ls.getClass().getName());
  }
}
