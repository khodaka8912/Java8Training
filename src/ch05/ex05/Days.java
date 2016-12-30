package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author hodaka
 */
public class Days {

    private static final LocalDate MY_BIRTHDAY = LocalDate.of(1989, 12, 14);

    static long numOfSpentDays(LocalDate birthday) {
        return birthday.until(LocalDate.now(), ChronoUnit.DAYS);
    }

    public static void main(String[] args) {
        System.out.printf("The number of days I have spent is : %d days.", numOfSpentDays(MY_BIRTHDAY));
    }
}
