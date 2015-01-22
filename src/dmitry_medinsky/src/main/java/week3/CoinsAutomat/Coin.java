package week3.CoinsAutomat;

/**
 * Created by Дмитрий on 29.01.14.
 */
public class Coin {

    private int valueCoin = 0;
    private String nameCoin = "";


    public Coin(){

    }

    public Coin(String name, int value){
        this.nameCoin = name;
        this.valueCoin = value;
    }

    public int getValueCoin() {
        return valueCoin;
    }

    public void setValueCoin(int value) {
        this.valueCoin = value;
    }

    public String getNameCoin() {
        return nameCoin;
    }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }
}
