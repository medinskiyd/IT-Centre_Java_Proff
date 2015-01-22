package weekend3.association;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */
@Entity
@Table(name="vehicles")
public class Vehicle {
    @Id
    @GeneratedValue
    private Long Id;

    private Long price;

    @ManyToOne
    private User user;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
