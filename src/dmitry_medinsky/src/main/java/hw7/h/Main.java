package hw7.h;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Scanner;

/**
 * Created by Дмитрий on 10.03.14.

 Написать приложение выполняющее функции магазина ноутбуков. У нотубука должны быть следующие параметры
 (винчестер, память, видеокарта, экран, модель, процессор).
 Создать отдельную схему notes по правилам 3й нормальной формы.
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

 Класс задания Main
 */

public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    private static final int EXIT_ITEM = 0;
    private static final int ADD_NOTE_TYPE_ITEM = 1;
    private static final int ADD_NOTE_MODEL_ITEM = 2;
    private static final int DELETE_NOTE_TYPE_ITEM = 3;
    private static final int DELETE_NOTE_MODEL_ITEM = 4;

    private static Object obj = new Object();

    public static void main(String[] args) {

        NotesStore rozetka = new NotesStore();
        Session session = rozetka.connection(log);

        menu();
        Scanner scan = new Scanner(System.in);
        int choise = scan.nextInt();
        choiseMenu(choise);


//        NotesType econom = new NotesType();
//        econom.setNotesType("Econom");
//        econom.setId(1L);
//        Model lenovo = new Model("Lenovo", "G575", econom);
////        Model asus = new Model("Asus", "X550", econom);
////        lenovo.setId(9L);
//        Set economModels = new HashSet();
////        economModels.add(lenovo);
////        economModels.add(asus);
////        econom.setModel(economModels);
//
//        FirmCreater fCLenovo = new FirmCreater();
//        fCLenovo.setFirmCreater("IBM");
//        fCLenovo.setModel(economModels);


        try {

            if(choise == 1 || choise == 2){
                session.save(obj);
            } else
            if (choise == 3 || choise ==4){
                session.delete(obj);
            }
//            session.update(obj);

//            session.save(fCLenovo);
//            session.update(asus);



            session.getTransaction().commit();
        } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        log.info(session);

    }

    static public void menu() {

        System.out.println(" Интернет магазин: ");
        System.out.println(" 0.Выход.");
        System.out.println(" 1.Добавить тип ноутбука.");
        System.out.println(" 2.Добавить модель ноутбука.");

    }
        // Метод выбирает требуемое действие.
        static void choiseMenu(int choise) {

        do {
            switch (choise) {

                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case ADD_NOTE_TYPE_ITEM:
                    obj = addNoteType();
                    choise = 0;
                    break;
                case ADD_NOTE_MODEL_ITEM:
                    obj = addModelType();
                    choise = 0;

            }
        } while (choise != 0);

    }
    // Метод добавляет в базу новый тип ноутбука.
    static public NotesType addNoteType(){

        System.out.print(" Введите новый тип ноутбука:");
        Scanner scan = new Scanner(System.in);
        String nameNotesType = scan.nextLine();
        NotesType econom = new NotesType();
        econom.setNotesType(nameNotesType);
        scan.close();
        return econom;
    }

    static public Model addModelType() {

        System.out.print(" Введите порядковый номер в базе типа ноутбука:");
        Scanner scan = new Scanner(System.in );
        Long number = scan.nextLong();
        NotesType nType = new NotesType();
        nType.setId(number);
        System.out.print(" Введите название фирмы ноутбука:");
        String firmName = scan.nextLine();
        System.out.print(" Введите модель ноутбука:");
        String model = scan.nextLine();
        Model noutModel = new Model(firmName, model, nType);
        scan.close();

        return noutModel;
    }

}
