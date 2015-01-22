//package week6.hibernate;
//
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;
//import weekend3.dao.Region;
//
//
//public class ConfigEx {
//    private static Logger log = Logger.getLogger(ConfigEx.class);
//
//    public static void main(String[] args) {
//
//        Configuration configuration = new AnnotationConfiguration();
//        SessionFactory factory = configuration.configure().buildSessionFactory();
//        log.info("Reference to SessionFactory " + factory);
//
//        Session session = null;
//        Region region = new Region(5L, "ukr");
//        try {
//            session = factory.openSession();
//            session.beginTransaction();
//            session.save(region);
//            region = (Region) session.get(Region.class, 3L);
//            System.out.println(region.getId()+" "+region.getName());
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            log.error("Open session failed", e);
//            session.getTransaction().rollback();
//        } finally {
//            if(session != null) {
//                session.close();
//            }
//        }
//        log.info(session);
//    }
//}
