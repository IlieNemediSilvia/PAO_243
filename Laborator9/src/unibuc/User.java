package unibuc;

public class User {
    private int id;
    private String firstName;
    private String lastName;

    public User(String[] values){
        if(values.length == 3){
            id = Integer.parseInt(values[0]);
            lastName = values[1];
            firstName = values[2];
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
