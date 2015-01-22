package week4.ProduserConsumer;

/**
 * Created by Дмитрий on 07.02.14.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Shelf shelf = new Shelf(); // Объект полка.
        Produser produser = new Produser(shelf); // Объект добавляющий числа на полку.
        Consumer costumer = new Consumer(shelf); // Объект берущий числа с полки.


        produser.start(); // Запускается поток добавления числа на полку.
        costumer.start(); // Запускается поток приема числа с полки.
        Thread.sleep(2000); // Главный поток засыпает на 2000 мс.
        produser.interrupt(); // Заканчивает работать поток добавления.
        costumer.interrupt(); // Заканчивает работать поток приема.
    }

}
