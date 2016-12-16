package ch03.ex15;

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
    public void start(Stage ImageAppprimaryStage) throws Exception {
        Image in = new Image(new File("len_std.jpg").toURI().toString());
        Image out = LatentImage.from(in).transform(Color::brighter).transform(Color::grayscale).toImage();
        ImageIO.write(SwingFXUtils.fromFXImage(out, null), "PNG", new File("ex15_len_brighten_grayscale.png"));
        Platform.exit();
    }
}
