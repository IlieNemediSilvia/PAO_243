package pao.unibuc;

import java.util.Comparator;
import java.util.List;

public class SorterStep implements Step{
    private Comparator<Exchange> comparator;
    public SorterStep(Comparator<Exchange> comparator){
        this.comparator = comparator;
    }
    @Override
    public List<Exchange> process(List<Exchange> exchanges) {
        exchanges.sort(comparator);
        return exchanges;
    }
}
