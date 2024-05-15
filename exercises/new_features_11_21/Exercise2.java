import java.util.*;


// NEW FEATURES JAVA 11-21: Exercise 2
// -------------
// The code below uses four different methods to find the index of the largest
// element in four different types of ordered collection.

// Part 1.
// -------
// Update the code so that only one common method can be used for all of the
// collections.

// Part 2.
// -------
// Add a method `argmaxBack` that returns the number of spaces from the back of
// the collection to the largest element.
// You can test this by uncommenting the 4 lines at the end of the main method.
//
// Hint: This method can make use of the existing argmax function.


public class Exercise2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 3, 4, 1, 3, 7, 2, 2, 3, 7, 2, 1);
        System.out.println("The largest item in the List is at position: " + argmax(list));

        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);
        System.out.println("The largest item in the LinkedHashSet is at position: " + argmax(hashSet));

        SortedSet<Integer> sortedSet = new TreeSet<>(list);
        System.out.println("The largest item in the SortedSet is at position: " + argmax(sortedSet));

        Deque<Integer> deque = new ArrayDeque<>(list);
        System.out.println("The largest item in the Deque is at position: " + argmax(deque));

        // System.out.println("The largest item in the List is " + argmaxBack(list) + " from the back");
        // System.out.println("The largest item in the LinkedHashSet is " + argmaxBack(hashSet) + " from the back");
        // System.out.println("The largest item in the SortedSet is " + argmaxBack(sortedSet) + " from the back");
        // System.out.println("The largest item in the Deque is " + argmaxBack(deque) + " from the back");
    }

    public static Integer argmax(List<Integer> numbers) {
        Integer max = null;
        int maxIndex = -1;

        for (int i = 1; i < numbers.size(); i++) {
            if (max == null || numbers.get(i) > max) {
                max = numbers.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static Integer argmax(LinkedHashSet<Integer> numbers) {
        var iterator = numbers.iterator();
        Integer max = null;
        int maxIndex = -1;

        for (int i = 0; iterator.hasNext(); i++) {
            Integer number = iterator.next();
            if (max == null || number > max) {
                max = number;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static Integer argmax(SortedSet<Integer> numbers) {
        // The largest item in a sorted set is always the last one
        return numbers.size() - 1;
    }

    public static Integer argmax(Deque<Integer> numbers) {
        Integer max = null;
        int maxIndex = -1;
        int currentIndex = 0;

        for (Integer number : numbers) {
            if (max == null || number > max) {
                max = number;
                maxIndex = currentIndex;
            }
            currentIndex++;
        }

        return maxIndex;
    }
}
