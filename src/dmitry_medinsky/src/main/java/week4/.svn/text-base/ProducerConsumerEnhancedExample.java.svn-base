package week4;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/7/14
 */
public class ProducerConsumerEnhancedExample {
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
            for (int i=0; !currentThread().isInterrupted(); i++) {
                try {
//                    shelf.put(rnd.nextInt());
                    shelf.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
                try {
                    Integer number = shelf.get();
                    System.out.println("Выведено: " + number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Shelf {
        private Lock lock = new ReentrantLock();
        private Condition empty = lock.newCondition();
        private Condition full = lock.newCondition();

        private Integer value;

        public void put(Integer value) throws InterruptedException {
            lock.lock();
            try {
                while (this.value != null) {
                    full.await();
                }
                this.value = value;
                System.out.println("Положено: " + value);

                empty.signal();
            }  finally {
                lock.unlock();
            }
        }

        public Integer get() throws InterruptedException {
            lock.lock();
            try {
                while (value == null) {
                    empty.await();
                }

                System.out.println("Взято: " + value);
                int tmp = value;
                value = null;

                full.signal();
                return tmp;
            }  finally {
                lock.unlock();
            }

        }
    }
}
