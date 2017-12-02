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

public class teacherAdd {

	public static void startaddTeacher() {

		// created labels
		Label username = new Label("Username: ");
		Label password = new Label("Password: ");
		Label crn = new Label("CRN: ");
		Label crn2 = new Label("CRN 2: ");
		Label crn3 = new Label("CRN 3: ");


                
                

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

		Button register = new Button("Register Teacher");
                
                //creates a date table to pick dates from
                DatePicker dob1 = new DatePicker();
                DatePicker enroll2 = new DatePicker();

		// created text fields
		TextField username1 = new TextField();
		TextField password1 = new TextField();
		TextField crn11 = new TextField();
		TextField crn22 = new TextField();
		TextField crn33 = new TextField();


		// Window Creation
		Stage stage1 = new Stage();
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(23);
		root1.setHgap(5);
                
                

                GridPane.setConstraints(username, 22, 4);
		GridPane.setConstraints(username1, 23, 4);
		GridPane.setConstraints(password, 22, 5);
		GridPane.setConstraints(password1, 23, 5);
                
		GridPane.setConstraints(crn, 22, 6);
		GridPane.setConstraints(crn11, 23, 6);
		GridPane.setConstraints(crn2, 22, 7);
		GridPane.setConstraints(crn22, 23, 7);
		GridPane.setConstraints(crn3, 22, 8);
		GridPane.setConstraints(crn33, 23, 8);
                
		
                GridPane.setConstraints(register, 23, 9);

		root1.getChildren().addAll(username, username1, password, password1, register, crn2, crn22, crn3, crn33, crn, crn11);
		Scene scene = new Scene(root1, 600, 600);
		root1.setId("pane1");
		// scene.getStylesheets().add("Style.css");
		stage1.setTitle("Add Teacher Page");
		stage1.setScene(scene);
		stage1.setY(100.0);
		stage1.setX(400.0);
		stage1.show();

		register.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("hello world");

				try {
					Connection connect = null;
					connect = sqliteConnection.dbconnector();

					String Signupstring = "Insert into Teacher values(?,?,?,?,?)";
					PreparedStatement prepstate;

					prepstate = connect.prepareStatement(Signupstring);

					prepstate.setString(1, username1.getText());
					prepstate.setString(2, password1.getText());
					prepstate.setString(3, crn11.getText());
					prepstate.setString(4, crn22.getText());
					prepstate.setString(5, crn33.getText());

                                        
					int result = prepstate.executeUpdate();
					System.out.println(password1.getText());
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
