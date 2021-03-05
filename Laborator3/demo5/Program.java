package unibuc.demo5;

public class Program {
    public static void main(String[] args) {
        Storage fileStorage = new FileStorage();
        fileStorage.size = 512;
        fileStorage.open();
        fileStorage.save();
        fileStorage.delete();
        fileStorage.close();

        Storage dbStorage = new DatabaseStorage();
        dbStorage.size = 1024;
        dbStorage.open();
        dbStorage.save();
        dbStorage.delete();
        dbStorage.close();


    }
}
