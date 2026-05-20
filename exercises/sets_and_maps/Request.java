import java.util.Objects;

class Request {
    final String ip;
    final String endpoint;

    Request(String ip, String endpoint) {
        this.ip = ip;
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return ip + " -> " + endpoint;
    }
}
