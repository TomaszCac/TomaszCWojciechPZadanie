import java.io.*;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class CRUD {
    void Create(User user) {
        PrintWriter konstruktor = null;
        try {
            konstruktor = new PrintWriter("users.txt");
            konstruktor.print(user.id + "," + user.name + ",");
            for (var book: user.books
                 ) {
                konstruktor.print(book + ",");
            }
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        finally {
            konstruktor.close();
        }

    }
}
