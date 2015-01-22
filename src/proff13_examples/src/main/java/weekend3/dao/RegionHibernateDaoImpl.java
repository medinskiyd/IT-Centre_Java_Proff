package weekend3.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import weekend3.annotate.utils.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class RegionHibernateDaoImpl implements  RegionDao {
    private static Logger log = Logger.getLogger(RegionHibernateDaoImpl.class);
    @Override
    public void create(Region region) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(region);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Region read(Long id) {
        // Do not use transactions!
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Region region) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Region region) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Region> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
//          return session.createQuery("FROM Region").list();
            return session.createCriteria(Region.class).list();
        } catch(HibernateException e) {
            log.error("Fetch error", e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Region> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Region where name = :name ");
        query.setParameter("name", name);
        return query.list();
    }
}
