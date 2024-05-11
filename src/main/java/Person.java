public class Person {
//public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    public Person(String firstName, String lastName, int age, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Fornavn: " + getFirstName() + ", Efternavn: " + getLastName() + ", Alder: " + getAge() + ", Højde: " + getHeight();
    }

//    @Override
//    public int compareTo(Person o) {
//        // Since it's just a number comparison, we can also use this:
//        //return Integer.compare(o.getAge(), this.getAge());
//        if (o.getAge() == this.getAge()) {
//            return 0;
//        }
//        else if (o.getAge() > this.getAge()) {
//            return -1;
//        }
//        else return 1;
//    }
}

