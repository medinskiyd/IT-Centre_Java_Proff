package week3;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 1/31/14
 */
public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Shelf shelf = new Shelf();
        Producer producer = new Producer(shelf);
        Consumer consumer = new Consumer(shelf);
        producer.start();
        consumer.start();
        Thread.sleep(2000);
        producer.interrupt();
        consumer.interrupt();
    }

    private static class Producer extends Thread {
        private Shelf shelf;
        private Random rnd = new Random();

        private Producer(Shelf shelf) {
            this.shelf = shelf;
        }

        @Override
        public void run() {
            while (!currentThread().isInterrupted()) {
                shelf.put(rnd.nextInt());
            }
        }
    }

    private static class Consumer extends Thread {
        private Shelf shelf;

        private Consumer(Shelf shelf) {
            this.shelf = shelf;
        }

        @Override
        public void run() {
            while (!currentThread().isInterrupted()) {
                System.out.println("Выведено: " + shelf.get());
            }
        }
    }

    private static class Shelf {
        private Integer value;
        public void put(Integer value) {
            this.value = value;
            System.out.println("Положено: " + value);
        }
        public Integer get() {
            System.out.println("Взято: " + value);
            return value;
        }
    }
}
