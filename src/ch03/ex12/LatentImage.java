package ch03.ex12;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author hodaka
 */
public class LatentImage {

    private Image in;
    private List<ColorTransformer> transformers = new ArrayList<>();

    LatentImage(Image in) {
        this.in = in;
    }

    static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    LatentImage transform(ColorTransformer transformer) {
        transformers.add(transformer);
        return this;
    }

    LatentImage transform(UnaryOperator<Color> operator) {
        return transform(ColorTransformer.toColorTransformer(operator));
    }

    Image toImage() {
        int height = (int) in.getHeight();
        int width = (int) in.getWidth();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = in.getPixelReader().getColor(x, y);
                for (ColorTransformer transformer : transformers) {
                    color = transformer.apply(x, y, color);
                }
                out.getPixelWriter().setColor(x, y, color);
            }
        }
        return out;
    }
}
