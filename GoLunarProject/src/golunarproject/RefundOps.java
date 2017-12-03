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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RefundOps {
	static ChoiceBox<String> cb = new ChoiceBox();
	
	public RefundOps() {
		//cb.getItems().addAll("Lunar Card","Direct Deposit","Paper Check");
		//cb.setValue("Lunar Card");
	}
	public static void refundOps(String username) {

//This is an option we might use in the future, where user just selects a button to choose the refund option.
//            // Window Creation
//		Stage stage1 = new Stage();
//		GridPane grid = new GridPane();
//		grid.setPadding(new Insets(10, 10, 10, 10));
//		grid.setVgap(10);
//		grid.setHgap(5);
//                
//                
//                Label pantheraccountrefund = new Label("Panther Account");
//                pantheraccountrefund.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
//                grid.add(pantheraccountrefund,0,1);
//                
//                Label personalaccountrefund = new Label("Personal Bank Account");
//                personalaccountrefund.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
//                grid.add(personalaccountrefund,0,4);
//                
//                Label mail = new Label("Personal Check in the Mail");
//                mail.setFont(Font.font("Tahoma",FontWeight.BOLD,12));
//                grid.add(mail,0,7);
//                
//                
//                
//                //select button to prompt term
//                Button pantheraccountrefundbtn = new Button("Select");
//                HBox BtnOne = new HBox(10);
//                BtnOne.getChildren().add(pantheraccountrefundbtn);
//                grid.add(BtnOne,4,1);
//                
//                Button personalaccountrefundbtn = new Button("Select");
//                HBox BtnTwo = new HBox(10);
//                BtnTwo.getChildren().add(personalaccountrefundbtn);
//                grid.add(BtnTwo,4,4);
//                
//                Button mailbtn = new Button("Select");
//                HBox BtnThree = new HBox(10);
//                BtnThree.getChildren().add(mailbtn);
//                grid.add(BtnThree,4,7);
//                
//                
//  
//		
//		Scene scene = new Scene(grid, 400, 300);
//		grid.setId("pane1");
//		
//                stage1.setTitle("Refund Option");
//		stage1.setScene(scene);
//		stage1.show();
//



//cb.getItems().add(null);
		cb.getItems().clear();
		cb.getSelectionModel().getSelectedItem();
		cb.getItems().addAll("Lunar Card","Direct Deposit","Paper Check");
		cb.setValue("Lunar Card");
		Stage stage1 = new Stage();
	
	stage1.setTitle("Refund Options");
	Label ref = new Label("Refund Options");
	//bp1.setTop(ref);
	Font font = new Font("Arial",24);
	ref.setFont(font);
	BorderPane bp1 = new BorderPane();
	Scene Bpane = new Scene(bp1,800,600);
	stage1.setScene(Bpane);
	stage1.show();
	Label lab = new Label("If your student account shows a credit balance, you may be entitled to receive a refund. Please follow the steps below to \nselect your refund preference. \n" + 
			"\n" + 
			"Option 1 -  Refund to your Lunar Card \n" + 
                        "\n" + 
			"The Office of Student Refunds in partnership with Auxiliary Services is now offering an option to have your student account \n refund available on your Money Network® Enabled Lunar Card \n" + 
			"\n" + 
			"Follow these steps to have your refund deposited to your Lunar Card: \n" + 
			"\n" + 
			"Step 1: Get a Money Network® Enabled Lunar Card\n" + 
			"Your Panther Card must have the VISA logo on the front. If you have an older version of the Lunar Card, you must visit \nthe Lunar Card Office to exchange/replace your card. \n" + 
			"\n" + 
			"Step 2: Activate your Money Network® Enabled Lunar Card\n" + 
			"Your account must be activated in order for it to work. Wait 24 hours after you have been issued your Lunar Card before \nyou call 1-800-555-5555 and follow the system's prompts. Remember your PIN-you will need it to make PIN-debit purchases\n ATM withdrawals and to access your account when calling Customer Service. \n" + 
			"\n" + 
			"Step 3: Authorize the Student Refunds Office to deposit your refund to your Money Network® Account\n" + 
			"Go to the Authorizations page and select \"Authorize\" from the drop down menu under the \"Panther Card Money Network \nAuthorization\" section.\n" + 
			"\n" + 
			
			"Option 2 - Direct deposit \n" + 
                         "You have the option to have your refund electronically deposited to the checking or savings account you designate.\n" + 
			"\n" + 
		 
			
			"Option 3 - Paper Check \n" + 
			"If you select \"Paper Check\" your refund will be sent to your address");
	bp1.setCenter(lab);
	bp1.setTop(ref);
	lab.setAlignment(Pos.CENTER);
	BorderPane.setAlignment(ref, Pos.CENTER);
	
	
	
	Button sub = new Button("submit");
	VBox vb = new VBox();
	vb.getChildren().addAll(cb,sub);
	vb.setPadding(new Insets(20,20,20,20));
	
	bp1.setBottom(vb);
	
	sub.setOnAction((ActionEvent event) -> {
       String str = "Lunar Card";
       String str1 = "Direct Deposit";
       String str2 = "Paper Check";
		if(cb.getValue().equals(str)) {
        	System.out.println("true boy");
                stage1.hide();
        }else if(cb.getValue().equals(str1)) {
        	System.out.println("true boy1");
        	Stage stage2 = new Stage();
    		BorderPane root1 = new BorderPane();
    		Label lab3 = new Label("Enter Direct Deposit Information");
    		lab3.setFont(font);
    		root1.setTop(lab3);
    		BorderPane.setAlignment(lab3,Pos.CENTER);
    		stage2.setTitle("Refund Option: Direct Deposit");
    		Label lab1 = new Label("Please enter Account Number: ");
    		Label lab2 = new Label("Please enter Routing number:  ");
    		TextField tf1 = new TextField();
    		TextField tf2 = new TextField();
    		tf1.setMaxWidth(200.0);
    		tf2.setMaxWidth(200.0);
    		VBox vb1 = new VBox(20);
    		vb1.setPadding(new Insets(20,20,20,20));
    		vb1.getChildren().addAll(lab1,lab2);
    		root1.setLeft(vb1);
    		
    		VBox vb2 = new VBox(20);
    		root1.setCenter(vb2);
    		vb1.setPadding(new Insets(20,20,20,20));
    		vb2.getChildren().addAll(tf1,tf2);
    		vb2.setAlignment(Pos.CENTER);
    		vb1.setAlignment(Pos.CENTER);
    		Scene sc = new Scene(root1,500,400);
    		Button sb =new Button("information is current");
    		VBox vb3 = new VBox(20);
       		Button sub1 = new Button("Submit");
    		vb3.getChildren().addAll(sub1,sb);
    		sb.setOnAction((ActionEvent eve) -> {
				stage2.hide();
			});
    		stage2.setScene(sc);
    		stage2.show();
    		
    		
        vb3.setAlignment(Pos.CENTER);
    		root1.setBottom(vb3);
    		BorderPane.setAlignment(vb3, Pos.TOP_CENTER);
    		 sub1.setOnAction((ActionEvent e) -> {
    			
    			 String regex1 = "[0-9]{9}";
    	    		String regex2 = "[0-9]{9}";

    			if(tf1.getText().matches(regex1)) {
    			System.out.println("it works");
    			
    			}else {
    				System.out.println("doesnt work");
    				
    			}if(tf2.getText().matches(regex2)) {
    				System.out.println("it works too");
    			}else {
    				System.out.println("doesnt work too");
    			}
    			if((tf1.getText().matches(regex1)==false) && (tf2.getText().matches(regex2)==false)) {
    		 inputnotsuc();
    		 }if((tf1.getText().matches(regex1)==true) && (tf2.getText().matches(regex2)==true)) {
    			 
    			 inputsuccess();
    			 try {
    			 Connection connect = null;
					connect = sqliteConnection.dbconnector();
					
					String Signupstring = "Insert into refund (student,accnumber,routing,type)  values(?,?,?,?)";
					PreparedStatement prepstate ;
					
					
					prepstate = connect.prepareStatement(Signupstring);
					
					prepstate.setString(1,username);
					prepstate.setString(2,tf1.getText());
					prepstate.setString(3,tf2.getText());
					prepstate.setString(4,"Direct Deposit");
			
					int resset =prepstate.executeUpdate();
					prepstate.close();
					System.out.println(resset);
					
					inputsuccess();
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
					ex.printStackTrace();
				}
				
    			 
    			 
    		 }
    		
    		
        
  
        
        });
	 
        }
        else if(cb.getValue().equals(str2)) {
        	System.out.println("true boy1");
        	Stage stage2 = new Stage();
    		BorderPane root1 = new BorderPane();
    		stage2.setTitle("Refund Option: Paper Check");
    		Label lab3 = new Label("Enter Address");
    		lab3.setFont(font);
    		root1.setTop(lab3);
    		BorderPane.setAlignment(lab3,Pos.CENTER);
    		Label lab1 = new Label("Please enter street: ");
    		Label lab2 = new Label("Please enter city:  ");
    		Label lab5 = new Label("Please enter state:  ");
    		Label lab4 = new Label("Please enter zipcode:  ");
    		//Label lab2 = new Label("Please enter city:  ");
    		TextField tf1 = new TextField();
    		TextField tf2 = new TextField();
    		TextField tf3 = new TextField();
    		TextField tf4 = new TextField();
    		tf3.setMaxWidth(200.0);
    		tf4.setMaxWidth(200.0);
    		tf1.setMaxWidth(200.0);
    		tf2.setMaxWidth(200.0);
    		VBox vb1 = new VBox(20);
    		vb1.setPadding(new Insets(20,20,20,20));
    		vb1.getChildren().addAll(lab1,lab2,lab5,lab4);
    		root1.setLeft(vb1);
    		Button sub1 = new Button("Submit");
    		Button sb = new Button("Information is current");
    		VBox vb3 = new VBox(20);
    		vb3.getChildren().addAll(sub1,sb);
    		root1.setBottom(vb3);
    		BorderPane.setAlignment(vb3, Pos.CENTER);
    		vb3.setAlignment(Pos.CENTER);
    		sb.setOnAction((ActionEvent eve) -> {
				stage2.hide();
			});
    		BorderPane.setAlignment(sub1, Pos.TOP_CENTER);
    		VBox vb2 = new VBox(20);
    		root1.setCenter(vb2);
    		vb1.setPadding(new Insets(20,20,20,20));
    		vb2.getChildren().addAll(tf1,tf2,tf3,tf4);
    		vb2.setAlignment(Pos.CENTER);
    		vb1.setAlignment(Pos.CENTER);
    		Scene sc = new Scene(root1,500,400);
    		stage2.setScene(sc);
    		stage2.show();
    		
    		sub1.setOnAction((ActionEvent ev) -> {
    			String regex1="[0-9]+ [a-zA-Z]+ [a-z]{2}.";
    			String regex2="[a-zA-Z]+";
    			String regex3 = "[A-Z]{2}";
    			String regex4 ="[0-9]{5}";
    			if(tf1.getText().matches(regex1)) {
        			System.out.println("it works");
        			
        			}else {
        				System.out.println("doesnt work");
        				
        			}if(tf2.getText().matches(regex2)) {
        				System.out.println("it works too");
        			}else {
        				System.out.println("doesnt work too");
        			}if(tf3.getText().matches(regex3)) {
        				System.out.println("it works too1");
        			}else {
            				System.out.println("doesnt work too1");
        			}if(tf4.getText().matches(regex4)) {
        				System.out.println("it works too2");
        			}else {
            				System.out.println("doesnt work too2");
        			}
        			if(tf1.getText().matches(regex1)==false ||tf2.getText().matches(regex2)==false||tf3.getText().matches(regex3)==false||tf4.getText().matches(regex4)==false) {
        				inputnotsuccess1();
        			}if(tf1.getText().matches(regex1)==true &&tf2.getText().matches(regex2)==true&&tf3.getText().matches(regex3)==true&&tf4.getText().matches(regex4)==true) {
        				inputsuccess();
        			
        				try {
        	    			 Connection connect = null;
        						connect = sqliteConnection.dbconnector();
        						
        						String Signupstring = "Insert into refundaddress (student,street,City,state,zip,type)  values(?,?,?,?,?,?)";
        						PreparedStatement prepstate ;
        						
        						
        						prepstate = connect.prepareStatement(Signupstring);
        						
        						prepstate.setString(1,username);
        						prepstate.setString(2,tf1.getText());
        						prepstate.setString(3,tf2.getText());
        						prepstate.setString(4,tf3.getText());
        						prepstate.setString(5,tf4.getText());
        						prepstate.setString(6,"Paper Check");
        						
        						int resset =prepstate.executeUpdate();
        						prepstate.close();
        						System.out.println(resset);
        						
        						inputsuccess();
        						
        					} catch (SQLException ex) {
        						// TODO Auto-generated catch block
        						System.out.println(ex.toString());
        						ex.printStackTrace();
        					}
        					
        	    			 
        			}	 
        	    		 
        	    
    		});
        }
        });
	
 

	}public static void status(String username) throws SQLException {
		//cb.getItems().addAll("Lunar Card","Direct Deposit","Paper Check");
		//cb.setValue("Lunar Card");
		String str5 = "Paper Check";
		String str6 = "Direct Deposit";
		String str7 = "Lunar Card";
		
		/*Connection connect = null;
		connect = sqliteConnection.dbconnector();
		String Signupstring = "SELECT * From ;
		PreparedStatement prepstate1 ;
		prepstate1 = connect.prepareStatement(Signupstring);
		prepstate1.setString(1, username);
		*/
		
		
		
		
		if(RefundOps.cb.getValue().equals(str5)) {
			System.out.println("its a paper check");
		
		Stage stage2 = new Stage();
		BorderPane root1 = new BorderPane();
		stage2.setTitle("Refund: Paper Check");
		Scene sc = new Scene(root1,500,400);
		stage2.setScene(sc);
		stage2.show();
		Connection connect = null;
		connect = sqliteConnection.dbconnector();
		
		String Signupstring = "SELECT Street,City,state,zip FROM refundaddress where student=? Order by rowid DESC LIMIT 1;";
		PreparedStatement prepstate ;
		prepstate = connect.prepareStatement(Signupstring);
		prepstate.setString(1, username);
		ResultSet reset = prepstate.executeQuery();
		if(!reset.isBeforeFirst()) {
			System.out.println("no entries");
			Label noinfo = new Label("Please update information in Refund Options");
			Label noinfo1 = new Label("No Address Found");
			Font font = new Font("Arial",24);
			noinfo.setFont(font);
			noinfo1.setFont(font);
			root1.setTop(noinfo1);
			root1.setCenter(noinfo);
			BorderPane.setAlignment(noinfo,Pos.CENTER);
			BorderPane.setAlignment(noinfo1, Pos.CENTER);
			Button ok = new Button("Accept");
			prepstate.close();
			connect.close();
			ok.setOnAction((ActionEvent event) -> {
				stage2.hide();
			});
			root1.setBottom(ok);
			BorderPane.setAlignment(ok, Pos.CENTER);
		}else {
		String street = reset.getString("Street");
        String city = reset.getString("City");
        String state = reset.getString("state");
        String zipcode = reset.getString("zip");
        System.out.println(street + " " + city + state + zipcode );
        Font font = new Font("Arial",24);
        Label ad = new Label("Address");
        ad.setFont(font);
        Label st = new Label("street: "+street);
        Label cit = new Label("city: "+ city);
        Label stat = new Label("state: "+state);
        Label zippy = new Label("zip code: "+zipcode);
        Label note = new Label("note: you can change refund preference and update information in: Refund Options");
        st.setFont(font);
        cit.setFont(font);
        stat.setFont(font);
        zippy.setFont(font);
        VBox vb = new VBox(20);
        vb.setPadding(new Insets(20,20,20,20));
        vb.getChildren().addAll(st,cit,stat,zippy,note);
        Label lb12 = new Label("Refund: Pending");
        
        Font font1 = new Font("Arial",12);
        note.setFont(font1);
        lb12.setFont(font);
        root1.setCenter(vb);
        BorderPane.setAlignment(vb, Pos.CENTER);
        root1.setTop(ad);
        BorderPane.setAlignment(ad, Pos.CENTER);
        root1.setBottom(lb12);
        BorderPane.setAlignment(lb12, Pos.CENTER);
		}
		}
		else if(RefundOps.cb.getValue().equals(str6)) {
			Stage stage2 = new Stage();
			BorderPane root1 = new BorderPane();
			stage2.setTitle("Refund: Direct Deposit");
			Scene sc = new Scene(root1,500,400);
			stage2.setScene(sc);
			stage2.show();
			Connection connect = null;
			connect = sqliteConnection.dbconnector();
			
			String Signupstring1 = "SELECT accnumber,routing FROM refund where student=? Order by rowid DESC LIMIT 1;";
			PreparedStatement prepstate1 ;
			prepstate1 = connect.prepareStatement(Signupstring1);
			prepstate1.setString(1, username);
			
			ResultSet reset = prepstate1.executeQuery();
			if(!reset.isBeforeFirst()) {
				System.out.println("no entries");
				Label noinfo = new Label("Please update information in Refund Options");
				Label noinfo1 = new Label("No Account Found");
				Font font = new Font("Arial",24);
				noinfo.setFont(font);
				noinfo1.setFont(font);
				root1.setTop(noinfo1);
				root1.setCenter(noinfo);
				BorderPane.setAlignment(noinfo,Pos.CENTER);
				BorderPane.setAlignment(noinfo1, Pos.CENTER);
				Button ok = new Button("Accept");
				ok.setOnAction((ActionEvent event) -> {
					stage2.hide();
				});
				root1.setBottom(ok);
				BorderPane.setAlignment(ok, Pos.CENTER);
			}
			while(reset.next()) {
			String street = reset.getString("accnumber");
	        String city = reset.getString("routing");
			System.out.println(street + city);
			stage2.setTitle("Refund: Direct Deposit");
			Label st = new Label("Account Number: "+street);
	        Label cit = new Label("Routing Number "+ city);
	        Label note = new Label("note: you can change refund preference and update information in: Refund Options");
	        Label pen = new Label("Refund: Pending");
	        
	        Font font = new Font("Arial",24);
	        Font font1 = new Font("Arial",12);
	        pen.setFont(font);
	        note.setFont(font1);
	        VBox vb = new VBox(20);
	        vb.setPadding(new Insets(20,20,20,20));
	        vb.getChildren().addAll(st,cit,note);
	        cit.setFont(font);
	        st.setFont(font);
	        root1.setCenter(vb);
			Label acc = new Label("Direct Deposit Information");
			acc.setFont(font);
			root1.setTop(acc);
			root1.setBottom(pen);
			BorderPane.setAlignment(pen, Pos.CENTER);
			BorderPane.setAlignment(acc, Pos.CENTER);
			
		}
			}else if(RefundOps.cb.getValue().equals(str7)) {
				Stage stage2 = new Stage();
				BorderPane root1 = new BorderPane();
				stage2.setTitle("Refund: Lunar Card");
				Label lab = new Label("You will recieve your refund on your Lunar Card");
				Label lab1 = new Label("Refund: Pending");
				Label note = new Label("note: you can change refund preference and update information in: Refund Options");
				Font font = new Font("Arial",24);
				Font font1 = new Font("Arial",12);
				lab.setFont(font);
				lab1.setFont(font);
				VBox vb = new VBox(20);
				
				root1.setCenter(note);
				root1.setTop(lab);
				BorderPane.setAlignment(lab, Pos.CENTER);
				
				Scene sc = new Scene(root1,600,400);
				Button ok = new Button("Accept");
				root1.setBottom(vb);
				BorderPane.setAlignment(vb, Pos.CENTER);
				vb.getChildren().addAll(ok,lab1);
				vb.setAlignment(Pos.CENTER);
				stage2.setScene(sc);
				stage2.show();
				ok.setOnAction((ActionEvent event) -> {
					stage2.hide();
				});
				root1.setBottom(ok);
				BorderPane.setAlignment(ok, Pos.CENTER);
		}
		}
		
		
		
		
	
	
	
	

	public static void inputsuccess() {
		Stage st1 = new Stage();
		st1.setResizable(false);
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

			// this is where the method for the main base page goes,
			// the method should be created in another class called
			// base page or something equivalent.
		});

	}

	public static void inputnotsuc() {
		Stage st1 = new Stage();
		st1.setResizable(false);
		st1.setTitle("Input UnSuccesful");
		BorderPane sp1 = new BorderPane();
		Label loginacc = new Label(
				"Input UnSuccesful\nPlease enter 9 digit account number sequentially\nand 9 digit routing number sequentially");
		HBox login1 = new HBox(loginacc);
		login1.setAlignment(Pos.CENTER);
		Scene Bpane = new Scene(sp1, 400, 100);
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

			// this is where the method for the main base page goes,
			// the method should be created in another class called
			// base page or something equivalent.
		});

	}

	public static void inputnotsuccess1() {
		Stage st1 = new Stage();
		st1.setResizable(false);
		st1.setTitle("Input UnSuccesful");
		BorderPane sp1 = new BorderPane();
		Label loginacc = new Label("Input UnSuccesful\nPlease enter information as example below\n"
				+ "street: 1234 Main st.\n" + "city: Brownsville\n" + "state: GA\n" + "zipcode: 30303");
		HBox login1 = new HBox(loginacc);
		login1.setAlignment(Pos.CENTER);
		Scene Bpane = new Scene(sp1, 400, 200);
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

			// this is where the method for the main base page goes,
			// the method should be created in another class called
			// base page or something equivalent.
		});

	}

}
