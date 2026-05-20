import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LogAnalyser {
    private final List<String> log;

    LogAnalyser(List<String> log) {
        this.log = log;
    }

    // ---------- //
    // EXERCISE 1 //
    // ---------- //
    int uniqueVisitorCount() {
        // TODO: return the number of distinct IP addresses in the log
        return 0;
    }

    Set<String> repeatVisitors() {
        // TODO: return a Set of IP addresses that appear more than once in the log
        // Hint: Set.add() returns false if the element was already present
        return new HashSet<>();
    }

    // ---------- //
    // EXERCISE 2 //
    // ---------- //
    Map<String, Integer> countVisits() {
        // TODO: return a Map from each IP address to the number of times it appears in the log
        return null;
    }

    // ---------- //
    // EXERCISE 3 //
    // ---------- //
    void printVisitCounts() {
        // TODO: print each IP address and its visit count in the format "ip: count"
    }

    String topVisitor() {
        // TODO: return the IP address with the highest visit count
        return null;
    }
}
