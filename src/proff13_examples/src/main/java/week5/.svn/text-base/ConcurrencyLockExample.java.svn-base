package week5;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sench_000 on 05/02/14.
 */
public class ConcurrencyLockExample implements Runnable {


        private Resource resource;
        private Lock lock;

        public ConcurrencyLockExample(Resource r){
            this.resource = r;
            this.lock = new ReentrantLock();
        }

    public ConcurrencyLockExample() {

    }

    @Override
        public void run() {
            try {
                lock.tryLock(10, TimeUnit.SECONDS);
                resource.doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                //release lock
                lock.unlock();
            }
            resource.doLogging();
        }


public class Resource {

    public void doSomething(){
        //do some operation, DB read, write etc
    }

    public void doLogging(){
        //logging, no need for thread safety
    }
}
}
