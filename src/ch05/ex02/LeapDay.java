package ch05.ex02;

import java.time.LocalDate;

/**
 * Check 29 Feb
 *
 * @author hodaka
 */
public class LeapDay {

    public static void main(String[] args) {
        LocalDate leapDay = LocalDate.of(2000, 2, 29);
        System.out.println("Leap Day                : " + leapDay);
        System.out.println("Plus one year           : " + leapDay.plusYears(1));
        System.out.println("Plus four years         : " + leapDay.plusYears(4));
        System.out.println("Plus one year four times: " + leapDay.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
    }
}
