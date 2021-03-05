package unibuc.demo5;

public class FileStorage extends Storage{
    @Override
    void save() {
        System.out.println("Save to file");
    }

    @Override
    void delete() {
        System.out.println("Delete from file");
    }
}
