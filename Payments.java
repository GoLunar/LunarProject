
import java.sql.Connection;
import java.util.regex.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Payments {
	static int sum = 0;
	static int tuition = 0;

	public static void paymentsdb(String username) throws SQLException {

		Connection connect;
		connect = sqliteConnection.dbconnector();

		String usernameandpassword = "SELECT  credits FROM classesadded inner join classinfo on classesadded.crn = classinfo.crn where classesadded.student=?";
		PreparedStatement prepstate;

		prepstate = connect.prepareStatement(usernameandpassword);
		prepstate.setString(1, username);
		// prepstate.setString(2, password.getText());

		ResultSet reset = prepstate.executeQuery();
		System.out.println(reset);
		if (!reset.isBeforeFirst()) {
			System.out.println("username not found");
			// loginnotsuccess();
			// int crnnum=Integer.parseInt(classcrn.getText())
		}
		sum=0;
		//System.out.println(total);
		while (reset.next()) {

			int c = reset.getInt("credits");
			sum = sum + c;
			
			System.out.println("sum = "+ sum);
		}
		
		prepstate.close();
		connect.close();
		tuition = sum * 12093;
		System.out.println("the sum is :" + tuition + ".00");
		Stage stage1 = new Stage();
		BorderPane root1 = new BorderPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		Label tuition1 = new Label("Your tuition and fees for the following semester is: $" + tuition + ".00");
		Label name = new Label("Enter Name on card:");

		Label cardnum = new Label("Enter card number:");

		Label expdate = new Label("Enter expiration date:");

		Label cvc = new Label("Enter CVV number:");

		TextField tuition2 = new TextField();
		TextField cardnum1 = new TextField();
		cardnum1.setPrefWidth(10);
		String cardnumstr = new String(cardnum1.getText());
		TextField expdate1 = new TextField();
		expdate1.setPrefWidth(2);
		TextField name1 = new TextField();
		name1.setPrefWidth(10);
		TextField cvc1 = new TextField();
		cvc1.setPrefWidth(10);
		VBox vbox = new VBox(100);
		VBox vbox1 = new VBox(100);
		vbox.setPadding(new Insets(10, 50, 50, 50));
		vbox1.getChildren().addAll(name, cardnum, expdate, cvc);
		vbox.getChildren().addAll(name1, cardnum1, expdate1, cvc1);

		vbox1.setPadding(new Insets(10, 50, 50, 50));

		// TextField name1 = new TextField();
		root1.setTop(tuition1);
		BorderPane.setAlignment(tuition1, Pos.CENTER);
		root1.setCenter(vbox);
		root1.setLeft(vbox1);
		vbox.setAlignment(Pos.CENTER); // To align horizontally in the cell
		vbox1.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(vbox1, Pos.CENTER);
		BorderPane.setAlignment(vbox, Pos.CENTER);
		Label classes1 = new Label("Please enter credit card number:");
		TextField classcrn = new TextField();
		TextField classcrnrem = new TextField();
		Button update = new Button("update information");
		root1.setBottom(update);
		BorderPane.setAlignment(update, Pos.CENTER);
		Button rembut = new Button("withdraw class");
		// root1.setHgap(5);
		// root1.set
		GridPane.setConstraints(tuition1, 30, 7);
		// GridPane.setConstraints(name,28,10);
		// GridPane.setConstraints(name1,36,10);
		GridPane.setConstraints(classes1, 41, 20);
		GridPane.setConstraints(classcrnrem, 41, 23);
		GridPane.setConstraints(rembut, 41, 28);
		// GridPane.setHalignment(addbut, HPos.CENTER); // To align horizontally in the
		// cell
		// GridPane.setValignment(addbut, VPos.CENTER);
		GridPane.setHalignment(rembut, HPos.CENTER); // To align horizontally in the cell
		GridPane.setValignment(rembut, VPos.CENTER);
		root1.getChildren().addAll(rembut, classes1, classcrnrem);

		Scene scene = new Scene(root1, 500, 600);
		root1.setId("pane1");
		stage1.setTitle("Class Selection");
		stage1.setScene(scene);
		stage1.show();

		update.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				String str = cardnum1.getText();
				String regex = "[0-9]{16}";
				String regex1 = "[a-zA-Z]+ [a-zA-Z]+";

				// System.out.println(str.matches(regex));
				/*
				 * if(str.matches(regex)==true) { System.out.println("it holds"); }else
				 * System.out.println("it doesnt hold"); cardnumregex(); }
				 */
				String str1 = name1.getText();
				if (str1.matches(regex1)) {
					System.out.println("it holds true now");
				} else {
					System.out.println("it doesnt hold true now");
				}
				String str2 = expdate1.getText();
				String regex2 = "[0-9]{2}/[0-9]{2}";
				/*
				 * if(str2.matches(regex2)) { System.out.println("it holds true forever"); }else
				 * { System.out.println("it doesnt hold true forever"); }
				 */

				String str3 = cvc1.getText();
				String regex3 = "[0-9]{3}";
				if (str3.matches(regex3) == true) {
					System.out.println("it holds true forever1");
				} else {
					System.out.println("it doesnt hold true forever1");
				}

				if (str.matches(regex) == false || str1.matches(regex1) == false || str2.matches(regex2) == false
						|| str3.matches(regex3) == false) {
					cardnumregex();
				}
				if (str.matches(regex) == true && str1.matches(regex1) == true && str2.matches(regex2) == true
						&& str3.matches(regex3) == true) {
					try {
						Connection connect = null;
						connect = sqliteConnection.dbconnector();
						
						String Signupstring = "Insert into payment (name,cardnumber,expdate,cvc)  values(?,?,?,?)";
						PreparedStatement prepstate ;
						
						
						prepstate = connect.prepareStatement(Signupstring);
						
						prepstate.setString(1,name1.getText());
						prepstate.setString(2,cardnum1.getText());
						prepstate.setString(3,expdate1.getText());
						prepstate.setString(4,cvc1.getText());
						//prepstate.setString(5,lname1.getText());
						//int result = prepstate.executeUpdate();
						//System.out.println(password1.getText());
						//connect.commit();
						//prepstate.commit();
						//prepstate.close();
						int resset =prepstate.executeUpdate();
						System.out.println(resset);
						inputsuccess();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.toString());
						e.printStackTrace();
					}
					
					
					
					
					
					
					
					
					stage1.close();
				}

				}
			
		});

	
			}
	public static void cardnumregex() {
		Stage st1 = new Stage();
		BorderPane sp1 = new BorderPane();
		st1.setTitle("input Unsuccesful");
		Label loginacc = new Label("input Unsuccesful");
		Label signupnow = new Label(
				"Please enter the information as example below:\n name: Ronald McDonald\n card number:1234567891234567\n expiration date: 10/18\n CVV: 123");
		loginacc.setTextFill(Color.RED);
		signupnow.setTextFill(Color.RED);
		sp1.setTop(loginacc);
		sp1.setCenter(signupnow);
		BorderPane.setAlignment(loginacc, Pos.CENTER);
		BorderPane.setAlignment(signupnow, Pos.CENTER);
		Scene Bpane = new Scene(sp1, 400, 200);
		Button loginbut = new Button("OK");
		sp1.setBottom(loginbut);
		BorderPane.setAlignment(loginbut, Pos.BASELINE_CENTER);
		sp1.setId("hbox");

		st1.setScene(Bpane);
		st1.show();
		st1.setAlwaysOnTop(true);

		loginbut.setOnAction((ActionEvent event) -> {
			st1.hide();
		});

	}public static void inputsuccess() {
        Stage st1 = new Stage();
        st1.setTitle("Input Succesful");
        BorderPane sp1 = new BorderPane();
        Label loginacc = new Label("Input Succesful");
        HBox login1 = new HBox(loginacc);
        login1.setAlignment(Pos.CENTER);
        Scene Bpane = new Scene(sp1, 200, 100);
        Button loginbut = new Button("OK");
        sp1.setId("hbox");
        sp1.setTop(login1);
        sp1.setCenter(loginbut);
        sp1.setPrefSize(200, 100);
        st1.setScene(Bpane);
        st1.show();
        st1.setAlwaysOnTop(true);

        // ok button action
        loginbut.setOnAction((ActionEvent event) -> {
            st1.hide();

            //this is where the method for the main base page goes,
            //the method should be created in another class called
            //base page or something equivalent.
        });

    }}


