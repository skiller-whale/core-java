import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

class ReadingListApp {
    public static void main(String[] args) throws IOException {
        // TODO (Exercise 1): if args.length == 0, print a usage message to System.err and return
        // TODO (Exercise 1): switch on args[0] to call listBooks(), addBook(), or searchBooks(args[1])
        //   for any unknown command, print an error to System.err
    }

    static void listBooks() throws IOException {
        for (String line : BookStore.getAll()) {
            // TODO (Exercise 1): split csvLine on "," and print the book details using System.out.printf()
            //   hint: fields are title [0], year [1], author [2]
        }
    }

    static void addBook() throws IOException {
        // TODO (Exercise 2): prompt for title (nextLine), year (nextInt), author (nextLine)

        // TODO (Exercise 2): once you've captured title, year, and author, call:
        //   BookStore.add(title + "," + year + "," + author + "\n");
    }

    static void searchBooks(String term) throws IOException {
        // TODO (Exercise 5): open BookStore.DATA_FILE for line-by-line reading using BufferedReader(new FileReader(...))
        //   check each line for term (case-insensitive): line.toLowerCase().contains(term.toLowerCase())
        //   write matching lines to "search_results.txt" using BufferedWriter(new FileWriter(...))
        //   close both streams, then print how many matches were found
    }
}
