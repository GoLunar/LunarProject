package golunarproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



/*
 * This class is to add casses which can
 * be picked from the database by students
 * for their next semester.
*/
public class classAdd {

	public static void startaddClass() {

		// created labels
		Label crn = new Label("CRN(#####): ");
		Label course = new Label("Course(ex:CSC 1010): ");
		Label credits = new Label("Credits(#): ");
		Label name = new Label("Class Name: ");
		Label time = new Label("Time(#:##am-#:##pm): ");
                Label professor = new Label("Professor(First Last): ");
                Label length = new Label("Length(mm/dd/yy-mm/dd/yy): ");
                Label room = new Label("Room: ");

                

//		// created Font
//		Font f1 = new Font("Arial", 24);
//		fname.setFont(f1);
//		lname.setFont(f1);
//		// email.setTextFill(Color.ANTIQUEWHITE);
//		email.setFont(f1);
//		// username.setTextFill(Color.ANTIQUEWHITE);
//		username.setFont(f1);
//		// password.setTextFill(Color.ANTIQUEWHITE);
//		password.setFont(f1);
//		// Font f2 = new Font();
//                dob.setFont(f1);
//		enroll.setFont(f1);

		Button register = new Button("Add Class");
                

		// created text fields
		TextField crn1 = new TextField();
		TextField course1 = new TextField();
		TextField credit1 = new TextField();
		TextField name1 = new TextField();
		TextField time1 = new TextField();
                TextField professor1 = new TextField();
                TextField length1 = new TextField();
                TextField room1 = new TextField();

		// Window Creation
		Stage stage1 = new Stage();
                
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(23);
		root1.setHgap(5);
                
                //crn allignment
                GridPane.setConstraints(crn, 22, 3);
		GridPane.setConstraints(crn1, 23, 3);
                
                //course allignment
                GridPane.setConstraints(course, 22, 4);
		GridPane.setConstraints(course1, 23, 4);
                
                //credit allignment
                GridPane.setConstraints(credits, 22, 5);
		GridPane.setConstraints(credit1, 23, 5);
                
                //name allignment
                GridPane.setConstraints(name, 22, 6);
		GridPane.setConstraints(name1, 23, 6);
                
                
                //time allignment
                GridPane.setConstraints(time, 22, 7);
		GridPane.setConstraints(time1, 23, 7);
                
                //professor allignment
                GridPane.setConstraints(professor, 22, 8);
		GridPane.setConstraints(professor1, 23, 8);
                
                
                //length allignment
                GridPane.setConstraints(length, 22, 9);
		GridPane.setConstraints(length1, 23, 9);
		
                //room allignment
		GridPane.setConstraints(room, 22, 10);
		GridPane.setConstraints(room1, 23, 10);
                
                
                //register allignment
                GridPane.setConstraints(register, 23, 11);

		root1.getChildren().addAll(crn,crn1,course,course1,credits,credit1,name,name1,time,time1,professor,professor1,length,length1,room,room1,register);
		Scene scene = new Scene(root1, 600, 600);
		root1.setId("pane1");
		// scene.getStylesheets().add("Style.css");
		stage1.setTitle("Add Student Page");
		stage1.setScene(scene);
		stage1.setY(100.0);
		stage1.setX(400.0);
                
		stage1.show();

                
                // database connection
                // that is used to add
                // classes to the database
		register.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("hello world");

                                
				try {
					Connection connect = null;
					connect = sqliteConnection.dbconnector();

                                        
					String Signupstring = "Insert into class values(?,?,?,?,?,?,?,?)";
					PreparedStatement prepstate;

                                        
					prepstate = connect.prepareStatement(Signupstring);

                                        
					prepstate.setString(1, crn1.getText());
					prepstate.setString(2, course1.getText());
					prepstate.setString(3, credit1.getText());
					prepstate.setString(4, name1.getText());
					prepstate.setString(5, time1.getText());
                                        prepstate.setString(6, professor1.getText());
                                        prepstate.setString(7, length1.getText());
                                        prepstate.setString(8, room1.getText());
                                        
                                        
					int result = prepstate.executeUpdate();
					System.out.println(course1.getText());
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

                
	}
        
}
