package ch04.ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author hodaka
 */
public class WebViewer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        TextField navigationBar = new TextField("http://www.google.com");
        navigationBar.setPrefWidth(500);
        navigationBar.setOnAction(event -> engine.load(navigationBar.getText()));
        Button backButton = new Button("←");
        backButton.setOnAction(event -> {
            if (engine.getHistory().getCurrentIndex() > 0) engine.getHistory().go(-1);
        });
        Button forwardButton = new Button("→");
        forwardButton.setOnAction(event -> {
            if (engine.getHistory().getCurrentIndex() < engine.getHistory().getEntries().size() - 1)
                engine.getHistory().go(1);
        });
        HBox box = new HBox();
        box.getChildren().add(backButton);
        box.getChildren().add(forwardButton);
        box.getChildren().add(navigationBar);
        BorderPane pane = new BorderPane();
        pane.setTop(box);
        pane.setCenter(webView);
        primaryStage.setScene(new Scene(pane));
        engine.load(navigationBar.getText());
        primaryStage.show();
    }
}
