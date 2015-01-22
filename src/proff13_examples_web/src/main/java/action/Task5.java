package action;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 01.12.13
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class Task5 {

    public ArrayList<Integer> secondHalf(ArrayList<Integer> baseArray){

        ArrayList<Integer> outArray = new ArrayList<>();
        if (baseArray.size()%2 == 0){
            for (int i = baseArray.size()/2; i < baseArray.size() ; i++) {
                outArray.add(baseArray.get(i));

            }

        }
        else {
            for (int i = (baseArray.size()/2+1); i < baseArray.size()  ; i++) {
                outArray.add(baseArray.get(i));

            }
        }
        return outArray;
    }
}

