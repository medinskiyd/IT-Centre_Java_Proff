package hw7.h;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Дмитрий on 10.03.14.
 */

@Entity
@Table(name = "FirmCreater")
public class FirmCreater {

    @Id // Для обозначения первичного ключа.
    @Column(name = "FirmCreater")
    private String firmCreater;

    public FirmCreater() {

    }

    public FirmCreater(String firmCreater, Set<Model> model) {
        this.firmCreater = firmCreater;
        this.model = model;
    }

    @OneToMany() // mappedBy = "firm"для того что бы не использовалась лишняя табличка для связей
    // Для того что бы вычитывать все сущности добавляем fetch = FetchType.EAGER
    // Для того что бы изменить все cascade = CascadeType.ALL
    private Set<Model> model = new HashSet<>();

    public String getFirmCreater() {
        return firmCreater;
    }

    public void setFirmCreater(String firmCreater) {
        this.firmCreater = firmCreater;
    }

    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }
}
