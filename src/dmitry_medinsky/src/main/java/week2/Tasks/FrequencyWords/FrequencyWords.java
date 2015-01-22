package week2.Tasks.FrequencyWords;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Дмитрий on 29.01.14.
 *
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole()
 - String setTextFromFile(String fileName)
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты
 */
public class FrequencyWords {

    TreeSet<String> setStr = new TreeSet<String>(); // Колекция слов.

    // Чтение текста из консоли.
    public String setTextFromConsole() {
        String str = "";

        Scanner scanConcole = new Scanner(System.in);
        str = scanConcole.nextLine();
        createWordsBase(str);

        return str;
    }

    // Чтение текста из файла.
    public String setTextFromFile(String fileName) throws FileNotFoundException {
        String str = "";

        Scanner scanFile = new Scanner(new FileReader(fileName));
        str = scanFile.toString();
        createWordsBase(str);

        return str;
    }

    // Создание рандомного текста.
    public String generateRandomText(int textLength) {
        String str = "";

//        String str = {"one","two","three"};
//        Random myRandom = new Random((long)str.length);
//        String str1 = [myRandom.nextInt()];
//
//
//        for(int i = 0; i < textLength; i++){
//            str = Math.random();
//        }
        return str;
    }

    public String createWordsBase(String str) { // Создание базы слов из строки.
        String word = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') { // Если символ не равен пробел, -->
                word = word + str.charAt(i); // создаем строку из перебираемых символов и -->
                 // добавляем созданное слово в нашу колекцию.
            } if(str.charAt(i) == ' ' || str.charAt(i) == '\r'){
                setStr.add(word);
                word = "";
            }

        }
        return word;
    }

    public Set<String> getWordsByFrequency(int frequency) {

        // беру 1 слово сравниваю со следующим, если слово не равно
        Iterator iterator;
        iterator = setStr.iterator();

        int compareStrings = 0;

        while (iterator.hasNext()){

            compareStrings = setStr.first().compareTo(iterator.next().toString());
            while (iterator.hasNext()) {
                compareStrings = setStr.first().compareTo(iterator.next().toString());
            }
        }


        return setStr;
    }
    @Override
    public String toString() {

        return setStr.toString();
    }

//    - Set<String> getWordsByFrequencyLessThan(int frequency)
//    - Set<String> getWordsByFrequencyMoreThan(int frequency)
//    - void printAcs() - вывести все слова + частота по возрастанию частоты
//    - void printDesc() - вывести все слова + частота по убыванию частоты
}
