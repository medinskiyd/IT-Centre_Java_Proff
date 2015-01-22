package weekend3.annotate.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
@Entity
@Table(name = "SUBJECTS")
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "SUBJECT_ID")
    private Long id;

    @Column(name = "SUBJECT_NAME")
    private String name;

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
}
