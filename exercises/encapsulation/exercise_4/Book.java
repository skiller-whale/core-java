//==============================//
// Encapsulation                //
//==============================//
/*

EXERCISE 4.
--------
Convert all fields in Book to `private`.
This will temporarily stop the library's User Interface from working.

Create getters for the 'title' and 'available' fields.
Read through the methods in Library.java and UserInterface.java, re-factoring where required to use these getters.

After doing this, return to the slide instructions to compile your code.

*/

public class Book {
    static int totalBooks;
    String title;
    String author;
    private int yearPublished;
    String genre;
    long isbn;
    boolean available;

    Book(String title, String author, int yearPublished, String genre, long isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.setYearPublished(yearPublished);
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

    // Setter for the yearPublished field
    public boolean setYearPublished(int num) {
        // If 'num' is sensible, assign its value to yearPublished
        if (num >= 0 && num <= java.time.YearMonth.now().getYear()) {
            yearPublished = num;
            return true;
        }
        return false;
    }

    void display() {
        System.out.printf("* %s, by %s", title, author);
        System.out.printf(" (%s, ISBN: %s)\n", yearPublished, isbn);
    }

    void lendBook() {
        available = false;
    }

    void returnBook() {
        available = true;
    }
}
