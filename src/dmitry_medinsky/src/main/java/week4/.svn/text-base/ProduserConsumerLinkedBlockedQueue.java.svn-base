package week4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Дмитрий on 07.02.14.
 */
public class ProduserConsumerLinkedBlockedQueue {

    private static final int NTHREDS = 10; // количество потоков.

        public static void main(String[] args) throws InterruptedException {

            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

            ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
            for (int i = 0; i < 25000; i++) {
                Runnable produser = new Producer(linkedBlockingQueue, i);
                executor.submit(produser);
                Runnable consumer = new Consumer(linkedBlockingQueue);
                executor.submit(consumer);
            }

            executor.shutdown();

            executor.awaitTermination(12, TimeUnit.SECONDS);
            System.out.println("Finished all threads");
        }

        private static class Producer extends Thread {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int number = 0;

            private Producer(LinkedBlockingQueue linkedBlockingQueue, int number) {
                this.linkedBlockingQueue = linkedBlockingQueue;
                this.number = number;
            }

            @Override
            public void run() {
                while (!currentThread().isInterrupted()) {
                    try {
                        linkedBlockingQueue.put(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static class Consumer extends Thread {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int number = 0;

            private Consumer(LinkedBlockingQueue linkedBlockingQueue) {
                this.linkedBlockingQueue = linkedBlockingQueue;
            }

            @Override
            public void run() {
                while (!currentThread().isInterrupted()) {
                    try {
                        number = (Integer) linkedBlockingQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Выведено: " + number);
                }
            }
        }

}
