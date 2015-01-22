package week4.ProduserConsumer;

/**
 * Created by Дмитрий on 07.02.14.
 */
public class Consumer extends Thread {

    private Shelf shelf; // Полка.

    public Consumer(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            try {
                Integer number = shelf.get();
                System.out.println("Взято: " + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
