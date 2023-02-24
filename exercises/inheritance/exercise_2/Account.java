// ========================================== //
// INHERITANCE: EXERCISE 2                    //
// ========================================== //
/*
 * The Savings and Current classes have been updated to contain several
 * methods for (e.g.) modifying an account's balance and making transfers
 * between different accounts.
 *
 * Currently, the Account superclass only implements a set of fields for
 * its subclasses to inherit.
 *
 *  1. Define a `transfer` method in Account that has the common functionality
 *     between the existing 'transfer' and 'transferTo...' methods.
 *
 *     HINT: In Savings you can call `super`.
 *
 *  2. Implement appropriate constructors for each class.
 */

 class Account {
    int accountNumber;
    int sortCode;
    int balancePence;
}

class Current extends Account {
    long debitCardNumber;
    int pin;

    Current(int accountNumber, int sortCode, int balancePence, long debitCardNumber, int pin) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.balancePence = balancePence;
        this.debitCardNumber = debitCardNumber;
        this.pin = pin;
    }

    public void deposit(int amountPence) {
        balancePence += amountPence;
    }

    public void withdraw(int amountPence) {
        balancePence -= amountPence;
    }

    // Current account can make external transfers
    public boolean transferToCurrent(Current transferee, int amountPence) {
        if (balancePence >= amountPence) {
            withdraw(amountPence);
            transferee.deposit(amountPence);
            return true;
        }
        return false;
    }

    // Transfer to another savings account
    public boolean transferToSavings(Savings transferee, int amountPence) {
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
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.balancePence = balancePence;
        this.interestRate = interestRate;
    }

    public void deposit(int amountPence) {
        balancePence += amountPence;
    }

    public void withdraw(int amountPence) {
        balancePence -= amountPence;
    }

    // Savings account cannot transfer to other clients' accounts
    public boolean transfer(Current transferee, int amountPence) {
        // A client's bank accounts will implement the same sort code
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
