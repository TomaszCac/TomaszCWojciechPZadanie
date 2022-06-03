import java.io.*;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class CRUDuser {
    void Create(User[] users) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("users.txt");
            for (User user : users
            ) {
                writer.print(user.id + "," + user.name + "," + user.city + "," + user.street + "," + user.houseNumber + ",");
                for (var book : user.books
                ) {
                    if (!Objects.isNull(book)) {
                        writer.print(book + ",");
                    }
                }
                writer.println();
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            writer.close();
        }

    }

    User[] Read() {
        ArrayList<User> test = new ArrayList<>();
        User[] users = null;

        try {
            File file = new File("users.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                Integer[] books = new Integer[5];
                String[] tab = line.split(",");
                for (int i = 5; i < tab.length; i++) {
                    if (tab[i] != "") {
                        books[i - 5] = Integer.parseInt(tab[i]);
                    }
                }
                test.add(new User(Integer.parseInt(tab[0]), tab[1], tab[2], tab[3], Integer.parseInt(tab[4]), books));
            }
            users = new User[test.size()];
            for (int x = 0; x < test.size(); x++) {
                users[x] = test.get(x);
            }


        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;


    }

    void Delete(int id) {
        ArrayList<User> users = new ArrayList<>();
        for (User user : Read()
        ) {
            if (user.id != id) {
                users.add(user);
            }


        }
        User[] userdata = new User[users.size()];
        for (int x = 0; x < users.size(); x++) {
            userdata[x] = users.get(x);
        }
        Create(userdata);


    }

    void Update(User updatedUser) {
        User[] users = Read();
        for (int i = 0; i <users.length ; i++) {
            if (users[i].id == updatedUser.id) {
                users[i] = updatedUser;
            }
        }
        Create(users);
    }
}
