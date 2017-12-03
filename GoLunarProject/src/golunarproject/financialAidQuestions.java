package golunarproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		

/*After the send button is pressed 
*it would be sent as an email from the student to the finacial aid office
*Eventually the database would connect to the students email.
*/
                
                stage1.setTitle("Financial Aid questions");
		stage1.setScene(scene);
		stage1.show();
                
                //This would be how it connects to a database that would pull the students email
                //send to financial aid services
//              btn.setOnAction(new EventHandler<ActionEvent>() {
//			
//                    
//                    public void handle(ActionEvent event) {
//				//System.out.println("hello world");
//                                
//            
//
//				try {
//					actiontarget.setFill(Color.FIREBRICK);
//                                           actiontarget.setText("Information Updated");
//                                    
//                                    
//                                        Connection connect = null;
//					connect = sqliteConnection.dbconnector();
//
//					String Signupstring = "Insert into UpdateInfo values(?,?,?,?,?,?,?,?,?)";
//					PreparedStatement prepstate;
//
//					prepstate = connect.prepareStatement(Signupstring);
//
//					prepstate.setString(1, fName.getText());
//					prepstate.setString(2, mName.getText());
//					prepstate.setString(3, lName.getText());
//					prepstate.setString(4, add.getText());
//					prepstate.setString(5, pN.getText());
//                                      prepstate.setString(6, e.getText());
//					prepstate.setString(7, DOB.getText());
//                                        prepstate.setString(8, eCN.getText());
//					prepstate.setString(9, eCPN.getText());
//                                        
//					int result = prepstate.executeUpdate();
//				
//                                        connect.commit();
//					
//					prepstate.close();
//
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					System.out.println(e.toString());
//					e.printStackTrace();
//				}
//
//				stage1.close();
//
//			}
//
//		});
//    }}
                
    }
    
}