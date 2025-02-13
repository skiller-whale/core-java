import calendar.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.io.IOException;

public class Exercise1 {

    public static void main(String[] args) throws IOException{
        Calendar calendar = new Calendar();

        calendar.addEvent(
            new Event(
                "Revise Logging",
                LocalDateTime.of(2020, 9, 19, 11, 0),
                Duration.ofMinutes(150),
                new ArrayList<>(List.of("George Eeliot"))
            )
        );

        calendar.addEvent(
            new Event(
                "Skiller Whale Session: Java Logging",
                LocalDateTime.of(2020, 9, 20, 15, 0),
                Duration.ofMinutes(60),
                new ArrayList<>(List.of("Salmon Rushdie"))
            )
        );

        calendar.addEvent(
            new Reminder(
                "Feed Sharkimedes",
                LocalDateTime.of(2020, 9, 20, 16, 15)
            )
        );

        calendar.addEvent(
            new AllDayEvent("Busy All Day", LocalDate.of(2020, 9, 22))
        );

        calendar.addEvent(
            new Meeting(
                "Important Discussions",
                LocalDateTime.of(2020, 9, 21, 17, 0),
                Duration.ofMinutes(45),
                "Surf Boardroom",
                new ArrayList<>(List.of("Sealion Dion"))
            )
        );


        calendar.removeFromAllEvents("Me"); // Calls removeAttendee on each Event
        calendar.inviteToAllEvents("Ernest Herringway"); // Calls addAttendee on each Event
        calendar.inviteToAllEvents("bot/audio_recording"); // Calls addAttendee on each Event

        // Uncomment to pretty-print the calendar.
        // new CalendarPrinter().print(calendar);
    }
}
