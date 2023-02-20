//==============================//
// Static Fields and Methods    //
//==============================//
/*

EXERCISE 2.
-----------
Define a static method called 'getBooksOfGenre' that:
* takes a String argument;
* for each book in the repository, increments an integer counter if the book's genre matches the argument;
* returns the integer counter.

Use 'Repository.books()' to access the repository books.
You will also need the 'a.equals(b)' method to compare two Strings.

After doing this, return to the slide instructions to compile your code.

*/

public class Book {
    static int totalBooks;
    String title;
    String author;
    int yearPublished;
    String genre;
    long isbn;
    boolean available;

    Book(String title, String author, int yearPublished, String genre, long isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.isbn = isbn;
        this.available = available;
        Book.totalBooks++;
    }
}
