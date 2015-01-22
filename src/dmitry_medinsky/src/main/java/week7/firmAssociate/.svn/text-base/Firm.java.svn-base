package week7.firmAssociate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Дмитрий on 05.03.14.
 */
@Entity
@Table(name = "FIRM")
public class Firm {

    @Id // Для обозначения первичного ключа.
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_FIRM_ID", allocationSize = 1, initialValue= 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
    @Column(name = "FIRM_ID")
    private Long id;

    @Column(name = "FIRM_NAME")
    private String name;

    public Firm() {

    }

    @OneToMany(mappedBy="firm", cascade = CascadeType.ALL) // Для того что бы вычитывать все сущности добавляем fetch = FetchType.EAGER
    // Для того что бы изменить все cascade = CascadeType.ALL
    private Set<Employee> employees = new HashSet<>();

    public Firm(Long id, String name) {
        this.id = id;
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
        return "Firms{" + employees +'\'' +
                '}';
    }
}
