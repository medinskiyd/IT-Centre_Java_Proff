package hw7.h;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Дмитрий on 10.03.14.
 */
@Entity
@Table(name = "NotesType")
public class NotesType {

   @Id // Для обозначения первичного ключа.
   @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTESTYPE_ID", allocationSize = 1, initialValue= 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
   @Column(name = "ID")
   private Long id;

   @Column(name = "NOTESTYPE")
   private String notesType;

    public NotesType() {

    }

    public NotesType(String notesType, Set<Model> model) {
        this.notesType = notesType;
        this.model = model;
    }

    @OneToMany(mappedBy = "notesType") //для того что бы не использовалась лишняя табличка для связей
        // Для того что бы вычитывать все сущности добавляем fetch = FetchType.EAGER
        // Для того что бы изменить все cascade = CascadeType.ALL
    private Set<Model> model = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotesType() {
        return notesType;
    }

    public void setNotesType(String notesType) {
        this.notesType = notesType;
    }

    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "NotesType{" +
                "id=" + id +
                ", notesType='" + notesType + '\'' +
                ", model=" + model +
                '}';
    }
}
