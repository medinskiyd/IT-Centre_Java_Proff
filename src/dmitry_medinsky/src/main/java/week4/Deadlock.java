package week4;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Дмитрий on 05.02.14.
 */
public class Deadlock {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> aList = new ArrayList<Integer>();
        aList.add(0, 11);   // Первая вилка.
        aList.add(1, 22);   // Вторая вилка.


        Tarelka tarelka = new Tarelka(aList);
        Philosopher firstPhil = new Philosopher("Аристотель", aList);
        Philosopher secondPhil = new Philosopher("Гератосфен", aList);
        firstPhil.start();
        secondPhil.start();
        Thread.sleep(2000);
        firstPhil.interrupt();
        secondPhil.interrupt();


    }

    private static class Tarelka  { // Классnfhtkrf наследуется
        private Tarelka tarelka; // Полка.
        private ArrayList<Integer> list;
        Lock lock = new ReentrantLock();
        public Tarelka() {

        }

        public Tarelka(ArrayList<Integer> list) {
            this.list = list;

        }

        public void getFirst() { // Синхронизированный метод добавления числа на полку.

            while(true){

                try{
                    lock.lock();
                    System.out.println(list.get(0) + list.get(1));
                } finally {
                    lock.unlock();
                }

            }

        }

        public void getSecond() { // Синхронизированный метод взятия числа с полку.
            while(true){
                try{
                    lock.lock();
                    System.out.println(list.get(0) + list.get(1));
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Philosopher extends Thread { //
        private ArrayList<Integer> list;
        private String name = "";

        public Philosopher() {
        }

        public Philosopher(String name, ArrayList<Integer> list) {
            this.name = name;
            this.list = list;
        }

        @Override
        synchronized public void run() {
            while(!currentThread().isInterrupted()){ // Если поток не прерван, -->

                System.out.println("Взято " + getName());

            }
        }
    }
}



