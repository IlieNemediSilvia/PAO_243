package exceptions;

public class Resource implements AutoCloseable{
    public Resource(){
        System.out.println("Resource was opened.");
    }
    @Override
    public void close() throws Exception {
        System.out.println("Resource was closed.");
    }
    public void doSomething() throws Exception {
        throw new Exception("Something went wrong.");
    }
}
