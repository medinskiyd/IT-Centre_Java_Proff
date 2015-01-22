package week6;

import oracle.sql.BLOB;

import java.io.*;
import java.nio.ByteBuffer;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Дмитрий on 26.02.14.
 */
public class GetFileOutOfBase {

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

        String fileName = null;
        String path = null;
        Blob blob = null;

        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println(" Соединение установлено: " + conn.toString());

            System.out.println(" Введите имя файла:");
            Scanner scan = new Scanner(System.in);
            fileName = scan.nextLine();

            System.out.println(" Введите путь куда сохранить файл:");
            path = scan.nextLine();

            System.out.println(" Файл выгружается из базы в директорию " + path + " , пожалуйста подождите.");
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT file_data FROM files WHERE file_name = '"+fileName+"' ");

            while(resultSet.next()){
                blob = resultSet.getBlob("FILE_DATA");
            }

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new DataOutputStream(new FileOutputStream(new File(path+fileName))));

            bufferedOutputStream.write(blob.getBytes(1, (int)blob.length()));

            bufferedOutputStream.flush();
            bufferedOutputStream.close();


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


