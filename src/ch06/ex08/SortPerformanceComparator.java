package ch06.ex08;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.nanoTime;

/**
 * @author hodaka
 */
public class SortPerformanceComparator {

    static final int NUM_OF_TRIAL = 10;
    static final int MAX_SIZE = 1 << 20;

    static int[] randomArray(int size, long seed) {
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    static long measureTime(Runnable task, int numOfTrial) {
        long sum = 0;
        for (int i = 0; i < numOfTrial; i++) {
            long start = nanoTime();
            task.run();
            sum += System.nanoTime() - start;
        }
        return sum / numOfTrial;
    }


    public static void main(String[] args) {
        for (int size = 2; size < MAX_SIZE; size = size << 1) {
            long seed = System.currentTimeMillis();
            int[] target1 = randomArray(size, seed);
            int[] target2 = randomArray(size, seed);
            long sequential = measureTime(() -> Arrays.sort(target1), NUM_OF_TRIAL);
            long parallel = measureTime(() -> Arrays.parallelSort(target2), NUM_OF_TRIAL);
            System.out.println("array size [" + size + "] : sequential="
                    + sequential + "[ns], parallel=" + parallel + "[ns]" +
                    (sequential > parallel ? " parallel won!" : ""));
        }
        System.out.println("end.");
    }

}
