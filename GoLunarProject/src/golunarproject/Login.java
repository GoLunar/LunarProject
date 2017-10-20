package golunarproject;

import golunarproject.sqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
	String dbUsername, dbPassword;
        private ComboBox userS = new ComboBox();
	public static void main(String args[]) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage){
	
		primaryStage.setTitle("Login");

		// all created labels
		Label loginpage = new Label("Login Page");
		Label usernamelabel = new Label("Username: ");
		Label passwordlabel = new Label("Password: ");
		Font f1 = new Font("Arial", 24);
		usernamelabel.setFont(f1);
		passwordlabel.setFont(f1);
		loginpage.setFont(f1);


		// all created textfields

		TextField username = new TextField();
		TextField password = new TextField();

		// login button
		Button login = new Button("login");

                //combo box
                
                userS.getItems().addAll(
                    "Admin",
                    "Student"
                );
                
                userS.setPromptText("Select User");  

		// gridpane layout
		GridPane root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(10);
		root.setHgap(5);
                
		GridPane.setConstraints(loginpage, 19, 0);
		GridPane.setConstraints(usernamelabel, 15, 25);
		GridPane.setConstraints(username, 16, 25);
		GridPane.setConstraints(passwordlabel, 15, 27);
		GridPane.setConstraints(password, 16, 27);
		GridPane.setConstraints(login, 16, 30);
                GridPane.setConstraints(userS, 16, 28);

		root.setId("pane");
		root.getChildren().addAll(loginpage, username, usernamelabel, passwordlabel, password, login, userS);
		Scene scene = new Scene(root, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();

		login.setOnAction((ActionEvent event) -> {
                    try {
                        
                        Connection connect;
                        connect = sqliteConnection.dbconnector();
                        
                        String usernameandpassword = "SELECT * from School where username = ? and password= ?";
                        PreparedStatement prepstate;
                        
                        prepstate = connect.prepareStatement(usernameandpassword);
                        prepstate.setString(1, username.getText());
                        prepstate.setString(2, password.getText());
                        
                        ResultSet reset = prepstate.executeQuery();
                        if (!reset.isBeforeFirst()) {
                            System.out.println("username not found");
                            loginnotsuccess();
                        }
                        
                        while (reset.next()) {
                            dbUsername = reset.getString("username");
                            dbPassword = reset.getString("password");
                            
                            if (dbUsername.equals(username.getText()) && dbPassword.equals(password.getText())) {
                                loginsuccess();
                                System.out.println("Username and Password is Correct");
                                
                                
                                switch ((this.userS.getValue()).toString()){
                                    case "Admin":                
                                        AdminMenu.startA();
                                        break;
                                    case "Student":
                                        StudentMenu.start();
                                        break;
                                }

                                primaryStage.hide();
                                
                            }
                        }
                        
                    }
                    
                    catch (SQLException e) {
                    }
                });

	}
        
       

	public void loginsuccess() {
		Stage st1 = new Stage();
		st1.setTitle("Login Succesful");
		BorderPane sp1 = new BorderPane();
		Label loginacc = new Label("Login Succesful");
		HBox login1 = new HBox(loginacc);
		login1.setAlignment(Pos.CENTER);
		Scene Bpane = new Scene(sp1,200,100);
		Button loginbut = new Button("OK");
		sp1.setId("hbox");
		sp1.getStylesheets().add("Style.css");
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
	
	
	
		
		
}

public void loginnotsuccess() {
	Stage st1 = new Stage();
	BorderPane sp1 = new BorderPane();
	st1.setTitle("Login Unsuccesful");
	Label loginacc = new Label("Login Unsuccesful");
	Label signupnow = new Label("Username/Password is incorrect.");
	loginacc.setTextFill(Color.RED);
	signupnow.setTextFill(Color.RED);
	sp1.setTop(loginacc);
	sp1.setCenter(signupnow);
	BorderPane.setAlignment(loginacc,Pos.CENTER);
	BorderPane.setAlignment(signupnow, Pos.CENTER);
	Scene Bpane = new Scene(sp1,400,200);
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
	
}}
