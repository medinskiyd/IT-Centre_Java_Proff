package week6.associate.service;

import weekend3.dantist.dao.UserDao;
import weekend3.dantist.domain.User;
import weekend3.dantist.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/23/13
 */
public class UserServiceImple implements UserService {
    private UserDao userDao;

    public UserServiceImple(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }
}
