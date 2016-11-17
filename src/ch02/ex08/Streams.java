package ch02.ex08;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * @author hodaka
 */
public class Streams {

    private Streams() {
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return new ZipStream<T>(first, second);
    }


    private static class ZipStream<T> implements Stream<T> {

        private Stream<T> first;
        private Stream<T> second;

        public ZipStream(Stream<T> first, Stream<T> second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public Stream<T> filter(Predicate<? super T> predicate) {
            return new ZipStream<T>(first.filter(predicate), second.filter(predicate));
        }

        @Override
        public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
            return new ZipStream<R>(first.map(mapper), second.map(mapper));
        }

        @Override
        public IntStream mapToInt(ToIntFunction<? super T> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public LongStream mapToLong(ToLongFunction<? super T> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
            return new ZipStream<R>(first.flatMap(mapper), second.flatMap(mapper));
        }

        @Override
        public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Stream<T> distinct() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Stream<T> sorted() {
            return new ZipStream<T>(first.sorted(), second.sorted());
        }

        @Override
        public Stream<T> sorted(Comparator<? super T> comparator) {
            return new ZipStream<T>(first.sorted(comparator), second.sorted(comparator));
        }

        @Override
        public Stream<T> peek(Consumer<? super T> action) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Stream<T> limit(long maxSize) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Stream<T> skip(long n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEach(Consumer<? super T> action) {
            forEachOrdered(action);
        }

        @Override
        public void forEachOrdered(Consumer<? super T> action) {
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                action.accept(it.next());
            }
        }

        @Override
        public Object[] toArray() {
            List<T> list = new ArrayList<T>();
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                list.add(it.next());
            }
            return list.toArray();
        }

        @Override
        public <A> A[] toArray(IntFunction<A[]> generator) {
            List<T> list = new ArrayList<T>();
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                list.add(it.next());
            }
            return list.toArray(generator.apply(list.size()));
        }

        @Override
        public T reduce(T identity, BinaryOperator<T> accumulator) {
            Iterator<T> it = iterator();
            T result = identity;
            while (it.hasNext()) {
                result = accumulator.apply(result, it.next());
            }
            return result;
        }

        @Override
        public Optional<T> reduce(BinaryOperator<T> accumulator) {
            Iterator<T> it = iterator();
            if (!it.hasNext()) {
                return Optional.empty();
            }
            T result = it.next();
            while (it.hasNext()) {
                result = accumulator.apply(result, it.next());
            }
            return Optional.of(result);
        }

        @Override
        public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
            U result = identity;
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                result = accumulator.apply(result, it.next());
            }
            return result;
        }

        @Override
        public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
            R r = supplier.get();
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                accumulator.accept(r, it.next());
            }
            return r;
        }

        @Override
        public <R, A> R collect(Collector<? super T, A, R> collector) {
            A a = collector.supplier().get();
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                collector.accumulator().accept(a, it.next());
            }
            return collector.finisher().apply(a);
        }

        @Override
        public Optional<T> min(Comparator<? super T> comparator) {
            Iterator<T> it = iterator();
            if (!it.hasNext()) {
                return Optional.empty();
            }
            T min = it.next();
            while (it.hasNext()) {
                T next = it.next();
                if (comparator.compare(min, next) < 0) {
                    min = next;
                }
            }
            return Optional.of(min);
        }

        @Override
        public Optional<T> max(Comparator<? super T> comparator) {
            return null;
        }

        @Override
        public long count() {
            Iterator<T> it = iterator();
            int count = 0;
            while (it.hasNext()) {
                it.next();
                count++;
            }
            return count;
        }

        @Override
        public boolean anyMatch(Predicate<? super T> predicate) {
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean allMatch(Predicate<? super T> predicate) {
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                if (!predicate.test(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean noneMatch(Predicate<? super T> predicate) {
            return allMatch(t -> !predicate.test(t));
        }

        @Override
        public Optional<T> findFirst() {
            Iterator<T> it = iterator();
            if (it.hasNext()) {
                return Optional.of(it.next());
            }
            return Optional.empty();
        }

        @Override
        public Optional<T> findAny() {
            return findFirst();
        }

        @Override
        public Iterator<T> iterator() {
            return new ZipIterator();
        }

        @Override
        public Spliterator<T> spliterator() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isParallel() {
            return false;
        }

        @Override
        public Stream<T> sequential() {
            return this;
        }

        @Override
        public Stream<T> parallel() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Stream<T> unordered() {
            return new ZipStream<T>(first.unordered(), second.unordered());
        }

        @Override
        public Stream<T> onClose(Runnable closeHandler) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void close() {
            first.close();
            second.close();
        }

        private class ZipIterator implements Iterator<T> {

            private boolean isFirst = true;
            private Iterator<T> firstIte = first.iterator();
            private Iterator<T> secondIte = second.iterator();

            @Override
            public boolean hasNext() {
                return isFirst ? firstIte.hasNext() : secondIte.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T next = isFirst ? firstIte.next() : secondIte.next();
                isFirst = !isFirst;
                return next;
            }
        }
    }


}
