package org.example.sdev200finalprojectcarsonbeckmann;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// import static javafx.application.Application.launch;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/org/example/sdev200finalprojectcarsonbeckmann/main.fxml"));
        ///stage.setScene(new Scene(root, 400, 200));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}