package week6.dao;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/26/14
 */
public interface FilesDao {
    Long create(File file);
    File read(int id) throws ClassNotFoundException;
    void update(File file);
    void delete(File file);
}
