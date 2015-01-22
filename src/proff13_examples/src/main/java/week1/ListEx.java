package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 1/17/14
 */
public class ListEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(1,2,3));
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
