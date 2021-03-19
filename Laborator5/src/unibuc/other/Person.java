package unibuc.other;

public class Person implements Human {
    private String name;
    public Person (String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name + " alias " + Human.super.getName();
    }
}
