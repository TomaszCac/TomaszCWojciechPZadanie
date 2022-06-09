import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Login log = new Login();
        Scanner scan = new Scanner(System.in);
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuUser menuUser = new MenuUser();
        try {
            System.out.println("Zaloguj sie:");
            User loggedUser = log.logIn(scan.nextLine());
            if(loggedUser.name.equals("admin")) {
                menuAdmin.showMenu(loggedUser);
            }
            else {
                menuUser.showMenu(loggedUser);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
