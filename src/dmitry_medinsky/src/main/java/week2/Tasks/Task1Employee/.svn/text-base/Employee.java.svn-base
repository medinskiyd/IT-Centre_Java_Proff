package week2.Tasks.Task1Employee;

import java.util.HashSet;

/**
 * Created by Дмитрий on 22.01.14.
 */
public class Employee {

    private Integer id = 0;
    private String sex = null;
    private Integer age = 0;
    private String name = null;
    private String password = null;

    public Employee(){

    }

    public Employee(Integer id, String sex, Integer age, String name, String password) {

        this.id = id;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override // Переопределение.
    public boolean equals(Object obj) {

        if(obj == null) { // Проверяем не сравниваем ли мы null с Employee.
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        Employee employee = (Employee) obj; //для того что бы сделать переопределение, а не перегрузку - мы используем Object и для этого переводим Object в Employee.

        if(employee == obj){
            return false;
        }

        if(this.getName() != null && this.getSex() != null && this.getAge() != null && this.getAge() != null &&
           this.getId().equals(employee.getId()) && this.getSex().equals(employee.getSex()) && this.getAge().equals(employee.getAge()) && this.getName().equals(employee.getName())){
            return true;
        } else {
            return false;
        }
    }

    @Override // Переопределение.
    public int hashCode() {

        final int code = 31;
        int result = 1;

        result = code * result + this.id;
        result = code * result + this.sex.hashCode();
        result = code * result + this.age;
        result = code * result + this.name.hashCode();

        return result;

    }

    /**
     * Created by Дмитрий on 24.01.14.
     */
    public static class Employees {

        HashSet<Employee> hashSet = new HashSet<Employee>();

        public void add(Integer id, String sex, Integer age, String name, String password) {
            hashSet.add(new Employee(id, sex, age, name, password));

        }
    }
}
