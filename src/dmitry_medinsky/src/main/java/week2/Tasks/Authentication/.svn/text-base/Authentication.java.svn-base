package week2.Tasks.Authentication;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Дмитрий on 27.01.14.
 * Написать класс аутентификации пользователя по логину и паролю, с методами:
    - boolean authenticate() - ввод логина и пароля + проверка
    - boolean authenticate(String login, String pass)
    - add(String login, String pass)
    - remove(String login)
 */
public class Authentication {

    private String login = "";
    private String password = "";
    private int numberUsers = 0; // Количество пользователей.
    HashMap baseUsers = new HashMap();

    public boolean authenticate() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя: ");
        this.login = scan.nextLine();

        System.out.println("Введите пароль: ");
        this.password = scan.nextLine();

        return authenticate(login, password);

    }

    public boolean authenticate(String login, String password) {

        if(baseUsers.containsKey(login) == true && baseUsers.get(login) == password) {
            System.out.println("Аутентификация прошла успешно! Вход выполнен.");
            return true;
        } else {
            System.out.println("Имя или пароль введены не верно, либо данного пользователя не существует - зарегистрируйтесь.");
            return false;
        }
    }

    public void add(String login, String password) throws UserIsException {

            try {
                if (baseUsers.containsKey(login) == false) { // Если пользователя нет, ->
                    baseUsers.put(login, password); // Добавляем нового пользователя.
                    System.out.println(login + " зарегистрирован, регистрация прошла успешно."); // Даем знать что пользователь теперь в нашей базе.
                } else {
                    if(baseUsers.containsKey(login) == true) throw new UserIsException(); // Если пользователь есть в базе выбрасываем исключение.
                }
            } catch (UserIsException UIE) {
                System.out.println("Пользователь с именем " + login + " уже существует, для регистрации придумайте другое имя.");
            } catch (NullPointerException e) {
                System.out.println("Введено недопустимое значение!");
            }
        }

    public void remove(String login) {
        try {
            if (baseUsers.containsKey(login) == false) { // Если пользователя нет, ->
                System.out.println("Пользователь с таким именем "+ login +" отсутствует в базе."); // Пользователь отсутствует в базе.
            } else {
                if(baseUsers.containsKey(login) == true) { // Если пользователь есть в базе, можем удалить его.
                      baseUsers.remove(login);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Введено недопустимое значение!");
        }
    }

    /**
     * Created by Дмитрий on 27.01.14.
     */
    public static class UserIsException extends Exception {



    }
}
