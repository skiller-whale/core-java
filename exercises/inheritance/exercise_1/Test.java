class Test {
    public static void main(String[] args) {
    boolean savings = Account.class.isAssignableFrom(Savings.class);
    boolean current = Account.class.isAssignableFrom(Current.class);
    if (savings && current) {
        System.out.printf("The accounts are structured as follows:\n\n");
        System.out.printf("\t   Account\t\n");
        System.out.printf("\t     / \\\n");
        System.out.printf("\t    /   \\\n");
        System.out.printf("\t   /     \\\n");
        System.out.printf("\t  /       \\\n");
        System.out.printf("\tSavings  Current\n");
    }
    else {
        System.out.printf("Account is not a superclass of Savings and Current");
    }
  }
}
