package brains;

import java.sql.SQLException;

/**
 * Created by olzhas on 22.04.17.
 */
public class InitDb {
    public static void init() throws SQLException {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setName("Sheldon");
        student2.setName("Leonard");
        student1.setRfid("11111");
        student2.setRfid("22222");

        DbUtil.getInstance().getStudentDao().create(student1);
        DbUtil.getInstance().getStudentDao().create(student2);


        Book book1 = new Book();
        book1.setRfid("1");
        book1.setName("Physics 1");
        book1.setStatus(Status.FREE);
        book1.setIsbn("aaaa");

        Book book2 = new Book();
        book2.setRfid("2");
        book2.setName("Physics 2");
        book2.setStatus(Status.FREE);
        book2.setIsbn("bbbb");

        Book book3 = new Book();
        book3.setRfid("3");
        book3.setName("Physics 3");
        book3.setStatus(Status.FREE);
        book3.setIsbn("cccc");

        Book book4 = new Book();
        book4.setRfid("4");
        book4.setName("Physics 4");
        book4.setStatus(Status.FREE);
        book4.setIsbn("dddd");

        Book book5 = new Book();
        book5.setRfid("5");
        book5.setName("Physics 5");
        book5.setStatus(Status.FREE);
        book5.setIsbn("eeee");

        DbUtil.getInstance().getBookDao().create(book1);
        DbUtil.getInstance().getBookDao().create(book2);
        DbUtil.getInstance().getBookDao().create(book3);
        DbUtil.getInstance().getBookDao().create(book4);
        DbUtil.getInstance().getBookDao().create(book5);
    }
}
