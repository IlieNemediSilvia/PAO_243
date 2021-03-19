package unibuc.other;


public class Program {
    public static void main(String[] args) {
        Person person = new Person("Ion Ionescu");
        System.out.println(person.getName());
        System.out.println(Human.isAdult(25));
        System.out.println(Human.isAdult(15));
    }
}
