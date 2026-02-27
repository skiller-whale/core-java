package com.skillerwhale;

import java.util.ArrayList;

public class TypesDemo {
    public static void main(String[] args) {
        var heights = new ArrayList<Integer>();

        heights.add(158);
        heights.add(167);
        heights.add(173);
        heights.add(182);
        heights.add(183);

        heights.add(183.1);
    }
}


// First, run this code and observe the error.

// Use this command:
//
//   cd intro
//   ./run_types_demo.sh

// You now have a choice of exercises from easier to harder:

// Level 1: Make the program run by changing the value on line 15 to make it an
//          Integer (whole number).

// Level 2: Make the program run by changing `ArrayList<Integer>` to
//          `ArrayList<Double>` and editing the values on lines 9-13.

// Level 3: Make the program run by _only_ changing line 7.

// If you choose to tackle more than one, be sure to revert to the original
// program between each exercise.
