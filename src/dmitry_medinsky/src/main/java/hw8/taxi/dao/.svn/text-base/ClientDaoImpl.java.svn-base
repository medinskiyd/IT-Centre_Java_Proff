package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Дмитрий on 15.03.14.
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientDaoImpl.class);
    private String path = "C:/Users/Дарина/IdeaProjects/Proff13/dmitry_medinsky/src/main/resources/week8/conf.properties";
    @Autowired
    private SessionFactory factory;

    public ClientDaoImpl() {
    }
    @Override
    public void create(Client client) {
        Locale.setDefault(Locale.ENGLISH);
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(client);
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
        Locale.setDefault(Locale.ENGLISH);
        Session session = factory.openSession();
        Client client = null;
        try {
            session.beginTransaction();
            client = (Client) session.get(Client.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return client;
    }

    @Override
    public void update(Client client) {
        Locale.setDefault(Locale.ENGLISH);
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Client client) {
        Locale.setDefault(Locale.ENGLISH);
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("FROM Client");
        return query.list();
    }
    // НЕ РАБОТАЕТ.
    @Override
    public List<Client> getAllClientByPart() {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Class.class); //создаем критерий запроса
        String part = null;
        try {
            LineNumberReader lnr = new LineNumberReader(new BufferedReader(new FileReader(path)));
            String str = null;
            Pattern p1 = Pattern.compile(".*clientPartOut = (\\w+).*");
            while (((str = lnr.readLine()) != null)) {
                Matcher m = p1.matcher(str);
                if (m.find()) {
                    part = str;
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int partInt = Integer.parseInt(part);
        crit.setMaxResults(partInt);//ограничиваем число результатов
        List clientsPart = crit.list();//помещаем результаты в список
        return clientsPart;
    }
}
