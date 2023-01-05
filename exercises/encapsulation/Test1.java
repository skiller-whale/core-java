public class Test1 {
    public static void main(String[] args) {
        Book test1 = new Book(null, null, 0, null, 0l, false);
        Book test2 = new Book(null, null, 0, null, 0l, false);
        Book test3 = new Book(null, null, 0, null, 0l, false);
        Book test4 = new Book(null, null, 0, null, 0l, false);
        System.out.printf("A total of %s books have been created\n", Book.collection);
    }
}
