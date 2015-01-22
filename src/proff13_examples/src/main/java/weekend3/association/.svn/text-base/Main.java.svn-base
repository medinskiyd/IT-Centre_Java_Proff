package weekend3.association;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/11/13
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Association example started");

        Session session = HibernateUtil.getSession();
        try {

            User user = new User();
            Vehicle vehicle = new Vehicle();
            user.getVehicles().add(vehicle);
            vehicle.setUser(user);

            session.beginTransaction();
            session.save(user);
            session.save(vehicle);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        log.info("Application finished");
    }
}
