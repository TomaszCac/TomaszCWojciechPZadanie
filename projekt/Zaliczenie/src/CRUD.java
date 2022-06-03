import java.io.*;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class CRUD {
    void Create(User user) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("users.txt");
            writer.print(user.id + "," + user.name + "," + user.city + "," + user.street + "," + user.houseNumber + ",");
            for (var book: user.books
                 ) {
                writer.print(book + ",");
            }
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        finally {
            writer.close();
        }

    }
    User[] Read() {
        ArrayList<User> test = new ArrayList<>();
        User[] users = null;

        try {
            File file = new File("users.txt");

            BufferedReader reader =new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null)
            {
                Integer[] books = new Integer[5];
                String[] tab = line.split(",");
                for(int i = 5; i < tab.length; i++)
                {
                    if(tab[i] != "")
                    {
                        books[i-5] = Integer.parseInt(tab[i]);
                    }
                }
                test.add(new User(Integer.parseInt(tab[0]),tab[1],tab[2],tab[3],Integer.parseInt(tab[4]),books));
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
