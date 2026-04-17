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
        if (balancePence < amountPence) {
            return false;
        }

        withdraw(amountPence);
        transferee.deposit(amountPence);
        return true;
    }
}
