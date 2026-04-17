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
        if (balancePence < amountPence || sortCode != transferee.sortCode) {
            return false;
        }

        withdraw(amountPence);
        transferee.deposit(amountPence);
        return true;
    }

    public double calculateInterest() {
        double interestAmount = (balancePence / 100) * interestRate;
        return Math.ceil(interestAmount);
    }
}
