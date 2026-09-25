package com.travelbloom.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private SceneManager() {
    }

    // Change the current scene
    public static void switchScene(
            Stage stage,
            String fxmlFile,
            String title) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource(
                        "/com/travelbloom/com.travelbloom/" + fxmlFile
                )
        );

        Parent root = loader.load();

        Scene scene = new Scene(root, 1200, 700);

        // Add common CSS
        scene.getStylesheets().add(
                SceneManager.class.getResource(
                        "/com/travelbloom/css/style.css"
                ).toExternalForm()
        );

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}