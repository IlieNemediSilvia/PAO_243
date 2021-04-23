package pao.unibuc.producerConsumer;

public class Main {
    public static void main(String[] args) {
        Storage<String> storage = new Storage<>(3);
        ProducerThread<String> producerThread = new ProducerThread<>(storage, () -> "portocale");
        ConsumerThread<String> consumerThread = new ConsumerThread<>(storage, item -> {});
        producerThread.start();
        consumerThread.start();
    }
}
