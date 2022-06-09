import java.util.Scanner;
import java.sql.Date;

public class MenuUser {
    Scanner scan = new Scanner(System.in);
    CRUDbook booksCRUD = new CRUDbook();
    CRUDuser usersCRUD = new CRUDuser();

    int choice = 0;

    void showMenu(User user) {
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
                    System.out.println("\nTwoje ksiazki: ");
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].borrowerId == user.id) {
                            System.out.println();
                            System.out.println("autor: " + books[i].author);
                            System.out.println("tytul: " + books[i].title);
                            System.out.println("data zwrotu: " + books[i].dateOfReturn);
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    for (Book b : booksCRUD.Read()
                    ) {
                        System.out.println("id: " + b.id);
                        System.out.println("autor: " + b.author);
                        System.out.println("tytul: " + b.title);
                        System.out.println("dostepnosc: " + ((b.available) ? "dostepny" : "niedostepny"));
                        System.out.println();
                    }
                    System.out.println("Podaj id ksiazki aby ja wypozyczyc albo wpisz 0 aby wrocic");
                    int bookChoice = Integer.parseInt(scan.nextLine());
                    if (bookChoice != 0) {
                        for (Book b : booksCRUD.Read()
                        ) {
                            if (b.id == bookChoice && b.available) {
                                System.out.println("id: " + b.id);
                                System.out.println("autor: " + b.author);
                                System.out.println("tytul: " + b.title);
                                System.out.println("Czy na pewno chcesz wypozyczyc ta ksiazke? Wpisz 1 aby wypozyczyc, 0 by wrocic");
                                if (Integer.parseInt(scan.nextLine()) == 1) {
                                    b.available = false;
                                    long DAY_IN_MS = 1000 * 60 * 60 * 24;
                                    String date = new Date(System.currentTimeMillis() + (31 * DAY_IN_MS)).toString();
                                    String[] dates = date.split("-");
                                    Book book = new Book(b.id, b.title, b.author, false, user.id, dates[2] + "/" + dates[1] + "/" + dates[0]);
                                    booksCRUD.Update(book);
                                    for (int i = 0; i < user.books.length; i++) {
                                        if (user.books[i] == null) {
                                            user.books[i] = b.id;
                                            i = user.books.length;
                                        }
                                    }
                                    usersCRUD.Update(user);
                                }
                            } else if (b.id == bookChoice && !b.available) {
                                System.out.println("Ksiazka jest juz wypozyczona");
                            }
                        }
                    }
                    break;
                case 3:
                    books = booksCRUD.Read();
                    System.out.println("Twoje ksiazki: ");
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].borrowerId == user.id) {
                            System.out.println();
                            System.out.println("id: " + books[i].id);
                            System.out.println("autor: " + books[i].author);
                            System.out.println("tytul: " + books[i].title);
                            System.out.println("data zwrotu: " + books[i].dateOfReturn);
                        }
                    }
                    System.out.println("Podaj id ksiazki ktora chcesz zwrocic lub wpisz 0 by wrocic");
                    bookChoice = Integer.parseInt(scan.nextLine());
                    if (bookChoice != 0) {
                        for (int i = 0; i < books.length; i++) {
                            if (bookChoice == books[i].id) {
                                books[i].available = true;
                                books[i].borrowerId = 0;
                                booksCRUD.Update(books[i]);
                                Date date = new Date(System.currentTimeMillis());
                                if (date.after(books[i].dateOfReturn)) {
                                    System.out.println("Oddales ksiazke poza terminem, nalozona zostaje kara");
                                } else {
                                    System.out.println("Dziekujemy za oddanie ksiazki w terminie");
                                }
                            }
                        }
                        for (int i = 0; i < user.books.length; i++) {
                            if (bookChoice == user.books[i]) {
                                user.books[i] = null;
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
