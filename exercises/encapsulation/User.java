public class User {
    public int userId;
    public String name;
    public String email;

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    User(int userId, String name, String email) {
        this.userId = userId;
        this.email = email;

        validateName(name);
        this.name = name;

        logUserCreation();
    }

    public void logUserCreation() {
        System.out.println("User created.");
        logUserInfo();
    }

    public void logUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
