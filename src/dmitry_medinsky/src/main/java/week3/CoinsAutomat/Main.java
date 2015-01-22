package week3.CoinsAutomat;

import java.util.Scanner;

/**
 * Created by Дмитрий on 29.01.14.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CoinsAutomat charly = new CoinsAutomat();

        charly.buyTicket(1);

        Task52 waletSort = new Task52();
        waletSort.sortCoin();
    }



}
