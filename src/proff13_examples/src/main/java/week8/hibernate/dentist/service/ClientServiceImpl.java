package week8.hibernate.dentist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week8.hibernate.dentist.dao.ClientDao;
import week8.hibernate.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
@Service
public class ClientServiceImpl implements ClientService {
    private ClientDao userDao;

    @Autowired
    public ClientServiceImpl(ClientDao dao) {
        userDao = dao;
    }

    @Override
    public List<Client> getAllUsers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addNewUser(Client user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

/*
    @Override
    public List<сlient> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addNewUser(сlient user) {
        userDao.create(user);
    }
*/
}
