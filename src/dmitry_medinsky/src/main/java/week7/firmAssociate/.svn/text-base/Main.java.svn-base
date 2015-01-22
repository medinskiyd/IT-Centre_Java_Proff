package week7.firmAssociate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by Дмитрий on 05.03.14.
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure().buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;

        Firm NASA = new Firm();
        Employee Gagarin = new Employee("Gagarin");
        Gagarin.setFirm(NASA);
        Employee Gagarin1 = new Employee("Gagarin1");
        Gagarin1.setFirm(NASA);
        Employee Gagarin2 = new Employee("Gagarin2");
        Gagarin2.setFirm(NASA);

        NASA.setName("NASA");
        Set setNasa = new HashSet();
        setNasa.add(Gagarin);
        setNasa.add(Gagarin1);
        setNasa.add(Gagarin2);
        NASA.setEmployees(setNasa);

        Firm USSR = new Firm();
        Employee Armstrong = new Employee("Armstrong");
        Armstrong.setFirm(USSR);
        Employee Armstrong1 = new Employee("Armstrong1");
        Armstrong1.setFirm(USSR);
        Employee Armstrong2 = new Employee("Armstrong2");
        Armstrong2.setFirm(USSR);

        USSR.setName("USSR");
        Set setUssr = new HashSet();
        setUssr.add(Armstrong);
        setUssr.add(Armstrong1);
        setUssr.add(Armstrong2);
        USSR.setEmployees(setUssr);

        List empl= null;

        try {
            session = factory.openSession();
            session.beginTransaction();

            session.save(NASA);
            session.save(USSR);
            session.save(Gagarin);
            session.save(Gagarin1);
            session.save(Gagarin2);
            session.save(Armstrong);
            session.save(Armstrong1);
            session.save(Armstrong2);
            NASA = (Firm) session.get(Firm.class, 1L);
            System.out.println(NASA.toString());
            System.out.println(USSR.toString());
//            Scanner scan = new Scanner(System.in);
//            System.out.println(" Введите название фирмы:");
//            String firm_name = scan.nextLine();
//
//            empl=session.createCriteria(Firm.class).add(Restrictions.eq("name", firm_name)).list();
//            System.out.println(empl);

              session.getTransaction().commit();
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
