/* Science Fiction Book Repository */

// Do not edit this code
public class Repository {
    public static Book[] repositoryBooks() {
        Book[] books = new Book[6];
        books[0] = new Book("2001: A Plaice Codyssey", "Arthur C. Karp", 1969, 978_0_099_79800_2l, true);
        books[1] = new Book("The Fishpossessed", "Ursula K. Le Fin", 1974, 978_1_857_98882_6l, true);
        books[2] = new Book("Children of Cod", "Mary Russell", 1998, 978_0_449_00483_8l, true);
        books[3] = new Book("The Mote in Cod's Eye", "Jerry Pournelle and Larry Niven", 1974, 978_0_860_07906_4l, true);
        books[4] = new Book("The Sharks My Destination", "Alfred Bester", 1956, 978_1_857_98814_7l, true);
        books[5] = new Book("Old Clam's War", "John Scalzi", 2006, 978_0_330_45216_8l, false);
        return books;
    }
}
