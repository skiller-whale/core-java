class Main {
    public static void main(String[] args) {
        int option = UserInterface.welcomeMessage();
        // This increments the static field in the 'Book' class
        Repository.books();
        if (option == 1) {
            UserInterface.borrowLib();
        }
        else if (option == 2) {
            UserInterface.returnLib();
        }
        else if (option == 3) {
            UserInterface.selectGenre();
        }
    }
}
