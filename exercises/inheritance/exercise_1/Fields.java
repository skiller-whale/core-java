// ========================================== //
// INHERITANCE: EXERCISE 1                    //
// ========================================== //
/*
 * The following code defines two kinds of bank account that a client might use.
 *
 *      Savings: accrues an amount of interest based on an interest rate
 *
 *      Current: for everyday use, has an associated debit card number and pin
 *
 * Define an 'Account' superclass from which Savings and Current will inherit.
 *
 * The superclass should eliminate any duplicated code.
 */

class Current {
    int accountNumber;
    int sortCode;
    int balancePence;
    long debitCardNumber;
    int pin;
}

class Savings {
    int accountNumber;
    int sortCode;
    double interestRate;
    int balancePence;
}
