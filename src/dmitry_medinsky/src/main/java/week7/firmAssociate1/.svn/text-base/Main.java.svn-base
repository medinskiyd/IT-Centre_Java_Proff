package week7.firmAssociate1;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

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
        Firm USSR = new Firm();
        NASA.setName("NASA");
        USSR.setName("USSR");

        Employee Gagarin = new Employee("Gagarin");
        Employee Gagarin1 = new Employee("Gagarin1");
        Employee Gagarin2 = new Employee("Gagarin2");

        Gagarin.setFirm(NASA);
        Gagarin.setFirm(USSR);
        Gagarin1.setFirm(NASA);
        Gagarin1.setFirm(USSR);
        Gagarin2.setFirm(NASA);
        Gagarin2.setFirm(USSR);

        Employee Armstrong = new Employee("Armstrong");
        Employee Armstrong1 = new Employee("Armstrong1");
        Employee Armstrong2 = new Employee("Armstrong2");

        Armstrong.setFirm(USSR);
        Armstrong.setFirm(NASA);
        Armstrong1.setFirm(USSR);
        Armstrong1.setFirm(NASA);
        Armstrong2.setFirm(USSR);
        Armstrong2.setFirm(NASA);

        Set setNasa = new HashSet();
        Set setUssr = new HashSet();

        setNasa.add(Gagarin);
        setNasa.add(Gagarin1);
        setNasa.add(Gagarin2);
        setNasa.add(Gagarin);
        setNasa.add(Gagarin1);
        setNasa.add(Gagarin2);

        setUssr.add(Armstrong);
        setUssr.add(Armstrong1);
        setUssr.add(Armstrong2);
        setUssr.add(Gagarin);
        setUssr.add(Gagarin1);
        setUssr.add(Gagarin2);

        USSR.setEmployees(setUssr);
        NASA.setEmployees(setNasa);
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
            USSR = (Firm) session.get(Firm.class, 1L);

            System.out.println(NASA.toString() + USSR.toString());
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
