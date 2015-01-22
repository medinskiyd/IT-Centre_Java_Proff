package weekend3.jdbc;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class ConnectEx {
    public static void main(String[] args) {
        System.out.println("Application started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e)  {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        Statement statement = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection established!");
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            while(resultSet.next()) {
                long id = resultSet.getLong(1);
                String first_name = resultSet.getString("FIRST_NAME");
                System.out.printf("%d      %s", id, first_name);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return;
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {}
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
