package week3.ConsumerCreater;

import java.util.Random;

// В этой программе потоки работают асинхронно.(сделать что бы они были синхронны).
// Один поток генерирует числа второй выводит на экран используя промежуточное хранилище.
//

public class ProduserConsumer {
    public static void main(String[] args) throws InterruptedException {
        Shelf shelf = new Shelf(); // Объект полка.
        Produser produser = new Produser(shelf); // Объект добавляющий числа на полку.
        Costumer costumer = new Costumer(shelf); // Объект берущий числа с полки.
        produser.start(); // Запускается поток добавления числа на полку.
        costumer.start(); // Запускается поток приема числа с полки.
        Thread.sleep(2000); // Главный поток засыпает на 2000 мс.
        produser.interrupt(); // Заканчивает работать поток добавления.
        costumer.interrupt(); // Заканчивает работать поток приема.
    }

    private static class Produser extends Thread { // Создаем добавляющий поток.
        private Shelf shelf; // Наша полка на которой лежит число.
        private Random rnd = new Random();

        private Produser(Shelf shelf) {
            this.shelf = shelf;
        }

        @Override
        synchronized public void run() {
            while(!currentThread().isInterrupted()){ // Если поток не прерван, -->

                try {
                    shelf.put(rnd.nextInt()); // Ложим на полку рандомное число.
                    System.out.println("Положено: " + shelf.get()); // Выводим положеное число.
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Costumer extends Thread { // Класс Братель наследуется от класса поток.
        private Shelf shelf; // Полка.


        private Costumer(Shelf shelf) {
            this.shelf = shelf;
        }

        @Override
        synchronized public void run() {
            while(!currentThread().isInterrupted()){
                try {
                    System.out.println("Взято: " + shelf.get());
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static class Shelf { // Класс полка.
        private Integer value; // Значение на полке.
        private boolean full = false; // Наличие на полке.

        public synchronized void put(Integer value) throws InterruptedException { // Синхронизированный метод добавления числа на полку.

            if(!full){
                this.value = value; // Ложим на полку число.
                this.full = true; // и говорим что полка полная.
                //wait();
            }
            notify();
        }

        public synchronized Integer get() throws InterruptedException { // Синхронизированный метод взятия числа с полку.

            if(full){
                this.full = false; // Говорим что полка пустая.
                //wait();
            }
            notify();

            return value;
        }
    }
}
