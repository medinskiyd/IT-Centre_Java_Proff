package week6.HomeWork.RegionHibernateDAO;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

/**
 * Created by Дмитрий on 03.03.14.
 */
public class Hibernate {

    private static Logger log = Logger.getLogger(Hibernate.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure().buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        String regionName = "Earth";
        Long regionId = 8L;

       RegionsHibernateDAO regionsHibernateDAO = new RegionsHibernateDAO();

        try {
            session = factory.openSession();
            session.beginTransaction();

            //regionsHibernateDAO.create(regionName, session); // Добавление региона в базу данных.
            //System.out.println(regionsHibernateDAO.read(regionId, session)); // Чтение региона из базы.
            System.out.println(regionsHibernateDAO.findAll(session)); // Вывод всех результатов в консоль.

            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        //regionsHibernateDAO.update(regionId, regionName, log); // Изменение региона.
        //regionsHibernateDAO.delete(regionId, log); // Удаление региона.

        log.info(session);


    }

    /**
     * Created by Дмитрий on 28.02.14.
     */

    @Entity
    @Table(name = "REGIONS")
    public static class Region {   // Класс не должен быть final (если мы хотим что бы Hibernate его использовал).

        @Id // Для обозначения первичного ключа.
        @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID", allocationSize = 1, initialValue= 5)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
        @Column(name = "REGION_ID")
        private Long regionId;

        @Column(name = "REGION_NAME")
        private String regionName;

        public Region() { // требование обязательное для Hibernate

        }

        public Region(Long regionId, String regionName) {
            this.regionId = regionId;
            this.regionName = regionName;
        }

        public Long getRegionId() {
            return regionId;
        }

        public void setRegionId(Long regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        @Override
        public String toString() {
            return "Region{" +
                    "regionId=" + regionId +
                    ", regionName='" + regionName +
                    '}';
        }
    }

    public static interface RegionsDAO {

        void create(String regionName, Session session);
        Region read(Long regionId, Session session);
        Region update(Long regionId, String regionName, Logger log);
        Region delete(Long regionId, Logger log);
        List findAll(Session session);

    }

    /**
    * Created by Дмитрий on 26.02.14.
    */
    public static class RegionsHibernateDAO implements RegionsDAO {

        @Override
        public void create(String regionName, Session session) {

            Region region = new Region();
            region.setRegionName(regionName);
            session.save(region);

        }

        @Override
        public Region read(Long regionId, Session session){

            Region region = new Region();
            region = (Region) session.get(Region.class, regionId);
            return region;
        }

        @Override
        public Region update(Long regionId, String regionName, Logger log){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            Region region = new Region();
            region.setRegionId(regionId);
            region.setRegionName(regionName);
            try {
                session = factory.openSession();
                session.beginTransaction();

                session.update(region); // Изменение региона.

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }

            return region;
        }

        @Override
        public Region delete(Long regionId, Logger log){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            Region region = new Region();
            region.setRegionId(regionId);

            try {
                session = factory.openSession();
                session.beginTransaction();

                session.delete(region); // Изменение региона.

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return region;
        }

        @Override
        public List findAll(Session session){

            Criteria crit = session.createCriteria(Region.class); //создаем критерий запроса
            //crit.setMaxResults(50);//ограничиваем число результатов
            List regions = crit.list();//помещаем результаты в список

            return regions;
        }
    }
}
