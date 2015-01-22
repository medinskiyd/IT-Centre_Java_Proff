package week3.CoinsAutomat;

import java.util.PriorityQueue;

/**
 * Created by Дмитрий on 29.01.14.
 ДОПИСАТЬ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

 */
public class Task52 implements Comparable<Coin>  {

    Coin coin = new Coin();

    @Override
    public int compareTo(Coin o) {

         //o.compareTo(coin);

        return 0;
    }

    PriorityQueue<Coin> walet = new PriorityQueue<Coin>();

    public void sortCoin(){

        walet.offer(new Coin("50 копеек", 50));
        walet.offer(new Coin("5 копеек", 5));
        walet.offer(new Coin("25 копеек", 25));
        walet.offer(new Coin("10 копеек", 10));
        walet.offer(new Coin("1 копейка", 1));
        walet.offer(new Coin("50 копеек", 50));
        walet.offer(new Coin("25 копеек", 25));
        walet.offer(new Coin("50 копеек", 50));


        for(int i = 0; i < walet.size(); i++) {
            System.out.println(walet.poll().getNameCoin());
        }
    }

}
