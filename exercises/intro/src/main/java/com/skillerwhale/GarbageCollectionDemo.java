package com.skillerwhale;

import java.util.ArrayList;
import java.util.List;

// This program creates a lot of objects and then throws most of them away.
// The garbage collector will have to work hard to catch all of the objects
// we're throwing away so that the program doesn't run out of memory!

public class GarbageCollectionDemo {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        // Create a list of numbers
        List<Integer> numbers = new ArrayList<>();

        // Iterate up to 1 million
        for (int i = 0; i < 1_000_000; i++) {
            // For each number,

            // Add it to the end of our list
            numbers.add(i);

            // If the list grows to over 1,000 items, clear the list
            if (numbers.size() > 1_000) {
                numbers.clear();
            }

            // Every 10,000 items, display the number we're on
            // This is just so you can see it
            if (i % 10_000 == 0) {
                System.out.println(i);
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        IO.println("Duration: " + duration / 1_000_000 + " ms");
    }
}

// Exercises:

// 1. Run this code.
//
// Use this command:
//
//   cd intro
//   ./run_garbage_collection_demo.sh
//
// This runs the Java program in a special debugging mode that reports
// what the garbage collector is doing. We have also lowered the memory limits
// on the program to exaggerate the effect.
//
// Some of the lines look like this:
//
//   [0.383s][info][gc] GC(39) Pause Young 5M->3M(8M) 0.439ms
//
// Let's break this down:
//
//   [0.383s][info][gc] <-- Logging information
//   GC(39)             <-- Number of the garbage collection (goes up every time)
//   Pause Young        <-- Type of garbage collection
//   5M->3M(8M)         <-- Memory used before, memory used after, total memory available
//   0.439ms            <-- Time taken to do garbage collection

// 2. Calculate how much memory the garbage collector freed up.
//
// This example line above has `5M->3M` in it.
//
// This means the program went from using 5M of memory to using 3M of memory.
// So the garbage collector freed up 2M.
//
// Calculate the total memory freed up throughout the life of the program.
//
// You can do this manually or using whatever tools you have available.
//
// Enter your answer into the text box in the session window.

// 3. Calculate the percentage of the program's time spent on garbage collection.
//
// The program also reports the total time it took to run at the end.
//
// Add up all of the time taken by each garbage collection pause.
//
// Work out the percentage of the program's total time it spent on garbage
// collection.
//
// Enter your answer into the text box in the session window.


