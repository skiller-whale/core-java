//==============================//
// Static Fields and Methods    //
//==============================//
/*

EXERCISE 1.
-----------
Modify the `Book` class to keep count of how many instances have been created, if any.
Declare a variable called 'totalBooks' to help with this.

After doing this, return to the slide instructions to compile your code.

*/

public class Book {
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
    }
}
