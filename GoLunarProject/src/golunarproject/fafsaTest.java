package golunarproject;

import static golunarproject.conSchedule.con;
import java.sql.Connection;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class fafsaTest{
    
    public static void fafsaTest(String username){
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
		
                stage1.setTitle("Financial Aid questions");
		stage1.setScene(scene);
		stage1.show();
                
                 // Window Creation
       
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        // created labels
        Label termSelect = new Label("Select a Term: ");

        // combo box for selecting terms
        final ComboBox termBox = new ComboBox();
        termBox.getItems().addAll(
                "Spring Semester 2018",
                "Summer Semester 2018"
        );

        termBox.setPromptText("Select a Term");

        Button submit = new Button();
        submit.setText("Submit");

        //alligns fields, buttons, labels
        GridPane.setConstraints(termSelect, 10, 5);
        GridPane.setConstraints(termBox, 11, 5);
        GridPane.setConstraints(submit, 11, 7);

        root1.getChildren().addAll(termSelect, termBox, submit);
  
        root1.setId("pane1");
        stage1.setTitle("Select a Term");
        stage1.setScene(scene);

        stage1.show();

        //basically triggers button actions and also hides the term window.
        submit.setOnAction((ActionEvent e) -> {
            if (termBox.getValue() != null && !termBox.getValue().toString().isEmpty()) {
                if (termBox.getValue().toString() == "Spring Semester 2018"){
                    
                    con(username);
                }else if (termBox.getValue().toString() == "Summer Semester 2018"){
                    
                }
                
                stage1.hide();
            }
        });

    }
    
    public static void fafasaCalc(){
         // Window Creation
        Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        // created labels
        Label termSelect = new Label("Select a Term: ");

        // combo box for selecting terms
        final ComboBox termBox = new ComboBox();
        termBox.getItems().addAll(
                "Spring Semester 2018",
                "Summer Semester 2018"
        );

        termBox.setPromptText("Select a Term");

        Button submit = new Button();
        submit.setText("Submit");

        //alligns fields, buttons, labels
        GridPane.setConstraints(termSelect, 10, 5);
        GridPane.setConstraints(termBox, 11, 5);
        GridPane.setConstraints(submit, 11, 7);

        root1.getChildren().addAll(termSelect, termBox, submit);
        Scene scene = new Scene(root1, 400, 200);
        root1.setId("pane1");
        stage1.setTitle("Select a Term");
        stage1.setScene(scene);

        stage1.show();

        //basically triggers button actions and also hides the term window.
        submit.setOnAction((ActionEvent e) -> {
            if (termBox.getValue() != null && !termBox.getValue().toString().isEmpty()) {
                if (termBox.getValue().toString() == "Spring Semester 2018"){
                 
                }else if (termBox.getValue().toString() == "Summer Semester 2018"){
                    
                }
                
                stage1.hide();
            }
        });

    }

  public static void setCrn(String username) throws SQLException{
    Connection connect;
		connect = sqliteConnection.dbconnector();

		String usernameandpassword = "SELECT";
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
		int sum=0;
		//System.out.println(total);
		while (reset.next()) {

			int c = reset.getInt("credits");
			sum = sum + c;
			
			System.out.println("sum = "+ sum);
		}
		
		prepstate.close();
		connect.close();
      int tuition = sum * 1000;
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

        private void cardnumregex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void inputsuccess() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
			
		});
  
  }
  public static void fLook(){
  Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        root1.getChildren().addAll();
        Scene scene = new Scene(root1, 800, 600);
        root1.setId("pane1");
        stage1.setTitle("Financial Availability");
        stage1.setScene(scene);
        //Description of financial aid year
        Label financialaidyear = new Label("This is your financial aid award history of the year 2017-2018");
        financialaidyear.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD, 12));
        root1.add(financialaidyear,0,1);
       
        //Description of financial aid
        Label Fund = new Label("Fund");
        Fund.setFont(Font.font("Tahoma",FontWeight.BOLD, 13));
        root1.add(Fund,0,3);
        
        
        Label Offered = new Label("Offered");
        Offered.setFont(Font.font("Tahoma",FontWeight.BOLD, 13));
        root1.add(Offered,5,3);
      
       
        Label Accepted = new Label("Accepted");
        Accepted.setFont(Font.font("Tahoma",FontWeight.BOLD, 13));
        root1.add(Accepted,10,3);
        
        Label Declined  = new Label("Declined");
        Declined.setFont(Font.font("Tahoma",FontWeight.BOLD, 13));
        root1.add(Declined,15,3);
        
        Label Total  = new Label("Total");
        Total.setFont(Font.font("Tahoma",FontWeight.BOLD, 13));
        root1.add(Total,20,3);
        
        //Financial Aids
        
        //Pell Grant
        Label FederalPellGrant  = new Label("Federal Pell Grant");
        FederalPellGrant.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalPellGrant,0,5);
        
        String FPGAmount = "5,920";
        Label FederalPellGrantAmount  = new Label(FPGAmount);
        FederalPellGrantAmount.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalPellGrantAmount,5,5);
        
        Label FederalPellGrantAccepted  = new Label(FPGAmount);
        FederalPellGrantAccepted.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalPellGrantAccepted,10,5);
        
        Label FederalPellGrantDeclined  = new Label("0");
        FederalPellGrantDeclined.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalPellGrantDeclined,15,5);
        
        Label FederalPellGrantTotal  = new Label(FPGAmount);
        FederalPellGrantTotal.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalPellGrantTotal,20,5);
        
        
        
        
        
       
        //Hope Scholarship
        Label HopeScholarship  = new Label("Hope Scholarship");
        HopeScholarship.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(HopeScholarship,0,7);
        
        String HSAmount = "6,480";
        Label HopeScholarshipAmount  = new Label(HSAmount);
        HopeScholarshipAmount.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(HopeScholarshipAmount,5,7);
        
        Label HopeScholarshipAccepted  = new Label(HSAmount);
        HopeScholarshipAccepted.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(HopeScholarshipAccepted,10,7);
        
        
        Label HopeScholarshipDeclined  = new Label("0");
        HopeScholarshipDeclined.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(HopeScholarshipDeclined,15,7);
        
        Label HopeScholarshipTotal  = new Label(HSAmount);
        HopeScholarshipTotal.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(HopeScholarshipTotal,20,7);
        
        
        
       //Federal Direct Subsidized Loan
        Label FederalDirectSubsidizedLoan  = new Label("Federal Direct Subsidized Loan");
        FederalDirectSubsidizedLoan.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectSubsidizedLoan,0,9);
        
        String FDSLAmount = "4,500";
        Label FederalDirectSubsidizedLoanAmount  = new Label(FDSLAmount);
        FederalDirectSubsidizedLoanAmount.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectSubsidizedLoanAmount,5,9);
       
        Label FederalDirectSubsidizedLoanAccepted  = new Label(FDSLAmount);
        FederalDirectSubsidizedLoanAccepted.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectSubsidizedLoanAccepted,10,9);
        
        Label FederalDirectSubsidizedLoanDeclined  = new Label("0");
        FederalDirectSubsidizedLoanDeclined.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectSubsidizedLoanDeclined,15,9);
        
        Label FederalDirectSubsidizedLoanTotal  = new Label(FDSLAmount);
        FederalDirectSubsidizedLoanTotal.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectSubsidizedLoanTotal,20,9);
       
       //Federal Direct UnSubsidized Loan
         Label FederalDirectUnSubsidizedLoan  = new Label("Federal Direct UnSubsidized Loan");
        FederalDirectUnSubsidizedLoan.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectUnSubsidizedLoan,0,11);
        
        String FDULAmount = "2,000$";
        Label FederalDirectUnSubsidizedLoanAmount  = new Label(FDULAmount);
        FederalDirectUnSubsidizedLoanAmount.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectUnSubsidizedLoanAmount,5,11);
        
        Label FederalDirectUnSubsidizedLoanAccepted  = new Label("0");
        FederalDirectUnSubsidizedLoanAccepted.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectUnSubsidizedLoanAccepted,10,11);
       
        Label FederalDirectUnSubsidizedLoanDeclined  = new Label(FDULAmount);
        FederalDirectUnSubsidizedLoanDeclined.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectUnSubsidizedLoanDeclined,15,11);
        
        Label FederalDirectUnSubsidizedLoanTotal  = new Label("0");
        FederalDirectUnSubsidizedLoanTotal.setFont(Font.font("Tahoma",FontWeight.NORMAL, 15));
        root1.add(FederalDirectUnSubsidizedLoanTotal,20,11);
        
        
        //Total Funds
        Label TotalFunds  = new Label("16,900$");
        TotalFunds.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD, 20));
        root1.add(TotalFunds,20,15);
        
        root1.setGridLinesVisible(false);
        

        stage1.show();
  
  }
  
  
  public static void cAdL(){
  
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
