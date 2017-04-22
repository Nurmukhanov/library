package brains;

import javax.persistence.*;

/**
 * Created by olzhas on 21.04.17.
 */
@Entity
public class StudentsBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String studentsRfid;
    @Column
    private String booksRfid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentsRfid() {
        return studentsRfid;
    }

    public void setStudentsRfid(String studentsRfid) {
        this.studentsRfid = studentsRfid;
    }

    public String getBooksRfid() {
        return booksRfid;
    }

    public void setBooksRfid(String booksRfid) {
        this.booksRfid = booksRfid;
    }
}
