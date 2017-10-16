
package golunarproject;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author igold
 */
public class AddDrop {

    public static void AddDrop() {
        
        // Window Creation
		Stage stage1 = new Stage();
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(10);
		root1.setHgap(5);
     
        // created labels
		Label termSelect = new Label("Select a Term: ");

        // combo box for selecting terms
                final ComboBox emailComboBox = new ComboBox();
                emailComboBox.getItems().addAll(
                    "Spring Semester 2018",
                    "Summer 2018"
                );
                
                emailComboBox.setPromptText("Select a Term");       
//        emailComboBox.valueProperty().addListener(new ChangeListener<String>() {
//            @Override 
//            public void changed(ObservableValue ov, String t, String t1) {                
//                address = t1;                
//            }    
//        });

        //submit button to prompt term
                Button submit = new Button();
                submit.setText("Submit");
                
        //alligns fields, buttons, labels
		GridPane.setConstraints(termSelect, 10, 5);
                GridPane.setConstraints(emailComboBox, 11, 5);
                GridPane.setConstraints(submit, 11, 7);
                
                


		root1.getChildren().addAll(termSelect, emailComboBox, submit);
		Scene scene = new Scene(root1, 400, 200);
		root1.setId("pane1");
		stage1.setTitle("Select a Term");
		stage1.setScene(scene);
		
		stage1.show();
                submit.setOnAction((ActionEvent e) -> {
                    if (emailComboBox.getValue() != null && !emailComboBox.getValue().toString().isEmpty()){
                        Classes();
                        stage1.hide();
                    }
                });
    }
    
    
    public static void Classes(){
        // Window Creation
		Stage stage1 = new Stage();
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(10);
		root1.setHgap(5);
     

		root1.getChildren().addAll();
		Scene scene = new Scene(root1, 800, 600);
		root1.setId("pane1");
		stage1.setTitle("Class Selection");
		stage1.setScene(scene);
		
		stage1.show();
    }
    
}
