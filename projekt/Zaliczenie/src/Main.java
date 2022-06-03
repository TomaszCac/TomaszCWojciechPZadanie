import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        CRUDuser crud = new CRUDuser();
        CRUDbook crudbook = new CRUDbook();
        User[] users = new User[3];
        Integer[] books = {0, 1};
        User us = new User(1,"marcinek","marcinia","marinow",1,books);
        User ud = new User(2,"daniel","danielow","denil",2,books);
        User uh = new User(3,"domson","domsonia","doms",3,books);
        User ug = new User(3,"bartek","bartkowo","bartoszs",4,books);


        Book book1 = new Book(1,"marcionowo","marcin",false,2,"31/12/1998");
        Book[] books1 = {book1};
        crudbook.Create(books1);

        for (Book d: crudbook.Read()
        ) {
            System.out.println(d+"\n");

        }

        users[0] = us;
        users[1] = ud;
        users[2] = uh;
        crud.Create(users);
        crud.Update(ug);
        for (User d: crud.Read()
             ) {
            System.out.println(d+"\n");

        }

    }

}
