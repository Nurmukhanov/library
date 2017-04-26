package brains;

import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.stmt.query.In;

import java.sql.SQLException;
import java.util.ArrayList;

import static spark.Spark.*;
/**
 * Created by olzhas on 14.04.17.
 */
public class Server {
    public static void main(String[] args) throws SQLException {
        InitDb.init();
        post("create-student", (req,res) -> {
            TerminalService.bindStudent(GetGson.getInstanceOfGson().fromJson(req.body(), StudentDTO.class));
            return "Student tied";
        });
        post("create-book", (req,res) -> {
            TerminalService.bindBook(GetGson.getInstanceOfGson().fromJson(req.body(), BookDTO.class));
            return "";
        });
        post("takes-books", (req, res) -> {
            KioskService.takesBooks(GetGson.getInstanceOfGson().fromJson(req.body(), new TypeToken<ArrayList<StudentsBook>>(){}.getType()));
            return "You must change the world!";
        });
        post("handed-overs", (req, res) -> {
                KioskService.handedBooks(GetGson.getInstanceOfGson().fromJson(req.body(), new TypeToken<ArrayList<StudentsBook>>(){}.getType()));
                return "Have you changed the world?";
            }
        );

    }
}
