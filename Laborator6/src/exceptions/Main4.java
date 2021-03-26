package exceptions;

public class Main4 {
    public static void main(String[] args) {
        try(Resource resource = new Resource()){
            resource.doSomething();
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
