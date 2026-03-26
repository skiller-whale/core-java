public class Notification {
    String app;
    String message;

    Notification(String app, String message) {
        this.app = app;
        this.message = message;
    }

    @Override
    public String toString() {
        return "┌──────────────────────────────────┐\n"
             + "│  " + pad(app) +                 "│\n"
             + "│──────────────────────────────────│\n"
             + "│  " + pad(message) +             "│\n"
             + "└──────────────────────────────────┘";
    }

    private static String pad(String text) {
        if (text.length() > 32) return text.substring(0, 32);
        return text + " ".repeat(32 - text.length());
    }
}
