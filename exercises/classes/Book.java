// =================== //
// Fields and Methods  //
// =================== //

/* PART 1.
----------
Add the following fields to the Book class:

  * `title`
  * `author`
  * `year`
  * `isbn` (a 13-digit number)
  * `available` (to indicate whether a book is on loan or not)

These should be of type String, int, boolean, or long.
*/

/* PART 2.
----------
Define two instance methods, lendBook and returnBook, to implement the following functionality:

* If `this.lendBook()` is called, `this` is not available to be borrowed
* If `this.returnBook()` is called, `this` is available to be borrowed
*/

/* PART 3.
----------
Define a constructor method for the Book class that initialises every instance variable.
*/

public class Book {

    // Add fields here

    // Define instance methods here

    // Define constructor method here

    void bookInfo() {
        System.out.printf("Title:\t%s\n", title);
        System.out.printf("Author:\t%s\n", author);
        System.out.printf("Year:\t%s\n", year);
        System.out.printf("ISBN:\t%s\n", isbn);
    }
}
