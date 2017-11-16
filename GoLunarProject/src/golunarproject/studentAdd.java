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

public class studentAdd {

	public static void startaddStudent() {

		// created labels
		Label username = new Label("Username: ");
		Label password = new Label("Password: ");
		Label email = new Label("Email Address: ");
		Label fname = new Label("First Name: ");
		Label lname = new Label("Last Name: ");
                Label dob = new Label("Date of Birth: ");
                Label enroll = new Label("Enrollment Date: ");
                Label phone = new Label("Phone Number: ");
                Label emergencyPhone = new Label("Emergency Contact: ");
                

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

		Button register = new Button("Register Student");
                
                //creates a date table to pick dates from
                DatePicker dob1 = new DatePicker();
                DatePicker enroll2 = new DatePicker();

		// created text fields
		TextField username1 = new TextField();
		TextField password1 = new TextField();
		TextField email1 = new TextField();
		TextField fname1 = new TextField();
		TextField lname1 = new TextField();
                TextField phone1 = new TextField();
		TextField emergencyPhone1 = new TextField();

		// Window Creation
		Stage stage1 = new Stage();
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(23);
		root1.setHgap(5);
                
                
                GridPane.setConstraints(enroll, 22, 3);
		GridPane.setConstraints(enroll2, 23, 3);
		GridPane.setConstraints(fname, 22, 4);
		GridPane.setConstraints(fname1, 23, 4);
		GridPane.setConstraints(lname, 22, 5);
		GridPane.setConstraints(lname1, 23, 5);
		GridPane.setConstraints(email, 22, 6);
		GridPane.setConstraints(email1, 23, 6);
		GridPane.setConstraints(username, 22, 7);
		GridPane.setConstraints(username1, 23, 7);
		GridPane.setConstraints(password, 22, 8);
		GridPane.setConstraints(password1, 23, 8);
                GridPane.setConstraints(phone, 22, 9);
		GridPane.setConstraints(phone1, 23, 9);
                GridPane.setConstraints(emergencyPhone, 22, 10);
		GridPane.setConstraints(emergencyPhone1, 23, 10);
                GridPane.setConstraints(dob, 22, 11);
		GridPane.setConstraints(dob1, 23, 11);
                GridPane.setConstraints(register, 23, 14);

		root1.getChildren().addAll(enroll, enroll2, fname, fname1, lname, lname1, email, email1, username, username1, password, password1, phone, phone1, emergencyPhone, emergencyPhone1, dob, dob1, register);
		Scene scene = new Scene(root1, 800, 600);
		root1.setId("pane1");
		// scene.getStylesheets().add("Style.css");
		stage1.setTitle("Add Student Page");
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

					String Signupstring = "Insert into School values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement prepstate;

					prepstate = connect.prepareStatement(Signupstring);

					prepstate.setString(1, username1.getText());
					prepstate.setString(2, password1.getText());
					prepstate.setString(3, email1.getText());
					prepstate.setString(4, fname1.getText());
					prepstate.setString(5, lname1.getText());
                                        prepstate.setString(6, phone1.getText());
					prepstate.setString(7, emergencyPhone1.getText());
                                        prepstate.setString(8, ((TextField)dob1.getEditor()).getText());
					prepstate.setString(9, ((TextField)enroll2.getEditor()).getText());
                                        
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
