public class Test3 {
    public static void main(String[] args) {
        Book test = new Book("2001: A Plaice Codyssey", "Arthur C. Karp", 1969, "Science-Fiction", 978_0_099_79800_2l, true);
        test.display();
        System.out.println("\nAttempt to assign '2080' as the publication year:");
        test.setYearPublished(2080);
        test.display();
        System.out.println("\nAttempt to assign '1968' as the publication year:");
        test.setYearPublished(1968);
        test.display();
    }
}
