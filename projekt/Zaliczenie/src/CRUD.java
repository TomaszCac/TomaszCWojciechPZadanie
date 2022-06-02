import java.io.*;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;


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
    User[] Read() {
        ArrayList<User> test = new ArrayList<>();
        User[] users = null;

        try {
            File file = new File("projekt/Zaliczenie/users.txt");

            BufferedReader reader =new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null)
            {
                int[] books = new int[5];
                String[] tab = line.split(",");
                for(int i = 2; i < tab.length; i++)
                {
                    if(tab[i] != "")
                    {
                        books[i-2] = Integer.parseInt(tab[i]);
                    }
                }
                test.add(new User(Integer.parseInt(tab[0]),tab[1],books));
            }
                 users = new User[test.size()];
                for(int i = 0; i < users.length; i++)
                {
                    users[i] = test.get(i);
                }


        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        return users;



    }
}
