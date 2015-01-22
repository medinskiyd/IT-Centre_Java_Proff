package week6.associate.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import hw8.taxi.domain.Order;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID", initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="CLIENT_ID")
    private Long id;

    private String name;
    private String surname;
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_VISIT_DATE")
    private Date date;
    private Double sum;

    public Client() {
    }

    public Client(String name, String surname, int age, Date date, double sum) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.date = date;
        this.sum = sum;
    }

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL) // Для того что бы вычитывать все сущности добавляем fetch = FetchType.EAGER
    // Для того что бы изменить все cascade = CascadeType.ALL
    private Set<Order> orders = new HashSet<>();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "сlient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
