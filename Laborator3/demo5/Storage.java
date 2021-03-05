package unibuc.demo5;

public abstract class Storage {
    protected int size;
    abstract void save();
    abstract void delete();
    public void open(){
        System.out.println("Opening storage");
    }
    public void close(){
        System.out.println("Closing storage");
    }
}
