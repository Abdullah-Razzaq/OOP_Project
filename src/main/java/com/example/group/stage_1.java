package com.example.group;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class stage_1 {

    Exceptions exceptions = new Exceptions();
    String css = getClass().getResource("/Style.css").toExternalForm();
    Bus bus_class_1 = new Bus();
    public void RemovePassengers(String back_g){
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setStyle(back_g);
        Scene scene1 = new Scene(gridPane, 550,500);
        scene1.getStylesheets().add(css);

        HBox box0 = new HBox();
        Text text = new Text("Enter Id or Reg no:");
        TextField textField = new TextField();
        Button remove = new Button("remove");
        Button back = new Button("Back");

        VBox box_v = new VBox();
        VBox box_v2 = new VBox();
        HBox b = new HBox();
        HBox extra = new HBox();

        box0.getChildren().addAll(text,textField,remove);
        box0.setSpacing(20);

        Text output = new Text("\n\n\n\n\n\n\n\n\n\n");
        Text text2 = new Text();

        text.getStyleClass().add("text-001");
        output.getStyleClass().add("text-001");
        text2.getStyleClass().add("text-001");
        output.setFill(Color.WHITE);
        text.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);

        extra.getChildren().add(text2);
        box_v.getChildren().add(output);
        b.getChildren().add(back);

        b.setPadding(new Insets(50,0,0,400));
        box_v2.getChildren().addAll(box0,box_v, extra,b);
        box_v.setMaxWidth(20);


        remove.setPadding(new Insets(5,10,5,10));
        back.setPadding(new Insets(10,20,10,20));

        remove.setOnAction(e ->{
            String p;
            p = exceptions.Removemethod(textField.getText());
            if (p.contains("Reg or Id not found")) {
                output.setText(p);
            }else if (!p.contains("Reg or Id not found")){
                output.setText(p);
                text2.setText("* Successfully Removed !");}});

        back.setOnAction(e ->/* Passengers(stage)*/ {
            System.out.println("pressed");
        });

        gridPane.add(box_v2,0,0);
        gridPane.setPadding(new Insets(90,0,0,0));
        gridPane.setAlignment(Pos.TOP_CENTER);
        stage.setX(400);
        stage.setY(100);
        stage.setScene(scene1);
        stage.show();

    }


    public void SearchPassengers(String back_g){

        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        Scene scene1 = new Scene(gridPane, 550,500);
        gridPane.setStyle(back_g);
        scene1.getStylesheets().add(css);

        HBox box0 = new HBox();
        Text text = new Text("Enter Id or Reg no:");
        TextField textField = new TextField();
        Button search = new Button("search");
        Button back = new Button("Back");
        VBox box_v = new VBox();
        VBox box_v2 = new VBox();
        HBox b = new HBox();

        box0.getChildren().addAll(text,textField,search);
        box0.setSpacing(20);

        Text output = new Text("\n\n\n\n\n\n\n\n");
        box_v.getChildren().add(output);
        b.getChildren().add(back);
        box_v2.getChildren().addAll(box0,box_v,b);
        box_v.setMaxWidth(20);

        text.setFill(Color.WHITE);
        output.setFill(Color.WHITE);
        text.getStyleClass().add("text-001");
        output.getStyleClass().add("text-001");


        search.setPadding(new Insets(5,10,5,10));
        back.setPadding(new Insets(10,20,10,20));
        b.setPadding(new Insets(70,0,0,400));
        gridPane.setPadding(new Insets(140,0,0,0));
        gridPane.add(box_v2,0,0);
        gridPane.setAlignment(Pos.TOP_CENTER);
        search.setOnAction(e -> output.setText(exceptions.Searchmethod(textField.getText())));
//        back.setOnAction(e -> Passengers(stage));
        stage.setX(400);
        stage.setY(100);
        stage.setScene(scene1);
        stage.show();

    }



    public void vehicleRequired(Stage stage, String back_g){
        Stage stage2 = new Stage();
        GridPane grid = new GridPane();
        grid.setStyle(back_g);
        Scene scene = new Scene(grid , 550, 500);
        scene.getStylesheets().add(css);

        Text text = new Text("Enter Route no: ");
        Text print = new Text();
        TextField textField = new TextField();
        Button required = new Button("required");
        Button back = new Button("Back");

        print.setUserData("string");

        HBox box = new HBox();
        HBox box1 = new HBox();
        VBox box2  = new VBox();
        box.setSpacing(20);
        box.getChildren().addAll(text,textField,required);
        box.getChildren().add(print);

        text.setFill(Color.WHITE);
        text.getStyleClass().add("text-001");

        box1.getChildren().add(print);
        box1.setPadding(new Insets(40,0,0,30));
        required.setPadding(new Insets(5,10,5,10));
        required.setOnAction(e -> {
            print.setText(exceptions.vehicle_required_ex(textField.getText()));
            print.getStyleClass().add("text-001");
            print.setFill(Color.WHITE);
        });

        back.setPadding(new Insets(10,20,10,20));
        box2.getChildren().add(back);
        box2.setPadding(new Insets(100,0,0,0));
        back.setOnAction(e-> stage2.close());
        grid.setPadding(new Insets(160,40,40,100));
        grid.add(box, 0,0);
        grid.add(box1, 0,1);
        grid.add(box2, 0,2);
        stage2.setScene(scene);
        stage2.setX(400);
        stage2.setY(100);
        stage2.show();
    }

    public void vehicleLeft(Stage stage3, String backG) {
        Stage stage3_1 = new Stage();
        GridPane grid = new GridPane();
        grid.setStyle(backG);
        Scene scene = new Scene(grid , 550, 500);
        scene.getStylesheets().add(css);

        Text text = new Text(bus_class_1.No_of_Vehicles_Left());
        Button back = new Button("Back");
        back.setPadding(new Insets(10,20,10,20));
        VBox box = new VBox();
        box.getChildren().add(back);

        text.setFill(Color.WHITE);
        text.getStyleClass().add("text-002");

        back.setOnAction(e -> stage3_1.close());
        box.setAlignment(Pos.BOTTOM_RIGHT);

        box.setPadding(new Insets(100,0,0,180));
        grid.setPadding(new Insets(180,0,0,180));
        grid.add(text, 0,0);
        grid.add(box, 0,1);
        stage3_1.setScene(scene);
        stage3_1.setX(400);
        stage3_1.setY(100);
        stage3_1.show();
    }
    public void AddVehicles(Stage stage3, String backG) {
        Stage stage = new Stage();
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 550,500);
        grid.setStyle(backG);
        scene.getStylesheets().add(css);

        Text text1 = new Text("Enter Bus quantity: ");
        Text text2 = new Text("Enter Coaster quantity: ");
        Text text3 = new Text();
        TextField bus = new TextField();
        TextField coaster = new TextField();
        Button enter = new Button("Enter");
        Button back = new Button("Back");

        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        text1.getStyleClass().add("text-001");
        text2.getStyleClass().add("text-001");


        HBox box1 = new HBox();
        HBox box2 = new HBox();
        HBox box3 = new HBox();
        HBox box4 = new HBox();
        HBox box5 = new HBox();

        box1.getChildren().addAll(text1, bus);
        box2.getChildren().addAll(text2, coaster);
        box3.getChildren().addAll(enter);
        box4.getChildren().addAll(text3);
        box5.getChildren().addAll(back);

        back.setPadding(new Insets(10,20,10,20));
        enter.setPadding(new Insets(5,10,5,10));
        box1.setSpacing(30);
        box2.setSpacing(10);
        box1.setPadding(new Insets(10,11,12,9));
        box2.setPadding(new Insets(30,0,0,0));
        box3.setPadding(new Insets(35,0,0,90));
        box4.setPadding(new Insets(30,0,0,20));
        box5.setPadding(new Insets(55,0,0,260));

        enter.setOnAction(e -> {text3.setText(exceptions.vehicle_Add_ex(bus.getText(), coaster.getText()));
            text3.setFill(Color.WHITE);
            try {
                FileHandler.write();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            text3.getStyleClass().add("text-001");});

        back.setOnAction(e -> {stage.close();});

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(0,0,0,130));
        grid.add(box1,0,0);
        grid.add(box2,0,1);
        grid.add(box3,0,2);
        grid.add(box4,0,3);
        grid.add(box5,0,4);
        stage.setScene(scene);
        stage.setX(400);
        stage.setY(100);
        stage.show();

    }

}
