package week5.HomeWork.AdministrationCompany2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Дмитрий on 16.02.14.
 - Пользователь вводит диапазон зарплат.
        Получить имя сотрудников и их зарплаты в порядке возрастания дат зачисления на работу.
 - Пользователь вводит должности. Получить имя и должности сотрудников,
        должность которых не входит в введеный список. Например: ST_CLERK IT_PROG MK_MAN.
 - Пользователь вводит имя департамента, вывести всех сотрудников из этого департамента.
 - Пользователь вводит имя менеджера, вывести всех сотрудников,
        которые взяты на работу в течении последнего месяца, у которых менеджер тот, имя которого введено.

 */
public class AdministrationCompany2 {


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

        //diapSalary(urlDB, nameDB, passDB); // Диапазон зарплаты.
        //outEmpl(urlDB, nameDB, passDB); // Не нужные должности.
        depEmpl(urlDB, nameDB, passDB); // Департамент.
        //manager(urlDB, nameDB, passDB); // Менеджер.

    }

    // Пользователь вводит диапазон зарплат.
    // Получить имя сотрудников и их зарплаты в порядке возрастания дат зачисления на работу.
    public static void diapSalary(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        int minSalary = 0;
        int maxSalary = 0;
        String nameEmpl = null;
        String lastNameEmpl = null;
        String hireDateEmpl = null;
        Double salaryEmpl = null;

        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Информация о сотрудниках исходя из их зарплаты.");

            System.out.println(" Введите нижнюю границу зарплаты сотрудника:");
            minSalary = scan.nextInt();

            System.out.println(" Введите верхнюю границу зарплаты сотрудника:");
            maxSalary = scan.nextInt();
            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика сортиовки сотрудников сотрудников _________________

            ResultSet resultSet = statement.executeQuery(" SELECT first_name, last_name FROM employees WHERE salary >= '"+minSalary+"' AND salary <= '"+maxSalary+"' ORDER BY hire_date");

            while(resultSet.next()) {
                nameEmpl = resultSet.getString("FIRST_NAME");
                lastNameEmpl = resultSet.getString("LAST_NAME");
                System.out.println(" " + nameEmpl + " " + lastNameEmpl + " ");
            }

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

//    Пользователь вводит должности. Получить имя и должности сотрудников,
//    должность которых не входит в введеный список. Например: ST_CLERK IT_PROG MK_MAN.
        //ДОДЕЛАТЬ!!! При вводе одной должности работает, со списком должностей не разобрался.
    public static void outEmpl(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        String nameEmpl = null;
        String lastNameEmpl = null;
        int numberJob = 0;
        ArrayList list = new ArrayList<String>();
        String jobId = null;
        String result = null;

        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Информация о сотрудниках исходя из не введенных должностей.");

            System.out.println(" Введите должности сотрудников:");

            jobId = scan.nextLine();
//            for(int i = 0; i <= numberJob; i++){
//                jobId = scan.nextLine();
//                if(jobId != null){
//                    result = result + jobId + ", ";
//                    //list.add(jobId);
//                }
//            }

            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика _________________

            String result1 = list.toString(); // [IT_RPOG, AD_PRES]
            String resultJobIdList = result1.replaceAll("\\[|\\]", ""); // IT_RPOG, AD_PRES
            System.out.println(resultJobIdList);
//
//            String a = " 'AD_PRES' OR job_id = 'IT_PROG' ";

            ResultSet resultSet = statement.executeQuery(" SELECT first_name, last_name, job_id FROM employees WHERE job_id not in '"+resultJobIdList+"' ORDER BY job_id ");

            while(resultSet.next()) {
                nameEmpl = resultSet.getString("FIRST_NAME");
                lastNameEmpl = resultSet.getString("LAST_NAME");
                jobId = resultSet.getString("JOB_ID");
                System.out.println(" " + nameEmpl + " " + lastNameEmpl + " " + jobId + " ");
            }

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

    // Пользователь вводит имя департамента, вывести имена всех сотрудников из этого департамента.
    public static void depEmpl(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        String dep_name = null;
        String dep_id = null;
        String nameEmpl = null;
        String lastNameEmpl = null;


        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Сотрудники департамента.");

            System.out.println(" Введите название департамента:");
            dep_name = scan.nextLine();
            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика поиска департамента сотрудников _________________

            ResultSet resultSet1 = statement.executeQuery(" SELECT department_id FROM departments WHERE department_name = '"+dep_name+"' ");

            while(resultSet1.next()) {
                dep_id = resultSet1.getString("DEPARTMENT_ID");

            }

            ResultSet resultSet = statement.executeQuery(" SELECT first_name, last_name FROM employees WHERE department_id = '"+dep_id+"' ");

            while(resultSet.next()) {
                nameEmpl = resultSet.getString("FIRST_NAME");
                lastNameEmpl = resultSet.getString("LAST_NAME");
                System.out.println(" " + nameEmpl + " " + lastNameEmpl + " ");
            }

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

    // Пользователь вводит имя менеджера, вывести всех сотрудников,
    // которые взяты на работу в течении последнего месяца, у которых менеджер тот, имя которого введено.
    public static void manager(String urlDB, String nameDB, String passDB){

        Connection conn = null;
        Statement statement = null;
        String managerName = null;
        String managerLastName = null;
        String managerId = null;
        String nameEmpl = null;
        String lastNameEmpl = null;

        try {
            // ____________ Создание соединения с базой данных ___________
            conn = DriverManager.getConnection(urlDB, nameDB, passDB);
            System.out.println(" Соединение установлено: " + conn.toString());
            statement = conn.createStatement();

            // ____________ Создание потоков ввода данных ________________
            Scanner scan = new Scanner(System.in);

            // ____________ Начало ввода данных пользователем _____________
            System.out.println(" Сотрудники менеджера.");

            System.out.println(" Введите имя менеджера:");
            managerName = scan.nextLine();

            System.out.println(" Введите фамилию менеджера:");
            managerLastName = scan.nextLine();
            // ____________ Конец ввода данных пользователем _____________

            // ____________ Логика поиска департамента сотрудников _________________

            ResultSet resultSet = statement.executeQuery(" SELECT employee_id FROM employees WHERE first_name = '"+managerName+"' AND last_name = '"+managerLastName+"' ");

            while(resultSet.next()) {
                managerId = resultSet.getString("EMPLOYEE_ID");
            }
            System.out.println("Эти сотрудники работают на менеджера " + managerName + " " + managerLastName + ":");

            ResultSet resultSet1 = statement.executeQuery(" SELECT first_name, last_name FROM employees WHERE manager_id = '"+managerId+"' AND hire_date > ADD_MONTHS(SYSDATE, -1) ");

            while(resultSet1.next()) {
                nameEmpl = resultSet1.getString("FIRST_NAME");
                lastNameEmpl = resultSet1.getString("LAST_NAME");
                System.out.println(" " + nameEmpl + " " + lastNameEmpl + " ");
            }

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



}
