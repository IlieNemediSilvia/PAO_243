package unibuc;

public class Example1 {

    // primitives: byte, short, int, long, float, double, char, boolean
    // wrapper classes: Byte, Short, Integer, Long, Float, Double, Character, Boolean

    public static void main(String[] args) {
        int a = 5, b = 0;
        short c = 10;
        long d = 13435L;
        float e = 6.7f, f = 7.89F;
        double g = 356.6765;
        boolean h = true;
        char j = 'a';
        String str = "this is a test";
        int sum = 4 + 6;
        boolean bool = 5 < 10;

        System.out.println("a+b: " + (a+b));
        System.out.println(sum);
        System.out.println(bool);
        System.out.println(5 / 2);
        System.out.println(5 % 2);
    }
}
