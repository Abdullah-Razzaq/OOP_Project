package Transport_Managment;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class gui extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 700,500 );
        stage.setTitle("Transport Management");
        grid.setStyle("-fx-background-color: rgba(198,232,254,0.45)");


        HBox sub_head1 =new HBox();
        Text main_head = new Text("CUI ROUTE MANAGEMENT");
        main_head.setFont(Font.font("Monospaced", FontWeight.BOLD,32));
        main_head.setFill(Color.WHITE);
        sub_head1.getChildren().add(main_head);
        sub_head1.setStyle("-fx-background-color: #9dd4f9");
        sub_head1.setAlignment(Pos.CENTER);


        HBox box1 = new HBox();
        box1.setBorder(new Border(new BorderStroke(Color.rgb(149,203,240), BorderStrokeStyle.DASHED,null,new BorderWidths(3))));
        Text t1 = new Text("Passengers info");
        t1.setFont(Font.font("serif",20));
        t1.setFill(Color.rgb(103,188,241));
        Button button1 = new Button("Passengers");
        button1.setOnAction(e -> {Passengers(stage);});
        HBox box1_1 =new HBox();
        HBox box1_2 =new HBox();
        box1_1.getChildren().add(t1);
        box1_2.getChildren().add(button1);
        box1_1.setPadding(new Insets(13,10,10,10));
        box1_2.setPadding(new Insets(13,10,10,200));
        button1.setPadding(new Insets(5,20,5,20));

        box1.getChildren().addAll(box1_1,box1_2);

        HBox box2 = new HBox();
        box2.setBorder(new Border(new BorderStroke(Color.rgb(149,203,240), BorderStrokeStyle.DASHED,null,new BorderWidths(3))));
        Text t2 = new Text("Routes info");
        t2.setFont(Font.font("serif",20));
        t2.setFill(Color.rgb(103,188,241));
        Button button2 = new Button("Routes");
        button2.setOnAction(e->{Routes(stage);});

        HBox box2_1 =new HBox();
        HBox box2_2 =new HBox();
        box2_1.getChildren().add(t2);
        box2_2.getChildren().add(button2);
        box2_1.setPadding(new Insets(13,10,10,10));
        box2_2.setPadding(new Insets(13,10,10,250));
        button2.setPadding(new Insets(5,20,5,20));

        box2.getChildren().addAll(box2_1,box2_2);

        HBox box3 = new HBox();
        box3.setBorder(new Border(new BorderStroke(Color.rgb(149,203,240), BorderStrokeStyle.DASHED,null,new BorderWidths(3))));
        Text t3 = new Text("Bus info");
        t3.setFont(Font.font("serif",20));
        t3.setFill(Color.rgb(103,188,241));
        Button button3 = new Button("Bus");
        HBox box3_1 =new HBox();
        HBox box3_2 =new HBox();
        box3_1.getChildren().add(t3);
        box3_2.getChildren().add(button3);
        box3_1.setPadding(new Insets(13,10,10,10));
        box3_2.setPadding(new Insets(13,10,10,290));
        button3.setPadding(new Insets(5,20,5,20));

        box3.getChildren().addAll(box3_1,box3_2);

        HBox box4 = new HBox();
        box4.setBorder(new Border(new BorderStroke(Color.rgb(149,203,240), BorderStrokeStyle.DASHED,null,new BorderWidths(3))));
        Text t4 = new Text("Payment info");
        t4.setFont(Font.font("serif",20));
        t4.setFill(Color.rgb(103,188,241));
        Button button4 = new Button("payment");
        HBox box4_1 =new HBox();
        HBox box4_2 =new HBox();
        box4_1.getChildren().add(t4);
        box4_2.getChildren().add(button4);
        box4_1.setPadding(new Insets(13,10,10,10));
        box4_2.setPadding(new Insets(13,10,10,224));
        button4.setPadding(new Insets(5,20,5,20));
        box4.getChildren().addAll(box4_1,box4_2);

        Button exit = new Button("Exit");
        exit.setPadding(new Insets(10,20,10,20));
        exit.setOnAction(e -> stage.close());

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


    public void Passengers(Stage stage1) {
        GridPane layout = new GridPane();

        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");
        Button updateButton = new Button("Update");
        Button searchButton = new Button("Search");
        Button back = new Button("Back");

        layout.add(addButton,0,0);
        layout.add(removeButton,0,1);
        layout.add(updateButton,0,2);
        layout.add(searchButton,0,3);
        layout.add(back,0,4);

        back.setPrefSize(100, 50);
        removeButton.setPrefSize(100, 50);
        searchButton.setPrefSize(100, 50);
        updateButton.setPrefSize(100, 50);
        addButton.setPrefSize(100, 50);

        layout.setAlignment(Pos.CENTER_RIGHT);

        GridPane.setHalignment(addButton, HPos.RIGHT);
        GridPane.setHalignment(removeButton, HPos.RIGHT);
        GridPane.setHalignment(updateButton, HPos.RIGHT);
        GridPane.setHalignment(searchButton, HPos.RIGHT);
        GridPane.setHalignment(back,HPos.RIGHT);

        addButton.setOnAction(e -> addMethod());
        removeButton.setOnAction(e -> RemoveMethod(stage1));
        updateButton.setOnAction(e -> updateMethod());
        searchButton.setOnAction(e -> SearchMethod(stage1));
        back.setOnAction(e -> {
            try {
                start(stage1);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Scene scene = new Scene(layout, 700, 500);
        stage1.setScene(scene);

        stage1.show();
    }

    private void addMethod() {

        Stage stage2 = new Stage();
        stage2.setTitle("Add Entry");

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

        Button submit = new Button("Submit");
        Button back = new Button("Back");

        GridPane inputLayout = new GridPane();
        inputLayout.setHgap(10);
        inputLayout.setVgap(10);
        inputLayout.setPadding(new Insets(10));

        inputLayout.addRow(0, new Label("Select Entry Type:"), choice);
        inputLayout.addRow(1, new Label("Name:"), name);
        inputLayout.addRow(2, new Label("ID or Registration:"), id);
        inputLayout.addRow(3, new Label("Program:"), program);
        inputLayout.addRow(4, new Label("Route:"), route);
        inputLayout.addRow(5, new Label("Payment:"), payment);
        inputLayout.addRow(6, new Label("PaymentStatus:"), paymentStatus);

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
            try {
                FileHandler.Write_File();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Submit button clicked");
            stage2.close();
        });
        back.setOnAction(e->{
            stage2.close();
        });

        Scene inputScene = new Scene(inputLayout, 400, 400);
        stage2.setScene(inputScene);

        stage2.show();
    }

    public void RemoveMethod(Stage stage){

        GridPane gridPane = new GridPane();
        Scene scene1 = new Scene(gridPane, 700,500);
        HBox box0 = new HBox();
        Text text = new Text("Enter Id or Reg no:");
        TextField textField = new TextField();
        Button remove = new Button("remove");
        Button back = new Button("Back");
        VBox box_v = new VBox();
        VBox box_v2 = new VBox();
        HBox b = new HBox();

        box0.getChildren().addAll(text,textField,remove);
        box0.setSpacing(20);

        Text t = new Text("\n\n\n\n\n\n\n\n\n\n");
        box_v.getChildren().add(t);
        b.getChildren().add(back);
        b.setPadding(new Insets(70,0,0,400));
        box_v2.getChildren().addAll(box0,box_v,b);
        box_v.setMaxWidth(20);
        gridPane.add(box_v2,0,0);
        gridPane.setPadding(new Insets(120,0,0,0));
        gridPane.setAlignment(Pos.TOP_CENTER);
        remove.setOnAction(e -> RemovePassengers(t));
        back.setOnAction(e -> Passengers(stage));
        stage.setScene(scene1);
        stage.show();

    }

    private void updateMethod() {
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Entry");

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


        Button updateButton = new Button("Update");
        Button back = new Button("Back");

        back.setOnAction(e -> updateStage.close());
        updateButton.setOnAction(e -> updateStage.close());

        GridPane updateLayout = new GridPane();
        updateLayout.setHgap(10);
        updateLayout.setVgap(10);
        updateLayout.setPadding(new Insets(10));

        updateLayout.addRow(0, new Label("Select Entry Type:"), entryTypeChoice);
        updateLayout.addRow(1, new Label("Enter ID or Registration:"), idUpdate, searchButton);

        entryTypeChoice.setOnAction(e -> {

            updateLayout.getChildren().removeAll(oldFields);
            updateLayout.getChildren().removeAll(newFields);
            updateLayout.getChildren().removeIf(node -> node instanceof Label && !((Label) node).getText().equals("Select Entry Type:") && !((Label) node).getText().equals("Enter ID or Registration:"));
            updateLayout.getChildren().removeAll(hostelite,scholarship,paymentStatus,updateButton,back);

            switch (entryTypeChoice.getValue()) {
                case "Student":
                    addFields(updateLayout, oldFields, "Old ", "Name", "ID", "Program", "Route", "Payment");
                    addFields(updateLayout, newFields, "New ", "Name", "ID", "Program", "Route", "Payment");
                    updateLayout.addRow(7, new Label("PaymentStatus:"), paymentStatus);
                    updateLayout.addRow(8, hostelite, scholarship);
                    break;
                case "Faculty":
                    addFields(updateLayout, oldFields, "Old ", "Name", "ID", "Route", "Payment", "Faculty Specialization");
                    addFields(updateLayout, newFields, "New ", "Name", "ID", "Route", "Payment", "Faculty Specialization");
                    updateLayout.addRow(7, new Label("PaymentStatus:"), paymentStatus);
                    break;
                case "Staff":
                    addFields(updateLayout, oldFields, "Old ", "Name", "ID", "Route", "Payment", "Staff Department");
                    addFields(updateLayout, newFields, "New ", "Name", "ID", "Route", "Payment", "Department");
                    updateLayout.addRow(7, new Label("PaymentStatus:"), paymentStatus);
                    break;
            }

            updateLayout.addRow(20, updateButton,back);
        });

        Scene updateScene = new Scene(updateLayout, 600, 600);
        updateStage.setScene(updateScene);
        updateStage.show();
    }


    public void SearchMethod(Stage stage){

        GridPane gridPane = new GridPane();
        Scene scene1 = new Scene(gridPane, 700,500);
        HBox box0 = new HBox();
        Text text = new Text("Enter Id or Reg no:");
        TextField textField = new TextField();
        Button remove = new Button("search");
        Button back = new Button("Back");
        VBox box_v = new VBox();
        VBox box_v2 = new VBox();
        HBox b = new HBox();

        box0.getChildren().addAll(text,textField,remove);
        box0.setSpacing(20);

        Text t = new Text("\n\n\n\n\n\n\n\n\n\n");
        box_v.getChildren().add(t);
        b.getChildren().add(back);
        b.setPadding(new Insets(70,0,0,400));
        box_v2.getChildren().addAll(box0,box_v,b);
        box_v.setMaxWidth(20);
        gridPane.add(box_v2,0,0);
        gridPane.setPadding(new Insets(120,0,0,0));
        gridPane.setAlignment(Pos.TOP_CENTER);
        remove.setOnAction(e -> SearchPassengers(t));
        back.setOnAction(e -> Passengers(stage));
        stage.setScene(scene1);
        stage.show();

    }

    public void Routes(Stage stage){
        GridPane layout = new GridPane();

        Button addRoute = new Button("Add new Route");
        Button passengers = new Button("Route passengers quantity");
        Button details = new Button("All Routes detail");
        Button back = new Button("Back");

        layout.add(addRoute,0,0);
        layout.add(passengers,0,1);
        layout.add(details,0,2);
        layout.add(back,0,3);

        addRoute.setPrefSize(200,50);
        back.setPrefSize(200, 50);
        passengers.setPrefSize(200, 50);
        details.setPrefSize(200, 50);


        layout.setAlignment(Pos.CENTER_RIGHT);

        GridPane.setHalignment(addRoute,HPos.RIGHT);
        GridPane.setHalignment(passengers, HPos.RIGHT);
        GridPane.setHalignment(details, HPos.RIGHT);
        GridPane.setHalignment(back,HPos.RIGHT);

        addRoute.setOnAction(e->{

        });

        passengers.setOnAction(e ->{

        });

        details.setOnAction(e ->{

        });

        back.setOnAction(e -> {
            try {
                start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Scene scene = new Scene(layout, 700, 500);
        stage.setScene(scene);

        stage.show();

    }

    private void addFields(GridPane layout, List<TextField> fields, String labelPrefix, String... labels) {
        for (int i = 0; i < labels.length; i++) {
            layout.addRow(2 + i, new Label(labelPrefix + labels[i]), fields.get(i));
        }
    }

    public void RemovePassengers(Text text){
        text.setText("\n\n\n\n\nReg not found\n\n\n\n\n");
    }

    public void SearchPassengers(Text text){
        text.setText("\n\n\n\n\nReg not found\n\n\n\n\n");
    }



}
