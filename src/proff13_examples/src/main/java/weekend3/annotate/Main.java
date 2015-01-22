package weekend3.annotate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import weekend3.annotate.domain.Subject;
import weekend3.annotate.utils.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Application started");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Subject subject = new Subject();

        subject.setName("Math");

        try {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed",e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
