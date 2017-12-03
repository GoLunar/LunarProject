package golunarproject;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */

class financialAidForms {
    
    public static void Form(){
        
        // Window Creation
		Stage stage1 = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(3);
		grid.setHgap(3);
     
        // created labels and text field for form
        /*This information will be use with a fafsa form in the future
        * This will cut down on the time when reapplying to fafs
        * And will make filling out any information with Go Lunar easier
        */   
                Label enterfullname = new Label("1-3. Enter your full name (as it appears on your Social Security card)");
                enterfullname.setFont(Font.font("Tahoma",FontWeight.NORMAL,12));
                grid.add(enterfullname,0,1);
                Label lastName = new Label("1. Last Name:");
                TextField lName = new TextField();
                lastName.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(lastName,0,3);
                grid.add(lName,0,4);
                
                //first name
                Label firstName = new Label("2. First Name:");
                TextField fName = new TextField();
                firstName.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(firstName,3,3);
                grid.add(fName, 3, 4);
                
                //middle name
                Label middleInitial = new Label("Middle Initial:");
                TextField mInitial = new TextField();
                middleInitial.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(middleInitial,6,3);
                grid.add(mInitial,6,4);
             
                //address
                Label fulladdress = new Label("4-7. Your permanent mailing address");
                fulladdress.setFont(Font.font("Tahoma",FontWeight.NORMAL,12));
                grid.add(fulladdress,0,5);
                
                //permanent addres
                Label permanentaddress = new Label("4. Number and Street name:");
                TextField pAddress = new TextField();
                permanentaddress.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(permanentaddress,0,6);
                grid.add(pAddress,0,7);
               
                //City Name
                Label cityname = new Label("5. City (if not in US, country #):");
                TextField cityName = new TextField();
                cityname.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(cityname,3,6);
                grid.add(cityName,3,7);
                
                //State Initial
                Label stateInitial = new Label("6. State:");
                TextField stateInitialTextField = new TextField();
                stateInitial.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(stateInitial,6,6);
                grid.add(stateInitialTextField,6,7);
                
                //zipcode
                Label zipcode = new Label("7. Zipcode:");
                TextField zipcodeTextField = new TextField();
                zipcode.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(zipcode,9,6);
                grid.add(zipcodeTextField,9,7);
                
                //social security
                Label socialsecurity= new Label("8. Social Security #:");
                TextField socialsecurityTextField = new TextField();
                socialsecurity.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(socialsecurity,0,8);
                grid.add(socialsecurityTextField,0,9);
                
                
                //date of birth
                Label dateofbirth = new Label("9. Date of Birth:");
                TextField dateofbirthTextField = new TextField();
                dateofbirth.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(dateofbirth,3,8);
                grid.add(dateofbirthTextField,3,9);
                
                //permanent telephone
                Label permanenttelephone = new Label("10. Permanent Telephone:");
                TextField permanenttelephoneTextField = new TextField();
                permanenttelephone.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(permanenttelephone,6,8);
                grid.add(permanenttelephoneTextField,6,9);
                
                //license info
                Label driverlicenseinfo = new Label("11-12. Your driver's license number and state(if any)");
                driverlicenseinfo.setFont(Font.font("Tahoma",FontWeight.NORMAL,12));
                grid.add(driverlicenseinfo,0,10);
                
                //license number
                Label driverlicensenumber = new Label("11. License Number:");
                TextField driverlicensenumberTextField = new TextField();
                driverlicensenumber.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(driverlicensenumber,0,11);
                grid.add(driverlicensenumberTextField,0,12);
           
                //state license
                Label licensestate = new Label("12. State:");
                TextField licensestateTextField = new TextField();
                licensestate.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(licensestate,3,11);
                grid.add(licensestateTextField,3,12);
                
                //email
                Label emailaddressinfo = new Label("We will use the email address to correspond with you. You will recieve "
                        + "FAFSA information through a secure link on the internet.");
                emailaddressinfo.setFont(Font.font("Tahoma",FontWeight.NORMAL,8));
                grid.add(emailaddressinfo,0,13);
                
                Label emailaddress = new Label("13.Your email address:");
                TextField emailaddressTextField = new TextField();
                emailaddress.setFont(Font.font("Tahoma",FontWeight.SEMI_BOLD,15));
                grid.add(emailaddress,0,15);
                grid.add(emailaddressTextField,0,16);
                
//submit button to prompt term
                Button submit = new Button();
                submit.setText("Submit");
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                hbBtn.getChildren().add(submit);
                grid.add(hbBtn,9,25);
                
                
//We would like to connect this to fafsa as well as any other forms that we require for students to fill out  

submit.setOnAction((ActionEvent e) -> {
                  
            
                stage1.hide();
                });

                
                grid.setGridLinesVisible(false);
               
  
		
		Scene scene = new Scene(grid, 1200, 500);
		grid.setId("pane1");
		
                stage1.setTitle("Financial Aid Application");
		stage1.setScene(scene);
		stage1.show();
                
                
    }
    
}