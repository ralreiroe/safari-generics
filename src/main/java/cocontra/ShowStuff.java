package cocontra;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


// This is Predicate<F> homemade
//interface Criterion<F> {
//  boolean test(F s);
//}
//
//class LongStrings implements Criterion<String> {
//  public boolean test(String s) {
//    return s.length() > 3;
//  }
//}
public class ShowStuff/*<F> */{
  // CALLER must provide a predicate of some type that "will work"
  // to work, we're going to call test(?) with a parameter of type F
  // therefore, ? (that's the CALLER's type) must be assignment compatible
  // to F.. Hence "super" (note, super includes self type :)
  // Contra-variance...
  public static <F> void showSelected(List<F> ls, Predicate<? super F> crit) {
    for (F s : ls) {
      if (crit.test(s))
        System.out.println("> " + s);
    }
  }

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Fred", "Jim", "Sheila");
    // explicit assignemet to <F> in context of this particular call
//    ShowStuff.<String>showSelected(names, s -> s.length() > 3);
    // inferencing (from context) is more normal.
    ShowStuff.showSelected(names, s -> s.length() > 3);

    System.out.println("---------------------------------");
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    LocalDate yesterday = today.minusDays(1);
    showSelected(Arrays.asList(today, tomorrow, yesterday),
        d -> d.isAfter(today));

    System.out.println("---------------------------------");
    Predicate<CharSequence> pcs = s -> s.length() > 3;
    StringBuilder sb1 = new StringBuilder("Alan");
    StringBuilder sb2 = new StringBuilder("Jim");
    StringBuilder sb3 = new StringBuilder("William");
    List<StringBuilder> sbl = Arrays.asList(sb1, sb2, sb3);
    ShowStuff.showSelected(sbl, pcs);
  }
}
