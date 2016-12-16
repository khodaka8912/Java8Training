package ch03.ex15;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, PixelReader reader);

    static ColorTransformer toColorTransformer(UnaryOperator<Color> operator) {
        return (x, y, r) -> operator.apply(r.getColor(x, y));
    }
}