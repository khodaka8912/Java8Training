package ch03.ex06;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.BiFunction;

/**
 * @author hodaka
 */
public class Images {

    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int height = (int) in.getHeight();
        int width = (int) in.getWidth();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
            }
        }
        return out;
    }
}
