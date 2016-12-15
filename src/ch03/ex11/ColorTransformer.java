package ch03.ex11;

import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);

    static ColorTransformer andThen(ColorTransformer first, ColorTransformer second) {
        return (x, y, c) -> second.apply(x, y, first.apply(x, y, c));
    }

    static ColorTransformer toColorTransformer(UnaryOperator<Color> operator) {
        return (x, y, c) -> operator.apply(c);
    }
}