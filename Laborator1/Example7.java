package unibuc;
import java.text.MessageFormat;

public class Example7 {

    public static void main(String[] args) {
        System.out.println(MessageFormat.format("byte: {0} .. {1}", Byte.MIN_VALUE, Byte.MAX_VALUE));
        System.out.println(MessageFormat.format("short: {0} .. {1}", Short.MIN_VALUE, Short.MAX_VALUE));
        System.out.println(MessageFormat.format("int: {0} .. {1}", Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(MessageFormat.format("long: {0} .. {1}", Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(MessageFormat.format("float: {0} .. {1}", Float.MIN_VALUE, Float.MAX_VALUE));
        System.out.println(MessageFormat.format("double: {0} .. {1}", Double.MIN_VALUE, Double.MAX_VALUE));
        System.out.println(MessageFormat.format("char: {0} .. {1}", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE));
    }
}
