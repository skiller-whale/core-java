import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

class ReadingListApp {
    public static void main(String[] args) throws IOException {
        // TODO (Exercise 1): if args.length == 0, print an error message to System.err and return
        // "No arguments provided. Usage: java ReadingListApp [list|add|search <term>]"

        // TODO (Exercise 1): based on value of args[0], call listBooks(), addBook(), or searchBooks(args[1]) as appropriate
        //   for any unknown command, print an error to System.err: "Unknown command: " + args[0] + ". Usage: java ReadingListApp [list|add|search <term>]"
    }

    static void listBooks() throws IOException {
        for (Book book : BookStore.getAll()) {
            // TODO (Exercise 1): print the book details using System.out.printf()
            //   use `book.getTitle()`, `book.getYear()`, and `book.getAuthor()` to get the details
            //   example output: "A Philosophy of Software Design (2018) by John Ousterhout"
        }
    }

    static void addBook() throws IOException {
        System.err.println("not yet implemented");
        // TODO (Exercise 2): prompt for title (nextLine), year (nextInt), author (nextLine)

        // TODO (Exercise 2): once you've captured title, year, and author, call:
        //   BookStore.add(new Book(title, year, author));
    }

    static void searchBooks(String term) throws IOException {
        System.err.println("not yet implemented");
        // TODO (Exercise 5): open BookStore.DATA_FILE for line-by-line reading using a buffered reader
        //   check each line for term (case-insensitive): line.toLowerCase().contains(term.toLowerCase())
        //   write matching lines to "search_results.txt" using BufferedWriter(new FileWriter(...))
        //   close both streams, then print how many matches were found
    }
}
