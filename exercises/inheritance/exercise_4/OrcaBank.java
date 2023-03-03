// ========================================== //
// INHERITANCE: EXERCISE 3                    //
// ========================================== //
/*
 * The following code implements the Account superclass and its subclasses, Current and Savings.
 *
 *  1. The Account class has an instance method `display`.
 *     - Override this method for Current and Savings.
 *     - For each subclass, the method should print any inherited fields, and any fields unique to the class.
 *
 *  2. In class OrcaBank, add a new `public static` method called `printCustomerInfo`.
 *     - This should take as input an array of `Account`s and `display` the information for each account.
 */

public class OrcaBank {
    // YOUR CODE GOES HERE
}

class Account {
    int accountNumber;
    int sortCode;
    int balancePence;

    Account(int accountNumber, int sortCode, int balancePence) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.balancePence = balancePence;
    }

    public void display() {
        System.out.printf("%s\nBalance:\t£%s\n", this.getClass(), (balancePence / 100d));
        System.out.printf("Account Number:\t%s\n", accountNumber);
        System.out.printf("Sort Code:\t%s\n", sortCode);
    }

    public void deposit(int amountPence) {
        balancePence += amountPence;
    }

    public void withdraw(int amountPence) {
        balancePence -= amountPence;
    }

    public boolean transfer(Account transferee, int amountPence) {
        if (balancePence >= amountPence) {
            withdraw(amountPence);
            transferee.deposit(amountPence);
            return true;
        }
        return false;
    }
}

class Current extends Account {
    long debitCardNumber;
    int pin;

    Current(int accountNumber, int sortCode, int balancePence, long debitCardNumber, int pin) {
        super(accountNumber, sortCode, balancePence);
        this.debitCardNumber = debitCardNumber;
        this.pin = pin;
    }

    // YOUR CODE GOES HERE: override the 'display' method
}

class Savings extends Account {
    double interestRate;

    Savings(int accountNumber, int sortCode, int balancePence, double interestRate) {
        super(accountNumber, sortCode, balancePence);
        this.interestRate = interestRate;
    }

    @Override
    public boolean transfer(Account transferee, int amountPence) {
        if (sortCode == transferee.sortCode) {
            super.transfer(transferee, amountPence);
        }
        return false;
    }

    public double calculateInterest() {
        double interestAmount = (balancePence / 100) * interestRate;
        return Math.ceil(interestAmount);
    }

    // YOUR CODE GOES HERE: override the 'display' method
}
