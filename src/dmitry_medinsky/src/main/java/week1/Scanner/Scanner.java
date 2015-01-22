package week1.Scanner;

/**
 * Created by Дмитрий on 21.01.14.
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Scanner {

//  --------Поля--------
    private String string;
    private InputStream inputStr;
    private BufferedInputStream buffInputStr;
    private StringBuilder strBuild;
    private BufferedReader buffRead;
    private int pointer; // Указатель для String.
    private char delimiter = 32; // Разделитель, используемый в методе next();
    private String result; // Результат проверки hasNext...
    private boolean isHasNextDone = false; // Выполнился один из методов hasNext - имеем true, в противном случае false.
    private boolean closed = false; // close() выполнился, имеем true.
    private int numberInputMetod; // Используемый способ ввода (0.String; 1.FileReader).

//  --------Конструкторы--------
    // Для работы со строкой.
    public Scanner(String str) {
    this.string = str;
    numberInputMetod = 0;
}
    // Для работы с FileReader.
    public Scanner(FileReader fr) {
    buffRead = new BufferedReader(fr);
    numberInputMetod = 1;
}

//  --------Методы--------
    // Чтение одного слова в строке.
    public String next() {
    if (closed) {
        throw new NoSuchElementException();
    }
    if (isHasNextDone) {
        isHasNextDone = false;
        return result;
    } else {
        if (numberInputMetod == 0) {
            try {
                strBuild = new StringBuilder();
                while (string.charAt(pointer) != delimiter && string.charAt(pointer) != '\n') {
                    strBuild.append(string.charAt(pointer++));
                }
                pointer++;
                while (string.charAt(pointer) == delimiter || string.charAt(pointer) == '\n') {
                    pointer++;
                }
                return strBuild.toString();
            } catch (StringIndexOutOfBoundsException e) {
                return strBuild.toString();
            }
        } else if (numberInputMetod == 1) {
            try {
                strBuild = new StringBuilder();
                int a;
                while ((a = buffRead.read()) == '\n' || a == delimiter) {

                }
                while (a != delimiter && a != -1) {
                    if (a == '\n') {
                        a = buffRead.read();
                        break;
                    }
                    strBuild.append((char) a);
                    a = buffRead.read();
                }
                return strBuild.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return null;
}
    // Чтение целого числа из строки или InputMismatchException.
    public int nextInt() {
        if (closed) {
            throw new NoSuchElementException();
        }
        if (isHasNextDone) {
            isHasNextDone = false;
            try {
                return Integer.parseInt(result);
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        } else {
            if (numberInputMetod == 0) {
                strBuild = new StringBuilder();
                try {
                    try {
                        while (string.charAt(pointer) != 32 && string.charAt(pointer) != '\n') {
                            strBuild.append(string.charAt(pointer++));
                        }
                        pointer++;
                        while (string.charAt(pointer) == 32 || string.charAt(pointer) == '\n') {
                            pointer++;
                        }
                        return Integer.parseInt(strBuild.toString());
                    } catch (StringIndexOutOfBoundsException e) {
                        return Integer.parseInt(strBuild.toString());
                    }
                } catch (NumberFormatException e) {
                    throw new InputMismatchException();
                }
            } else if (numberInputMetod == 1) {
                try {
                    strBuild = new StringBuilder();
                    int a;
                    while ((a = buffRead.read()) == 32 || a == '\n') {
                    }
                    while (a != 32 && a != '\n') {
                        if (a == -1) {
                            break;
                        }
                        strBuild.append((char) a);
                        a = buffRead.read();
                    }
                    try {
                        return Integer.parseInt(strBuild.toString());
                    } catch (NumberFormatException e) {
                        throw new InputMismatchException();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
    // Чтение всей строки.
    public String nextLine() {
        strBuild = new StringBuilder();
        if (closed) {
            throw new NoSuchElementException();
        }
        if (isHasNextDone) {
            isHasNextDone = false;
            return result;
        } else {
            if (numberInputMetod == 0) {
                try {
                    while (string.charAt(pointer) == '\n') {
                        pointer++;
                    }
                    while (string.charAt(pointer) != '\n') {
                        strBuild.append(string.charAt(pointer++));
                    }
                    return strBuild.toString();
                } catch (StringIndexOutOfBoundsException e) {
                    return strBuild.toString();
                }
            } else {
                if (numberInputMetod == 1) {
                    try {
                        String line;
                        while ((line = buffRead.readLine()).isEmpty()) {
                        }
                        return line;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    } catch (NullPointerException e) {
                        return "";
                    }
            }
            return null;
        }
    }
}
    // Определение наличия в потоке данных.
    public boolean hasNext() {

        if(closed){
            throw new NoSuchElementException();
        }
        result = next();
        isHasNextDone = true;
        if (result.isEmpty()) {
            return false;
        }
        return true;
    }
    // Определение наличия в потоке целого int числа.
    public boolean hasNextInt() {
        if(closed){
            throw new NoSuchElementException();
        }
        try {
            result = String.valueOf(nextInt());
            isHasNextDone = true;
            return true;
        } catch (InputMismatchException e) {
            return false;
        }
    }
    // Задаем символ разделителя.
    public void useDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
    // Закрытие сканнера, теперь нельзя использовать и NoSuchElementException.
    public void close() throws NoSuchElementException {
        try {
            buffInputStr.close();
            buffRead.close();
            closed = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

