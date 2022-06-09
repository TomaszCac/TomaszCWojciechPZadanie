import java.sql.Date;
import java.util.Scanner;

public class MenuAdmin {
    Scanner scan = new Scanner(System.in);
    CRUDbook booksCRUD = new CRUDbook();
    CRUDuser usersCRUD = new CRUDuser();
    int choice = 0;
    void showMenu(User user) {
            while(choice != 5) {
                System.out.println("1-Wyswietl liste ksiazek");
                System.out.println("2-Wyswietl liste uzytkownikow");
                System.out.println("3-Dodaj uzytkownika");
                System.out.println("4-Dodaj ksiazke");
                System.out.println("5-Wyloguj");
                choice = Integer.parseInt(scan.nextLine());
                int admchoice;
                switch (choice)
                {
                    case 1:
                        Book[] chosenBooks = booksCRUD.Read();
                        for (var book: chosenBooks
                             ) {
                            System.out.println("\n"+book);
                        }
                        System.out.println("\nPodaj id ksiazki aby ja zmodyfikowac albo wpisz 0 aby wrocic");
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
                                booksCRUD.Delete(bookId);
                            } else if (admchoice == 2) {
                                System.out.println("Nazwa ksiazki: ");
                                String newBookName = scan.nextLine();
                                System.out.println("Autor: ");
                                String newBookAuthor = scan.nextLine();
                                Book updatedBook = booksCRUD.Find(bookId);
                                updatedBook.author = newBookAuthor;
                                updatedBook.title = newBookName;
                                booksCRUD.Update(updatedBook);
                            }
                        }
                        break;
                    case 2:
                        User[] chosenUsers = usersCRUD.Read();
                        for (User u: chosenUsers
                             ) {
                            System.out.println("\n"+u);
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
                                usersCRUD.Delete(userId);
                            } else if (admchoice == 2) {
                                System.out.println("Nazwa: ");
                                String newUserName = scan.nextLine();
                                System.out.println("Miasto: ");
                                String newUserCity = scan.nextLine();
                                System.out.println("Ulica: ");
                                String newUserStreet = scan.nextLine();
                                System.out.println("Numer mieszkania: ");
                                int newUserNumber = Integer.parseInt(scan.nextLine());
                                User updatedUser = usersCRUD.Find(userId);
                                updatedUser.name = newUserName;
                                updatedUser.city = newUserCity;
                                updatedUser.street = newUserStreet;
                                updatedUser.houseNumber = newUserNumber;
                                usersCRUD.Update(updatedUser);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Podaj nazwe uzytkownika");
                        String name = scan.nextLine();
                        System.out.println("Podaj miasto");
                        String city = scan.nextLine();
                        System.out.println("Podaj ulice");
                        String street = scan.nextLine();
                        System.out.println("Podaj numer domu");
                        int houseNumber = Integer.parseInt(scan.nextLine());
                        int length = usersCRUD.Read().length+1;
                        User[] updatedUsers = new User[length];
                        User[] updatedUsers2 = usersCRUD.Read();
                        Integer[] book = null;
                        int maxid = 1;
                        for (User u: usersCRUD.Read()
                             ) {
                            if(maxid<u.id) {
                                maxid = u.id;
                            }
                        }
                        maxid++;
                        for (int i = 0; i < usersCRUD.Read().length; i++) {
                            updatedUsers[i] = updatedUsers2[i];
                        }
                        updatedUsers[updatedUsers.length-1] = new User(maxid,name,city,street,houseNumber,book);
                        usersCRUD.Create(updatedUsers);
                        break;
                    case 4:
                        System.out.println("Podaj tytul ksiazki");
                        String title = scan.nextLine();
                        System.out.println("Podaj autora");
                        String author = scan.nextLine();
                        length = booksCRUD.Read().length+1;
                        Book[] updatedBooks = new Book[length];
                        Book[] updatedBooks2 = booksCRUD.Read();
                        maxid = 1;
                        for (Book b: booksCRUD.Read()
                        ) {
                            if(maxid<b.id) {
                                maxid = b.id;
                            }
                        }
                        maxid++;
                        for (int i = 0; i < booksCRUD.Read().length; i++) {
                            updatedBooks[i] = updatedBooks2[i];
                        }
                        updatedBooks[updatedBooks.length-1] = new Book(maxid,title,author,true,0, "01/01/1900");
                        booksCRUD.Create(updatedBooks);
                        break;
                }
            }
    }
}

