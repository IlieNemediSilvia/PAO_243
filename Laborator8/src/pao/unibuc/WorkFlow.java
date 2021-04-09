package pao.unibuc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Thread.sleep;

public class WorkFlow {
    private List<Step> steps = new ArrayList<>();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(20 * Runtime.getRuntime().availableProcessors());
    private static volatile boolean running = true;

    private WorkFlow(){
    }

    public static WorkFlow from (Supplier<List<?>> supplier){
        WorkFlow workFlow =  new WorkFlow();
        workFlow.steps.add(new FromStep(supplier));
        return workFlow;
    }
    public WorkFlow filter (Predicate<Exchange> predicate){
        this.steps.add(new FilterStep(predicate));
        return this;
    }
    public WorkFlow sort(Comparator<Exchange> comparator){
        this.steps.add(new SorterStep(comparator));
        return this;
    }
    public WorkFlow transform(Consumer<Exchange> consumer){
        steps.add(new TransformStep(consumer));
        return this;
    }
    public WorkFlow aggregate(Function<Exchange, Object> criterion, Aggregator<Exchange> aggregator){
        steps.add(new AggregateStep(criterion, aggregator));
        return this;
    }
    public void to(Consumer<Exchange> consumer){
        steps.add(new ToStep(consumer));
        executorService.submit(() -> {
            while(running){
                List<Exchange> exchanges = Collections.emptyList();
                for(Step step: steps){
                    exchanges = step.process(exchanges);
                }
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public static void shutDown(){
        running =  false;
        executorService.shutdown();
    }

}
