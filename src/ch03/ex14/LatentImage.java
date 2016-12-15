package ch03.ex14;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
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
        PixelReader reader = in.getPixelReader();
        for (ColorTransformer transformer : transformers) {
            Color[][] intermediate = new Color[width][height];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    intermediate[x][y] = transformer.apply(x, y, reader);
                }
            }
            reader = new ColorReader(intermediate);
        }
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, reader.getColor(x, y));
            }
        }
        return out;
    }

    private static class ColorReader implements PixelReader {

        final Color[][] rawColors;

        ColorReader(Color[][] rawColors) {
            this.rawColors = rawColors;
        }

        @Override
        public PixelFormat getPixelFormat() {
            return null;
        }

        @Override
        public int getArgb(int x, int y) {
            return 0;
        }

        @Override
        public Color getColor(int x, int y) {
            return rawColors[x][y];
        }

        @Override
        public <T extends Buffer> void getPixels(int x, int y, int w, int h, WritablePixelFormat<T> pixelformat, T buffer, int scanlineStride) {

        }

        @Override
        public void getPixels(int x, int y, int w, int h, WritablePixelFormat<ByteBuffer> pixelformat, byte[] buffer, int offset, int scanlineStride) {

        }

        @Override
        public void getPixels(int x, int y, int w, int h, WritablePixelFormat<IntBuffer> pixelformat, int[] buffer, int offset, int scanlineStride) {

        }
    }
}
