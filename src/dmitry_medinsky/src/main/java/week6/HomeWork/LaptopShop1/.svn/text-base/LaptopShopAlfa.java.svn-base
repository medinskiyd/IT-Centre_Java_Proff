package week6.HomeWork.LaptopShop1;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

/**
 * Created by Дмитрий on 04.03.14.
 *
 * Написать приложение выполняющее функции магазина ноутбуков.
 * У нотубука должны быть следующие параметры (винчестер, память, видеокарта, экран, модель, процессор).
 * Создать отдельную схему notes по правилам 3й нормальной формы.
 *
 1. Создавать и удалять следующие элементы:
 - модель (id, фирма изготовитель, модель)
 - процессор (id, изготовитель, тактовая частота)
 - винчестер (id, изготовитель, объем в мегабайтах)
 - память (id, изготовитель, объем)
 - видеокарта (id, изготовитель, объем памяти)
 - экран (id, размер)
 2. Задать новый тип ноутбука. Оператору последовательно предлагается выбрать
    (модель, процессор, винчестер, память, видеокарта, экран)
 3. Принять на склад указанное количество единиц определенного типа ноутбуков
    (указывается номер партии, тип, цена, дата).
 4. Списать указанное кол-во единиц определенного типа ноутбуков.
 */
public class LaptopShopAlfa {

    private static Logger log = Logger.getLogger(LaptopShopAlfa.class);

    public static void main(String[] args) {

        String noteModel = "Asus 15-4";
        Long noteId = 2L;

        NotesHibernateDAO notesHibernateDAO = new NotesHibernateDAO();

        //notesHibernateDAO.create(noteModel); // Добавление региона в базу данных.
        //System.out.println(notesHibernateDAO.read(noteId)); // Чтение региона из базы.
        System.out.println(notesHibernateDAO.findAll()); // Вывод всех результатов в консоль.
        //notesHibernateDAO.update(noteId, noteModel); // Изменение региона.
        //notesHibernateDAO.delete(noteId); // Удаление региона.
    }

    @Entity
    @Table(name = "NOTES")
    public static class Note {   // Класс не должен быть final (если мы хотим что бы Hibernate его использовал).

        @Id // Для обозначения первичного ключа.
        @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTES_ID", allocationSize = 1, initialValue= 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
        @Column(name = "NOTES_ID")
        private Long notesId;

        @Column(name = "NOTES_MODEL")
        private String NotesModel;

        public Note() { // требование обязательное для Hibernate

        }

        public Long getNotesId() {
            return notesId;
        }

        public void setNotesId(Long notesId) {
            this.notesId = notesId;
        }

        public String getNotesModel() {
            return NotesModel;
        }

        public void setNotesModel(String notesModel) {
            NotesModel = notesModel;
        }

        @Override
        public String toString() {
            return "Note{" +
                    "notesId=" + notesId +
                    ", NotesModel='" + NotesModel + '\'' +
                    '}';
        }
    }

    public static interface NotesDAO {

        void create(String regionName);
        Note read(Long regionId);
        Note update(Long regionId, String regionName);
        Note delete(Long regionId);
        List findAll();
    }

    /**
     * Created by Дмитрий on 26.02.14.
     */
    public static class NotesHibernateDAO implements NotesDAO {

        @Override
        public void create(String noteModel) {

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            Note note = new Note();
            note.setNotesModel(noteModel);

            try {
                session = factory.openSession();
                session.beginTransaction();
                session.save(note);
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
        public Note read(Long noteId){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;
            Note note = new Note();

            try {
                session = factory.openSession();
                session.beginTransaction();
                note = (Note) session.get(Note.class, noteId);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return note;
        }

        @Override
        public Note update(Long noteId, String noteModel){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            Note note = new Note();
            note.setNotesId(noteId);
            note.setNotesModel(noteModel);
            try {
                session = factory.openSession();
                session.beginTransaction();

                session.update(note); // Изменение региона.

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return note;
        }

        @Override
        public Note delete(Long noteId){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            Note note = new Note();
            note.setNotesId(noteId);

            try {
                session = factory.openSession();
                session.beginTransaction();

                session.delete(note); // Изменение региона.

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return note;
        }

        @Override
        public List findAll(){

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new AnnotationConfiguration();
            SessionFactory factory = configuration.configure().buildSessionFactory();
            log.info("Reference to SessionFactory " + factory);

            Session session = null;

            List notes = null;

            try {
                session = factory.openSession();
                session.beginTransaction();

                Criteria crit = session.createCriteria(Note.class); //создаем критерий запроса
                //crit.setMaxResults(50);//ограничиваем число результатов
                notes = crit.list();//помещаем результаты в список

                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
            } finally {
                if(session != null) {
                    session.close();
                }
            }
            return notes;
        }
    }
}

