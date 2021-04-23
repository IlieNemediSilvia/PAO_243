package pao.unibuc.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        long number = 1000000000;
        long startTime = System.currentTimeMillis();
        long sum1 = 0;
        for(long i=1; i<= number; i++){
            sum1+=i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(sum1);

        startTime = System.currentTimeMillis();
        int numberOfThreads = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        long step = number/numberOfThreads;
        MyThread[] threads = new MyThread[numberOfThreads];
        for(int i=0;i< numberOfThreads;i++){
            threads[i] = new MyThread(step * i +1, step*(i+1));
            executorService.execute(threads[i]);
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){

        }
        long sum2 = 0;
        for(int i=0;i<numberOfThreads;i++){
            sum2+=threads[i].getSum();
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(sum2);
    }
}
