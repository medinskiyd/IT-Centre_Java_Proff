package week6.DAO;

import java.io.InputStream;
import java.sql.*;
import java.util.Locale;

/**
* Created by Дмитрий on 26.02.14.
*/
public class RegionsJDBCDAO implements RegionsDAO {

    @Override
    public Region create(String regionName) throws ClassNotFoundException {

        Region region = new Region();
        Locale.setDefault(Locale.ENGLISH);
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
            statement.executeUpdate(
                    "INSERT INTO regions (region_id, region_name) VALUES (reg_seq.nextVal, '"+regionName+"')");

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM regions WHERE region_name = '"+regionName+"' ");


            if(resultSet.next()) {
                region.setRegionName(resultSet.getString("REGION_NAME"));
                region.setRegionId(resultSet.getLong("REGION_ID"));
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
        return region;
    }

    @Override
    public Region read(Long regionId) throws ClassNotFoundException {

        Region region = new Region();
        Locale.setDefault(Locale.ENGLISH);
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
                    "SELECT region_name, region_id FROM regions WHERE region_id = '" + regionId + "' ");

            if(resultSet.next()) {
                region.setRegionName(resultSet.getString("REGION_NAME"));
                region.setRegionId(resultSet.getLong("REGION_ID"));
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
        return region;
    }

    @Override
    public Region update(Long regionId, String regionName) throws ClassNotFoundException {

        Region region = new Region();
        Locale.setDefault(Locale.ENGLISH);
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
            statement.executeUpdate(
                    "UPDATE regions SET region_name = '"+regionName+"' WHERE region_id = '"+regionId+"'");

            ResultSet resultSet = statement.executeQuery(
                    "SELECT region_name, region_id FROM regions WHERE region_id = '"+regionId+"' ");

            if(resultSet.next()) {
                region.setRegionName(resultSet.getString("REGION_NAME"));
                region.setRegionId(resultSet.getLong("REGION_ID"));
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
        return region;
    }

    @Override
    public Region delete(Long regionId) throws ClassNotFoundException {

        Region region = new Region();
        Locale.setDefault(Locale.ENGLISH);
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
                    "SELECT * FROM regions WHERE region_id = '"+regionId+"' ");
            if(resultSet.next()) {
                region.setRegionName(resultSet.getString("REGION_NAME"));
                region.setRegionId(resultSet.getLong("REGION_ID"));
            }

            statement.executeUpdate(
                    "DELETE FROM regions WHERE region_id = '"+regionId+"' ");

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
        return region;
    }

    @Override
    public void findAll() throws ClassNotFoundException {

        System.out.println("Application started...");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("JDBC driver is loaded!");
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        Statement statement = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection established!");
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM regions");
            while(resultSet.next()) {
                System.out.print(resultSet.getLong("REGION_ID") + ". ");
                System.out.println(resultSet.getString("REGION_NAME"));
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
    }
}
