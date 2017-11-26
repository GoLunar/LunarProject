package golunarproject;


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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
* Login class starts the application and calls the primary stage
* which will prompt two buttons which says admin or student
* Clicking on the options will bring their respective menus. 
* Typing in username and password will access database then return
* the menu for the respective login.
*/

public class Login extends Application {
// string to store username and database entered by the user
    String dbUsername, dbPassword;
//  private final ComboBox userS = new ComboBox();
    
// button for login
    Button login = new Button("login");
//textfield for username and password
    TextField username = new TextField();
    PasswordField password = new PasswordField();

    
    
    /*
    * Main method of the program calls launch 
    * orgs to start the gui
    */   
    public static void main(String args[]) {
        launch(args);
    }

    
    
    
   /*
    * starts the primary stage and sets up all the layout
    * for all functions
    */

    @Override
    public void start(Stage primaryStage) {
        //stops resizing function for stage
        primaryStage.setResizable(false);
        
        //gridpane layout
        GridPane root1 = new GridPane();
        root1.setAlignment(Pos.CENTER);

        // necessary buttons for student/admin
        Button studentx = new Button("Student Login");
        Button adminx = new Button("Admin Login");

        //font size and type change
        studentx.setStyle("-fx-font-size: 11pt;");
        adminx.setStyle("-fx-font-size: 11pt;");
        
        //gridpane constraint to allign layout
        GridPane.setConstraints(studentx, 0, 2);
        GridPane.setConstraints(adminx, 0, 4);
        
        //vertical box for vertical allignment within gridpane
        VBox vbox = new VBox();
        vbox.setPrefWidth(130);
        vbox.setSpacing(10);
        
        //vertical box configuration with width
        studentx.setMinWidth(vbox.getPrefWidth());
        adminx.setMinWidth(vbox.getPrefWidth());
        
        //ading buttons to the vertical box
        vbox.getChildren().addAll(studentx, adminx);
        
        //adding vertical box to gridpane
        root1.getChildren().addAll(vbox);
        
        //adding gridpane to scene
        Scene scene = new Scene(root1, 400, 300);
        
        //name of panel
        root1.setId("pane1");
        
        //name of primary stage
        primaryStage.setTitle("GoLunar");
        primaryStage.setScene(scene);

        primaryStage.show();

        studentx.setOnAction((ActionEvent event) -> {
            studentLog();
            primaryStage.close();
        });

        adminx.setOnAction((ActionEvent event) -> {
            adminLog();
            primaryStage.close();
        });

    }
    
    
/*
* This method/function checks to see if the username and password
* entered is correct. If Correct it will call the respective menu.
* Student menu for students, admin menu for admins, etc.
*/
    public void loginsuccess() {
        
        //makes a stage for login success gui alert
        Stage st1 = new Stage();
        
        //stops resizing function for stage
        st1.setResizable(false);
        
        //name of stage
        st1.setTitle("Login Succesful");
        
        //borderpane layout used
        BorderPane sp1 = new BorderPane();
        Label loginacc = new Label("Login Succesful");
        
        //horizontal box used to allign
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

             /*
             *this is where the method for the main base page goes,
             *the method should be created in another class called
             *base page or something equivalent.
             */
        });

    }
    
    
/*
* This method/function checks to see if the username and password
* entered is incorrect. If Correct it will call the respective menu, else.
* It triggers the menu to re enter password and username.
* Student menu for students, admin menu for admins, etc.
*/
    public void loginnotsuccess() {
        Stage st1 = new Stage();
        st1.setResizable(false);
        
        
        BorderPane sp1 = new BorderPane();
        
        
        st1.setTitle("Login Unsuccesful");
        Label loginacc = new Label("Login Unsuccesful");
        Label signupnow = new Label("Username/Password is incorrect.");
        
        
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

    }
    
    
/*
* When the first scene promps for student or admin menu,
* picking admin will call this method/function/gui.
* This function will only accept admin username and password.
* Typing student username and pass will prompt an error message,
* then ask to type it again.
*/
    private void adminLog() {
        
        Stage Stage1 = new Stage();
        Stage1.setResizable(false);
        Stage1.setTitle("Login");

        // all created labels
        Label loginpage = new Label("Admin Login Page");
        
        Label usernamelabel = new Label("Username: ");
        Label passwordlabel = new Label("Password: ");
        
        Font f1 = new Font("Arial", 16);
        
        usernamelabel.setFont(f1);
        passwordlabel.setFont(f1);
        loginpage.setFont(f1);

        // gridpane layout
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);
        
        // gridpane constraints for alligning layout
        GridPane.setConstraints(loginpage, 5, 1);
        GridPane.setConstraints(usernamelabel, 5, 3);
        GridPane.setConstraints(username, 6, 3);
        GridPane.setConstraints(passwordlabel, 5, 4);
        GridPane.setConstraints(password, 6, 4);
        GridPane.setConstraints(login, 6, 5);

        root.setId("pane");
        root.getChildren().addAll(loginpage, username, usernamelabel, passwordlabel, password, login);
        Scene scene = new Scene(root, 400, 200);

        Stage1.setScene(scene);
        Stage1.show();

        login.setOnAction((ActionEvent event) -> {
            try {

                Connection connect;
                connect = sqliteConnection.dbconnector();

                String usernameandpassword = "SELECT * from Admin where username = ? and password= ?";
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

                        AdminMenu.startA(dbUsername);

                        Stage1.hide();

                    }
                }
            } catch (SQLException e) {
            }
        });

    }
    
    
/*
* When the first scene promps for student or admin menu,
* picking studentwill call this method/function/gui.
* This function will only accept student username and password.
* Typing admin username and pass will prompt an error message,
* then ask to type it again.
*/
    private void studentLog() {
        Stage Stage1 = new Stage();
        Stage1.setResizable(false);
        Stage1.setTitle("Login");

        // all created labels
        Label loginpage = new Label("Student Login page");
        Label usernamelabel = new Label("Username: ");
        Label passwordlabel = new Label("Password: ");
        
        Font f1 = new Font("Arial", 16);
        
        usernamelabel.setFont(f1);
        passwordlabel.setFont(f1);
        loginpage.setFont(f1);

        // gridpane layout
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);

        GridPane.setConstraints(loginpage, 5, 1);
        GridPane.setConstraints(usernamelabel, 5, 3);
        GridPane.setConstraints(username, 6, 3);
        GridPane.setConstraints(passwordlabel, 5, 4);
        GridPane.setConstraints(password, 6, 4);
        GridPane.setConstraints(login, 6, 5);

        root.setId("pane");
        root.getChildren().addAll(loginpage, username, usernamelabel, passwordlabel, password, login);
        Scene scene = new Scene(root, 400, 200);

        Stage1.setScene(scene);
        Stage1.show();

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
                        	StudentMenu sm=new StudentMenu();
                        sm.start(dbUsername);

                        Stage1.hide();

                    }
                }

            } catch (SQLException e) {
            }
        });

    }
}



