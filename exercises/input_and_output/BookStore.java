import java.util.*;
import java.nio.file.*;
import java.io.*;

class BookStore {
    // TODO (Exercise 3): replace this with a Path to "reading_list.txt" in the current directory
    static final List<String> data = new ArrayList<>(List.of(
        "The Pragmatic Programmer,1999,Andrew Hunt",
        "Clean Code,2008,Robert C. Martin",
        "Effective Java,2001,Joshua Bloch",
        "Designing Data-Intensive Applications,2017,Martin Kleppmann",
        "The Phoenix Project,2013,Gene Kim",
        "A Philosophy of Software Design,2018,John Ousterhout"
    ));

    static List<Book> getAll() throws IOException {
        // TODO (Exercise 3): instead of looping over the hardcoded `data` list, read lines from the file and parse them into Book objects
        List<Book> books = new ArrayList<>();
        for (String csvLine : data) {
            String[] fields = csvLine.split(",");
            String title = fields[0];
            int year = Integer.parseInt(fields[1]);
            String author = fields[2];
            books.add(new Book(title, year, author));
        }
        return books;
    }

    static void add(Book book) throws IOException {
        // TODO (Exercise 4): append the csvLine to the file
        // String csvLine = book.getTitle() + "," + book.getYear() + "," + book.getAuthor() + "\n";
    }
}
