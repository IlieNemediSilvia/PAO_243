package unibuc.example6.other;

import unibuc.example6.Person;

public class Example6 {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Alina";
        //person.age = 25;
        //person.job = "doctor";
        person.setReligion("orthodox");
        //person.initialize();

        Student student = new Student();
        student.showInformation();
    }
}
