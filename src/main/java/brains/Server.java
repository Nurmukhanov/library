package brains;

import com.google.gson.reflect.TypeToken;

import java.sql.SQLException;
import java.util.ArrayList;

import static spark.Spark.*;
/**
 * Created by olzhas on 14.04.17.
 */
public class Server {
    public static void main(String[] args) throws SQLException {
//        InitDb.init();
        post("create-book",(req, res) -> {
            TerminalService.createBook(GetGson.getInstanceOfGson().fromJson(req.body(), Book.class));
            return "book added";
        });
        post("create-student", (req, res) -> {
            TerminalService.createStudent(GetGson.getInstanceOfGson().fromJson(req.body(), Student.class));
            return "student added";
        });
        get("get-all-books", (req, res) -> {
            res.type("application/json");
            return GetGson.getInstanceOfGson().toJson(TerminalService.getAllBooks());
        });
        get("get-all-students", (req, res) -> {
            res.type("application/json");
            return GetGson.getInstanceOfGson().toJson(TerminalService.getAllStudents());
        });
        post("takes-books", (req, res) -> {
            KioskService.takesBooks(GetGson.getInstanceOfGson().fromJson(req.body(), new TypeToken<ArrayList<StudentsBook>>(){}.getType()));
            return "You must change the world!";
        });
        post("handed-overs", (req, res) -> {
                KioskService.handedBooks(GetGson.getInstanceOfGson().fromJson(req.body(), new TypeToken<ArrayList<StudentsBook>>(){}.getType()));
                return "Have you changed the world";
            }
        );

    }
}
