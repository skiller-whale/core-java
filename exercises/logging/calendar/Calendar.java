package calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.UUID;

import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calendar {

    private List<Event> events;
    private final String uuid = UUID.randomUUID().toString().substring(0, 8);

    public Calendar(List<Event> events) {
        this.events = events;
    }

    public Calendar() {
        this(new ArrayList<>());
    }

    public String toString() {
        return "cal#" + this.uuid;
    }

    public void addEvent(Event event) {
        events.add(event);

        System.out.println(String.format("Adding %s to %s", event, this));
    }

    public void inviteToAllEvents(String attendee) {
        for (Event event : events) {
            try {
                event.addAttendee(attendee);
            } catch (InvalidAttendeeException e) {
                System.out.println(String.format("Could not invite %s to %s in %s", attendee, event, this));
            }
        }
    }

    public void removeFromAllEvents(String attendee) {
        for (Event event : events) {
            try {
                event.removeAttendee(attendee);
            } catch (AttendeeNotFoundException e) {
                System.out.println(String.format("Not removing %s from %s in %s, not in event.", attendee, event, this));
            }
        }
    }

    public void moveAllEvents(Duration delta) {
        for (Event event : events) {
            event.move(delta);

            System.out.println(String.format("Moving %s in %s by %s", event, this, delta));
        }
    }

    public Map<LocalDate, List<Event>> groupEventsByDay() {
        return events
            .stream()
            .sorted(Comparator.comparing(Event::getStart))
            .collect(
                Collectors.groupingBy(
                    event -> event.getStart().toLocalDate(),
                    TreeMap::new,
                    Collectors.toList()
                )
            );
    }
}
