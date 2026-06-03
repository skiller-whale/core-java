import java.util.*;
import java.nio.file.*;
import java.io.*;

class BookStore {
    // TODO (Exercise 3): replace this with a Path to "reading_list.txt" in the current directory
    static final List<String> books = new ArrayList<>(List.of(
        "The Pragmatic Programmer,1999,Andrew Hunt",
        "Clean Code,2008,Robert C. Martin",
        "Effective Java,2001,Joshua Bloch",
        "Designing Data-Intensive Applications,2017,Martin Kleppmann",
        "The Phoenix Project,2013,Gene Kim",
        "A Philosophy of Software Design,2018,John Ousterhout"
    ));

    static List<String> getAll() throws IOException {
        // TODO (Exercise 3): replace this with reading all lines from the file
        return books;
    }

    static void add(String csvLine) throws IOException {
        // TODO (Exercise 4): append the csvLine to the file
    }
}
