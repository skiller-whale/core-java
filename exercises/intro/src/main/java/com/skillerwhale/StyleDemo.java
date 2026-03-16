package com.skillerwhale;

import java.util.List;

public class StyleDemo {
  public static void main() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int total = 0;

    for (int i = 0; i < numbers.size(); i++) {
      total += numbers.get(i);
    }

    System.out.println("The total is: " + total);
  }
}

// First, run this code and observe the error.

// Use this command:
//
//   cd intro
//   ./run_style_demo.sh

// You now have a choice of exercises. They are ordered loosely from easier to
// harder. You can pick whichever you want in whatever order you like.

// You may need to research some of these. You are welcome to use AI to help.

// 1. Replace `System.out.println` with `IO.println`.

// 2. Use `var` everywhere it is legally allowed.

// 3. Remove the class declaration so that the file is just a main method.

// 4. Make the program compute the product of the list (multiplying all the
//    numbers together) rather than the sum.

// 5. Use `String.format` to format the final output.

// 6. Use a `for-each` loop instead of a `for` loop with an index.

// 7. Allow the user to add one additional number to the list.

// 8. Change the list of numbers to an array of numbers and update the rest of
//    the code to produce the same output.

// 9. Rewrite this program to use Java streams.

// 10. Make this program as short as possible while still summing the numbers
//     from 1 to 10 and printing the same message.
//
//     Our record is 70 characters. Can you beat it?

