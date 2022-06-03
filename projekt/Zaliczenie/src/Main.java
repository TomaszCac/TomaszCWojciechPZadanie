import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        CRUD crud = new CRUD();
        User[] users = new User[3];
        Integer[] books = {0, 1};
        User us = new User(1,"marcinek","marcinia","marinow",1,books);
        User ud = new User(2,"daniel","danielow","denil",2,books);
        User uh = new User(3,"domson","domsonia","doms",3,books);
        users[0] = us;
        users[1] = ud;
        users[2] = uh;
        crud.Create(users);
        int c = 2;
        crud.Delete(c);
        for (User d: crud.Read()
             ) {
            System.out.println(d);

        }

    }

}
