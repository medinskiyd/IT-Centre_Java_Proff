package week3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 1/29/14
 */
public class QueueEx {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(20, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        q.offer(3);
        q.offer(4);
        q.offer(1);
        q.offer(2);

        for (Integer integer : q) {
            System.out.println(integer);
        }
    }
}
