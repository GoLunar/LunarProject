package golunarproject;


import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;


/*
*Student menu class brings up the Student menu gui. It has 
*similar format to admin menu except it has many different
*functions such as adding classes, viewing classes,
*gpa, schedule, financial aids, payments, etc.
*/
public class StudentMenu {

    static Tab tab, tab2, tab3, tab4, tab5, tab6;
    static Group root = new Group();
    static Scene scene = new Scene(root, 800, 600, Color.WHITE);
    static TabPane tabPane = new TabPane();
    static BorderPane borderPane = new BorderPane();
    private static Image myImage;

    /**
     *
     */
    //public String username;
    //public StudentMenu(String username) {
    	//this.username=username;
    //}
    
    
    
/*
*start method starts the main stage for the admin menu gui
*Has 3 tabs. home, registration, records, accounts, financial aid,
*personal info.
*Uses borderpane, gridpane, to have proper layout for this menu.
*/  
    public static void start(String username) throws SQLException {
        Stage stage = new Stage();
        stage.setResizable(false);

         
        stage.setTitle("GoLunar");       // name of program
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        tab = new Tab("Main");    // name of tabs
        tab2 = new Tab("Registration");
        tab3 = new Tab("Student Records");
        tab4 = new Tab("Student Accounts");
        tab5 = new Tab("Financial Aid");
        tab6 = new Tab("Personal Accounts");

        tabPane.getTabs().add(tab);
        home();
        tabPane.getTabs().add(tab2);
        registration(username);
        tabPane.getTabs().add(tab3);
        records(username);
        tabPane.getTabs().add(tab4);
        accounts(username);
        tabPane.getTabs().add(tab5);
        financialAid();
        tabPane.getTabs().add(tab6);
        personalInfo();

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
/*
*Calls home tab which just greets the student.
*/
    public static void home() {
        HBox hbox = new HBox();//horizontal box to allign
        hbox.getChildren().add(new Label("Welcome to GoLunar!"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);

    }
    
    
    
    
/*
*Registration tab has many important functions such as,
*Add/withdrawing classes, classlookup, and concise schedule.
*/
    public static void registration(String username) {

        Hyperlink classRegister = new Hyperlink();
        classRegister.setText("Add/Withdraw Classes");
        classRegister.setOnAction((ActionEvent event) -> {
        	AddDrop.AddDrop(username);
        	;
        });

        Hyperlink classLookup = new Hyperlink();
        classLookup.setText("Look-Up Classes to Add");
        classLookup.setOnAction((ActionEvent event) -> {
        	classLookUp.classLookUp(); 
        });

        Hyperlink conciseSch = new Hyperlink();
        conciseSch.setText("View Concise Student Schedule");
        conciseSch.setOnAction((ActionEvent event) -> {
            conSchedule.conSchedule(username);
        });

        //Hyperlink weeklySch = new Hyperlink();
       // weeklySch.setText("View Weekly Student Schedule");
       // weeklySch.setOnAction((ActionEvent event) -> {
        //    weekSchedule.weekSchedule();
       // });

        /*Hyperlink courseInfo = new Hyperlink();
        courseInfo.setText("View Basic Course Information");
*/
        //vertical box to allign
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Registration Menu"));
        vbox.getChildren().add(classRegister);
        vbox.getChildren().add(classLookup);
        vbox.getChildren().add(conciseSch);
        //vbox.getChildren().add(weeklySch);
        //vbox.getChildren().add(courseInfo);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 50, 50, 50));

        tab2.setContent(vbox);
    }
    
    
    
/*
*This method calls view final grades link, gpa, and
*withdraw classes. It also has update student info for
*quick changes with address, contact,etc. 
*/
    public static void records(String username) {
        /*Hyperlink holds = new Hyperlink();
        holds.setText("View Holds");
        holds.setOnAction((ActionEvent event) -> {
            Holds.Holds();
        });
        */
        Hyperlink finalGrades = new Hyperlink();
        finalGrades.setText("View Final Grades");
        finalGrades.setOnAction((ActionEvent event) -> {
            viewGrade.viewGrade(username);
        });

        Hyperlink myGPA = new Hyperlink();
        myGPA.setText("My Grade Point Average");
        myGPA.setOnAction((ActionEvent event) -> {
            try {
				GPA.GPA(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });

        Hyperlink myWithdraw = new Hyperlink();
        myWithdraw.setText("My Withdrawal History");
        myWithdraw.setOnAction((ActionEvent event) -> {
            Withdrawal.withdraw(username);
        });

        //Hyperlink applyToGrad = new Hyperlink();
       // applyToGrad.setText("Apply to Graduate");
        
        Hyperlink updateInfo = new Hyperlink();
        updateInfo.setText("Update Student Information");
        updateInfo.setOnAction((ActionEvent event) -> {
           updateInfos.updateInfo();
        });

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Student Records Menu"));
        //vbox.getChildren().add(holds);
        vbox.getChildren().add(finalGrades);
        vbox.getChildren().add(myGPA);
        vbox.getChildren().add(myWithdraw);
       // vbox.getChildren().add(applyToGrad);
        vbox.getChildren().add(updateInfo);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        tab3.setContent(vbox);
    }
/*
*
*
*
*
*/
    public static void accounts(String username) throws SQLException {
        Hyperlink payment = new Hyperlink();
        payment.setText("Payment");
        payment.setOnAction((ActionEvent event) -> {
            try {
				Payments.paymentsdb(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
         });

        Hyperlink refundOpt = new Hyperlink();
        refundOpt.setText("Refund Options");
        refundOpt.setOnAction((ActionEvent refund) ->
        {refundOption.refund();

        Hyperlink viewRefundSt = new Hyperlink();
        viewRefundSt.setText("View Refund Status");
        viewRefundSt.setOnAction((ActionEvent event) -> {
            try {
				RefundOps.status(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }); 
       // Hyperlink tax = new Hyperlink();
        //tax.setText("Select Tax Year");
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Student Accounts Menu"));
        vbox.getChildren().add(payment);
        vbox.getChildren().add(refundOpt);
        vbox.getChildren().add(viewRefundSt);
        //vbox.getChildren().add(tax);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        tab4.setContent(vbox);
    }
    
    
/*
*
*
*
*
*/
    public static void financialAid() {
        Hyperlink status = new Hyperlink();
        status.setText("My Overall Status of Financial Aid");
        status.setOnAction((ActionEvent financialstatus) -> {
            Status.Status();
        });

        Hyperlink forms = new Hyperlink();
        forms.setText("Financial Aid Forms");
        forms.setOnAction((ActionEvent financialaidforms) -> {
        financialAidForms.Form();
        });

        Hyperlink questions = new Hyperlink();
        questions.setText("Financial Aid Questions");
        questions.setOnAction((ActionEvent financialquestions) -> {
        financialAidQuestions.Question();
        });

//        Hyperlink appointment = new Hyperlink();
//        appointment.setText("Enrollment Services Appointment");
//        appointment.setOnAction((ActionEvent apptime) -> {
//            ERAppointment.Appointment();
//        });
//        
//        Hyperlink summerApp = new Hyperlink();
//        summerApp.setText("Summer Application");
//        summerApp.setOnAction((ActionEvent summerapplication) ->
//        { summerApplication.Application();
//        });
//        

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Financial Aid Menu"));
        vbox.getChildren().add(status);
        vbox.getChildren().add(forms);
        vbox.getChildren().add(questions);
//        vbox.getChildren().add(appointment);
//        vbox.getChildren().add(summerApp);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        vbox.setAlignment(Pos.TOP_LEFT);
        tab5.setContent(vbox);
    }
    
    
/*
*
*
*
*
*/
   
