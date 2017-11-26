package golunarproject;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */
class updateInfos {
    
    
    public static void updateInfo() {
        
        // Window Creation
		Stage stage1 = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(5);
     
        // created labels and text fields
		Label sceneTitle = new Label("Update Information");
                sceneTitle.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD, 20));
                Label firstName = new Label("First Name:");
                TextField fName = new TextField();
                Label midName = new Label("Middle Name:");
                TextField mName = new TextField();
                Label lastName = new Label("Last Name:");
                TextField lName = new TextField();
                Label address = new Label("Address:");
                TextField add = new TextField(); 
                Label phoneNumber = new Label("Phone Number:");
                TextField pN = new TextField(); 
                Label email = new Label("Email:");
                TextField e = new TextField();
                Label altEmail = new Label("Alternative Email");
                TextField aE = new TextField(); 
                Label emergencyContact = new Label("Emergency Contact:");
                emergencyContact.setFont(Font.font("Tahoma",FontWeight.BOLD, 15));
                Label emergencyContactName = new Label("Name:");
                Label emergencyContactPhoneNumber = new Label("Phone Number:");
                TextField eCN = new TextField(); 
                TextField eCPN = new TextField(); 
                
                
                grid.add(sceneTitle,0,0,2,1);
                grid.add(firstName,0,1);
                grid.add(fName, 1,1);
                grid.add(midName,0,2);
                grid.add(mName,1,2);
                grid.add(lastName,0,3);
                grid.add(lName,1,3);
                grid.add(address,0,4);
                grid.add(add,1,4);
                grid.add(phoneNumber,0,5);
                grid.add(pN,1,5);
                grid.add(email,0,6);
                grid.add(e,1,6);
                grid.add(altEmail,0,7);
                grid.add(aE,1,7);
                grid.add(emergencyContact,0,8);
                grid.add(emergencyContactName,0,9);
                grid.add(emergencyContactPhoneNumber,0,10);
                grid.add(eCN,1,9);
                grid.add(eCPN,1,10);
                
                
                
                grid.setGridLinesVisible(false);
                
        //submit button to prompt term
                Button btn = new Button("Update");
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                hbBtn.getChildren().add(btn);
                grid.add(hbBtn,1,15);
                
                final Text actiontarget = new Text();
                grid.add(actiontarget,0,15);
  
		
		Scene scene = new Scene(grid, 350, 490);
		grid.setId("pane1");
		
                stage1.setTitle("Personal Information");
		stage1.setScene(scene);
		stage1.show();
                
                btn.setOnAction(event -> {
                   actiontarget.setFill(Color.FIREBRICK);
                   actiontarget.setText("Information Updated");
                });
    }
    
}
