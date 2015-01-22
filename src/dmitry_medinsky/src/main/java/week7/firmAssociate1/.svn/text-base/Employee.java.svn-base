package week7.firmAssociate1;

import javax.persistence.*;

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

    @ManyToMany
    private Firm firm;

    @ManyToMany
    private Firm firm1;

    public Employee() {

    }

    public Employee(String name) {

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

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public Firm getFirm1() {
        return firm1;
    }

    public void setFirm1(Firm firm1) {
        this.firm1 = firm1;
    }

    @Override
    public String toString() {
        return "Firm{ " + firm.getName() + "= " +
                name + '\'' +
                '}';
    }
}
