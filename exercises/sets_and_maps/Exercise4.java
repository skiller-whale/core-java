import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        // Create a list of requests with IP addresses and endpoints
        var requests = List.of(
            new Request("192.168.1.1", "/home"),
            new Request("10.0.0.2",    "/api/users"),
            new Request("192.168.1.1", "/home"),       // duplicate
            new Request("172.16.0.3",  "/api/orders"),
            new Request("10.0.0.2",    "/api/users"),  // duplicate
            new Request("192.168.1.1", "/about"),      // different endpoint — not a duplicate
            new Request("10.0.0.2",    "/api/users"),  // duplicate
            new Request("192.168.1.1", "/home")        // duplicate
        );

        // Convert the list to a Set to find unique requests
        Set<Request> uniqueRequests = new HashSet<>(requests);

        // Print out the number of unique requests
        System.out.println("Unique requests: " + uniqueRequests.size());
    }
}
