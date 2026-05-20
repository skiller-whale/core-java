import java.util.List;

class Main {
    static final List<String> LOG = List.of(
        "192.168.1.1",
        "10.0.0.2",
        "192.168.1.1",
        "172.16.0.3",
        "10.0.0.2",
        "10.0.0.4",
        "192.168.1.1",
        "172.16.0.3",
        "10.0.0.5",
        "192.168.1.1"
    );

    public static void main(String[] args) {
        var counter = new LogAnalyser(LOG);

        System.out.println(counter.countVisits());
    }
}
