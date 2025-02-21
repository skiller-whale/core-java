package calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllDayEvent extends Event {

    private LocalDate date;

    public AllDayEvent(String title, LocalDate date, List<String> attendees) {
        super(title, date.atStartOfDay(), Duration.ofHours(24), attendees);
        this.date = date;
    }

    public AllDayEvent(String title, LocalDate date) {
        this(title, date, new ArrayList<>());
    }

    public LocalDate getDate() {
        return date;
    }

    // Override move to do nothing. AllDayEvents should always start at midnight
    @Override
    public void move(Duration delta) {}

    @Override
    public String getEventType() {
        return AllDayEvent.class.getName();
    }
}
