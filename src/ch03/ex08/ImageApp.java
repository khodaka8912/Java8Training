package ch03.ex08;

import javafx.application.Application;
import javafx.application.Platform;
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
        Image out = Images.framing(in, 50, Color.BLUE);
        ImageIO.write(SwingFXUtils.fromFXImage(out, null), "PNG", new File("ex08_len_framed2.png"));
        Platform.exit();
    }
}
