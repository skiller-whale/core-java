public class Test2 {
    public static void main(String[] args) {
        Book test = new Book();
        test.available = true;
        test.returnBook();
        System.out.println(test.available); // true
        test.lendBook();
        System.out.println(test.available); // false
    }
}
