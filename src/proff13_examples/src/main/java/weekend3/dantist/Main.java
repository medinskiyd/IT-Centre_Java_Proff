package weekend3.dantist;

import org.hibernate.SessionFactory;
import weekend3.dantist.dao.ClientDao;
import weekend3.dantist.dao.ClientHibernateDaoImpl;
import weekend3.dantist.dao.UserDao;
import weekend3.dantist.dao.UserHibernateDaoImpl;
import weekend3.dantist.domain.User;
import weekend3.dantist.service.ClientService;
import weekend3.dantist.service.ClientServiceImpl;
import weekend3.dantist.service.UserService;
import weekend3.dantist.service.UserServiceImple;
import weekend3.dantist.utils.HibernateUtil;
import weekend3.dantist.view.Menu;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        ClientDao clientDao = new ClientHibernateDaoImpl(sessionFactory);
        ClientService clientService = new ClientServiceImpl(clientDao);
        UserDao userDao = new UserHibernateDaoImpl(User.class);
        UserService userService = new UserServiceImple(userDao);

        Menu menu = new Menu(clientService, userService);
        menu.main();
    }
}
