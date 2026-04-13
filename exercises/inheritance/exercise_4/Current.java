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
