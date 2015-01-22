package week6.dao;

import java.io.InputStream;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/26/14
 */
public class FilesJdbcDao implements FilesDao {
    @Override
    public Long create(File file) {
        return null;
    }

    @Override
    public File read(int id) throws ClassNotFoundException {
        File file = null;
        System.out.println("Application started...");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        Statement statement = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection established!");
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM files WHERE id = '" + id + "'");

            if(resultSet.next()) {
                String name = resultSet.getString("name");
                InputStream content = resultSet.getBinaryStream("content");
                file = new File(id, name, content);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
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
        return file;
    }

    @Override
    public void update(File file) {

    }

    @Override
    public void delete(File file) {

    }
}
