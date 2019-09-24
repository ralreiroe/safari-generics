package cocontra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
public class ShowStuff2{
  public static <F> void showSelected(List<F> ls, Predicate<? super F> crit) {
    for (F s : ls) {
      if (crit.test(s))
        System.out.println("> " + s);
    }
  }

  public static <F, G> List<G> map(List<F> ls,
                                   Function<? super F, ? extends G> op) {
    List<G> out = new ArrayList<>();
    for (F s : ls) {
      out.add(op.apply(s));
    }
    return out;
  }

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Fred", "Jim", "Sheila");
    Function<String, Integer> fsi = s -> s.length();
    List<Object> li = map(names, fsi);

    for (Object i : li) {
      System.out.println(">> " + i);
    }

  }
}
