package week5;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Дмитрий on 14.02.14.
 */
public class Task102 {

        public static void main(String[] args) {

            Locale.setDefault(Locale.ENGLISH);
            System.out.println("Application started...");
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");

            } catch (ClassNotFoundException e) {
                System.out.println("Driver not found");
                e.printStackTrace();
                return;
            }

            Connection conn = null;
            Statement statement = null;
            String url = "jdbc:oracle:thin:@localhost:1521:XE";

            try {
                conn = DriverManager.getConnection(url, "hr", "hr");
                System.out.println(" Соединение установлено: " + conn.toString());

                statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT salary,first_name FROM employees WHERE salary > 10000 AND first_name LIKE '%i%'");

                while(resultSet.next()){
                    String first_name = resultSet.getString("FIRST_NAME");
                    System.out.printf(first_name + " ");

                }

            } catch (SQLException e) {
                System.out.println("Connection failed");
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
            // Закрывать все соединения что открыли.
        }
    }
