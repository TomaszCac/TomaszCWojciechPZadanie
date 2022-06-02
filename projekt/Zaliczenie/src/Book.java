import java.util.Date;
import java.util.Objects;

public class Book {
    int bookId;
    String title = new String();
    String author = new String();
    boolean available;
    int borrowerId;
    Date dateOfReturn;
    @Override
    public String toString() {
        return "id ksiazki: " + bookId + "\n" + "autor: " + author + "\n" +
                "tytul: " + title + "\n" +
                "dostepnosc: " +(available ? "dostepny" :
                "niedostepny" + "\n" + "id wypozyczajacego: " + borrowerId + "\n" +"data zwrotu: " + dateOfReturn);

    }
}
