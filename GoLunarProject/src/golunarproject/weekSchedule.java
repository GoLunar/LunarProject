


import static golunarproject.AddDrop.Classes;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class weekSchedule {

    public static void weekSchedule() {
        // Window Creation
        Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        // created labels
        Label termSelect = new Label("Select a Term: ");

        // combo box for selecting terms
        final ComboBox termBox = new ComboBox();
        termBox.getItems().addAll(
                "Spring Semester 2018",
                "Summer 2018"
        );

        termBox.setPromptText("Select a Term");

        Button submit = new Button();
        submit.setText("Submit");

        //alligns fields, buttons, labels
        GridPane.setConstraints(termSelect, 10, 5);
        GridPane.setConstraints(termBox, 11, 5);
        GridPane.setConstraints(submit, 11, 7);

        root1.getChildren().addAll(termSelect, termBox, submit);
        Scene scene = new Scene(root1, 400, 200);
        root1.setId("pane1");
        stage1.setTitle("Select a Term");
        stage1.setScene(scene);

        stage1.show();

        //basically triggers button actions and also hides the term window.
        submit.setOnAction((ActionEvent e) -> {
            if (termBox.getValue() != null && !termBox.getValue().toString().isEmpty()) {
                Classes();
                stage1.hide();
            }
        });

    }

    public static void lookup() {
        // Window Creation
        Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        root1.getChildren().addAll();
        Scene scene = new Scene(root1, 800, 600);
        root1.setId("pane1");
        stage1.setTitle("Weekly Schedule");
        stage1.setScene(scene);

        stage1.show();
    }
}
