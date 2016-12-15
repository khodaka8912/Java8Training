package ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author hodaka
 */
public class Lists {

    static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
        List<U> mappedList = new ArrayList<>();
        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }
        return mappedList;
    }
}
