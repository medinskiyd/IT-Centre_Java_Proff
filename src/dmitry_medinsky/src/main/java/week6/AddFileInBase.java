package week6;

import java.io.*;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Дмитрий on 26.02.14.
 */
public class AddFileInBase {

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
            String path = null;
            int id = 0;
            String fileName = null;

            try {
                conn = DriverManager.getConnection(url, "hr", "hr");
                System.out.println(" Соединение установлено: " + conn.toString());

                System.out.println(" Введите имя файла:");
                Scanner scan = new Scanner(System.in);
                fileName = scan.nextLine();

                System.out.println(" Введите путь где лежит файл:");
                path = scan.nextLine();

                File file = new File(path);

                PreparedStatement prep = conn.prepareStatement("INSERT INTO files (id, file_name, file_data) VALUES (file_seq.nextVal, ?, ?)");
                prep.setString(1, fileName);
                prep.setBinaryStream(2, new FileInputStream(file), (int)file.length());
                prep.executeUpdate();

                System.out.println(" Файл загружается в базу...");
                System.out.println(" Готово");

                scan.close();

            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
                return;

            } catch (IOException e) {
                e.printStackTrace();
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

