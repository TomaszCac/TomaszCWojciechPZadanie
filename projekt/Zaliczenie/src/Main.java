import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        int[] books = {0,1};
        User user = new User(1,"marcin",books);
        CRUD crud = new CRUD();
        crud.Create(user);
    }

}
