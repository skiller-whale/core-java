public class Main {
    public static void main(String[] args) {
        assert (Compass.NORTH.reverse() == Compass.SOUTH) : "SOUTH should be the reverse of NORTH";
        assert (Compass.SOUTH.reverse() == Compass.NORTH) : "NORTH should be the reverse of SOUTH";
        assert (Compass.EAST.reverse() == Compass.WEST) : "WEST should be the reverse of EAST";
        assert (Compass.WEST.reverse() == Compass.EAST) : "EAST should be the reverse of WEST";
        System.out.printf("The Compass constants are %s, %s, %s, and %s.\n", Compass.NORTH.direction,
                Compass.SOUTH.direction, Compass.EAST.direction, Compass.WEST.direction);
        assert (Coin.HEADS.reverse() == Coin.TAILS) : "TAILS should be the reverse of HEADS";
        assert (Coin.TAILS.reverse() == Coin.HEADS) : "HEADS should be the reverse of TAILS";
        System.out.printf("The Coin constants are %s and %s.\n", Coin.HEADS.side, Coin.TAILS.side);
    }
}
