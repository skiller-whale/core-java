//==============================//
// Static Fields and Methods    //
//==============================//
/*

PART 1.
--------
Modify the `Book` class to keep count of how many instances have been created.
Declare a variable called 'collection' to help with this.

PART 2.
--------
Define a static method called 'genre' that:
* takes a String argument;
* for each book in the repository, increments an integer counter if the book's genre matches the argument;
* returns the integer counter.

Use 'Repository.books()' to access the repository books.
You will also need the 'a.equals(b)' method to compare two Strings.

PART 3.
--------
Make the 'yearPublished' field private.
Define a setter for it that ignores incorrect integer values, i.e., those in excess of the current year.

The constructor should make use of this setter.

(Note: an API would usually throw an error if given an incorrect value. For simplicity, we ignore incorrect values).

PART 4.
--------
Convert all fields in Book to `private`.
This will temporarily stop the library's User Interface from working.

Create getters for the 'title' and 'available' fields.
Then re-factor the methods in Library.java and UserInterface.java to use these getters.

*/

public class Book {
    String title;
    String author;
    int yearPublished;
    long isbn;
    boolean available;

    Book(String title, String author, int yearPublished, long isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.available = available;
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
