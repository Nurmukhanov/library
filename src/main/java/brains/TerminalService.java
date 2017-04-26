package brains;

import java.sql.SQLException;

/**
 * Created by olzhas on 20.04.17.
 */
public class TerminalService {

    public static void bindStudent(StudentDTO studentDTO) throws SQLException {
        Student student = DbUtil.getInstance().getStudentDao().queryBuilder().where().eq("nick", studentDTO.getNick()).query().get(0);
        student.setRfid(studentDTO.getRfid());
        DbUtil.getInstance().getStudentDao().update(student);
    }

    public static void bindBook(BookDTO bookDTO) throws SQLException {
        Book book = DbUtil.getInstance().getBookDao().queryBuilder().where().eq("id", bookDTO.getId()).query().get(0);
        book.setRfid(bookDTO.getRfid());
        DbUtil.getInstance().getBookDao().update(book);
    }
}
