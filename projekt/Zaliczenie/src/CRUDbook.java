
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;

public class CRUDbook {
    void Create(Book[] books) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("books.txt");
            for (Book book : books
            ) {
                if(!Objects.isNull(book)) {
                    writer.print(book.id + "," + book.title + "," + book.author + "," + book.available + "," + book.borrowerId + "," + book.dateString);
                    writer.println();
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            writer.close();
        }

    }

    Book[] Read() {
        ArrayList<Book> test = new ArrayList<>();
        Book[] books = null;
        try {
            File file = new File("books.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tab = line.split(",");
                test.add(new Book(Integer.parseInt(tab[0]),tab[1],tab[2],Boolean.parseBoolean(tab[3]),Integer.parseInt(tab[4]),tab[5]));
            }
            books = new Book[test.size()];
            for (int x = 0; x < test.size(); x++) {
                books[x] = test.get(x);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return books;


    }

    void Delete(int id) {
        Book[] books = Read();
        for (int i = 0; i < books.length ; i++) {
            if(books[i].id==id) {
                books[i] = null;
                i = books.length;
            }
        }
        Create(books);
    }

    void Update(Book updatedBook) {
        Book[] books = Read();
        for (int i = 0; i <books.length ; i++) {
            if (books[i].id == updatedBook.id) {
                books[i] = updatedBook;
            }
        }
        Create(books);
    }
}
