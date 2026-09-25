package com.travelbloom;

import com.travelbloom.util.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Database.initializeDatabase();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/travelbloom/com.travelbloom/dashboard.fxml"
                )
        );

        Scene scene = new Scene(
                loader.load(),
                1200,
                700
        );

        scene.getStylesheets().add(
                getClass().getResource(
                        "/com/travelbloom/css/style.css"
                ).toExternalForm()
        );

        stage.setTitle(
                "TravelBloom - Smart Trip Planning System"
        );

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}