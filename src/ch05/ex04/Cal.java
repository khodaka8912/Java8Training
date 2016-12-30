package ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

/**
 * @author hodaka
 */
public class Cal {


    private static void showCalender(int year, int month) {
        LocalDate first = LocalDate.of(year, month, 1);
        LocalDate nextMonth = first.with(TemporalAdjusters.firstDayOfNextMonth());
        for (int i = DayOfWeek.MONDAY.getValue(); i < first.getDayOfWeek().getValue(); i++) {
            System.out.print("   ");
        }
        for (LocalDate date = first; date.isBefore(nextMonth); date = date.plusDays(1)) {
            System.out.printf("%2d", date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
    }

    private static void showUsage() {
        System.out.println("usage : java Cal <month> <year>\n\tmonth\tan integer value of a month(1-12)\n\t" +
                "year\tan integer value of a year");
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            showUsage();
            return;
        }
        int month;
        int year;
        try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            showUsage();
            return;
        }
        if (month < 1 || month > 12) {
            System.out.println("Bad month value : " + month);
            return;
        } else if (year < Year.MIN_VALUE || year > Year.MAX_VALUE) {
            System.out.println("Bad year value : " + year);
            return;
        }
        showCalender(year, month);
    }

}
