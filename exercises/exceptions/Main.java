import fortunes.Fortunes;
import fortunes.MilleniumBugException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Number inputNumber(String prompt) {
        System.out.print(prompt + " ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static LocalDate askForBirthday() {
        int year = inputNumber("In what year were you born?").intValue();
        int month = inputNumber("In what month were you born?").intValue();
        int day = inputNumber("On what day of the month were you born?").intValue();
        return LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {
        // Fortunes fortunes = new Fortunes("fortunes.txt");
        // LocalDate birthday = askForBirthday();
        // String fortune = fortunes.getFortune(birthday);
        // System.out.println(fortune);
    }
}
