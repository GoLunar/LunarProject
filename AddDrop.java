


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Sadat
 */
public class AddDrop {
	public static ObservableList<ObservableList> data;
    public static TableView tableview;
    public static void AddDrop(String username) {

        // Window Creation
        Stage stage1 = new Stage();
        stage1.setResizable(false);
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        // created labels
        /*Label termSelect = new Label("Select a Term: ");

        // combo box for selecting terms
        //final ComboBox termBox = new ComboBox();
        //termBox.getItems().addAll(
          //      "Spring Semester 2018",
          //      "Summer 2018"
       // );

        //termBox.setPromptText("Select a Term");

        //submit button to prompt term
        Button submit = new Button();
        submit.setText("Submit");

        //alligns fields, buttons, labels
        //GridPane.setConstraints(termSelect, 10, 5);
        //GridPane.setConstraints(termBox, 11, 5);
       // GridPane.setConstraints(submit, 11, 7);

        //root1.getChildren().addAll(termSelect, termBox, submit);
        Scene scene = new Scene(root1, 400, 200);
        root1.setId("pane1");
        stage1.setTitle("Select a Term");
        stage1.setScene(scene);

        stage1.show();

        //basically triggers button actions and also hides the term window.
        submit.setOnAction((ActionEvent e) -> {
            if (termBox.getValue() != null && !termBox.getValue().toString().isEmpty()) {
                Classes();
                stage1.hide();
            }
        });
    }

   

}*/
    Classes(username);
    
    
    }
    public static void Classes(String username) {
        // Window Creation
        Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        Label classes = new Label("Please enter course number of the class you wish to add");
        Label classes1 = new Label("Please enter course number of the class you wish to withdraw");
        TextField classcrn = new TextField();
        TextField classcrnrem = new TextField();
        Button addbut = new Button("add class");
        Button rembut = new Button("withdraw class");
        root1.setHgap(5);
        root1.setVgap(10);
        GridPane.setConstraints(classes, 41, 7);
        GridPane.setConstraints(classcrn,41,10);
        GridPane.setConstraints(addbut,41,15);
        GridPane.setConstraints(classes1,41,20);
        GridPane.setConstraints(classcrnrem,41,23);
        GridPane.setConstraints(rembut,41,28);
        GridPane.setHalignment(addbut, HPos.CENTER); // To align horizontally in the cell
        GridPane.setValignment(addbut, VPos.CENTER);
        GridPane.setHalignment(rembut, HPos.CENTER); // To align horizontally in the cell
        GridPane.setValignment(rembut, VPos.CENTER);
       root1.getChildren().addAll(classes,classcrn,addbut,rembut,classes1,classcrnrem);
       
        Scene scene = new Scene(root1, 800, 600);
        root1.setId("pane1");
        stage1.setTitle("Class Selection");
        stage1.setScene(scene);
        stage1.show();
        
        addbut.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("hello world");
				
				
				
				
				try {
					Connection connect = null;
					connect = sqliteConnection.dbconnector();
					
					String Signupstring = "select * from class where crn=?";
					PreparedStatement prepstate ;
					
					
					prepstate = connect.prepareStatement(Signupstring);
					prepstate.setString(1, classcrn.getText());
				    ResultSet resset = prepstate.executeQuery();
					
					if (!resset.isBeforeFirst()) {
						System.out.println("class not accepted");
						classnotaccepted();
					}
					while (resset.next()) {
						int crnnum = resset.getInt("crn");
						prepstate.close();

						if (crnnum==Integer.parseInt(classcrn.getText()));{

							System.out.println("class is accepted");
							classaccepted();
							
							
							String insertclass = "REPLACE INTO classesadded (crn,student) Values (?,?)";
						  
						    System.out.println("yea it works ," +crnnum +" "+username);
						    try {
						    	Connection conn=connect;
						 
						    PreparedStatement prepstate1 ;
						    prepstate1 = conn.prepareStatement(insertclass); 
						    prepstate1.setInt(1, crnnum);
						    prepstate1.setString(2, username);
							int result =prepstate1.executeUpdate();
							System.out.println(result);
							prepstate1.close();
						    }
						    catch(SQLException e){
						    		System.out.println(e.getMessage());;
						    }
						}
						
					}
					//connect.commit();
					prepstate.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
					e.printStackTrace();
				}
			
        
				
		    	
		    	
			
		
			
			
			
			
			}
			});
        
        rembut.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("hello world");
				
				
				
				
				try {
					Connection connect = null;
					connect = sqliteConnection.dbconnector();
					
					String Signupstring = "select * from class where crn=?";
					PreparedStatement prepstate ;
					
					
					prepstate = connect.prepareStatement(Signupstring);
					prepstate.setString(1, classcrnrem.getText());
				    ResultSet resset = prepstate.executeQuery();
					
					if (!resset.isBeforeFirst()) {
						System.out.println("class not accepted");
						classnotaccepted();
					}
					while (resset.next()) {
						int crnnum = resset.getInt("crn");
						prepstate.close();

						if (crnnum==Integer.parseInt(classcrnrem.getText()));{

							System.out.println("class is accepted");
							classremoved();
							
							
							String insertclass = "Delete from classesadded where crn=? and student=?";
						  
						    System.out.println("yea it works ," +crnnum +" "+username);
						    try {
						    	Connection conn=connect;
						 
						    PreparedStatement prepstate1 ;
						    prepstate1 = conn.prepareStatement(insertclass); 
						    prepstate1.setInt(1, crnnum);
						    prepstate1.setString(2, username);
							int result =prepstate1.executeUpdate();
							System.out.println(result);
							prepstate1.close();
							String Signupstring1 = "Insert into withdraw values(?,?)";
							PreparedStatement prepstate2 ;
							
							
							prepstate2 = connect.prepareStatement(Signupstring1);
							
							prepstate2.setInt(1,crnnum);
							prepstate2.setString(2,username);
							int result1 =prepstate2.executeUpdate();
							
						    }
						    catch(SQLException e){
						    		System.out.println(e.getMessage());;
						    }
						}
						
					}
					
					
					
					
					
					
					
					
					//connect.commit();
					prepstate.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
					e.printStackTrace();
				}
			
        
				
		    	
		    	
			
		
			
			
			
			
			}
			});









}public static void classaccepted() {
    Stage st1 = new Stage();
    st1.setTitle("class accepted");
    BorderPane sp1 = new BorderPane();
    Label loginacc = new Label("class accepted");
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
    });

}public static void classnotaccepted() {
    Stage st1 = new Stage();
    BorderPane sp1 = new BorderPane();
    st1.setTitle("class not accepted");
    Label loginacc = new Label("class not accepted");
    Label signupnow = new Label("CRN number is incorrect");
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
public static void classremoved() {
    Stage st1 = new Stage();
    st1.setTitle("class removed");
    BorderPane sp1 = new BorderPane();
    Label loginacc = new Label("class removed");
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
    });










}}
