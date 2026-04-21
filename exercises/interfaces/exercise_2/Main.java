/* INTERFACES
 * ----------
 *
 * A compass direction is reversed if it is 'rotated' by 180 degrees.
 *  NORTH -> SOUTH
 *  SOUTH -> NORTH
 *  EAST -> WEST
 *  WEST -> EAST
 *
 * A coin is reversed if it is flipped to its opposite side.
 *  HEADS -> TAILS
 *  TAILS -> HEADS
 *
 * 1. Implement the `reverse` method for both the `Compass` and `Coin` classes.
 *     * You can uncomment the `assert` statements to check your implementation.
 * 2. Implement a 'Reversible' interface that's implemented in both Compass and Coin.
 * 3. [Extension] Implement `assertReversesTwice`.
 *     * It should take an object of type `Reversible` and assert that reversing twice returns the original object.
 *     * Call `assertReversesTwice` for each of the Compass and Coin constants.
 */
public class Main {
    // public static assertReversesTwice(...) {
    //     ...
    // }

    public static void main(String[] args) {
        System.out.printf(
            "The Compass constants are %s, %s, %s, and %s.\n",
            Compass.NORTH, Compass.SOUTH, Compass.EAST, Compass.WEST
        );
        System.out.printf(
            "The Coin constants are %s and %s.\n",
            Coin.HEADS, Coin.TAILS
        );

        // Part 1
        // assert (Compass.NORTH.reverse() == Compass.SOUTH) : "SOUTH should be the reverse of NORTH";
        // assert (Compass.SOUTH.reverse() == Compass.NORTH) : "NORTH should be the reverse of SOUTH";
        // assert (Compass.EAST.reverse() == Compass.WEST) : "WEST should be the reverse of EAST";
        // assert (Compass.WEST.reverse() == Compass.EAST) : "EAST should be the reverse of WEST";
        // assert (Coin.HEADS.reverse() == Coin.TAILS) : "TAILS should be the reverse of HEADS";
        // assert (Coin.TAILS.reverse() == Coin.HEADS) : "HEADS should be the reverse of TAILS";
    }
}
