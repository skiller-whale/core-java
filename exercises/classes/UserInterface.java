/* User Interface for the Library's Book System */

import java.util.Scanner;
import java.util.Objects;

// Do not edit this code
public class UserInterface {
    static Scanner input = new Scanner(System.in);
    static int select;
    static String nameOfBook;
    static Library lib = new Library();

    // Library welcome message
    public static int libraryWelcome() {
        System.out.println("\nWelcome to the George Sea-body Library");
        System.out.println("======================================\n");
        System.out.printf("Would you like to BORROW or RETURN an item?\n\n");
        System.out.printf("Enter '1': BORROW an item\n");
        System.out.printf("Enter '2': RETURN an item\n");
        System.out.printf("Enter '3': Quit\n");
        select = input.nextInt();
        input.nextLine();
        return select;
    }

    // Browse the repository
    public static void printSelection() {
        for (Book book : Repository.repositoryBooks()) {
            System.out.printf("* %s, by %s\n",book.title, book.author);
        }
    }

    // Interface for borrowing books
    public static void borrowLib() {
        System.out.printf("Which book would you like to borrow?\n\n");
        UserInterface.printSelection();
        System.out.printf("\nEnter a book title: ");
        nameOfBook = input.nextLine();
        System.out.println("");
        for (Book book : Repository.repositoryBooks()) {
            if (Objects.equals(nameOfBook, book.title)) {
                lib.customerLend(book);
            }
        }
    }

    // Interface for returning books
    public static void returnLib() {
        System.out.printf("Which book would you like to return?\n\n");
        UserInterface.printSelection();
        System.out.printf("\nEnter a book title: ");
        nameOfBook = input.nextLine();
        System.out.println("");
        for (Book book : Repository.repositoryBooks()) {
            if (Objects.equals(nameOfBook, book.title)) {
                lib.customerReturn(book);
            }
        }
    }
}
