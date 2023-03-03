import java.lang.reflect.*;
import java.util.*;

class Test {
    // Check that Account is a superclass of Savings and Current
    static boolean savings = Account.class.isAssignableFrom(Savings.class);
    static boolean current = Account.class.isAssignableFrom(Current.class);

    // Get the fields for each class
    static Field[] savingsFields = Savings.class.getDeclaredFields();
    static Field[] currentFields = Current.class.getDeclaredFields();
    static Field[] accountFields = Account.class.getDeclaredFields();

    public static void main(String[] args) {

        // Check that each field has the correct name and type
        assert (Arrays.stream(savingsFields).anyMatch(field
        -> field.getName().equals("interestRate") && field.getType().equals(double.class)))
        : "double interestRate should be in Savings";

        assert (Arrays.stream(currentFields).anyMatch(field
        -> field.getName().equals("debitCardNumber") && field.getType().equals(long.class)))
        : "long debitCardNumber should be in Current";

        assert (Arrays.stream(currentFields).anyMatch(field
        -> field.getName().equals("pin") && field.getType().equals(int.class)))
        : "int pin should be in Current";

        assert (Arrays.stream(accountFields).anyMatch(field
        -> field.getName().equals("accountNumber") && field.getType().equals(int.class)))
        : "int accountNumber should be in Account";

        assert (Arrays.stream(accountFields).anyMatch(field
        -> field.getName().equals("sortCode") && field.getType().equals(int.class)))
        : "int sortCode should be in Account";

        assert (Arrays.stream(accountFields).anyMatch(field
        -> field.getName().equals("balancePence") && field.getType().equals(int.class)))
        : "int balancePence should be in Account";

        if (savings && current) {
            System.out.printf("The accounts are structured as follows:\n\n");
            System.out.printf("\t   Account\t\n");
            System.out.printf("\t     / \\\n");
            System.out.printf("\t    /   \\\n");
            System.out.printf("\t   /     \\\n");
            System.out.printf("\t  /       \\\n");
            System.out.printf("\tSavings  Current\n");
        } else {
            System.out.printf("Account is not a superclass of Savings and Current");
        }
    }
}
