import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SortPeople {
    public static void main(String[] args) {
        Person[] people = {
                // Tilføj flere personer, som deler nogle af de samme egenskaber f.eks. samme fornavn, men hvor deres andre egenskaber er unikke.
                new Person("AHans", "AFilipson", 30, 1.70),
                new Person("BMerete", "BPoulsen", 12, 1.22),
                new Person("CIbsen", "CPoulsen", 55, 1.20),
                new Person("DSixten", "DOttesen", 15, 1.90),
                new Person("ENanu", "EUnique", 25, 1.80),
                new Person("FUnique", "FName", 35, 1.75),
        };


        System.out.println(Arrays.toString(people));
//        printPeople(people);
//        System.out.println("Usorteret liste af personer");

        // skriv kode herunder
//        Arrays.sort(people);
//        printPeople(people);
//        System.out.println("Sorteret efter alder");

        Arrays.sort(people, new FirstNameComparator());
        printPeople(people);
        System.out.println("Sorteret efter fornavn");


        Arrays.sort(people, (Person a, Person b) -> a.getLastName().compareToIgnoreCase(b.getLastName()));
        printPeople(people);
        System.out.println("Sorteret efter efternavn?");

        Collections.reverse(Arrays.asList(people));
        printPeople(people);
        System.out.println("Sorteret OMVENDT efter efternavn?");
    }

    private static void printPeople(Person[] p) {
        System.out.println();
        for (Person person : p) {
            System.out.println(person);
        }
    }

}
