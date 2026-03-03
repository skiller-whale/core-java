// ======================================== //
// CHATBOT
// ======================================== //
/*
 * Use if/else statements to handle the following user inputs:
 *
 *    - "hi" or "hello" -> respond with "hello"
 *    - "best whale?" -> respond with "skiller whale"
 *    - "bye" or "goodbye" -> respond with "bye"
 *
 * For any other input, just print it out as is.
 *
 * Run the application to test your code with different inputs.
 */

import java.util.Scanner;

class ChatBot {
    public static void main(String[] args) {
        // ===== DO NOT EDIT THE CODE BELOW =====
        Scanner scanner = new Scanner(System.in);
        System.out.print("type your message >>> ");
        String input = scanner.nextLine();
        // ===== DO NOT EDIT THE CODE ABOVE =====

        // TODO: Add if/else statements to handle the special cases
        System.out.println(input);
    }
}
