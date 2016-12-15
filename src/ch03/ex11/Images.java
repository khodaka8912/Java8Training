package ch03.ex11;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
 * @author hodaka
 */
public class Images {

    static Image transform(Image in, ColorTransformer transformer) {
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
}
