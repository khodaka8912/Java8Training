package ch03.ex10;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

/**
 * @author hodaka
 */
public class Images {
    public static void test() {
        Image in = null;
        UnaryOperator<Color> op = Color::brighter;
        /*
        Function#composeの返り値はFunctionであり、UnaryOperatorではないため、transformメソッドに渡せない。
        ストラクチャル型であれば、Function<Color, Color>とUnaryOperator<Color>は同構造のため、適用できる。
         */
//        Image finalImage = transform(in, op.compose(Color::grayscale));
    }


    public static Image transform(Image in, UnaryOperator<Color> transformer) {
        int height = (int) in.getHeight();
        int width = (int) in.getWidth();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, transformer.apply(in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }
}
