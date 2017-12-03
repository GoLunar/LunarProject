package golunarproject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
class updateInfos{
    
    
    public static void updateInfo() {
        
        // Window Creation
		Stage stage1 = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(5);
     
        // created labels and text fields
		
                //Label of the Window
                Label sceneTitle = new Label("Update Information");
                sceneTitle.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD, 20));
                
                //First Name
                Label firstName = new Label("First Name:");
                TextField fName = new TextField();
                
                //middle Name
                Label midName = new Label("Middle Name:");
                TextField mName = new TextField();
                
                //lastname
                Label lastName = new Label("Last Name:");
                TextField lName = new TextField();
                
                //address
                Label address = new Label("Address:");
                TextField add = new TextField(); 
                
                //Phone Number
                Label phoneNumber = new Label("Phone Number:");
                TextField pN = new TextField(); 
                
                //email
                Label email = new Label("Email:");
                TextField e = new TextField();
                
                //date of birth
                Label dateofbirth = new Label("Date of Birth:");
                TextField DOB = new TextField(); 
                
                
                //emergency Contact
                Label emergencyContact = new Label("Emergency Contact:");
                emergencyContact.setFont(Font.font("Tahoma",FontWeight.BOLD, 15));
                TextField eCN = new TextField();
             
                Label emergencyContactName = new Label("Name:");
                Label emergencyContactPhoneNumber = new Label("Phone Number:");
                TextField eCPN = new TextField(); 
                
                //Scene Title
                grid.add(sceneTitle,0,0,2,1);
                
                //First Name
                grid.add(firstName,0,1);
                grid.add(fName, 1,1);
                
                //Middle Name
                grid.add(midName,0,2);
                grid.add(mName,1,2);
                
                //Last Name
                grid.add(lastName,0,3);
                grid.add(lName,1,3);
                
                //Address
                grid.add(address,0,4);
                grid.add(add,1,4);
                
                //Phone Number
                grid.add(phoneNumber,0,5);
                grid.add(pN,1,5);
                
                //email
                grid.add(email,0,6);
                grid.add(e,1,6);
                
                //DOB
                grid.add(dateofbirth,0,7);
                grid.add(DOB,1,7);
                
                //Emergency
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
  
		
		Scene scene = new Scene(grid, 400, 600);
		grid.setId("pane1");
		
                stage1.setTitle("Personal Information");
		stage1.setScene(scene);
		stage1.show();
                
                                  
                    
            
                    
                btn.setOnAction(new EventHandler<ActionEvent>() {
			
                    
                    public void handle(ActionEvent event) {
				//System.out.println("hello world");
                                
            

				try {
					actiontarget.setFill(Color.FIREBRICK);
                                           actiontarget.setText("Information Updated");
                                    
                                    
                                        Connection connect = null;
					connect = sqliteConnection.dbconnector();

					String Signupstring = "Insert into UpdateInfo values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement prepstate;

					prepstate = connect.prepareStatement(Signupstring);

					prepstate.setString(1, fName.getText());
					prepstate.setString(2, mName.getText());
					prepstate.setString(3, lName.getText());
					prepstate.setString(4, add.getText());
					prepstate.setString(5, pN.getText());
                                        prepstate.setString(6, e.getText());
					prepstate.setString(7, DOB.getText());
                                        prepstate.setString(8, eCN.getText());
					prepstate.setString(9, eCPN.getText());
                                        
					int result = prepstate.executeUpdate();
				
                                        connect.commit();
					
					prepstate.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
					e.printStackTrace();
				}

				stage1.close();

			}

		});
    }}