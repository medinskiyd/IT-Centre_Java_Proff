package hw7.hibernote;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Дмитрий on 10.03.14.
 */
public class NotesStore {
    private static Set notesType = new HashSet();

    // Метод реализует соединение с базой данных через hibernate.
    public Session connection(Logger log) {

        Session session = null;

        Locale.setDefault(Locale.ENGLISH);
        Configuration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure().buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        session = factory.openSession();
        session.beginTransaction();

        return session;
    }


}

