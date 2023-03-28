/* INTERFACES
 * ----------
 *
 * A compass direction is reversed if it is 'rotated' by 180 degrees.
 *
 * A coin is reversed if it is flipped to its opposite side.
 *
 * Implement a 'Reversible' interface with a method template called 'reverse'. Extend the `Compass`
 * and `Coin` classes so that each implements this interface.
 */

class Coin {
    static final Coin HEADS = new Coin("Heads");
    static final Coin TAILS = new Coin("Tails");

    String side;

    Coin(String side) {
        this.side = side;
    }
}

class Compass {
    static final Compass NORTH = new Compass("North");
    static final Compass SOUTH = new Compass("South");
    static final Compass EAST = new Compass("East");
    static final Compass WEST = new Compass("West");

    String direction;

    Compass(String direction) {
        this.direction = direction;
    }
}
