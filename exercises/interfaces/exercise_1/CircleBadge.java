public class CircleBadge {
    private String text;

    public CircleBadge(String text) {
        this.text = text;
    }

    public void printBadge() {
        System.out.println("=================");
        System.out.println("     _____       ");
        System.out.println("   /       \\     ");
        System.out.println("  /         \\     ");
        System.out.println("  " + text);
        System.out.println("  \\         /  ");
        System.out.println("   \\       /     ");
        System.out.println("     -----       ");
        System.out.println("=================");
    }
}