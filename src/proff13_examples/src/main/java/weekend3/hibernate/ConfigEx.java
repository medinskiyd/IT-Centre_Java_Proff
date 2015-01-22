package weekend3.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/11/13
 */
public class ConfigEx {
    private static Logger log = Logger.getLogger(ConfigEx.class);

    public static void main(String[] args) {
        log.info("Reference to SessionFactory ");

        Session session = null;
        try {
            session = HibernateUtil.getSession();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        log.info(session);
    }
}
