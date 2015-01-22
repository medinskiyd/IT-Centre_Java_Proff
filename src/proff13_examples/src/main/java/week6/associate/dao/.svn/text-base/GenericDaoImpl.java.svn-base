package week6.associate.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import weekend3.dantist.dao.GenericDao;

import java.io.Serializable;
import java.util.List;

import static weekend3.dantist.utils.HibernateUtil.getSession;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private static Logger log = Logger.getLogger(weekend3.dantist.dao.GenericDaoImpl.class);
    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public PK create(T o) {
        Session session = getSession();
        try {
            session.beginTransaction();
            PK result = (PK) session.save(o);
            session.getTransaction().commit();
            return result;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public T get(PK id) {
        return (T) getSession().get(type, id);
    }

    public List<T> getAll() {
        Criteria crit = getSession().createCriteria(type);
        return crit.list();
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void createOrUpdate(T persistentObject) {
        // The same as create
    }

    @Override
    public void delete(T persistentObject) {
        // The same as create
    }

}