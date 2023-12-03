package com.example.group;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid,500,500);
        stage.setTitle("Transport Management");
        Button b = new Button("Student");
        b.maxWidth(200);
        grid.add(b, 0,1);
        stage.setScene(scene);
        stage.show();
    }


}