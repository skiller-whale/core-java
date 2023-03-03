public class Test {
    public static void main(String[] args) {
        // Account class and two subclasses
        Account sealionDion = new Account(0, 0, 0);
        Current sealionCurrent = new Current(23984753, 397646, 4893407, 1098234823048723l, 3481);
        Savings sealionSavings = new Savings(23984754, 397646, 846139183, 0.41d);
        // Print output for the exercise
        System.out.println("OrcaBank: Giving Your Money Porpoise");
        System.out.println("************************************");
        System.out.printf("%s: SeaLion Dion\n", sealionDion.getClass());
        System.out.println("------------------------------------");
        System.out.printf("Current Account -- Balance: £%s\n", (sealionCurrent.balancePence / 100d));
        System.out.printf("Account Number:\t%s\n", sealionCurrent.accountNumber);
        System.out.printf("Sort Code:\t%s\n", sealionCurrent.sortCode);
        System.out.printf("Debit Card:\t%s\n", sealionCurrent.debitCardNumber);
        System.out.printf("PIN:\t\t%s\n\n", sealionCurrent.pin);
        System.out.printf("Savings Account -- Balance: £%s\n", (sealionSavings.balancePence / 100d));
        System.out.printf("Account Number:\t%s\n", sealionSavings.accountNumber);
        System.out.printf("Sort Code:\t%s\n", sealionSavings.sortCode);
        System.out.printf("Interest:\t£%s\n", (sealionSavings.calculateInterest() / 100d));
    }
}
