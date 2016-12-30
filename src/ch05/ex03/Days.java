package ch05.ex03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * @author hodaka
 */
public class Days {

    public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(d -> {
            LocalDate next = d.plusDays(1);
            while (predicate.test(next)) {
                next = next.plusDays(1);
            }
            return next;
        });
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today is      : " + today);
        LocalDate nextFriday = today.with(next(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY));
        System.out.println("Next friday is: " + nextFriday);
    }
}
