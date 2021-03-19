package unibuc.other;

public interface Human {
    String DEFAULT_NAME = "John Doe";
    default String getName(){
        test();
        return DEFAULT_NAME;
    }
    private void test(){
        System.out.println("private method was called");
    }
    static boolean isAdult(int age){
        return age >= 18;
    }
}
