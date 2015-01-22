package week2.Tasks.Task1Employee;

/**
 * Created by Дмитрий on 22.01.14.
 */
public class Main {

    public static void main(String[] args) {

        Employee.Employees employees = new Employee.Employees();
        employees.add(1, "man", 20, "emp1", "11");
        employees.add(2, "man", 21, "emp2", "12");
        employees.add(3, "woman", 22, "emp3", "13");
        employees.add(4, "man", 23, "emp4", "14");
        employees.add(5, "woman", 24, "emp5", "15");

//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Введите имя: ");
//        String name = scan.nextLine();
//
//        System.out.println("Введите пароль: ");
//        String password = scan.nextLine();
//
//        System.out.println("Введите возраст: ");
//        Integer age = scan.nextInt();
//
//        Scanner scan1 = new Scanner(System.in);
//        System.out.println("Введите пол: ");
//        String sex = scan1.nextLine();
//
//        System.out.println("Введите id: ");
//        Integer id = scan.nextInt();
//
//        Employee empTest = new Employee();
//        empTest.setRegionName(name);
//        empTest.setPassword(password);
//        empTest.setAge(age);
//        empTest.setSex(sex);
//        empTest.setRegionId(id);
//        scan.close();
//        scan1.close();

        Employee empTest1 = new Employee(1, "man", 20, "emp1", "11");

        System.out.println(employees.hashSet.contains(empTest1));


    }

}
