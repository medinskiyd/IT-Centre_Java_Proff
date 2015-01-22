package week6.associate.service;

import week6.associate.dao.VehicleDao;
import week6.associate.domain.Vehicle;
import weekend3.dantist.dao.ClientDao;
import weekend3.dantist.domain.Client;
import weekend3.dantist.service.ClientService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class VehicleServiceImpl implements VehicleService {
    private VehicleDao userDao;

    public VehicleServiceImpl(VehicleDao dao) {
        userDao = dao;
    }

    @Override
    public List<Vehicle> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addNewUser(Vehicle user) {
        userDao.create(user);
    }
}
