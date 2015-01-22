package week8.calc;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week8.calc.view.Menu;
import week8.context.Man;
import weekend3.dantist.dao.ClientDao;
import weekend3.dantist.dao.ClientHibernateDaoImpl;
import weekend3.dantist.dao.UserDao;
import weekend3.dantist.dao.UserHibernateDaoImpl;
import weekend3.dantist.domain.User;
import weekend3.dantist.service.UserService;
import weekend3.dantist.service.UserServiceImple;
import weekend3.dantist.utils.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:/week8/context.xml");
        Menu menu = context.getBean("manu", Menu.class);
        menu.showMenu();
    }
}
