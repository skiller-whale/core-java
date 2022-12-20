// ======================================== //
// IF AND ELSE                              //
// ======================================== //
/*
 * If you run the code below, it should print an introductory rhyme, followed by:
 *
 *    A rhyme by Lewis Carroll.
 *    A rhyme about orcas.
 *
 * However, the code should print only one of these two rhymes, depending on whether printRhyme is given:
 *
 *    The prompt: "carroll".
 *    The prompt: "orca".
 *
 * Modify the 'if' statement in printRhyme, and add nested conditionals, so that:
 *
 *    1. The intro rhyme is printed only if either prompt is given to printRhyme.
 *    2. The Carroll rhyme is printed only if the prompt is "carroll".
 *    3. The Orca rhyme is printed only if the prompt is "orca".
 *    4. If the prompt is neither keyword, print "I can't rhyme without my prompt!".
 *
 * Run the application to test your code.
 */

class Rhymes {
  static String intro = "Here is a rhyme about some things aquatic\nOne is by Carroll\nYou might think both are erratic!\n\n";
  static String carroll = "Beneath the waters of the sea\nAre lobsters thick as thick can be\nThey love to dance with you and me\nMy own, my gentle Salmon!\n\n";
  static String orca = "Under the bustle of the ocean\nSwim orcas, constantly in motion\nThey are black and white, a magnificent sight\nIt really is quite a commotion!\n\n";

  static void printRhyme(String prompt) {
    // modify the code below
    if (true) {
      System.out.print(intro);   // Print the intro rhyme
      System.out.print(carroll); // Print the Carroll rhyme
      System.out.print(orca);    // Print the Orca rhyme
    }
  }

  public static void main(String[] args) {
    boolean likesOrcas = true;
    // change the code below for the Ternary Operator exercise
    printRhyme("orca");
  }
}





// ========================== //
// THE TERNARY OPERATOR       //
// ========================== //
/*
 * Change the call to printRhyme to use a ternary operator.
 * This should pass in the "orca" prompt or "carroll" prompt depending on the value of the boolean 'likesOrcas' variable.
 */
