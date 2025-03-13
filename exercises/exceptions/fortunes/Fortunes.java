package fortunes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Fortunes {
    private List<String> FORTUNES = new ArrayList<>();
    private List<String> DAY_NAMES = new ArrayList<>();

    public Fortunes(String fileName) throws IOException, ParseException {
        loadFortunes(fileName);
    }

    private void loadFortunes(String fileName) throws IOException, ParseException {
        FORTUNES = new ArrayList<String>();
        DAY_NAMES = new ArrayList<String>();
        int numFortunes = 0;
        String line = null;
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        line = in.readLine();
        while (line != null) {
            String[] parts = line.split(",");
            FORTUNES.add(parts[1]);
            DAY_NAMES.add(parts[0]);

            line = in.readLine();

            numFortunes ++;
            if (numFortunes >= 7) break;
        }

        in.close();

        if (numFortunes < 7) throw new ParseException("Not enough fortunes!", -1);
        if (line != null) throw new ParseException("Too many fortunes!", -1);
    }

    public String getFortune(LocalDate date) {
        if (date.getYear() < 1000) {
            throw new IllegalArgumentException("Millenium Bug! Fortunes only available after 1000AD");
        }
        int dayOfWeekIndex = date.getDayOfWeek().getValue() - 1;

        return String.format(
            "You were born on a %s, you %s.",
            DAY_NAMES.get(dayOfWeekIndex),
            FORTUNES.get(dayOfWeekIndex)
        );
    }
}
