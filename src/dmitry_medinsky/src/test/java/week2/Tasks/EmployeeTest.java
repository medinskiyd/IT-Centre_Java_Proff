package week2.Tasks;

import static org.junit.Assert.*; // сделали статиком.
import org.junit.Before;
import org.junit.Test;
import week2.Tasks.Task1Employee.Employee;

/**
* Created by Дмитрий on 22.01.14.
*/
public class EmployeeTest { //Название теста должно быть таким как назваени класса + Test

    private Employee employee;

    @Before // для создания нового экземпляра перед каждым методом(тестом).
    public void setUp() {
        employee = new Employee(1, "man", 25, "Jack", "pass");
    }

    @Test // Проверка на null.
    public void testEqualsNull() {
        boolean actualResult = employee.equals(null);
        assertEquals(false, actualResult);
    }

    @Test //Проверка на левый объект.
    public void testDifferentObject() {
        boolean actualResult = employee.equals(new Object());
        assertEquals(false, actualResult);
    }

    @Test //Проверка на самого себя.
    public void testThemself() {
        boolean actualResult = employee.equals(employee);
        assertEquals(false, actualResult);
    }

    @Test //Проверка на правильные данные.
    public void testRightData() {
        boolean actualResult = employee.equals(new Employee(2, "woman", 23, "Helga", "Pass"));
        assertEquals(false, actualResult);
    }

    @Test //Проверка на неправильные данные.
    public void testNotRightData() {
        String strTest = "strTest";
        boolean actualResult = employee.equals(strTest);
        assertEquals(false, actualResult);
    }


    @Test //Проверка HashCode на самого себя.
    public void testHashCodeRight() {
        assertEquals(true, (employee.hashCode() == new Employee(1, "man", 25, "Jack", "pass").hashCode()));
    }

    @Test //Проверка HashCode на неравество.
    public void testHashCodeWrong() {
      assertEquals(false, (employee.hashCode() == new Employee(2, "woman", 21, "Kate", "Pass").hashCode()));
    }

//    @Test //Проверка HashCode на null. (java.lang.NullPointerException)
//         public void testHashCodeNull() {
//
//        assertEquals(false, (employee.hashCode() == new Employee(null, null, null, null, null).hashCode()));
//    }

    @Test //Проверка HashCode на левый объект.
    public void testHashCodeDifferentObj() {

        assertEquals(false, employee.hashCode() == new Object().hashCode());
    }


}
