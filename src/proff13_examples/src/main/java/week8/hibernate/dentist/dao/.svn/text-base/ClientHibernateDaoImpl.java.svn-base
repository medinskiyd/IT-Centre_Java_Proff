package week8.hibernate.dentist.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import week8.hibernate.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.05.13
 */
@Repository
public class ClientHibernateDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public ClientHibernateDaoImpl() {
    }

    public void create(Client user) {
        Session session = factory.openSession();
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

    public void update(Client client) {

    }

    public void delete(Client client) {

    }

    @Override
    public List<Client> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Client");
        return query.list();
    }

    @Override
    public List<Client> findMonyGT(long amount) {
        return null;
    }
}
