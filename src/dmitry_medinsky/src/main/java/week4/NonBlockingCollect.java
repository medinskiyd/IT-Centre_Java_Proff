package week4;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Дмитрий on 07.02.14.
 */
public class NonBlockingCollect {

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList al = new CopyOnWriteArrayList(); // При чтении работает очень быстро для многопоточности.
        BlockingQueue queue = new LinkedBlockingQueue(); // Блокирает поток евли нечего брать и если нечего читать.
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition(); // Условие для координации потоков.
        condition.await(); // Аналог wait.
        condition.signal(); // Аналог notify.
        condition.signalAll(); // Аналог notifyAll.
        // Условия нужно передавать потокам.

        //queue.take(); // получить из головы очереди (блокирующие).
        //queue.put(); // положить в хвост очереди (блокирующий).

        ConcurrentHashMap map = new ConcurrentHashMap(); // Позволяет работать не блокирующе с картами.
    }

}
