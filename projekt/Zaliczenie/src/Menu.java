import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    CRUDbook books = new CRUDbook();
    CRUDuser users = new CRUDuser();
    int choice = 0;
    void showMenu(User user) {
        if(user.name.equals("admin"))
        {
            while(choice != 3) {
                System.out.println("1-Wyswietl liste ksiazek");
                System.out.println("2-Wyswietl liste uzytkownikow");
                System.out.println("3-Wyloguj");
                choice = Integer.parseInt(scan.nextLine());
                int admchoice;
                switch (choice)
                {
                    case 1:
                        Book[] chosenBooks = books.Read();
                        for (var book: chosenBooks
                             ) {
                            System.out.println(book);
                        }
                        System.out.println("Podaj id ksiazki aby ja zmodyfikowac albo wpisz 0 aby wrocic");
                         admchoice = Integer.parseInt(scan.nextLine());
                        if(admchoice != 0)
                        {
                            int bookId = admchoice;
                            System.out.println("1-Usun");
                            System.out.println("2-Zmodyfikuj");
                            System.out.println("3-Cofnij");
                            admchoice = Integer.parseInt(scan.nextLine());
                            if(admchoice == 1)
                            {
                                books.Delete(bookId);
                            } else if (admchoice == 2) {
                                System.out.println("Nazwa ksiazki: ");
                                String newBookName = scan.nextLine();
                                System.out.println("Autor: ");
                                String newBookAuthor = scan.nextLine();
                                Book updatedBook = books.Find(bookId);
                                updatedBook.author = newBookAuthor;
                                updatedBook.title = newBookName;
                                books.Update(updatedBook);
                            }
                        }
                        break;
                    case 2:
                        User[] chosenUsers = users.Read();
                        for (User u: chosenUsers
                             ) {
                            System.out.println(u);
                        }
                        System.out.println("Podaj id uzytkownika aby go zmodyfikowac albo wpisz 0 aby wrocic");
                         admchoice = Integer.parseInt(scan.nextLine());
                        if(admchoice != 0)
                        {
                            int userId = admchoice;
                            System.out.println("1-Usun");
                            System.out.println("2-Zmodyfikuj");
                            System.out.println("3-Cofnij");
                            admchoice = Integer.parseInt(scan.nextLine());
                            if(admchoice == 1)
                            {
                                users.Delete(userId);
                            } else if (admchoice == 2) {
                                System.out.println("Nazwa: ");
                                String newUserName = scan.nextLine();
                                System.out.println("Miasto: ");
                                String newUserCity = scan.nextLine();
                                System.out.println("Ulica: ");
                                String newUserStreet = scan.nextLine();
                                System.out.println("Numer mieszkania: ");
                                int newUserNumber = Integer.parseInt(scan.nextLine());
                                User updatedUser = users.Find(userId);
                                updatedUser.name = newUserName;
                                updatedUser.city = newUserCity;
                                updatedUser.street = newUserStreet;
                                updatedUser.houseNumber = newUserNumber;
                                users.Update(updatedUser);
                            }
                        }
                        break;
                }
            }
        }
        else
        {
            while(choice != 5) {
                System.out.println("1-Pokaz swoje dane");
                System.out.println("2-Wyswietl liste ksiazek");
                System.out.println("3-Wypozycz ksiazke");
                System.out.println("4-Zwroc ksiazke");
                System.out.println("5-Wyloguj");
                choice = Integer.parseInt(scan.nextLine());
            }
        }
    }
}
