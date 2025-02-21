package calendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Meeting extends Event {

    private String location;

    public Meeting(
        String title,
        LocalDateTime start,
        Duration duration,
        String location,
        List<String> attendees
    ) {
        super(title, start, duration, attendees);
        this.location = location;
    }

    public Meeting(
        String title,
        LocalDateTime start,
        Duration duration,
        String location
    ) {
        this(title, start, duration, location, new ArrayList<String>());
    }

    @Override
    protected Map<String, String> additionalDisplayFields() {
        // Default implementation, can be overridden by subclasses
        return Map.of("Location", location);
    }

    @Override
    public String getEventType() {
        return Meeting.class.getName();
    }
}
