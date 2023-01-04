public class Test3 {
    public static void main(String[] args) {
        Book test = new Book();
        Library lib = new Library();
        test.available = false;
        lib.customerReturn(test);
        System.out.printf("\n%s\n\n",test.available); // true
        lib.customerLend(test);
        System.out.printf("\n%s\n\n",test.available); // false
    }
}
