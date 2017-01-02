package ch06.ex02;

import java.util.concurrent.atomic.LongAdder;

/**
 * ID列の生成のためには毎回合計値を計算する必要があり、LongAdderの恩恵は受けられない。
 * また、インクリメントと取得をAtomicに行えないため、別途同期が必要となる。
 * このようなパターンでは、LongAdderは役に立たない。
 *
 * @author hodaka
 */
public class IdAdder {

    private static final LongAdder id = new LongAdder();

    static long newId() {
        long newId;
        synchronized (id) {
            id.increment();
            newId = id.longValue();
        }
        return newId;
    }
}
