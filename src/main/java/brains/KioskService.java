package brains;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by olzhas on 20.04.17.
 */
public class KioskService {

    public static void handedBooks(List<StudentsBook> studentsBooks) throws SQLException {
        DbUtil.getInstance().getStudentsBooksDaa().delete(studentsBooks);
        for(StudentsBook studentsBook : studentsBooks){
            Book b = DbUtil.getInstance().getBookDao().queryBuilder().where().eq("rfid", studentsBook.getBooksRfid()).query().get(0);
            b.setStudent(null);
            b.setStatus(Status.FREE);
            DbUtil.getInstance().getBookDao().update(b);
        }
    }

    public static void takesBooks(List<StudentsBook> studentsBooks) throws SQLException {
        for (StudentsBook studentsBook: studentsBooks){
            DbUtil.getInstance().getStudentsBooksDaa().create(studentsBook);
            Book b = DbUtil.getInstance().getBookDao().queryBuilder().where().eq("rfid", studentsBook.getBooksRfid()).query().get(0);
            b.setStudent(DbUtil.getInstance().getStudentDao().queryBuilder().where().eq("rfid", studentsBook.getStudentsRfid()).query().get(0));
            b.setStatus(Status.BUSY);
            DbUtil.getInstance().getBookDao().update(b);
        }
    }
}
