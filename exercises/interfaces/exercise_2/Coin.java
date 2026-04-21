class Coin {
    static final Coin HEADS = new Coin("Heads");
    static final Coin TAILS = new Coin("Tails");

    private final String side;
    private Coin(String side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return side;
    }

    public Coin reverse() {
        return this;
    }
}
