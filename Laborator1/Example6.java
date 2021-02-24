package unibuc;

public class Example6 {
     //Tipurile wrapper sunt imutabile, de fiecare data cand modificam o instanta wrapper, se va crea o alta instanta

    public static void main(String[] args)
    {
        Integer i = 5;
        System.out.println(i);
        increment(i);
        System.out.println(i);
    }

    private static void increment(Integer i){
        i = i + 1;
    }
}
