package action;/* Создано 01.12.13 в 16:37 */

import java.util.ArrayList;

public class Task3
{
    boolean isEven(Integer n) {
        if (n % 2 == 0) {return true;} else {return false;}
    }
    public ArrayList<Integer> go (ArrayList<Integer> input){
        ArrayList<Integer> outArray = new ArrayList<>();
        for (int i=0; i<input.size(); i++){
            if (isEven(input.get(i))) {input.set(i, 0);}}
        for (int i=0; i<input.size(); i++){outArray.add(input.get(i));}
        return outArray;
    }
}

