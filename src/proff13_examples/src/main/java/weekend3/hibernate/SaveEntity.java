package weekend3.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/9/13
 */
public class SaveEntity {
    private static Logger log = Logger.getLogger(SaveEntity.class);

    public static void main(String[] args) {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure("/relation/hibernate.cfg.xml").buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            session.beginTransaction();
            session.save(new User());
            session.getTransaction().commit();

            User user = (User) session.get(User.class, 1L);
            System.out.println("User " + user);
            List<User> list = session.createCriteria(User.class).list();
            System.out.println(list);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        log.info(session);
    }

}
