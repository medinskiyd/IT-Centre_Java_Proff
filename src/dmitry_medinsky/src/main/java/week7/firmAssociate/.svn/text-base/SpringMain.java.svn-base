package week7.firmAssociate;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import week8.context.*;

import javax.sql.PooledConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Дмитрий on 14.03.14.
 */
public class SpringMain {

    public static void main(String[] args) {
        //---------- Для настройки Spring context  ----------
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:/hibernate/context.xml");
        SessionFactory factory = context.getBean("mySessionFactory", SessionFactory.class);

        Firm firm = new Firm(4L, "ChinaSpase");
        Employee employee = new Employee("Cui Chan", firm);
        firm.getEmployees().add(employee);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(firm);
        session.getTransaction().commit();

        List companies = session.createCriteria(Firm.class).list();
        System.out.println(companies);

        session.close();
    }

}
