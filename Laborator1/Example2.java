package unibuc;

public class Example2 {

    public static void main(String[] args) {
        Integer x = 208;
        int y = x.intValue();
        System.out.println(y);
        Double a = 6.89;
        double b = a.doubleValue();
        System.out.println(b);
        int i = Integer.parseInt("56");
        Integer j = Integer.valueOf(25);
        Character c = 'a';
        System.out.println(c.charValue());
        int counter = 5;
        counter ++;
        System.out.println("Counter is: " + counter);
        String str = Integer.toString(6825);
        System.out.println(str.length());
        System.out.println("thIs is a Test".toLowerCase());
        System.out.println("Test".equals("test"));
        System.out.println("Test".equalsIgnoreCase("test"));
        System.out.println("abc".toUpperCase());
        System.out.println("   ".isBlank());
        System.out.println("".isEmpty());
    }
}
