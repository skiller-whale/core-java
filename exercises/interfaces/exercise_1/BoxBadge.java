public class BoxBadge {
    private String text;

    public BoxBadge(String text) {
        this.text = text;
    }

    public void printBadge() {
        System.out.println("=================");
        System.out.println("   ______     ");
        System.out.println("  /     /\\    ");
        System.out.println(" " + text);
        System.out.println("/-----/    \\  ");
        System.out.println("\\     \\    /  ");
        System.out.println(" \\     \\  /   ");
        System.out.println("  \\_____\\/    ");
        System.out.println("=================");
    }
}
