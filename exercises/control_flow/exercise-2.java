// ======================================== //
// IF AND ELSE                              //
// ======================================== //
/*
 * If you run the code below, it should print an introductory rhyme, and then two other rhymes.
 *
 * We would like the code to print only one of the other two rhymes, depending which rhyming key it is given.
 *
 * Improve the 'if' statement, and add nested conditionals, so that:
 *
 *    1. The intro rhyme is printed only if the rhymingKey is set to either keyword.
 *    2. The Carroll rhyme is printed only if the ryhmingKey is set to the first keyword.
 *    3. The Orca rhyme is printed only if the rhymingKey is set to the second keyword.
 *    4. If the key is not set to either keyword, the output should print "I can't rhyme without my key!".
 */

class Rhyme {
    public static void main(String[] args) {
        var intro = new Rhymes("intro");
        var carroll = new Rhymes("carroll");
        var orca = new Rhymes("orca");
        // Ignore the code above
        String keyword1 = "sea";
        String keyword2 = "ocean";
        String rhymingKey;
        // Modify the code below
        if (true) {
            intro.rhyme();   // Print the intro rhyme
            carroll.rhyme(); // Print the Carroll rhyme
            orca.rhyme();    // Print the Orca rhyme
          }
    }
}

/*
 * Set the rhymingKey to one of the keywords.
 *
 * Run the file to check that only the intro and the ryhme corresponding to the keyword are printed.
 */






// ========================== //
// THE TERNARY OPERATOR       //
// ========================== //
/*
 * Re-factor the rhyming code so that the value assigned to rhymingKey depends on
 * the boolean value of a separate likesOrcas variable.
 */









// ------------------------------------------------------ //
// Do not edit the code here
// ------------------------------------------------------ //

record Rhymes (String name) {
    void rhyme() {
      if (name == "intro") {
        System.out.println("Here is a rhyme about some things aquatic");
        System.out.println("One is by Carroll");
        System.out.println("You might think both are erratic!");
        System.out.println("");
      } else if (name == "carroll") {
        System.out.println("Beneath the waters of the sea");
        System.out.println("Are lobsters thick as thick can be");
        System.out.println("They love to dance with you and me");
        System.out.println("My own, my gentle Salmon!");
    } else if (name == "orca") {
        System.out.println("Under the bustle of the ocean");
        System.out.println("Swim orcas, constantly in motion");
        System.out.println("They are black and white, a magnificent sight");
        System.out.println("It really is quite a commotion!");
    }
  }
}

