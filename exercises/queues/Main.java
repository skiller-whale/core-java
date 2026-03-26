import java.util.Scanner;

class Main {
    static Notification[] notifications = new Notification[] {
        new Notification("📧  Email",           "You have 3 unread messages"),
        new Notification("📅  Calendar",        "Stand-up in 10 minutes"),
        new Notification("🐳  Skiller Whale",   "Your coaching session is ready!"),
        new Notification("☕  Coffee Tracker",   "You've had 4 coffees today..."),
        new Notification("📰  News",            "LinkedList wins Queue of Year")
    };

    static boolean processNotifications(int index) {
        if (index >= notifications.length) {
            System.out.println("\n✅ All notifications cleared!");
            return false;
        }

        System.out.println(notifications[index]);
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;

        System.out.println("🔔 You have " + notifications.length + " notifications.\n");


        while (processNotifications(index)) {
            System.out.print("\n\tPress 'Enter' to read next notification.");
            // for simplicity, we need any input regardless of what it is
            scanner.nextLine();
            index++;
        }

        scanner.close();
    }
}
