package week8.calc.service;

import weekend3.dantist.dao.UserDao;
import weekend3.dantist.domain.User;
import weekend3.dantist.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/23/13
 */
public class OperationServiceImpl implements UserService {
    private UserDao userDao;

    public OperationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }
}
