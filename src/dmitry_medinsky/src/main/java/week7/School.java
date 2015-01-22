package week7;

/**
 * Created by Дмитрий on 05.03.14.
 */
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class School {

    private static Logger log = Logger.getLogger(School.class);

    public static void main(String[] args) {

        Long cla = 101L;
        String sub = "Archeology";

        Integer select = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println(" Введите 1 для Археология или 2 для Окультизма.");
        select = scan.nextInt();

        ClassesHibernateDAO classesHibernateDAO = new ClassesHibernateDAO();

        if(select == 1) {
            System.out.println(" Археология: ");
            System.out.println(classesHibernateDAO.findAll()); // Вывод всех результатов в консоль.
        } else if(select == 2) {
            System.out.println(" Оккультизм: ");
        } else {
            return;
        }


        classesHibernateDAO.create(cla, sub); // Добавление региона в базу данных.
        //System.out.println(classesHibernateDAO.read(1L)); // Чтение региона из базы.
        //System.out.println(classesHibernateDAO.findAll()); // Вывод всех результатов в консоль.
        //notesHibernateDAO.update(id, cla, sub); // Изменение региона.
        //notesHibernateDAO.delete(id); // Удаление региона.
    }

    @Entity
    @Table(name = "SCHOOL")
    public static class SchoolClass {   // Класс не должен быть final (если мы хотим что бы Hibernate его использовал).

        @Id // Для обозначения первичного ключа.
        @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SCHOOL_ID", allocationSize = 1, initialValue= 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
        @Column(name = "ID")
        private Long id;

        @Column(name = "CLASSES")
        private Long classeName;

        @Column(name = "SUBJECTS")
        private String subject;

        public SchoolClass() { // требование обязательное для Hibernate

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getClasseName() {
            return classeName;
        }

        public void setClasseName(Long classeName) {
            this.classeName = classeName;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }

    public static interface ClassesDAO {

        void create(Long cla, String sub);
        SchoolClass read(Long id);
        SchoolClass update(Long id, Long cla, String sub);
        SchoolClass delete(Long id);
        List findAll();
    }

    public static class ClassesHibernateDAO implements ClassesDAO {

        @Override
        public void create(Long cla, String sub) {

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            configuration.configure();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            SchoolClass schoolClassA = new SchoolClass();
            schoolClassA.setClasseName(cla);
            schoolClassA.setSubject(sub);

            try {
                session = factory.openSession();
                session.beginTransaction();
                session.save(schoolClassA);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
        }

        @Override
        public SchoolClass read(Long id){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;
            SchoolClass schoolClassA = new SchoolClass();

            try {
                session = factory.openSession();
                session.beginTransaction();
                schoolClassA = (SchoolClass) session.get(SchoolClass.class, id);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return schoolClassA;
        }

        @Override
        public SchoolClass update(Long id, Long cla, String sub){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;
            SchoolClass schoolClassA = new SchoolClass();

            schoolClassA.setClasseName(cla);
            schoolClassA.setSubject(sub);
            try {
                session = factory.openSession();
                session.beginTransaction();

                session.update(schoolClassA); // Изменение региона.

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return schoolClassA;
        }

        @Override
        public SchoolClass delete(Long id){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            SchoolClass schoolClassB = new SchoolClass();
            schoolClassB.setId(id);

            try {
                session = factory.openSession();
                session.beginTransaction();

                session.delete(schoolClassB); // Изменение региона.

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return schoolClassB;
        }

        @Override
        public List findAll(){ // Для Археологии.

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;
            List classes = null;
            try {
                session = factory.openSession();
                session.beginTransaction();

                Criteria crit = session.createCriteria(SchoolClass.class).add(Restrictions.gt("ID", 3)).addOrder(Order.asc("ID")); //создаем критерий запроса
                //crit.setMaxResults(50);//ограничиваем число результатов
                classes = crit.list();//помещаем результаты в список

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return classes;
        }
    }
}


