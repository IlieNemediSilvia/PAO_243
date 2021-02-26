package unibuc;

public class Example2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        Integer x = Integer.valueOf(a);
        Integer y = Integer.valueOf(b);
        Integer p = new Integer(a);
        Integer q = new Integer(b);

        compare(a, b);
        compare(x, y);
        compare(p, q);

    }
    public static void compare(int a, int b){
        System.out.println(" int == int : " + (a == b));
    }
    public static void compare(Integer a, Integer b){
        System.out.println(" Integer == Integer : " + (a == b));
        System.out.println(" Integer equals Integer : " + a.equals(b));
    }
}
