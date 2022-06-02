import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        CRUD crud = new CRUD();
        for (User user: crud.Read()
             ) {
            System.out.println(user);
        }
    }

}
