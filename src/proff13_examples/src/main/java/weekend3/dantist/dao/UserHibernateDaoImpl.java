package weekend3.dantist.dao;

import weekend3.dantist.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/21/13
 */
public class UserHibernateDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
    public UserHibernateDaoImpl(Class type) {
        super(type);
    }
}
