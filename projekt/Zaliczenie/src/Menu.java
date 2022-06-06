import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    CRUDbook booksCRUD = new CRUDbook();
    CRUDuser usersCRUD = new CRUDuser();
    int choice = 0;
    void showMenu(User user) {
        if(user.name.equals("admin"))
        {
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
                        updatedBooks[updatedBooks.length-1] = new Book(maxid,title,author,true,0, "31/12/1998");
                        booksCRUD.Create(updatedBooks);
                        break;
                }
            }
        }
        else
        {
            while(choice != 4) {
                System.out.println("1-Pokaz swoje dane");
                System.out.println("2-Wyswietl liste ksiazek/wypozycz ksiazke");
                System.out.println("3-Zwroc ksiazke");
                System.out.println("4-Wyloguj");
                choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println(user);
                        Book[] books = booksCRUD.Read();
                        System.out.println("Twoje ksiazki: ");
                        for (int i = 0; i < books.length; i++) {
                            if(books[i].borrowerId==user.id) {
                                System.out.println();
                                System.out.println("autor: " + books[i].author);
                                System.out.println("tytul: " + books[i].title);
                                System.out.println("data zwrotu: " + books[i].dateOfReturn);
                            }
                        }
                        System.out.println();
                        break;
                    case 2:
                        for (Book b: booksCRUD.Read()
                             ) {
                            System.out.println("id: " + b.id);
                            System.out.println("autor: " + b.author);
                            System.out.println("tytul: " + b.title);
                            System.out.println("dostepnosc: " + ((b.available)? "dostepny" : "niedostepny"));
                            System.out.println();
                        }
                        System.out.println("Podaj id ksiazki aby ja wypozyczyc albo wpisz 0 aby wrocic");
                        int bookChoice= Integer.parseInt(scan.nextLine());
                        if(bookChoice!=0) {
                            for (Book b: booksCRUD.Read()
                                 ) {
                                if(b.id==bookChoice && b.available) {
                                    System.out.println("id: " + b.id);
                                    System.out.println("autor: " + b.author);
                                    System.out.println("tytul: " + b.title);
                                    System.out.println("Czy na pewno chcesz wypozyczyc ta ksiazke? Wpisz 1 aby wypozyczyc, 0 by wrocic");
                                    if(Integer.parseInt(scan.nextLine())==1) {
                                        b.available = false;
                                        long DAY_IN_MS = 1000 * 60 * 60 * 24;
                                        String date = new Date(System.currentTimeMillis() + (31 * DAY_IN_MS)).toString();
                                        String[] dates = date.split("-");
                                        Book book = new Book(b.id,b.title,b.author,false,user.id,dates[2]+"/"+dates[1]+"/"+dates[0]);
                                        booksCRUD.Update(book);
                                        for (int i = 0; i < user.books.length; i++) {
                                            if(user.books[i]==null) {
                                                user.books[i] = b.id;
                                                i = user.books.length;
                                            }
                                        }
                                        usersCRUD.Update(user);
                                    }
                                }
                                else if(b.id==bookChoice && !b.available){
                                    System.out.println("Ksiazka jest juz wypozyczona");
                                }
                            }
                        }
                        break;
                    case 3:
                        books = booksCRUD.Read();
                        System.out.println("Twoje ksiazki: ");
                        for (int i = 0; i < books.length; i++) {
                            if(books[i].borrowerId==user.id) {
                                System.out.println();
                                System.out.println("id: " + books[i].id);
                                System.out.println("autor: " + books[i].author);
                                System.out.println("tytul: " + books[i].title);
                                System.out.println("data zwrotu: " + books[i].dateOfReturn);
                            }
                        }
                        System.out.println("Podaj id ksiazki ktora chcesz zwrocic lub wpisz 0 by wrocic");
                        bookChoice = Integer.parseInt(scan.nextLine());
                        if(bookChoice!=0) {
                            for (int i = 0; i < books.length; i++) {
                                if(bookChoice==books[i].id) {
                                    books[i].available = true;
                                    books[i].borrowerId = 0;
                                    booksCRUD.Update(books[i]);
                                    Date date  = new Date(System.currentTimeMillis());
                                    if(date.after(books[i].dateOfReturn)) {
                                        System.out.println("Oddales ksiazke poza terminem, nalozona zostaje kara");
                                    }
                                    else {
                                        System.out.println("Dziekujemy za oddanie ksiazki w terminie");
                                    }
                                }
                            }
                            for (int i = 0; i < user.books.length; i++) {
                                if(bookChoice==user.books[i]) {
                                    user.books[i]=null;
                                    i = user.books.length;
                                }
                            }
                            usersCRUD.Update(user);

                        }
                        break;
                }
            }
        }
    }
}
