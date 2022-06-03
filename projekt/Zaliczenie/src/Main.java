import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Login log = new Login();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();

        try {
            System.out.println("Zaloguj sie:");
            menu.showMenu(log.logIn(scan.nextLine()));



        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
