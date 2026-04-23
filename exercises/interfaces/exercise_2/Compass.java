class Compass {
    static final Compass NORTH = new Compass("North");
    static final Compass SOUTH = new Compass("South");
    static final Compass EAST = new Compass("East");
    static final Compass WEST = new Compass("West");

    private final String direction;
    private Compass(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }

    public Compass reverse() {
        return this;
    }
}
