package ch04.ex06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author hodaka
 */
public class ButtonApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setTop(new Button("Top"));
        pane.setLeft(new Button("Left"));
        pane.setCenter(new Button("Center"));
        pane.setRight(new Button("Right"));
        pane.setBottom(new Button("Bottom"));
        BorderPane.setAlignment(pane.getTop(), Pos.CENTER);
        BorderPane.setAlignment(pane.getBottom(), Pos.CENTER);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
