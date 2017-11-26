package golunarproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */
class financialAidQuestions {
    
    public static void Question(){
        
        // Window Creation
		Stage stage1 = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(5);
                
                
                Label email = new Label("Questions or Concerns regarding your financial aid:");
                TextField emailTextField = new TextField();
                email.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
                emailTextField.setPrefWidth(150);
                emailTextField.setPrefHeight(150);
                grid.add(email,0,1);
                grid.add(emailTextField,0,2);
                
                
                //submit button to prompt term
                Button btn = new Button("Send");
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                hbBtn.getChildren().add(btn);
                grid.add(hbBtn,3,8);
                
                final Text actiontarget = new Text();
                grid.add(actiontarget,0,15);
  
		
		Scene scene = new Scene(grid, 400, 300);
		grid.setId("pane1");
		
                stage1.setTitle("Financial Aid questions");
		stage1.setScene(scene);
		stage1.show();
                
    }
    
}