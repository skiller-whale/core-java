class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        // Check that Account has a ternary constructor
        Class<?> account = Class.forName("Account");
        account.getDeclaredConstructor(int.class, int.class, int.class);

        // Check that Savings has a quaternary constructor
        Class<?> savings = Class.forName("Savings");
        savings.getDeclaredConstructor(int.class, int.class, int.class, double.class);

        // Check that Current has a quinary constructor
        Class<?> current = Class.forName("Current");
        current.getDeclaredConstructor(int.class, int.class, int.class, long.class, int.class);

        System.out.printf("The constructor chains are structured as follows:\n\n");
        System.out.printf("\tjava.lang.Object()\t\n");
        System.out.printf("\t   |\n");
        System.out.printf("\t   |\n");
        System.out.printf("\t   |\n");
        System.out.printf("\t   |\n");
        System.out.printf("\tAccount(int accountNumber, int sortCode, int balancePence) { ... }\t\n");
        System.out.printf("\t   |\n");
        System.out.printf("\t   |-----------------------+\n");
        System.out.printf("\t   |  \t\t\t   |\n");
        System.out.printf("\t   |  \t\t\t   |\n");
        System.out.printf("\tSavings(...) { ... }");
        System.out.printf("\tCurrent(...) { ... }\n");
    }
}
