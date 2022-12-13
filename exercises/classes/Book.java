// =================== //
// Fields and Methods  //
// =================== //

/* PART 1.
----------
Add the following fields to the Book class.
These should be of type String, int, long, or boolean.
  * `title`
  * `author`
  * `year`
  * `isbn` (a 13-digit number)
  * `available` (to determine whether a book is on loan or not)
*/

/* PART 2.
----------
Define two methods, lendBook and returnBook, to implement the following functionality:
If a book is lent to a library user, it is no longer available to be borrowed.
If a book is returned to the library, it is available to be borrowed.
*/

/* PART 3.
----------
Define a constructor method for the Book class.
The method should set every instance variable.
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
