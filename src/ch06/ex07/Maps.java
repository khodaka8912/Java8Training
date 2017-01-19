package ch06.ex07;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hodaka
 */
public class Maps {

    static final long PARALLELISM_THRESHOLD = 5;

    static <K, V extends Comparable<? super V>> K keyOfMaxValue(ConcurrentHashMap<K, V> map) {
        return map.reduceEntries(PARALLELISM_THRESHOLD,
                (e1, e2) -> e1.getValue().compareTo(e2.getValue()) > 0 ? e1 : e2).getKey();
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.put("one", 1L);
        map.put("two", 2L);
        map.put("thousand", 1000L);
        map.put("minus", -1L);
        map.put("zero", 0L);
        map.put("ten", 10L);
        System.out.println("The key of max value is: " + keyOfMaxValue(map));
    }
}
