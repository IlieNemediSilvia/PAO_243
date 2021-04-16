package unibuc;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
        printStream("Even stream", evenStream(), 10);
        printStream("Odd stream", oddStream(), 10);
        printStream("Squared stream", squaredStream(), 10);
        printStream("Fibonacci stream", fibonacciStream(), 10);
        printStream("Prime stream", primeStream(), 20);
    }
    private static void printStream(String name, Stream<Integer> stream, int limit){
        System.out.println(name + ":");
        stream.limit(limit).forEach(System.out::println);
        System.out.println();
    }
    private static Stream<Integer> evenStream(){
        return Stream.iterate(0, i -> i + 2);
    }
    private static Stream<Integer> oddStream(){
        return Stream.iterate(1, i -> i + 2);
    }
    private static Stream<Integer> squaredStream(){
        return Stream.iterate(1, i -> i + 1).map(i -> i * i);
    }
    private static Stream<Integer> fibonacciStream(){
        return Stream.iterate(new int[] {1, 2}, t-> new int[]{t[1], t[0] + t[1]})
                .map(t -> t[0]);
    }
    private static Stream<Integer> primeStream(){
        final Map<Integer, Integer> factors = new HashMap<>();
        return Stream.iterate(2, i -> i + 1)
                .filter(i -> {
                    factors.entrySet().stream().forEach(f -> {
                        while(f.getValue() < i){
                            f.setValue(f.getValue() + f.getKey());
                        }
                    });
                    if(factors.containsValue(i)){
                        return false;
                    }
                    else {
                        factors.put(i, i);
                        return true;
                    }
                });
    }
}
