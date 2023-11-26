package com.example.group;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.Icon;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public ObservableList<Object> observableList = FXCollections.observableArrayList();
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

    public void update(){
        GridPane grid = new GridPane();
        Scene scene1 = new Scene(grid,500,500);
        TableCell tableCell = new TableCell<>();
        TableColumn tableColumn = new TableColumn<>();
        grid.add(tableCell,0,0);
        Text t = new Text();


    }
}