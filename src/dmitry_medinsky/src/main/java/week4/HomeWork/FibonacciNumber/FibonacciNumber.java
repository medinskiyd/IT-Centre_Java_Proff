package week4.HomeWork.FibonacciNumber;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Дмитрий on 11.02.14.
 *
 * Написать многопоточное вычисление значения членов
 * ряда Фибоначчи до введенного пользователем числа.
 * Вывести на экран значения всех членов ряда.
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        int sizeOfPool = 10;
        int untilNumber = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println(" Введите число до которого выводить ряд Фибоначчи: ");
        untilNumber = scan.nextInt();

        ExecutorService poolOfFiboThread = Executors.newFixedThreadPool(sizeOfPool);
        FibonacciThread threadFibo = new FibonacciThread(untilNumber);
        poolOfFiboThread.submit(threadFibo);

        poolOfFiboThread.shutdown();
        scan.close();
    }
}

class FibonacciThread implements Runnable {
    private int untilNumber = 0;
    private int prev = 0;
    private int curr = 1;
    private int next = 0;

    public FibonacciThread(int untilNumber) {
        this.untilNumber = untilNumber;
    }

    @Override
    public void run() {

        while (next <= untilNumber) {
            if((next + curr) > untilNumber) {
                System.out.println(next + ".");
            } else {
                System.out.print(next + ", ");
            }

            prev = curr;
            curr = next;
            next = prev + curr;

        }
    }
}
