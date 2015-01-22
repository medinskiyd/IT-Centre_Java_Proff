package week7.firmAssociate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Дмитрий on 05.03.14.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id // Для обозначения первичного ключа.
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_EMPLOYEE_ID", allocationSize = 1, initialValue= 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @ManyToOne
    private Firm firm;

    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Firm firm) {

        this.name = name;
        this.firm = firm;
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

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    @Override
    public String toString() {
        return "Firm{ " + firm.getName() + "= " +
                name + '\'' +
                '}';
    }
}
