//==============================//
// Encapsulation                //
//==============================//
/*

EXERCISE 3.
-----------
Make the 'yearPublished' field private.
Define a setter for it that ignores incorrect integer values, i.e., those in the future.
You can use 'java.time.YearMonth.now().getYear()' to get the current year.

The constructor should make use of this setter.

(Note: an API would usually throw an error if given an incorrect value. For simplicity, we ignore incorrect values).

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

    // Count the number of books of a certain genre
    public static int getBooksOfGenre(String category) {
        int total = 0;
        for (Book book : Repository.books()) {
            if (category.equals(book.genre)) {
                total++;
            }
        }
        return total;
    }

    void display() {
        System.out.printf("* %s, by %s", title, author);
        System.out.printf(" (%s, ISBN: %s)\n", yearPublished, isbn);
    }
}
