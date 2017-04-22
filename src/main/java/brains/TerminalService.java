package brains;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by olzhas on 20.04.17.
 */
public class TerminalService {
    public static void createBook(Book book) throws SQLException {
        DbUtil.getInstance().getBookDao().create(book);
    }
    public static void createStudent(Student student) throws SQLException{
        DbUtil.getInstance().getStudentDao().create(student);
    }

    public static List<Student> getAllStudents() throws SQLException {
        return DbUtil.getInstance().getStudentDao().queryForAll();
    }

    public void DeleteStudent(){
    }
    public void DeleteBook(){}
    public void UpdateStudent(){}
    public void UpdateBook(){}

    public static List<Book> getAllBooks() throws SQLException {
        return DbUtil.getInstance().getBookDao().queryForAll();
    }
}
