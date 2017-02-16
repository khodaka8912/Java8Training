package ch08.ex09;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author hodaka
 */
public class ScannerStream {

    static Stream<String> lines(Scanner in) {
        Iterator<String> iterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return in.hasNextLine();
            }

            @Override
            public String next() {
                return in.nextLine();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iterator, Spliterator.ORDERED | Spliterator.NONNULL), false);

    }

    static Stream<String> words(Scanner in) {
        Iterator<String> iterator = new Iterator<String>() {
            final Pattern pattern = Pattern.compile("[^\\P{L}]+");

            @Override
            public boolean hasNext() {
                return in.hasNext(pattern);
            }

            @Override
            public String next() {
                return in.next(pattern);
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iterator, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    static IntStream intValues(Scanner in) {
        PrimitiveIterator.OfInt iterator = new PrimitiveIterator.OfInt() {
            @Override
            public boolean hasNext() {
                return in.hasNextInt();
            }

            @Override
            public int nextInt() {
                return in.nextInt();
            }
        };
        return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
                iterator, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }


    static DoubleStream doubleValues(Scanner in) {
        PrimitiveIterator.OfDouble iterator = new PrimitiveIterator.OfDouble() {
            @Override
            public boolean hasNext() {
                return in.hasNextDouble();
            }

            @Override
            public double nextDouble() {
                return in.nextDouble();
            }
        };
        return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(
                iterator, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
}
