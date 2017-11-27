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
class refundOption {

    public static void refund() {
        
        // Window Creation
		Stage stage1 = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(5);
                
                
                Label pantheraccountrefund = new Label("Panther Account");
                pantheraccountrefund.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
                grid.add(pantheraccountrefund,0,1);
                
                Label personalaccountrefund = new Label("Personal Bank Account");
                personalaccountrefund.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
                grid.add(personalaccountrefund,0,4);
                
                Label mail = new Label("Personal Check in the Mail");
                mail.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
                grid.add(mail,0,7);
                
                
                
                //select button to prompt term
                Button pantheraccountrefundbtn = new Button("Select");
                HBox BtnOne = new HBox(10);
                BtnOne.getChildren().add(pantheraccountrefundbtn);
                grid.add(BtnOne,4,1);
                
                Button personalaccountrefundbtn = new Button("Select");
                HBox BtnTwo = new HBox(10);
                BtnTwo.getChildren().add(personalaccountrefundbtn);
                grid.add(BtnTwo,4,4);
                
                Button mailbtn = new Button("Select");
                HBox BtnThree = new HBox(10);
                BtnThree.getChildren().add(mailbtn);
                grid.add(BtnThree,4,7);
                
                
  
		
		Scene scene = new Scene(grid, 400, 300);
		grid.setId("pane1");
		
                stage1.setTitle("Refund Option");
		stage1.setScene(scene);
		stage1.show();
                
    }
    

}
