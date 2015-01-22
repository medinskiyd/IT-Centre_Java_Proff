package hw7.hibernote;

import javax.persistence.*;

/**
 * Created by Дмитрий on 10.03.14.
 */
    @Entity
    @Table(name = "Models")
    public class Model {

        @Id // Для обозначения первичного ключа.
        @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MODEL_ID", allocationSize = 1, initialValue= 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
        @Column(name = "ID")
        private Long id;

        //@ManyToMany
        @Column(name = "FIRM")
        private String firm;

        @Column(name = "MODEL")
        private String name;

        @ManyToOne
        private NotesType notesType;

        public Model() {

        }

    public Model(String firm, String name, NotesType notesType) {
        this.firm = firm;
        this.name = name;
        this.notesType = notesType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NotesType getNotesType() {
        return notesType;
    }

    public void setNotesType(NotesType notesType) {
        this.notesType = notesType;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", name='" + name + '\'' +
                ", notesType=" + notesType +
                '}';
    }
}
