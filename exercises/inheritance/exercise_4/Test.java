public class Test {
    public static void main(String[] args) {
        Account[] sealionDion = new Account[2];
        Account[] dolphinLundgren = new Account[2];
        sealionDion[0] = new Current(23984753, 397646, 4893407, 1098234823048723l, 3481);
        sealionDion[1] = new Savings(23984754, 397646, 846139183, 0.41d);
        dolphinLundgren[0] = new Current(73489597, 209384, 2093818, 2390847502938751l, 2397);
        dolphinLundgren[1] = new Savings(73489598, 209384, 419871441, 0.41d);
        System.out.printf("SeaLion Dion\n");
        System.out.println("-----------------");
        OrcaBank.printCustomerInfo(sealionDion);
        System.out.printf("\n-----------------\n\n");
        System.out.printf("Dolphin Lundgren\n");
        System.out.println("-----------------");
        OrcaBank.printCustomerInfo(dolphinLundgren);
        System.out.printf("\n-----------------\n\n");
    }
}
