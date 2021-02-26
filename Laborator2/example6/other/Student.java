package unibuc.example6.other;

import unibuc.example6.Person;

public class Student extends Person {
    public void changeData(){
        name = "Tudor";
        job = "musician";
//        age = 30;
//        religion = "";
        showInformation();
    }

    @Override
    protected void showInformation() {
        super.showInformation();
        System.out.println("showInformation in Student class");
    }
}