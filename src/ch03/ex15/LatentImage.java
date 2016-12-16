package ch03.ex15;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.function.UnaryOperator;

/**
 * @author hodaka
 */
public class LatentImage implements PixelReader {

    private static final ColorTransformer NO_CHANGE = (x, y, r) -> r.getColor(x, y);

    private PixelReader reader;
    private int width;
    private int height;
    private ColorTransformer transformer;
    private Color[][] cache;

    LatentImage(Image in) {
        reader = in.getPixelReader();
        width = (int) in.getWidth();
        height = (int) in.getHeight();
        transformer = NO_CHANGE;
        cache = new Color[width][height];
    }

    LatentImage(LatentImage in, ColorTransformer transformer) {
        reader = in;
        width = in.getWidth();
        height = in.getHeight();
        this.transformer = transformer;
    }

    static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    LatentImage transform(ColorTransformer transformer) {
        return transformer == null ? this : new LatentImage(this, transformer);
    }

    LatentImage transform(UnaryOperator<Color> operator) {
        return transform(ColorTransformer.toColorTransformer(operator));
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    Image toImage() {
        WritableImage out = new WritableImage(width, height);
        PixelWriter writer = out.getPixelWriter();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                writer.setColor(x, y, transformer.apply(x, y, reader));
            }
        }
        return out;
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
        return cache[x][y] == null ? (cache[x][y] = transformer.apply(x, y, reader)) : cache[x][y];
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
