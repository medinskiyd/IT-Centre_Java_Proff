package week8.springCalc;

import org.hibernate.SessionFactory;
import week8.springCalc.dao.CalkDAO;
import week8.springCalc.dao.CalkDAOImpl;
import week8.springCalc.service.OperService;
import week8.springCalc.service.OperServiceImpl;
import week8.springCalc.utils.HibernateUtil;
import week8.springCalc.view.Menu;

/**
 * Created by Дмитрий on 12.03.14.
 */
public class Main {
    public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    CalkDAO calkDao = new CalkDAOImpl(sessionFactory);
    OperServiceImpl operService = new OperServiceImpl(calkDao);

    Menu menu = new Menu(operService);
    menu.main();
    }

}
