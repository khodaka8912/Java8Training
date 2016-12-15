package ch04.ex05;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author hodaka
 */
public class Observables {

    static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
        return new ConvertedObservableValue<>(f, t);
    }

    static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
        return new DoubleObservableValue<>(f, t, u);
    }

    static class ConvertedObservableValue<T, R> extends ObservableValueBase<R> {
        final ObservableValue<T> observableValue;
        final Function<T, R> function;

        ConvertedObservableValue(Function<T, R> f, ObservableValue<T> t) {
            observableValue = t;
            function = f;
            observableValue.addListener(observables -> fireValueChangedEvent());
            observableValue.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
        }

        @Override
        public R getValue() {
            return function.apply(observableValue.getValue());
        }
    }

    static class DoubleObservableValue<T, U, R> extends ObservableValueBase<R> {
        final ObservableValue<T> tValue;
        final ObservableValue<U> uValue;
        final BiFunction<T, U, R> function;

        DoubleObservableValue(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
            tValue = t;
            uValue = u;
            function = f;
            tValue.addListener(observables -> fireValueChangedEvent());
            tValue.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
            uValue.addListener(observables -> fireValueChangedEvent());
            uValue.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
        }

        @Override
        public R getValue() {
            return function.apply(tValue.getValue(), uValue.getValue());
        }
    }
}
