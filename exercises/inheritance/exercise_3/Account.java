// ========================================== //
// INHERITANCE: EXERCISE 3                    //
// ========================================== //
/*
 * The Savings and Current classes have been updated to contain a few methods.
 *
 * Currently, the Account superclass does not implement any methods for its
 * subclasses, so there is some code duplication across each subclass.
 *
 *  1. Define a `transfer` method in Account that has the common functionality
 *     between the existing 'transfer' methods. Update the subclasses accordingly.
 *
 *     HINT: In Savings you can call `super`.
 *
 *  2. Refactor the code so that the 'deposit' and 'withdrawal' methods are
 *     not duplicated between Savings and Current.
 */

 class Account {
    int accountNumber;
    int sortCode;
    int balancePence;

    Account(int accountNumber, int sortCode, int balancePence) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.balancePence = balancePence;
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

class Savings extends Account {
    double interestRate;

    Savings(int accountNumber, int sortCode, int balancePence, double interestRate) {
        super(accountNumber, sortCode, balancePence);
        this.interestRate = interestRate;
    }

    public void deposit(int amountPence) {
        balancePence += amountPence;
    }

    public void withdraw(int amountPence) {
        balancePence -= amountPence;
    }

    // Savings account can transfer only to accounts with the same sort code
    public boolean transfer(Account transferee, int amountPence) {
        if (balancePence >= amountPence && sortCode == transferee.sortCode) {
            withdraw(amountPence);
            transferee.deposit(amountPence);
            return true;
        }
        return false;
    }

    public double calculateInterest() {
        double interestAmount = (balancePence / 100) * interestRate;
        return Math.ceil(interestAmount);
    }
}
