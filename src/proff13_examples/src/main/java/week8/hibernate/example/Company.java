package week8.hibernate.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/14/14
 */
@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",\n employees=" + employees +
                "}\n";
    }
}
