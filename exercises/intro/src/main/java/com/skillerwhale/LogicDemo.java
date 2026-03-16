package com.skillerwhale;

public class LogicDemo {
  public static void main(String[] args) {
    String pickedNumString = IO.readln("Guess my number: ");

    int pickedNum = Integer.parseInt(pickedNumString);

    IO.println("You guessed: " + pickedNum);
  }
}

// First, run this code to see it work.

// Use this command:
//
//   cd exercises/intro
//   ./run_logic_demo.sh

// You now have a choice of exercises from easier to harder:

// Level 1: Make this program print
//          "You guessed my number!" if the user guesses 42,
//          and "You guessed wrong!" otherwise.

// Level 2: Make the program print
//          "You guessed too low!" if the user guesses a number less than 42,
//          "You guessed too high!" if the user guesses a number greater than 42,
//          and "You guessed my number!" if the user guesses 42.

// Level 3: Implement Level 2, but allow the user to keep guessing until they
//          guess the number correctly.
//
//          You will need a `while` loop for this. It looks like this:
//
//          while (condition) {
//            // code to run while condition is true
//          }

// Level 4: Implement level 3, but give the user a maximum of 5 guesses.

// Level 5: Implement level 4, but also handle the situation where the user
//          enters a non-numeric value.
//
//          You will need to use a `try`/`catch` block for this. It looks like this:
//
//          try {
//            // code that might throw an exception
//          } catch (ExceptionType e) {
//            // code to run if an exception of type ExceptionType is thrown
//          }
