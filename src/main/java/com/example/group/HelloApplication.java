package com.example.group;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application {
    String css = getClass().getResource("/Style.css").toExternalForm();
    stage_1 subclass = new stage_1();

    Management management = new Management();

    public void start(Stage stage) throws IOException {

        FileHandler.Read_file();

        String background = "-fx-background-color: linear-gradient(to top, rgb(32,33,37)  , rgb(40,41,45) , rgb(63,67,86));";
        String button_presses ="-fx-background-color: rgba(92,108,121); -fx-font-size: 18px; -fx-text-fill: rgb(104,202,255);";
        String normal_button = "-fx-background-color: rgba(59,74,170,0); -fx-font-size: 18px; -fx-text-fill: rgb(255,255,255);";

        PauseTransition delay = new PauseTransition(Duration.millis(20));


        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 850,600 );
        scene.getStylesheets().add(css);
        stage.getIcons().add(new Image(new FileInputStream("src/main/java/com/example/group/bus_icon.png")));


        stage.setTitle("Route Management");
        grid.setStyle(background);


        HBox sub_head1 =new HBox();
        Text main_head = new Text("CUI ROUTE MANAGEMENT");
        main_head.setFont(Font.font("Monospaced", FontWeight.BOLD,37));
        main_head.setFill(Color.WHITE);
        main_head.getStyleClass().add("main_head");
        sub_head1.getChildren().add(main_head);


        HBox box1 = new HBox();
        box1.setBorder(new Border(new BorderStroke(Color.rgb(104,202,255), BorderStrokeStyle.SOLID,null,new BorderWidths(1.2))));
        Button button1 = new Button("Passengers info");
        button1.setStyle(normal_button);
        Image pass = new Image(new FileInputStream("src/main/java/com/example/group/multi-user-3-256.png"));
        ImageView passengers = new ImageView(pass);
        passengers.setFitHeight(60);
        passengers.setFitWidth(60);


        HBox box1_1 =new HBox();
        HBox box1_2 =new HBox();
        box1_1.getChildren().add(button1);
        box1_2.getChildren().add(passengers);
        box1_1.setPadding(new Insets(15,10,1,10));
        box1_2.setPadding(new Insets(0,0,0,200));
        button1.setPadding(new Insets(5,20,5,20));

        box1.getChildren().addAll(box1_1, box1_2);

        HBox box2 = new HBox();
        box2.setBorder(new Border(new BorderStroke(Color.rgb(104,202,255), BorderStrokeStyle.SOLID,null,new BorderWidths(1.2))));

        Button button2 = new Button("Routes");
        button2.setStyle(normal_button);
        Image Route = new Image(new FileInputStream("src/main/java/com/example/group/routes2.png"));
        ImageView Routes = new ImageView(Route);
        Routes.setFitHeight(60);
        Routes.setFitWidth(60);
        HBox box2_1 =new HBox();
        HBox box2_2 =new HBox();
        box2_1.getChildren().add(button2);
        box2_2.getChildren().add(Routes);
        box2_1.setPadding(new Insets(15,10,1,10));
        box2_2.setPadding(new Insets(0,0,0,270));
        button2.setPadding(new Insets(5,20,5,20));

        box2.getChildren().addAll(box2_1,box2_2);

        HBox box3 = new HBox();
        box3.setBorder(new Border(new BorderStroke(Color.rgb(104,202,255), BorderStrokeStyle.SOLID,null,new BorderWidths(1.2))));
        Button button3 = new Button("Bus");
        button3.setStyle(normal_button);
        Image Bus = new Image(new FileInputStream("src/main/java/com/example/group/bus.png"));
        ImageView Busses = new ImageView(Bus);
        Busses.setFitHeight(60);
        Busses.setFitWidth(60);
        HBox box3_1 =new HBox();
        HBox box3_2 =new HBox();
        box3_1.getChildren().add(button3);
        box3_2.getChildren().add(Busses);
        box3_1.setPadding(new Insets(15,10,1,10));
        box3_2.setPadding(new Insets(0,0,0,290));
        button3.setPadding(new Insets(5,20,5,20));

        box3.getChildren().addAll(box3_1,box3_2);

        HBox box4 = new HBox();
        box4.setBorder(new Border(new BorderStroke(Color.rgb(104,202,255), BorderStrokeStyle.SOLID,null,new BorderWidths(1.2))));
        Button button4 = new Button("payment");
        button4.setStyle(normal_button);
        Image pay = new Image(new FileInputStream("src/main/java/com/example/group/money.png"));
        ImageView Payment = new ImageView(pay);
        Payment.setFitHeight(60);
        Payment.setFitWidth(60);
        HBox box4_1 =new HBox();
        HBox box4_2 =new HBox();
        box4_1.getChildren().add(button4);
        box4_2.getChildren().add(Payment);
        box4_1.setPadding(new Insets(15,10,1,10));
        box4_2.setPadding(new Insets(2,0,2,250));
        button4.setPadding(new Insets(5,20,5,20));
        box4.getChildren().addAll(box4_1,box4_2);

        Button exit = new Button("Exit");
        exit.setPadding(new Insets(10,20,10,20));

        button1.setOnAction(e -> {
            button1.setStyle(button_presses);
            delay.play();
        });

        button2.setOnAction(e -> {
            button2.setStyle(button_presses);
            delay.play();
        });


        button3.setOnAction(e -> {
            button3.setStyle(button_presses);
            delay.setOnFinished(event -> {Busses(stage, background);});
            delay.play();
        });

        button4.setOnAction(e -> {
            button4.setStyle(button_presses);
            delay.setOnFinished(event -> {Payment(normal_button,background, button4);});
            delay.play();
        });

        exit.setOnAction(e -> {stage.close();
//            try {
//                FileHandler.Write_File();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        });

        grid.add(sub_head1,0,0);
        grid.add(box1,0,1);
        grid.add(box2,0,2);
        grid.add(box3,0,3);
        grid.add(box4,0,4);
        grid.add(exit,1,7);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(15);

        stage.setScene(scene);
        stage.show();
    }


    public void Busses(Stage stage3, String back_g){

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 800, 550);
        grid.setStyle(back_g);
        scene.getStylesheets().add(css);

        Image r_v = null;
        Image plus = null;
        Image left = null;
        Image exi  = null;
        try {
            r_v = new Image(new FileInputStream("src/main/java/com/example/group/routes2.png"));
            plus = new Image(new FileInputStream("src/main/java/com/example/group/grid.png"));
            left = new Image(new FileInputStream("src/main/java/com/example/group/add.png"));
            exi= new Image(new FileInputStream("src/main/java/com/example/group/exit.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView Routes_vehicle = new ImageView(r_v);
        ImageView v_left = new ImageView(left);
        ImageView add = new ImageView(plus);
        ImageView exit = new ImageView(exi);

        Routes_vehicle.setFitHeight(40);
        Routes_vehicle.setFitWidth(40);

        v_left.setFitHeight(40);
        v_left.setFitWidth(40);

        add.setFitHeight(40);
        add.setFitWidth(40);

        exit.setFitHeight(40);
        exit.setFitWidth(40);

        VBox box1 = new VBox();
        VBox box2 = new VBox();
        VBox box3 = new VBox();
        VBox box4 = new VBox();

        Button button1 = new Button("Vh for Routes");
        Button button2 = new Button("Vehicles left");
        Button button3 = new Button("Add Vehicles");
        Button back = new Button("Back");

        button1.getStyleClass().add("button_un");
        button2.getStyleClass().add("button_un");
        button3.getStyleClass().add("button_un");
        back.getStyleClass().add("button_un");


        box1.getChildren().addAll(Routes_vehicle,button1);
        box2.getChildren().addAll(v_left,button2);
        box3.getChildren().addAll(add,button3);
        box4.getChildren().addAll(exit,back);

        box1.setSpacing(7);
        box2.setSpacing(7);
        box3.setSpacing(7);

        box1.setPadding(new Insets(19,20,10,30));
        box2.setPadding(new Insets(19,20,10,30));
        box3.setPadding(new Insets(19,20,10,30));
        box4.setPadding(new Insets(20,20,22,30));

        box1.setStyle("-fx-border-color: rgb(104,202,255); -fx-border-width: 1px 0px 1px 1px;");
        box2.setStyle("-fx-border-color: rgb(104,202,255); -fx-border-width: 1px 0px 1px 1px;");
        box3.setStyle("-fx-border-color: rgb(104,202,255); -fx-border-width: 1px 0px 1px 1px;");
        box4.setStyle("-fx-border-color: rgb(104,202,255); -fx-border-width: 1px 0px 1px 1px;");

        box1.setAlignment(Pos.CENTER);
        box2.setAlignment(Pos.CENTER);
        box3.setAlignment(Pos.CENTER);
        box4.setAlignment(Pos.CENTER);

        button1.setOnAction(e -> {subclass.vehicleRequired(stage3, back_g);});
        button2.setOnAction(e -> {subclass.vehicleLeft(stage3, back_g);});
        button3.setOnAction(e -> {subclass.AddVehicles(stage3, back_g);});
        back.setOnAction(e -> {
            try {
                start(stage3);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        grid.add(box1, 0 , 0);
        grid.add(box2, 0 , 1);
        grid.add(box3, 0 , 2);
        grid.add(box4, 0,3);
        grid.setPadding(new Insets(70,0,0,0));
        grid.setAlignment(Pos.BASELINE_RIGHT);
        stage3.setScene(scene);
        stage3.show();
    }


    public void Payment(String sta, String back_g, Button b1){

        Stage stage4 = new Stage();
        GridPane gridPane = new GridPane();
        Scene scene1 = new Scene(gridPane, 850,600);
        gridPane.setStyle(back_g);
        HBox box = new HBox();
        Text text = new Text("Total Payment collected: ");
        Text text2 = new Text(management.Total_Payment_Recieved());


        text.setStyle("-fx-fill: rgb(255,255,255); -fx-font-size: 30px; ");
        text.setFont(Font.font("Monospaced", FontWeight.BOLD,39));
        text.setUnderline(true);
        text2.setStyle("-fx-fill: rgb(255,255,255); -fx-font-size: 30px; ");
        HBox box2 = new HBox();
        Text unpaid = new Text("Unpaid passengers:");
        box2.getChildren().add(unpaid);
        unpaid.setFont(Font.font("Monospaced", FontWeight.NORMAL,19));
        unpaid.setFill(Color.WHITE);
        box2.setPadding(new Insets(80,0,1,0));
        box.getChildren().addAll(text,text2);
        box.setSpacing(30);
        box.setPadding(new Insets(40,0,0,70));
        ScrollPane s = new ScrollPane();

        HBox box0 = new HBox();
        Button back = new Button("Back");
        back.setPadding(new Insets(10,20,10,20));
        box0.getChildren().add(back);
        box0.setPadding(new Insets(60,0,0,0));

        Text t = new Text();
        t.setText(management.Unpaid_passengers());
        t.setFill(Color.WHITE);
        t.setStyle("-fx-font-size: 17px;");

        s.setPrefViewportWidth(500);
        s.setPrefViewportHeight(200);
        s.setContent(t);
        s.setStyle("-fx-background:  rgb(43,43,43) ");

        gridPane.add(box,0,0);
        gridPane.add(box2,0,1);
        gridPane.add(s,0,2);
        gridPane.add(box0,1,3);
        gridPane.setPadding(new Insets(0,0,0,60));
        gridPane.setAlignment(Pos.CENTER);

        back.setOnAction(e -> {
            stage4.close();
            b1.setStyle(sta);
        });
        stage4.setScene(scene1);
        stage4.show();

    }
}