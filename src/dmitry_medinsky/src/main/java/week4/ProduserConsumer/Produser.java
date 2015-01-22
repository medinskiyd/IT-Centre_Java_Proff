package week4.ProduserConsumer;

/**
 * Created by Дмитрий on 07.02.14.
 */
public class Produser extends Thread {

    private Shelf shelf; // Наша полка на которой лежит число.

    public Produser(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public void run() {
        for(int i = 0; !currentThread().isInterrupted(); i++){
            try {
                shelf.put(i); // Ложим на полку рандомное число.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
