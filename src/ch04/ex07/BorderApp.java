package ch04.ex07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * @author hodaka
 */
public class BorderApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(new Button("Top"));
        pane.setLeft(new Button("Left"));
        pane.setCenter(new Button("Center"));
        pane.setRight(new Button("Right"));
        pane.setBottom(new Button("Bottom"));

        pane.setBorder(new Border(new BorderStroke(Paint.valueOf("blue"), BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
