package brains;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by olzhas on 14.04.17.
 */

public class DbUtil {
    private static DbUtil ourInstance = new DbUtil();
    private JdbcConnectionSource dbSource;
    private Dao<Student, Long> studentDao;
    private Dao<Book, Long> bookDao;
    private Dao<StudentsBook, Long> studentsBookDao;

    public static DbUtil getInstance(){
        return ourInstance;
    }
    private DbUtil(){
        try {
            dbSource = new JdbcConnectionSource("jdbc:postgresql://localhost:32781/docker?user=docker&password=docker");
//            TableUtils.createTable(dbSource, Book.class);
            bookDao = DaoManager.createDao(dbSource, Book.class);
//            TableUtils.createTable(dbSource, Student.class);
            studentDao = DaoManager.createDao(dbSource, Student.class);
//            TableUtils.createTable(dbSource, StudentsBook.class);
            studentsBookDao = DaoManager.createDao(dbSource, StudentsBook.class);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot establish DB connection " + e.getMessage() + " " + e.getCause());
        }
    }

    public Dao<Student, Long> getStudentDao(){
        return studentDao;
    }

    public Dao<Book, Long> getBookDao(){
        return bookDao;
    }

    public Dao<StudentsBook, Long> getStudentsBooksDaa(){
        return studentsBookDao;
    }
}