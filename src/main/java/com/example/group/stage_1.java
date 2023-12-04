package com.example.group;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class stage_1 {

    Exceptions exceptions = new Exceptions();
    String css = getClass().getResource("/Style.css").toExternalForm();
    Bus bus_class_1 = new Bus();
    Routes r = new Routes();
    public void addMethod(String back_g) {

        Stage stage2 = new Stage();
        stage2.setTitle("Add Entry");

        GridPane inputLayout = new GridPane();
        inputLayout.setStyle(back_g);

        Scene inputScene = new Scene(inputLayout, 400, 400);
        inputScene.getStylesheets().add(css);

        ChoiceBox<String> choice = new ChoiceBox<>();
        choice.getItems().addAll("Student", "Faculty", "Staff");

        TextField name = new TextField();
        TextField id = new TextField();
        TextField program = new TextField();
        TextField route = new TextField();
        TextField payment = new TextField();
        ChoiceBox<String> paymentStatus = new ChoiceBox<>();
        paymentStatus.getItems().addAll("Paid", "Unpaid");
        paymentStatus.setValue("Unpaid");

        TextField facultySpecialization = new TextField();
        Label facultyLabel = new Label("Faculty Specialization:");

        TextField staffDepartment = new TextField();
        Label staffLabel = new Label("Staff Department:");

        CheckBox hostelite = new CheckBox("Hostelite");
        CheckBox scholarship = new CheckBox("Scholarship");
        hostelite.setStyle("-fx-text-fill: white;");
        scholarship.setStyle("-fx-text-fill: white;");

        Button submit = new Button("Submit");
        Button back = new Button("Back");

        inputLayout.setHgap(10);
        inputLayout.setVgap(10);
        inputLayout.setPadding(new Insets(10));

        Label ch=new Label("Select Entry Type");
        Label na=new Label("Name:");
        Label ir=new Label("ID or Registration:");
        Label pr=new Label("Program:");
        Label r=new Label("Route:");
        Label pa=new Label("Payment:");
        Label ps=new Label("PaymentStatus:");

        inputLayout.addRow(0, ch, choice);
        inputLayout.addRow(1, na, name);
        inputLayout.addRow(2, ir, id);
        inputLayout.addRow(3, pr, program);
        inputLayout.addRow(4, r, route);
        inputLayout.addRow(5, pa, payment);
        inputLayout.addRow(6, ps, paymentStatus);

        ch.setTextFill(Color.WHITE);
        na.setTextFill(Color.WHITE);
        ir.setTextFill(Color.WHITE);
        pa.setTextFill(Color.WHITE);
        ps.setTextFill(Color.WHITE);
        pr.setTextFill(Color.WHITE);
        r.setTextFill(Color.WHITE);
        facultyLabel.setTextFill(Color.WHITE);
        staffLabel.setTextFill(Color.WHITE);

        choice.setOnAction(e -> {
            inputLayout.getChildren().removeAll(
                    hostelite, scholarship, submit,back,
                    facultyLabel, facultySpecialization,
                    staffLabel, staffDepartment
            );

            switch (choice.getValue()) {
                case "Student":
                    inputLayout.addRow(7, hostelite, scholarship);
                    break;
                case "Faculty":
                    inputLayout.addRow(7, facultyLabel, facultySpecialization);
                    break;
                case "Staff":
                    inputLayout.addRow(7, staffLabel, staffDepartment);
                    break;
            }

            inputLayout.addRow(8, submit,back);
        });

        submit.setOnAction(e -> {
            System.out.println("Submit button clicked");
            stage2.close();
        });
        back.setOnAction(e->{
            stage2.close();
        });



        stage2.setScene(inputScene);

        stage2.show();
    }
    public void updateMethod(String back_g) {
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Entry");

        GridPane updateLayout = new GridPane();
        updateLayout.setStyle(back_g);

        Scene updateScene = new Scene(updateLayout, 600, 600);
        updateScene.getStylesheets().add(css);

        ChoiceBox<String> entryTypeChoice = new ChoiceBox<>();
        entryTypeChoice.getItems().addAll("Student", "Faculty", "Staff");

        TextField idUpdate = new TextField();
        Button searchButton = new Button("Search");

        searchButton.setOnAction(e -> {

            String id = idUpdate.getText();

        });

        List<TextField> oldFields = new ArrayList<>();
        List<TextField> newFields = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            oldFields.add(new TextField());
            newFields.add(new TextField());
        }

        ChoiceBox<String> paymentStatus = new ChoiceBox<>();
        paymentStatus.getItems().addAll("Paid", "Unpaid");
        paymentStatus.setValue("Unpaid");
        CheckBox hostelite = new CheckBox("Hostelite");
        CheckBox scholarship = new CheckBox("Scholarship");
        hostelite.setStyle("-fx-text-fill: white;");
        scholarship.setStyle("-fx-text-fill: white;");

        Button updateButton = new Button("Update");
        Button back = new Button("Back");

        back.setOnAction(e -> updateStage.close());
        updateButton.setOnAction(e -> updateStage.close());

        updateLayout.setHgap(10);
        updateLayout.setVgap(10);
        updateLayout.setPadding(new Insets(10));

        Label ch = new Label("Select Entry Type:");
        Label ir = new Label("Enter ID or Registration:");
        Label ps = new Label("Payment Status:");
        ch.setTextFill(Color.WHITE);
        ir.setTextFill(Color.WHITE);
        ps.setTextFill(Color.WHITE);

        updateLayout.addRow(0,ch, entryTypeChoice);
        updateLayout.addRow(1, ir, idUpdate, searchButton);

        entryTypeChoice.setOnAction(e -> {

            updateLayout.getChildren().removeAll(oldFields);
            updateLayout.getChildren().removeAll(newFields);
            updateLayout.getChildren().removeIf(node -> node instanceof Label && !((Label) node).getText().equals("Select Entry Type:") && !((Label) node).getText().equals("Enter ID or Registration:"));
            updateLayout.getChildren().removeAll(hostelite,scholarship,paymentStatus,updateButton,back);

            switch (entryTypeChoice.getValue()) {
                case "Student":
                    addFields(updateLayout,updateScene, oldFields, "Old ", "Name", "ID", "Program", "Route", "Payment");
                    addFields(updateLayout,updateScene, newFields, "New ", "Name", "ID", "Program", "Route", "Payment");
                    updateLayout.addRow(7, ps, paymentStatus);
                    updateLayout.addRow(8, hostelite, scholarship);
                    break;
                case "Faculty":
                    addFields(updateLayout,updateScene, oldFields, "Old ", "Name", "ID", "Route", "Payment", "Faculty Specialization");
                    addFields(updateLayout, updateScene,newFields, "New ", "Name", "ID", "Route", "Payment", "Faculty Specialization");
                    updateLayout.addRow(7, ps, paymentStatus);
                    break;
                case "Staff":
                    addFields(updateLayout, updateScene,oldFields, "Old ", "Name", "ID", "Route", "Payment", "Staff Department");
                    addFields(updateLayout, updateScene,newFields, "New ", "Name", "ID", "Route", "Payment", "Department");
                    updateLayout.addRow(7,ps, paymentStatus);
                    break;
            }

            updateLayout.addRow(20, updateButton,back);
        });

        updateStage.setScene(updateScene);
        updateStage.show();
    }
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
            stage.close();
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
        back.setOnAction(e ->stage.close());
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
    public void addRoute(String back_g){
        Stage stage = new Stage();
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 550,500);
        grid.setStyle(back_g);
        scene.getStylesheets().add(css);

        Text text1 = new Text("Enter new Route: ");
        TextField route=new TextField();
        Button enter = new Button("Enter");
        Button back = new Button("Back");

        text1.setFill(Color.WHITE);
        text1.getStyleClass().add("text-001");

        HBox box1 = new HBox();
        HBox box2 = new HBox();
        HBox box3 = new HBox();

        box1.getChildren().addAll(text1,route,enter);
        box3.getChildren().addAll(back);

        back.setPadding(new Insets(10,20,10,20));
        enter.setPadding(new Insets(5,10,5,10));
        box1.setSpacing(30);
        box2.setSpacing(10);
        box1.setPadding(new Insets(10,11,12,9));
        box2.setPadding(new Insets(30,0,0,0));
        box3.setPadding(new Insets(30,0,0,0));

        enter.setOnAction(e -> {});

        try {
            FileHandler.write();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        back.setOnAction(e -> {stage.close();});

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(0,0,0,130));
        grid.add(box1,0,0);
        grid.add(box2,0,1);
        grid.add(box3,0,2);
        stage.setScene(scene);
        stage.setX(400);
        stage.setY(100);
        stage.show();

    }
    public void routeQuantity(String back_g){
        Stage stage2 = new Stage();
        GridPane grid = new GridPane();
        grid.setStyle(back_g);
        Scene scene = new Scene(grid , 550, 500);
        scene.getStylesheets().add(css);

        Text text = new Text("Enter Route no: ");
        Text print = new Text();
        TextField textField = new TextField();
        Button required = new Button("Quantity");
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
            print.setText(exceptions.Pass_quantity_ex(textField.getText()));
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
    private void addFields(GridPane layout, Scene scene, List<TextField> fields, String labelPrefix, String... labels) {
        scene.getStylesheets().add(css);

        for (int i = 0; i < labels.length; i++) {
            Label label = new Label(labelPrefix + labels[i]);
            label.setTextFill(Color.WHITE);
            layout.addRow(2 + i, label, fields.get(i));
        }
    }

    public void All_Route(String back_g){

        Stage stage4 = new Stage();
        GridPane gridPane = new GridPane();
        Scene scene1 = new Scene(gridPane, 850,600);
        gridPane.setStyle(back_g);
        HBox box = new HBox();
        Text text = new Text("*All Route Details*");


        text.setStyle("-fx-fill: rgb(255,255,255); -fx-font-size: 30px; ");
        text.setFont(Font.font("Monospaced", FontWeight.BOLD,39));
        text.setUnderline(true);
        HBox box2 = new HBox();
        Text unpaid = new Text("Route passengers:");
        box2.getChildren().add(unpaid);
        unpaid.setFont(Font.font("Monospaced", FontWeight.NORMAL,19));
        unpaid.setFill(Color.WHITE);
        box2.setPadding(new Insets(80,0,1,0));
        box.getChildren().addAll(text);
        box.setSpacing(30);
        box.setPadding(new Insets(40,0,0,70));
        ScrollPane s = new ScrollPane();

        HBox box0 = new HBox();
        Button back = new Button("Back");
        back.setPadding(new Insets(10,20,10,20));
        box0.getChildren().add(back);
        box0.setPadding(new Insets(60,0,0,0));

        Text t = new Text();
        t.setText(r.toString());
        t.setFill(Color.WHITE);
        t.setStyle("-fx-font-size: 17px;");

        s.setPrefViewportWidth(570);
        s.setPrefViewportHeight(240);
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
        });
        stage4.setScene(scene1);
        stage4.show();

    }

}
