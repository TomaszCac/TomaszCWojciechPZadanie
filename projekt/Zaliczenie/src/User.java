import java.util.Arrays;

class User {
    int id;

    public User(int id, String name, Integer[] books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    String name= new String();
    Integer[] books = new Integer[5];

    @Override
    public String toString() {
        return  "id: " + id + "\n" +
                "nazwa: " + name + '\n' +
                "id wypozyczonych ksiazek: " + parseBooks(books);
    }
    public String parseBooks(Integer[] books) {
        StringBuilder output = new StringBuilder("[");
        for (var book: books
             ) {
            if(book!=null) {
                output.append(book).append(", ");
            }
        }
        if(output.length()>2) {
            output.deleteCharAt(output.length()-1);
            output.deleteCharAt(output.length()-1);
        }
        output.append("]");
        return output.toString();
    }
}
