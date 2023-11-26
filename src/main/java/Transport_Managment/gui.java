package Transport_Managment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class gui extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage1) {
        stage1.setTitle("Transport Management");

        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");
        Button updateButton = new Button("Update");
        Button searchButton = new Button("Search");

        addButton.setMaxWidth(Double.MAX_VALUE);
        removeButton.setMaxWidth(Double.MAX_VALUE);
        updateButton.setMaxWidth(Double.MAX_VALUE);
        searchButton.setMaxWidth(Double.MAX_VALUE);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);

        GridPane layout = new GridPane();
        layout.getColumnConstraints().addAll(columnConstraints, columnConstraints, columnConstraints, columnConstraints);

        GridPane.setConstraints(addButton, 0, 0);
        GridPane.setConstraints(removeButton, 1, 0);
        GridPane.setConstraints(updateButton, 2, 0);
        GridPane.setConstraints(searchButton, 3, 0);

        layout.getChildren().addAll(addButton, removeButton, updateButton, searchButton);

        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10));

        addButton.setOnAction(e -> addMethod());
        removeButton.setOnAction(e -> System.out.println("Remove button clicked"));
        updateButton.setOnAction(e -> updateMethod());
        searchButton.setOnAction(e -> System.out.println("Search button clicked"));

        Scene scene = new Scene(layout, 700, 500);
        stage1.setScene(scene);

        stage1.show();
    }

    private void addMethod() {

        Stage stage2 = new Stage();
        stage2.setTitle("Add Entry");

        ChoiceBox<String> choice = new ChoiceBox<>();
        choice.getItems().addAll("Student", "Faculty", "Staff");
        choice.setValue("Student");

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
                    hostelite, scholarship, submit,
                    facultyLabel, facultySpecialization, submit,
                    staffLabel, staffDepartment, submit
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

            inputLayout.addRow(8, submit);
        });

        submit.setOnAction(e -> {
            System.out.println("Submit button clicked");
            stage2.close();
        });

        Scene inputScene = new Scene(inputLayout, 400, 400);
        stage2.setScene(inputScene);

        stage2.show();
    }

    private void updateMethod() {
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Entry");

        ChoiceBox<String> entryTypeChoice = new ChoiceBox<>();
        entryTypeChoice.getItems().addAll("Student", "Faculty", "Staff");
        entryTypeChoice.setValue("Student");

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
            updateLayout.getChildren().remove(hostelite);
            updateLayout.getChildren().remove(scholarship);
            updateLayout.getChildren().remove(paymentStatus);
            updateLayout.getChildren().remove(updateButton);

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

            updateLayout.addRow(20, updateButton);
        });

        Scene updateScene = new Scene(updateLayout, 600, 600);
        updateStage.setScene(updateScene);
        updateStage.show();
    }


    private void addFields(GridPane layout, List<TextField> fields, String labelPrefix, String... labels) {
        for (int i = 0; i < labels.length; i++) {
            layout.addRow(2 + i, new Label(labelPrefix + labels[i]), fields.get(i));
        }
    }



}
