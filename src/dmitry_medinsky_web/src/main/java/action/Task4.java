package action;/* Создано 01.12.13 в 16:37 */

import java.util.ArrayList;

public class Task4
{
    boolean isPrime(Integer n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
    public ArrayList<Integer> go (ArrayList<Integer> input){
        ArrayList<Integer> outArray = new ArrayList<>();
        for (int i=0; i<input.size(); i++){
            if (isPrime(input.get(i))) {input.remove(i);}}
        for (int i=0; i<input.size(); i++){outArray.add(input.get(i));}
        return outArray;
    }
}

