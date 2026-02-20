// ========================== //
// Division Calculator        //
// ========================== //

// Write code that divides numbers.
//
// The program should:
//  - if the user inputs `1`, terminate
//  - if the user inputs `0`, this should be skipped
//

import java.util.Scanner;

class DivisionCalculator {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        // TODO: modify the code below to implement a division calculator
        while (true) {
            System.out.print("Enter a number: ");
            float number = scanner.nextFloat();
            System.out.println(number);
        }
    }
}
