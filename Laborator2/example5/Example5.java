package unibuc.example5;

public class Example5 {
    public static void main(String[] args) {

        MyClass myClass1 = new MyClass();
        myClass1.a = 5;
        myClass1.b = 10;
        System.out.println("a: " + myClass1.a + ", b: "+myClass1.b);

        MyClass myClass2 = new MyClass();
        myClass2.a = 2;
        myClass2.b = 11;
        System.out.println("a: " + myClass1.a + ", b: "+myClass1.b);
        System.out.println("a: " + myClass2.a + ", b: "+myClass2.b);
        MyClass.b = 12;
        System.out.println("a: " + myClass1.a + ", b: "+myClass1.b);
        System.out.println("a: " + myClass2.a + ", b: "+myClass2.b);
    }
}
