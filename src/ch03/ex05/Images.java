package ch03.ex05;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * @author hodaka
 */
public class Images {

    @FunctionalInterface
    interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }

    public static Image transform(Image in, ColorTransformer transformer) {
        int height = (int) in.getHeight();
        int width = (int) in.getWidth();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, transformer.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

    static Image framing(Image in, int frameThick) {
        return transform(in, (x, y, color) -> {
            int height = (int) in.getHeight();
            int width = (int) in.getWidth();
            if (x <= frameThick || x >= height - frameThick || y <= frameThick || y >= height - frameThick) {
                return Color.gray(0.5);
            }
            return in.getPixelReader().getColor(x, y);
        });
    }

}
