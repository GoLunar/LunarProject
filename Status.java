


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Status {

    public static void Status() {
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
        
        Label year1 = new Label("2017-2018");
        termBox.getItems().addAll(
                year1 
                
        );

        termBox.setPromptText("Select a Year");

        Button submit = new Button();
        submit.setText("Submit");

        //alligns fields, buttons, labels
        GridPane.setConstraints(termSelect, 10, 5);
        GridPane.setConstraints(termBox, 11, 5);
        GridPane.setConstraints(submit, 11, 7);

        root1.getChildren().addAll(termSelect, termBox, submit);
        Scene scene = new Scene(root1, 400, 200);
        root1.setId("pane1");
        stage1.setTitle("Financial Aid Year");
        stage1.setScene(scene);

        stage1.show();

        //basically triggers button actions and also hides the term window.
        submit.setOnAction((ActionEvent e) -> {
            if (termBox.getValue() != null && !termBox.getValue().toString().isEmpty()) {
                financialaidlookup();
                stage1.hide();
            }
        });

    }

    public static void financialaidlookup() {
        // Window Creation
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


    }