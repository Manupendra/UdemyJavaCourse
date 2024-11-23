package s10.Enum;

import java.util.Random;

public class EnumIntro {
    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay);

        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();

            System.out.printf("Name os %s, Ordinal Value = %d%n",
                    weekDay.name(), weekDay.ordinal());

            if (weekDay == DayOfTheWeek.FRI) {
                System.out.println("Found a Friday!!!");
            }
        }
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case WED -> System.out.println("Wednesday is Day" + weekDayInteger);
            case SAT -> System.out.println("Saturday is Day" + weekDayInteger);
        }
    }

    public static DayOfTheWeek getRandomDay() {

        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }
}
