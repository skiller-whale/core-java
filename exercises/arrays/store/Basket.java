class Basket {
    public static float applyDiscount(Item item, float discount) {
        return (float) (item.price * (1 - discount));
    }
}
