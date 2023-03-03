// ========================================== //
// INHERITANCE: EXERCISE 2                    //
// ========================================== //
/*
 * Implement constructors for the Account, Savings, and Current classes.
 */

class Account {
    int accountNumber;
    int sortCode;
    int balancePence;
}

class Current extends Account {
    long debitCardNumber;
    int pin;
}

class Savings extends Account {
    double interestRate;
}
