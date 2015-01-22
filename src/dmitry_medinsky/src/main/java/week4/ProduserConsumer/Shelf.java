package week4.ProduserConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Дмитрий on 07.02.14.
 */
public class Shelf {

    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition(); // Пусто
    private Condition full = lock.newCondition(); // Занято

    private Integer value;

    public void put(Integer value) throws InterruptedException {
        lock.lock();
        try{
            while(this.value != null) { // while потому что внезапное пробуждение (потоки могут внезапно пробуждаться, никогда не делать if).
                full.await(); // Если данных нет, продюсер ждет.
            }

            this.value = value; // Ложим на полку число.
            System.out.println("Положено: " + value);
            empty.signal(); // У каждого потока свое условие!
        } finally {
            lock.unlock(); //
        }

    }

    public Integer get() throws InterruptedException { // Синхронизированный метод взятия числа с полку.

        lock.lock();
        try{
            while(value == null) {
               empty.await(); //
            }
            System.out.println("Взято: " + value);
            int tmp = value;
            value = null;

            full.signal();// У каждого потока свое условие!
            return tmp;

        } finally {
            lock.unlock();
        }
    }
}
