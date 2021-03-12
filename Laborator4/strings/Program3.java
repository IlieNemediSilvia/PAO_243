package unibuc.strings;

public class Program3 {
    public static void main(String[] args) {
        String input = "<p class=\"test\">First paragraph</p><p>Second paragraph</p>"
                + "<p>Third paragraph</p>";
        System.out.println(input.replaceAll("<p.*?>(.+?)</p>", "$1\n"));
        String regex = "[a-z_0-9]+@[a-z0-9]+(?:\\.[a-z0-9]+)*\\.(?:ro|com)";
        System.out.println("abc@domain.com".matches(regex));
        System.out.println("abc@test.domain.com".matches(regex));
        System.out.println("abc@test.domain.ro".matches(regex));
        System.out.println("ab-c@test.domain.com".matches(regex));
        System.out.println("abc@test.domain.test".matches(regex));
    }
}
