package week5.HomeWork.AdministrationCompany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
  Created by Дмитрий on 16.02.14.
  Написать приложение выполняющее следующие действия по фирме:
    - Пользователь вводит значения всех обязательных полей таблицы сотрудник. Добавить нового сотрудника.
    - Удалить сотрудника по идентификационному номеру (id).
    - Перевести сотрудника в другой департамент.
    - Повысить сотрудника с увеличением зарплаты (на основании значений таблицы JOBS)
        пользователь вводит id сотрудника, должность и зарплату.
 */
public class AdministrationCompany1 {

        public static void main(String[] args) {

            String urlDB = "jdbc:oracle:thin:@localhost:1521:XE"; // Путь к нашей базе данных.
            String nameDB = "hr"; // Имя для входа в базу.
            String passDB = "hr"; // Пароль для входа в базу.

            Locale.setDefault(Locale.ENGLISH);
            System.out.println(" Приложение запущено.");
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver"); // Подключаем драйвер.

            } catch (ClassNotFoundException e) {
                System.out.println(" Драйвер не найден.");
                e.printStackTrace();
                return;
            }

            //addEmployee(urlDB, nameDB, passDB); //Добавление сотрудника в базу.
            //deleteEmployee(urlDB, nameDB, passDB); //Удаление сотрудника из базы.
            //changeDepEmployee(urlDB, nameDB, passDB); //Смена отдела сотрудника в базе.
            riseEmployee(urlDB, nameDB, passDB); //Повышение сотрудника.
        }

    // Пользователь вводит значения всех обязательных полей таблицы сотрудник. Добавить нового сотрудника.
    public static void addEmployee(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        Long idEmpl = null;
        String nameEmpl = null;
        String lastNameEmpl = null;
        String emailEmpl = null;
        String hireDateEmpl = null;
        String jobIdEmpl = null;
        Double salaryEmpl = null;

        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            // ____________ Начало ввода данных пользователем ____________
            System.out.println(" Добавление нового сотрудника в базу.");

            System.out.println(" Введите id сотрудника:");
            idEmpl = scan.nextLong();

            System.out.println(" Введите имя сотрудника:");
            nameEmpl = keyboard.readLine();

            System.out.println(" Введите фамилию сотрудника:");
            lastNameEmpl = keyboard.readLine();

            System.out.println(" Введите EMAIL сотрудника:");
            emailEmpl = keyboard.readLine();

            System.out.println(" Введите дату принятия на работу сотрудника (Пример: 00/MON/0000) :");
            hireDateEmpl = keyboard.readLine();

            System.out.println(" Введите id должности сотрудника:");
            jobIdEmpl = keyboard.readLine();

            System.out.println(" Введите зарплату сотрудника:");
            salaryEmpl = scan.nextDouble();
            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика добавления сотрудника _________________

            statement.executeUpdate("INSERT INTO employees VALUES ('"+idEmpl+"','"+nameEmpl+"','"+lastNameEmpl+"','"+emailEmpl+"','','"+hireDateEmpl+"','"+jobIdEmpl+"','"+salaryEmpl+"','','','')");
            System.out.println(" Сотрудник с id: " + idEmpl + " " + nameEmpl + " " + lastNameEmpl + " " + " добавлен в базу.");

            // ____________ Закрытие всех открытых потоков ________________
            keyboard.close();
            scan.close();

            // ____________ Отловка исключений ____________________________
        } catch (SQLException e) {
            System.out.println(" Соединение прервано.");
            e.printStackTrace();
            return;

        } catch (IOException e) {
            System.out.println(" Неверные входные данные.");
            e.printStackTrace();
            return;
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }


        }
    }

    // Удалить сотрудника по идентификационному номеру (id).
    public static void deleteEmployee(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        Long idEmpl = null;


        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Удаление сотрудника из базы.");

            System.out.println(" Введите id сотрудника для удаления его из базы:");
            idEmpl = scan.nextLong();

            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика удаления сотрудника _________________

            statement.executeUpdate("DELETE FROM employees WHERE employee_id = '"+idEmpl+"' ");
            System.out.println(" Сотрудник с id " + idEmpl + " удален из базы.");

            // ____________ Закрытие всех открытых потоков ________________
            scan.close();

            // ____________ Отловка исключений ____________________________
        } catch (SQLException e) {
            System.out.println(" Соединение прервано.");
            e.printStackTrace();
            return;

        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }


        }
    }

    // Перевести сотрудника в другой департамент.
    public static void changeDepEmployee(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        Long idEmpl = null;
        int department_id = 0;

        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Перевод сотрудника в другой отдел.");

            System.out.println(" Введите id сотрудника для перевода:");
            idEmpl = scan.nextLong();

            System.out.println(" Введите номер отдела в который следует перевести сотрудника:");
            department_id = scan.nextInt();
            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика перевода сотрудника в другой департамент _________________

            statement.executeUpdate("UPDATE employees SET department_id = '"+department_id+"' WHERE employee_id = '"+idEmpl+"' ");
            System.out.println(" Сотрудник с id " + idEmpl + " переведен в " + department_id + " департамент.");

            // ____________ Закрытие всех открытых потоков ________________
            scan.close();

            // ____________ Отловка исключений ____________________________
        } catch (SQLException e) {
            System.out.println(" Соединение прервано.");
            e.printStackTrace();
            return;

        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }


        }
    }

//    Повысить сотрудника с увеличением зарплаты (на основании значений таблицы JOBS)
//    пользователь вводит id сотрудника, должность и зарплату.
    public static void riseEmployee(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        Long idEmpl = null;
        String jobEmpl = null;
        Double salaryEmpl = null;
        String min_salary = null;
        String max_salary = null;
        String job_id = null;

        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Повышение сотрудника.");

            System.out.println(" Введите id сотрудника для перевода:");
            idEmpl = scan.nextLong();

            System.out.println(" Введите новую должность сотрудника:");
            jobEmpl = keyboard.readLine();

            ResultSet resultSet = statement.executeQuery(" SELECT min_salary, max_salary, job_id FROM jobs WHERE job_title = '"+jobEmpl+"' ");

            while(resultSet.next()) {
                min_salary = resultSet.getString("MIN_SALARY");
                max_salary = resultSet.getString("MAX_SALARY");
                job_id = resultSet.getString("JOB_ID");
            }
            System.out.println(" Введите новую зарплату сотрудника в диапазоне " + min_salary + " - " + max_salary + ":");
            salaryEmpl = scan.nextDouble();
            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика  ______________________________________
            statement.executeUpdate("DELETE hr.job_history WHERE employee_id= '"+idEmpl+"' ");
            statement.executeUpdate("UPDATE employees SET job_id = '"+job_id+"', salary = '"+salaryEmpl+"' WHERE employee_id = '"+idEmpl+"' ");
            System.out.println(" Сотрудник с id " + idEmpl + " переведен на должность " + jobEmpl + " с зарплатой " + salaryEmpl);


            // ____________ Закрытие всех открытых потоков ________________
            scan.close();
            keyboard.close();

            // ____________ Отловка исключений ____________________________
        } catch (SQLException e) {
            System.out.println(" Соединение прервано.");
            e.printStackTrace();
            return;

        } catch (IOException e) {
            System.out.println(" Неверные входные данные.");
            e.printStackTrace();
            return;
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }


        }
    }

}

