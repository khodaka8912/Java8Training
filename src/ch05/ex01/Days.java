package ch05.ex01;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.IntStream;

/**
 * @author hodaka
 */
public class Days {

    /**
     * 指定した年のプログラマーの日を取得する。
     *
     * @param year 指定する年（西暦）
     * @return その年のプログラマーの日
     */
    static LocalDate programmersDay(int year) {
        return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
    }

    public static void main(String[] args) {
        System.out.println("Programmer's Days : ");
        IntStream.range(2000, 2017).forEach(i -> System.out.println(programmersDay(i)));
    }
}
