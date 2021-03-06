package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/7/14
 */
public class ThreadPool {
    private static final int NTHREDS = 10;
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 50000; i++) {
            Runnable producer = new Producer(queue, i);
            executor.submit(producer);
            Runnable consumer = new Consumer(queue, i);
            executor.submit(consumer);
            System.out.println("submited: " + i);
        }
        executor.submit(new Consumer1(queue, 5));


        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Finished all threads");
    }

    static class MyRunnable implements Runnable {
        private final long countUntil;

        MyRunnable(long countUntil) {
            this.countUntil = countUntil;
        }

        @Override
        public void run() {
            long sum = 0;
            for (long i = 1; i < countUntil; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    private static class Producer extends Thread {
        private BlockingQueue<Integer> queue;
        private Integer number;

        private Producer(BlockingQueue<Integer> queue, Integer number) {
            this.queue = queue;
            this.number = number;
        }

        @Override
        public void run() {
                try {
                    queue.put(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private static class Consumer extends Thread {
        private BlockingQueue<Integer> queue;
        private Integer number;

        private Consumer(BlockingQueue<Integer> queue, Integer number) {
            this.queue = queue;
            this.number = number;
        }

        @Override
        public void run() {
                try {
                    Integer number = queue.take();
                    System.out.println("Выведено: " + number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private static class Consumer1 extends Thread {
        private BlockingQueue<Integer> queue;
        private Integer number;

        private Consumer1(BlockingQueue<Integer> queue, Integer number) {
            this.queue = queue;
            this.number = number;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted())
                try {
                    Integer number = queue.take();
                    System.out.println("Выведено: " + number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

}
