package pao.unibuc;

@FunctionalInterface
public interface Aggregator<T> {
    T aggregate(T previous, T current);
}
