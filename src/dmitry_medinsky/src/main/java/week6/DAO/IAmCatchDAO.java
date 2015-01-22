package week6.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Дмитрий on 26.02.14.
 */
public class IAmCatchDAO {

    public static void main(String[] args) throws ClassNotFoundException {

        RegionsDAO regionsDao = new RegionsJDBCDAO();
        Region region = null;

        //---------- Создание региона.
//        region = regionsDao.create("Upiter");
//        System.out.println(" Создан: " + region.toString());
//        System.out.println();
        //---------- Чтение региона.
//        region = regionsDao.read(2L);
//        System.out.println(" Прочитан: " + region.toString());
//        System.out.println();
        //---------- Обновление региона.
//        region = regionsDao.update(6L, "Earth");
//        System.out.println(" Обновлен: " + region.toString());
//        System.out.println();
        //---------- Удаление региона.
//        region = regionsDao.delete(6L);
        //---------- Вывод всех регионов.
//        regionsDao.findAll();

        }
}




