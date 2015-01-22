package week1.Cashier;


import java.util.Scanner;

/**
 * Created by Дмитрий on 18.01.14.
 * имя: Дима
 * пароль: best
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Cashier firstCasier = new Cashier();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scan.nextLine();
        System.out.println("Введите пароль:");
        String pass = scan.nextLine();
        firstCasier.autorisation(name, pass);
        Buy newBuy = firstCasier.newBuy();
        newBuy.addGoods(3,4);
        newBuy.addGoods(1,3);
        newBuy.addGoods(2,1);
        newBuy.deleteGoods(3,3);
        newBuy.endBuy();

        scan.close();
    }

}

