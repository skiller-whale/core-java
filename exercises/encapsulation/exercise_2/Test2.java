public class Test2 {
    public static void main(String[] args) {
        int scienceFiction = Book.getBooksOfGenre("Science-Fiction");
        int marineBiology = Book.getBooksOfGenre("Marine biology");
        int programming = Book.getBooksOfGenre("Programming");
        System.out.printf("The book repository contains:\n");
        System.out.printf("%s science fiction books\n", scienceFiction);
        System.out.printf("%s marine biology books\n", marineBiology);
        System.out.printf("%s programming books\n", programming);
    }
}
