public class Repository {
    public static Book[] books() {
        Book[] books = new Book[11];
        books[0] = new Book("2001: A Plaice Codyssey", "Arthur C. Karp", 1969, "Science-Fiction", 978_0_099_79800_2l, true);
        books[1] = new Book("The Fishpossessed", "Ursula K. Le Fin", 1974, "Science-Fiction", 978_1_857_98882_6l, true);
        books[2] = new Book("Children of Cod", "Mary Russell", 1998, "Science-Fiction", 978_0_449_00483_8l, true);
        books[3] = new Book("The Mote in Cod's Eye", "Jerry Pournelle and Larry Niven", 1974, "Science-Fiction", 978_0_860_07906_4l, true);
        books[4] = new Book("The Sharks My Destination", "Alfred Bester", 1956, "Science-Fiction", 978_1_857_98814_7l, true);
        books[5] = new Book("Old Clam's War", "John Scalzi", 2006, "Science-Fiction", 978_0_330_45216_8l, false);
        books[6] = new Book("The Sea Inside", "Philip Hoare", 2013, "Marine biology", 978_0_007_41211_2l, false);
        books[7] = new Book("Handbook of Whales, Dolphins and Porpoises", "Mark Carwardine", 2019, "Marine biology", 978_1_472_90814_8l, true);
        books[8] = new Book("Structure and Fin-terpretation of Computer Programs", "Harold Abelson and Gerald Jay Sussman", 1996, "Programming", 978_0_262_51087_5l, true);
        books[9] = new Book("Sea# in Depth", "John Skeet", 2019, "Programming", 978_1_617_29453_2l, false);
        books[10] = new Book("Algae-rithms", "Robert Sedgewick and Kevin Wayne", 2011, "Programming", 978_0_321_57351_3l, true);
        return books;
    }
}
