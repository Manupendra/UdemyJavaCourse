package s18.DateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate five5 = LocalDate.of(2005,5,5);
        System.out.println(five5);

        LocalDate may5 = LocalDate.of(2005, Month.MAY,5);
        System.out.println(may5);

        LocalDate May5 = LocalDate.parse("2005-05-05");
        System.out.println(May5);

        System.out.println(May5.get(ChronoField.YEAR));
        System.out.println(May5.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(May5.get(ChronoField.DAY_OF_MONTH));
        System.out.println(May5.get(ChronoField.DAY_OF_YEAR));

        // Comparison Methods

        System.out.println("May5 > today? "+May5.isAfter(today));
        System.out.println("May5 < today? "+May5.isBefore(today));

        System.out.println("May5 > today? "+May5.compareTo(today));
        System.out.println("May5 < today? "+today.compareTo(May5));

        System.out.println("today = now ? "+today.compareTo(LocalDate.now()));
        System.out.println("today = now ? "+today.equals(LocalDate.now()));

        System.out.println(today.isLeapYear());
        System.out.println(May5.minusYears(2).isLeapYear());
    }
}
