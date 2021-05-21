package pao.unibuc;

import java.util.*;

public class UserDB {
    private static UserDB instance;
    private Map<String,User> userMap = new HashMap<>();

    private UserDB(){
        addUser("John", "test1@abc.com", Arrays.asList("Mary", "George"));
        addUser("Mary", "test2@abc.com", Arrays.asList("Matilda", "George", "Paul"));
        addUser("Matilda", "test3@abc.com", Arrays.asList("Mary", "John"));
        addUser("George", "test4@abc.com", Arrays.asList("Mary", "Matilda"));
        addUser("Paul", "test5@abc.com", Arrays.asList("Mary", "George", "John"));
    }
    public void addUser(String name, String email, List<String> contacts){
        User user = new User(name, email);
        user.setContacts(contacts);
        userMap.put(name, user);
    }
    public static UserDB getInstance(){
        if(instance == null){
            synchronized (UserDB.class){
                if(instance == null){
                    instance = new UserDB();
                }
            }
        }
        return instance;
    }
    public User getUser(String name){
        return userMap.get(name);
    }
    public Collection<User> getAllUsers(){
        return userMap.values();
    }
}
