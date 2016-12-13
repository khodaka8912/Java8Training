package ch03.ex05;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
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
        Image out = Images.framing(in, 10);
        ImageIO.write(SwingFXUtils.fromFXImage(out, null), "JPEG", new File("len_framed.jpg"));
        stop();
    }
}
