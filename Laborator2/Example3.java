package unibuc;

public class Example3 {
    public static void main(String[] args) {
        int i = 1;
        Integer I = 1;
        long l = 1;
        Long L = 1L;

        testint(i);
        testint(I);
        //testint(l);
       // testint(L);

        testInteger(i);
        testInteger(I);
        //testInteger(l);
        //testInteger(L);

        testlong(i);
        testlong(l);
        testlong(I);
        testlong(L);

        //testLong(i);
        //testLong(I);
        testLong(l);
        testlong(L);

        testNumber(i);
        testNumber(l);
        testNumber(L);
        testNumber(I);
    }
    private static void testint(int i){
    }
    private static void testInteger(Integer i){
    }
    private static void testlong(long l){
    }
    private static void testLong(Long l){
    }
    private static void testNumber(Number n){
    }
}
