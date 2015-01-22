package week6.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/26/14
 */
public class BlobEx {

    public static void main(String[] args) {
        saveFileToDb(1, "oracle", "/home/al1/install/java/oracle-xe-universal_10.2.0.1-1.1_i386.deb");
    }

    private static void saveFileToDb(int id, String name, String path) {
        System.out.println("Saving started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e)  {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        PreparedStatement statement = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection established!");
            statement = conn.prepareStatement("INSERT INTO files (id, name, content) VALUES (file_seq.nextval, ?, ?)");
//            statement.setInt(1, id);
            statement.setString(1, name);
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            statement.setBinaryStream(2, inputStream, (int) file.length());
            statement.executeUpdate();
            System.out.println("Done");
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
