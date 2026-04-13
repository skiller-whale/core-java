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
