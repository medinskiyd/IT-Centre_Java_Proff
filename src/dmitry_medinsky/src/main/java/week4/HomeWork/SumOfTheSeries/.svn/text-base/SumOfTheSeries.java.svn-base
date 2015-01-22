package week4.HomeWork.SumOfTheSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Дмитрий on 11.02.14.
 *
 * Написать приложения для вычисление суммы элементов ряда
 * с использованием пула потоков. Число пользователь вводит
 * с клавиатуры. Например для 3 это 1+2+3=6.
 */

public class SumOfTheSeries {

    public static void main(String[] args) throws InterruptedException, IOException {

        int sizeOfPool = 10;
        int size = 0;

        System.out.println(" Введите число до которого считать сумму ряда: ");

        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        System.out.println(size);
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //size = bf.read();
        //System.out.println(bf.read());

        ExecutorService pool = Executors.newFixedThreadPool(sizeOfPool); // Создаем пул из 20 потоков.
        //ExecutorService pool = Executors.newCachedThreadPool(); // в таком виде не нужно явно указывать количество потоков в пуле.
        for (int i = 1; i < 500; i++) {
            SumOfNumbers sumOfNumbers = new SumOfNumbers(size + i); // Создаем объект класса "Сумма чисел".
            pool.submit(sumOfNumbers); // Добавляем в пул.
        }

        pool.shutdown();
    }

}

    class SumOfNumbers implements Runnable {
        private int size = 0;
        private int result = 0;

        public SumOfNumbers(int size) {
            this.size = size;
        }

        @Override
        public void run() {
            for (int i = 1; i <= size; i++) {
                result += i;
            }
            System.out.println("Сумма чисел ряда: " + result);
        }
    }
