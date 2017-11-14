import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

		// created Font
		Font f1 = new Font("Arial", 24);
		fname.setFont(f1);
		lname.setFont(f1);
		// email.setTextFill(Color.ANTIQUEWHITE);
		email.setFont(f1);
		// username.setTextFill(Color.ANTIQUEWHITE);
		username.setFont(f1);
		// password.setTextFill(Color.ANTIQUEWHITE);
		password.setFont(f1);
		// Font f2 = new Font();

		Button register = new Button("Register Student");

		// created text fields
		TextField username1 = new TextField();
		TextField password1 = new TextField();
		TextField email1 = new TextField();
		TextField fname1 = new TextField();
		TextField lname1 = new TextField();

		// Window Creation
		Stage stage1 = new Stage();
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(23);
		root1.setHgap(5);

		GridPane.setConstraints(fname, 22, 5);
		GridPane.setConstraints(fname1, 23, 5);
		GridPane.setConstraints(lname, 22, 7);
		GridPane.setConstraints(lname1, 23, 7);
		GridPane.setConstraints(email, 22, 9);
		GridPane.setConstraints(email1, 23, 9);
		GridPane.setConstraints(username, 22, 11);
		GridPane.setConstraints(username1, 23, 11);
		GridPane.setConstraints(password, 22, 13);
		GridPane.setConstraints(password1, 23, 13);
		GridPane.setConstraints(register, 23, 15);

		root1.getChildren().addAll(fname, fname1, lname, lname1, email, email1, username, username1, password,
				password1, register);
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

					String Signupstring = "Insert into School values(?,?,?,?,?)";
					PreparedStatement prepstate;

					prepstate = connect.prepareStatement(Signupstring);

					prepstate.setString(1, username1.getText());
					prepstate.setString(2, password1.getText());
					prepstate.setString(3, email1.getText());
					prepstate.setString(4, fname1.getText());
					prepstate.setString(5, lname1.getText());
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
