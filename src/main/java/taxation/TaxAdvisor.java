package taxation;

import java.util.Arrays;
import java.util.List;

public class TaxAdvisor {
  public static void calculateTaxes(Taxable t) {
  }

  // ? extends is called
  public static void calculateBulkTaxes(List<? extends Taxable> lt) {
//    lt.add(new Corporation()); // my friend's business
//    lt.add(new Individual()); // my friend :)
    for (Taxable t : lt) {
      calculateTaxes(t);
    }
  }

  public static void collectIndividualClients(List<? super Individual> li) {
//    Individual ind = li.get(0);
    Individual i = new Individual();
    li.add(i);
  }
  public static void main(String[] args) {
    List<Taxable> lt = Arrays.asList(
        new Corporation(),
        new Individual()
    );

    collectIndividualClients(lt);
    calculateBulkTaxes(lt);

    List<Individual> li = Arrays.asList(
        new Individual()
    );
    calculateBulkTaxes(li);

    collectIndividualClients(li);
  }
}
