import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Book {
    int id;
    String title = new String();

    public Book(int id, String title, String author, boolean available, int borrowerId, String input) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
        this.borrowerId = borrowerId;
        dateString = input;
        try {
            dateOfReturn = new SimpleDateFormat("dd/MM/yyyy").parse(input);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    String author = new String();
    boolean available;
    int borrowerId;
    Date dateOfReturn;

    String dateString;
    @Override
    public String toString() {
        return "id ksiazki: " +  id + "\n" + "autor: " + author + "\n" +
                "tytul: " + title + "\n" +
                "dostepnosc: " +(available ? "dostepny" :
                "niedostepny" + "\n" + "id wypozyczajacego: " + borrowerId + "\n" +"data zwrotu: " + dateString);

    }
}
