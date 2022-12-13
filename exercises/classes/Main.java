/* Library */
class Main {
    public static void main(String[] args) {
        int option = UserInterface.libraryWelcome();
        if (option == 1) {
            UserInterface.borrowLib();
        } else if (option == 2) {
            UserInterface.returnLib();
        }
    }
}
