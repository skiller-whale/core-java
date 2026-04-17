class Savings extends Account {
    double interestRate;

    Savings(int accountNumber, int sortCode, int balancePence, double interestRate) {
        super(accountNumber, sortCode, balancePence);
        this.interestRate = interestRate;
    }

    @Override
    public boolean transfer(Account transferee, int amountPence) {
        if (sortCode != transferee.sortCode) {
            return false;
        }

        return super.transfer(transferee, amountPence);
    }

    public double calculateInterest() {
        double interestAmount = (balancePence / 100) * interestRate;
        return Math.ceil(interestAmount);
    }

    // YOUR CODE GOES HERE: override the 'display' method
}
