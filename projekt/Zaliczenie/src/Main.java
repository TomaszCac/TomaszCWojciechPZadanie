import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        CRUD crud = new CRUD();
        for (User d: crud.Read()
             ) {
            System.out.println(d.id);
            System.out.println(d.name);
            System.out.println(d.books.length);
        }
    }

}
