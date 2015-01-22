package week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Дмитрий on 18.01.14.
 */
public class ReaderEX {
    public static void main(String[] args) throws IOException { // Потоки ввода-вывода выбрасывают IOException.
        FileReader reader = null; // Создаем переменную потока для чтения из файла.
        BufferedReader br = null; // Создаем буферную переменную потока для чтения из файла.

//        String line = null; // Создаем переменную строка.

// _______Менее предпочтительный вариант чтения информации из файла, но он показывает суть.
//        try { // Открываем проверяемый блок.
//            reader = new FileReader("text.txt"); // Присваиваем нашей переменной reader поток с именем файла который нужно прочесть.
//            br = new BufferedReader(reader); // Присваиваем нашей переменной br поток который содержит уже имеющийся поток reader.
//            int elem = 0; // Создаем переменную типа int.
//            while((elem = reader.read()) > 0) { // Создаем цикл, который читает элементы в файле, при условии больше 0.
//                System.out.print((char)elem); // Выводит символ в консоль.
//            }
//            while((line = br.readLine()) != null) { //используем BufferedReader, более предпочтительнее.
//                System.out.print(line); // Выводит в консоль всю строку.
//            }
//
//        } catch (Exception e) { // Ловим исключение.
//            e.printStackTrace(); // Если появилось исключение, пишем путь в стеке.
//        } finally { // В любом случае исполнящийся код.
//            if (reader != null) { // Если байтовый поток не равен null, закрываем этот поток.
//                try {
//                    reader.close(); // закрываем этот поток.
//                } catch (IOException e) {} // В ином случае ловим исключение.
//            }
//            if (br != null) { // Если буферный поток не равен null,
//                try {
//                    br.close(); // закрываем этот поток.
//                } catch (IOException e) {} // В ином случае ловим исключение.
//            }
//        }
        try (FileReader reader1 = new FileReader("text.txt"); // Создаем байтовый поток reader и даем ему для чтения файл "text.txt".
             BufferedReader br1 = new BufferedReader(reader1) // Создаем буферный поток reader и даем ему для чтения поток reader.
        )
        {
            String line = null; // Создаем переменную строка.
            while((line = br1.readLine()) != null) { // Создаем цикл, в условии проверяем, равна ли наша строка null.
                System.out.println(line); // Пока наша строка не равна null выводим её в консоль.
            }
        } catch (Exception e) {
            e.printStackTrace();
        } // Ловим исключение.
    }
}
