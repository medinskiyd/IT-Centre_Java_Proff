package week6.HomeWork.FileJDBCDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Locale;

/**
 * Created by Дмитрий on 01.03.14.
 */
public class FileJDBCDAO {
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {

        System.out.println("Application started...");
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("JDBC driver is loaded!");

        FilesDao filesDao = new FilesJdbcDao();
        // --------- Запись файла в базу данных.
        java.io.File newFile = new java.io.File("D:/FileToBase.txt"); // Беру файл.
        InputStream content = new FileInputStream(newFile); // Ложу файл в поток.
        File file = new File(0L, newFile.getName(), content, (int)newFile.length()); // Вытаскиваю из файла данные и присваиваю моему файлу для базы данных.
        System.out.println(" Файл " + newFile.getName() + " записан в базу под номером " + filesDao.create(file)); // Записываю файл в базу.
        // --------- Чтение файла с базы данных.
        file = filesDao.read(1L); // Читаю файл из базы.
        System.out.println(file); // Вывожу информацию о прочитаном файле.
        // --------- Перезапись файла в базе данных.
        newFile = new java.io.File("D:/fileReload.txt"); // Беру файл.
        content = new FileInputStream(newFile); // Ложу файл в поток.
        file = new File(39L, newFile.getName(), content, (int)newFile.length()); // Вытаскиваю из файла данные и присваиваю моему файлу для базы данных.
        System.out.println(" Файл " + newFile.getName() + " перезаписан в базу под номером " + filesDao.update(file)); // Записываю файл в базу.
        // --------- Удалить файл из базе данных.
        Long id = 38L;
        filesDao.delete(id);
        System.out.println(" Файл удален из базы под номером " + id); // Записываю файл в базу.
    }

    /**
     * Created by Дмитрий on 01.03.14.
     */
    public static class File {
        private Long id;
        private String name;
        private InputStream content;
        private Integer size;

        public File() {
        }

        public File(Long id, String name, InputStream content) {
            this.id = id;
            this.name = name;
            this.content = content;
        }

        public File(Long id, String name, InputStream content, Integer size) {
            this.id = id;
            this.name = name;
            this.content = content;
            this.size = size;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public InputStream getContent() {
            return content;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public void setContent(InputStream content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "File{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", content=" + content +
                    '}';
        }
    }

    /**
     * Created by Дмитрий on 01.03.14.
     */
    public static interface FilesDao {
        Long create(File file) throws ClassNotFoundException;
        File read(Long id) throws ClassNotFoundException;
        Long update(File file) throws ClassNotFoundException;
        void delete(Long id) throws ClassNotFoundException;
    }

    /**
     * Created by Дмитрий on 01.03.14.
     */
    public static class FilesJdbcDao implements FilesDao {
        @Override
        public Long create(File file) throws ClassNotFoundException {
            Connection conn = myConn();
            Statement statement = null;
            Long id = null;
            try {
                statement = conn.createStatement();

                PreparedStatement prep = conn.prepareStatement("INSERT INTO files (id, file_name, file_data) VALUES (file_seq.nextVal, ?, ?)");
                prep.setString(1, file.getName());
                prep.setBinaryStream(2, file.getContent(), file.getSize());
                prep.executeUpdate();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM files WHERE file_name = '" + file.getName() + "'");

                if(resultSet.next()) {
                    id = resultSet.getLong("ID");
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
            return id;
        }

        @Override
        public File read(Long id) throws ClassNotFoundException {
            File file = null;

            Connection conn = myConn();
            Statement statement = null;
            try {
                statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM files WHERE id = '" + id + "'");

                if(resultSet.next()) {
                    String name = resultSet.getString("FILE_NAME");
                    InputStream content = resultSet.getBinaryStream("FILE_DATA");
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

        @Override //не исправляет данные в файле в базе.
        public Long update(File file) throws ClassNotFoundException {
            Connection conn = myConn();
            Statement statement = null;
            Long id = file.getId();
            try {
                statement = conn.createStatement();
                statement.executeUpdate("UPDATE files SET file_name = '"+file.getName()+"' WHERE id = '"+id+"' ");
    //            statement.executeUpdate("UPDATE files SET file_name = '"+file.getRegionName()+"', file_data = '"+file.getContent()+"' WHERE id = '"+id+"' ");


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
            return id;
        }

        @Override
        public void delete(Long id) throws ClassNotFoundException {
            Connection conn = myConn();
            Statement statement = null;
            String fileName = null;
            try {
                statement = conn.createStatement();

                statement.executeUpdate(
                        "DELETE files WHERE id = '"+id+"'");

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

        public Connection myConn() throws ClassNotFoundException {

            Connection conn = null;
            String url = "jdbc:oracle:thin:@localhost:1521:XE";

            try {
                conn = DriverManager.getConnection(url, "hr", "hr");
                System.out.println("Connection established!");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        return conn;
        }
    }
}
