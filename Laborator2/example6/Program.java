package unibuc.example6;

public class Program {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Alina";
        person.age = 25;
        person.job = "doctor";
       // person.religion = "orthodox";
        person.setReligion("orthodox");
        person.initialize();
        person.showInformation();
    }
}
