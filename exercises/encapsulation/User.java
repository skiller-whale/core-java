public class User {
    public int userId;
    public String firstName;
    public String lastName;
    public String email;

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    public User(int userId, String firstName, String lastName, String email) {
        validateName(firstName);
        validateName(lastName);
        this.firstName = firstName;
        this.lastName = lastName;

        this.userId = userId;
        this.email = email;

        logUserCreation();
    }

    public void logUserCreation() {
        System.out.println("User created.");
        logUserInfo();
    }

    public void logUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
    }
}
