package weekend3.dantist.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import weekend3.dantist.domain.Client;
import weekend3.dantist.utils.HibernateUtil;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.05.13
 */
public class ClientHibernateDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);
    private SessionFactory factory;

    public ClientHibernateDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Client user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Client read(Long id) {
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public List<Client> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Region");
        return query.list();

    }

    @Override
    public List<Client> findMonyGT(long amount) {
        return null;
    }
}
