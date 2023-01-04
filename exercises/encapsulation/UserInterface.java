//==============================//
// Static Methods               //
//==============================//

import java.util.Scanner;
import java.util.Objects;

public class UserInterface {
    static Scanner input = new Scanner(System.in);
    static int select;
    static String choice;
    static String nameOfBook;
    static Library lib = new Library();

    // Library welcome message
    public static int welcomeMessage() {
        System.out.println("\nWelcome to the George Sea-body Library");
        System.out.println("======================================\n");
        System.out.printf("Please select an OPTION from those provided:\n\n");
        System.out.printf("Enter '1': BORROW an item\n");
        System.out.printf("Enter '2': RETURN an item\n");
        System.out.printf("Enter '3': DISPLAY genres\n");
        System.out.printf("Enter '4': Quit\n");
        select = input.nextInt();
        input.nextLine();
        return select;
    }

    // Interface for selecting a genre of book
    public static void selectGenre() {
        System.out.printf("Please SELECT a genre from those available:\n\n");
        System.out.printf("* Science-Fiction\n");
        System.out.printf("* Marine biology\n");
        System.out.printf("* Programming\n");
        System.out.printf("\nEnter your choice: ");
        choice = input.nextLine();
        System.out.println("");
        int count = Book.genre(choice);
        System.out.printf("There are %s %s books in the library\n", count, choice);
    }

    // Print the Library's repository
    public static void printSelection() {
        for (Book book : Repository.books()) {
            book.display();
        }
    }

    // Interface for borrowing books
    public static void borrowLib() {
        System.out.printf("Which book would you like to borrow?\n\n");
        printSelection();
        System.out.printf("\nEnter a book title: ");
        nameOfBook = input.nextLine();
        System.out.println("");
        for (Book book : Repository.books()) {
            if (Objects.equals(nameOfBook, book.title)) {
                lib.customerLend(book);
            }
        }
    }

    // Interface for returning books
    public static void returnLib() {
        System.out.printf("Which book would you like to return?\n\n");
        printSelection();
        System.out.printf("\nEnter a book title: ");
        nameOfBook = input.nextLine();
        System.out.println("");
        for (Book book : Repository.books()) {
            if (Objects.equals(nameOfBook, book.title)) {
                lib.customerReturn(book);
            }
        }
    }
}
