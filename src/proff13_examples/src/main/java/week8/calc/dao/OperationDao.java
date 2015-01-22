package week8.calc.dao;

import week6.associate.domain.Vehicle;
import weekend3.dantist.dao.GenericDao;
import weekend3.dantist.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/21/13
 */
public interface OperationDao {
    void create(Vehicle vehicle);
    Vehicle read(Long id);
    void update(Vehicle vehicle);
    void delete(Vehicle vehicle);
    List<Vehicle> findAll();
}
