package week3.CoinsAutomat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Дмитрий on 29.01.14.
 */
public class CoinsAutomat {

    Queue<Coin> walet = new LinkedList<Coin>();
    ArrayList<Coin> loseCoins = new ArrayList<Coin>();

    public void buyTicket(int amountTicket){

        String nameCoin = "";
        int money = 0;
        int ticketPrice = 200;

        walet.offer(new Coin("1 монета", 1));
        walet.offer(new Coin("50 монет", 50));
        walet.offer(new Coin("50 монет", 50));
        walet.offer(new Coin("50 монет", 50));
        walet.offer(new Coin("50 монет", 50));
        walet.offer(new Coin("10 монета", 10));
        walet.offer(new Coin("20 монета", 20));
        walet.offer(new Coin("10 монета", 10));
        walet.offer(new Coin("10 монета", 10));
        walet.offer(new Coin("20 монета", 20));


        money = walet.peek().getValueCoin();
        loseCoins.add(walet.peek());
        walet.poll();
        for(int i = 0; i < walet.size(); i++){
            if(money < (ticketPrice * amountTicket)) {
                money = money + walet.peek().getValueCoin();
                loseCoins.add(walet.peek());
                walet.poll();
            } else if (money >= (ticketPrice * amountTicket)) {
                System.out.println("Вы потратили такие монеты:");
                for(int j = 0; j < loseCoins.size(); j++) {
                    System.out.print(loseCoins.get(j).getNameCoin() + " ");
                }
                System.out.println();
                System.out.println("Для покупки " + amountTicket + " жетонов.");
                break;
            }
        }

    }

}
