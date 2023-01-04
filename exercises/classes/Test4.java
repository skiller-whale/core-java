public class Test4 {
    public static void main(String[] args) {
        Book test = new Book("Test","Test",1900,1900l,false);
        System.out.printf("'title' is of type String:\t%s\n",String.class.isInstance(test.title));
        System.out.printf("'author' is of type String:\t%s\n",String.class.isInstance(test.author));
        System.out.printf("'year' is of type int:\t\t%s\n",Integer.class.isInstance(test.year));
        System.out.printf("'isbn' is of type long:\t\t%s\n",Long.class.isInstance(test.isbn));
        System.out.printf("'available' is of type boolean:\t%s\n",Boolean.class.isInstance(test.available));
    }
}
