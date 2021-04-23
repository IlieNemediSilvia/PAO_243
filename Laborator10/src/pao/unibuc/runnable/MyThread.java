package pao.unibuc.runnable;

public class MyThread implements Runnable{
    private long from, to, sum;

    public MyThread(long from, long to){
        sum = 0;
        this.from = from;
        this.to = to;
    }
    @Override
    public void run() {
        for(long i = from; i<=to; i++){
            sum+=i;
        }
    }
    public long getSum(){
        return this.sum;
    }
}
