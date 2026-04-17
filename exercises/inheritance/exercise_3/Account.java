class Account {
    int accountNumber;
    int sortCode;
    int balancePence;

    Account(int accountNumber, int sortCode, int balancePence) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.balancePence = balancePence;
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
