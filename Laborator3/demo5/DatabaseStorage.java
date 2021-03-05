package unibuc.demo5;

public class DatabaseStorage extends Storage{
    @Override
    void save() {
        System.out.println("Save to database");
    }

    @Override
    void delete() {
        System.out.println("Delete from database");
    }
}
