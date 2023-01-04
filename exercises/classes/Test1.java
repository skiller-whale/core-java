public class Test1 {
    public static void main(String[] args) {
        Book test = new Book();
        test.title = "Test";
        test.author = "Test";
        test.year = 1900;
        test.isbn = 1900l;
        test.available = false;
        System.out.printf("'title' is of type String:\t%s\n",String.class.isInstance(test.title));
        System.out.printf("'author' is of type String:\t%s\n",String.class.isInstance(test.author));
        System.out.printf("'year' is of type int:\t\t%s\n",Integer.class.isInstance(test.year));
        System.out.printf("'isbn' is of type long:\t\t%s\n",Long.class.isInstance(test.isbn));
        System.out.printf("'available' is of type boolean:\t%s\n",Boolean.class.isInstance(test.available));
    }
}
