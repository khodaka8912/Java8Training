package ch03.ex12;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * @author hodaka
 */
public class ImageApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image in = new Image(new File("len_std.jpg").toURI().toString());
        int frameThick = 10;
        Color frameColor = Color.GRAY;
        ColorTransformer framer = (x, y, color) -> {
            int height = (int) in.getHeight();
            int width = (int) in.getWidth();
            if (x <= frameThick || x >= height - frameThick || y <= frameThick || y >= height - frameThick) {
                return frameColor;
            }
            return color;
        };
        Image out = LatentImage.from(in).transform(Color::brighter).transform(framer).toImage();
        ImageIO.write(SwingFXUtils.fromFXImage(out, null), "PNG", new File("ex12_len_brighten_framed.png"));
        System.exit(0);
    }
}
