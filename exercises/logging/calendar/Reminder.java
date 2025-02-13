package calendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reminder extends Event {

    public Reminder(String title, LocalDateTime time) {
        // Create an event with a duration of 0 seconds and no attendees
        super(title, time, Duration.ofSeconds(0), List.of());
    }

    @Override
    public void removeAttendee(String name) throws AttendeeNotFoundException {
        throw new AttendeeNotFoundException(
            "Cannot remove attendees from a Reminder"
        );
    }

    @Override
    public void addAttendee(String attendee) throws InvalidAttendeeException {
        throw new InvalidAttendeeException(
            "Attendees cannot be added to a Reminder"
        );
    }

    @Override
    public String getEventType() {
        return Reminder.class.getName();
    }
}
