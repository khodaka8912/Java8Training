package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hodaka
 */
public class Days {

    static List<LocalDate> allFridayThirteen(LocalDate start, LocalDate end) {
        List<LocalDate> fridayThirteens = new ArrayList<>();
        LocalDate firstThirteen = LocalDate.of(start.getYear(), start.getMonth(), 13);
        if (firstThirteen.isBefore(start)) {
            firstThirteen = firstThirteen.minusMonths(1);
        }
        for (LocalDate d = firstThirteen; d.isBefore(end); d = d.plusMonths(1)) {
            if (d.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThirteens.add(d);
            }
        }
        return fridayThirteens;
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1901, 1, 1);
        LocalDate end = start.plusYears(100);
        System.out.println("Friday Thirteens in 20th century are :");
        List<LocalDate> fridayThirteens = allFridayThirteen(start, end);
        fridayThirteens.forEach(d -> System.out.println(DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)").format(d)));
    }

}
