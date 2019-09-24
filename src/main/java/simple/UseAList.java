package simple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseAList {
  // might happen with older libraries
  public static void breakMyList(List n) {
    n.add(2, LocalDate.now());
  }
  public static void main(String[] args) {
    // Compile time constraint
    List<String> names =
        // Diamond operator "<>" infers suitable value for E...
        new ArrayList<>(Arrays.asList("Fred", "Jim",
            "Sheila"/*, LocalDate.now()*/));
    names = Collections.checkedList(names, String.class);
    names.add("Fred");
    names.add("Jim");
//    names.add(LocalDate.now());
    names.add("Sheila");
//    breakMyList(names);

    Class cl = names.getClass();
    System.out.println("Class of names is " + cl.getName());
    System.out.println("Class of string is " + String.class.getName());

    String nameZero = /*(String)*/names.get(0);
    String nameTwo = /*(String)*/names.get(2);
    System.out.println("Name number 2 is " + names.get(2));
  }
}
