package unibuc.strings;

public class Program2 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("This").append(" is ").append("a")
                .append(" longer").append(" sentence");
        System.out.println(builder.toString());
        System.out.println(builder.replace(1, 4, "hat"));
        System.out.println(builder.deleteCharAt(8));
        System.out.println(builder.insert(8, "one"));

        StringBuffer strBuffer = new StringBuffer("This is").append(" another ").append("sentence ");
        System.out.println(strBuffer.toString());
        strBuffer.setCharAt(0, 't');
        System.out.println(strBuffer.toString());
        System.out.println(strBuffer.reverse());
    }
}
