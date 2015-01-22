package week1.Cashier;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 18.01.14.
 *
 * Написать рабочее место кассира в супермаркете:
 Авторизация по имени и паролю.
 Создать покупку
 Добавить в покупку товар по штрихкоду, указать кол-во единиц покупаемого товара
 Убрать из покупки товар по штрихкоду, указать кол-во единиц покупаемого товара
 Отменить покупку
 Завершить покупку, на экран выводится общаяя сумма покупки
 */
public class Cashier {

    private boolean decision = false; // Решение о прохождении авторизации.
    private String cashierName = "Дима";
    private String cashierPassword = "best";


    // Авторизация по имени и паролю.
    public void autorisation(String cashierName, String cashierPassword) {
        try{
        if (this.cashierName.equals(cashierName) && this.cashierPassword.equals(cashierPassword)) {
            System.out.println("Авторизация пройдена, добро пожаловать " + cashierName + " !");
            decision = true;
        } else {
            System.out.println("Авторизация не пройдена, попробуйте еще раз.");
            decision = false;
        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Создать покупку.
    public Buy newBuy() {

        Buy newBuy = new Buy();
        System.out.println("Покупка создана, проводите товары.");
        return newBuy;

    }
}

class Buy {

    static private int numberOfBuy = 0;
    private double amount = 0;
    private int numberOfGoods = 0;

    ArrayList<Goods> buyList = new ArrayList<Goods>();
    // Добавить в покупку товар по штрихкоду, указать кол-во единиц покупаемого товара.
    public void addGoods(int barcode, int number) {
        buyList.add(new Goods(barcode, number));
    }

    // Убрать из покупки товар по штрихкоду, указать кол-во единиц убираемого товара.
    public void deleteGoods(int barcode, int number){

        for (int i = 0; i < buyList.size(); i++){

            if (barcode == buyList.get(i).getBarcode()){
                if(number == buyList.get(i).getNumber()){
                    buyList.remove(i);
                    System.out.println("Удаляем из покупки " + buyList.get(i).getName() + " * " + buyList.get(i).getNumber());
                }
                if(number < buyList.get(i).getNumber()){
                    buyList.get(i).setNumber(buyList.get(i).getNumber() - number);
                    System.out.println("Удаляем из покупки " + buyList.get(i).getName() + " * " + buyList.get(i).getNumber());
                }
            }
        }


    }
    // Отменить покупку.
    public void deleteBuy() {

        buyList = null;
        amount = 0;
        numberOfBuy = 0;
        numberOfGoods = 0;
        System.out.println("Покупка отменена!");

    }
    //  Завершить покупку, на экран выводится общаяя сумма покупки.
    public void endBuy() throws Exception{

        try{
            for(int i = 0; i < buyList.size(); i++){
                amount += buyList.get(i).getPrice();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Покупка закончена, заплатите = " + amount + " грн." );
    }


}

class Goods {

    private String name = null;
    private double price = 0;
    private int number = 0;
    private int barcode = 0;



    public Goods(int barcode, int number){

        if(barcode == 1) {
            this.name = "Молоко";
            this.price = 10.50 * number;
            this.barcode = 1;
        } else if(barcode == 2) {
            this.name = "Хлеб";
            this.price = 4.45 * number;
            this.barcode = 2;
        } else if(barcode == 3) {
            this.name = "Мяч";
            this.price = 45.99 * number;
            this.barcode = 3;
        }
        System.out.println(name + " * " + number + " = " + price + " грн.");

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {

        return number;
    }

    public int getBarcode() {
        return barcode;
    }
}


