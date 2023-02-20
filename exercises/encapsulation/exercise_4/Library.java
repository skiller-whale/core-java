public class Library {
    void customerLend(Book book) {
        if (!book.available) {
            System.out.printf("%s is not available to borrow.\n", book.title);
        }
        else {
            System.out.printf("Thank you for borrowing the following item:\n\n");
            book.display();
            System.out.printf("\nPlease return this book within 14 days.\n");
            book.lendBook();
        }
    }

    void customerReturn(Book book) {
        if (book.available) {
            System.out.printf("%s is not on loan.\n", book.title);
        }
        else {
            System.out.printf("Thank you for returning %s.\n", book.title);
            System.out.printf("We hope you continue to use this library.\n");
            book.returnBook();
        }
    }
}
