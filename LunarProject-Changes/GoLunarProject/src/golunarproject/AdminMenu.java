package golunarproject;



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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
*Admin menu class brings up the admin menu gui. It has 
*similar format to student menu except it has many different
*functions such as adding students, removing students,
*grading, and viewing student list.
*/
public class AdminMenu {
// tabs for menu
    static Tab tab, tab2, tab3;
    
    static Group root = new Group();
    //declaring scene
    static Scene scene = new Scene(root, 800, 600, Color.WHITE);
    //tabs
    static TabPane tabPane = new TabPane();
    //borderpane
    static BorderPane borderPane = new BorderPane();

    
    
/*
*start method starts the main stage for the admin menu gui
*Has 3 tabs. Main, registration, and student records.
*Uses borderpane, gridpane, to have proper layout for this menu.
*/
    public static void startA(String username) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("GoLunar");       // name of program
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        
        
//        final ImageView imv = new ImageView();
//        final Image image2 = new Image("./database/bg.png");
//        imv.setImage(image2);

        tab = new Tab("Main");    // name of tabs
        tab2 = new Tab("Registration");
        tab3 = new Tab("Student Records");

        tabPane.getTabs().add(tab);
        home();
        tabPane.getTabs().add(tab2);
        registration(username);
        tabPane.getTabs().add(tab3);
        records();

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
   //    root.getChildren().add(imv);
        
        stage.setScene(scene);
        stage.show();
    }

    
    
    
    
/*
*Calls home tab which just greets the admin.
*/
    public static void home() {
        HBox hbox = new HBox();//horizontal box to allign
        hbox.getChildren().add(new Label("Admin Menu"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);

    }
    
    
/*
*Registration tab, it is the most important tab
*for the admin menu. It includes the add student
*function, for adding students into the database.
*It also has Remove students function.
*/
    public static void registration(String username) {

    	Hyperlink addStudent = new Hyperlink();
        addStudent.setText("Add Student");
        addStudent.setOnAction((ActionEvent event) -> {
            studentAdd.startaddStudent();
        });
        
        Hyperlink remStudents = new Hyperlink();
        remStudents.setText("Remove Students");
        remStudents.setOnAction((ActionEvent event) -> {
            deleteStudent.removeStudent();
        });

        //vertical box to allign
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Registration Menu"));
        
        vbox.getChildren().add(addStudent);
        
        vbox.getChildren().add(remStudents);
        
        vbox.setSpacing(5);

        vbox.setPadding(new Insets(50, 50, 50, 50));

        tab2.setContent(vbox);
    }
    
    
/*
*Records tab/menu as the function to view students
*list from the database. It also has a function for
*adding grades to students classes for the semester.
*Which is can be used to show gpa, and also calculate
*student payments.
*/
    public static void records() {
    	
        Hyperlink viewStudents = new Hyperlink();
        viewStudents.setText("View Students");
        viewStudents.setOnAction((ActionEvent event) -> {
            studentList.start();
        });
        
        
        Hyperlink addGrade = new Hyperlink();
        addGrade.setText("Add Student Grades");
        addGrade.setOnAction((ActionEvent event) -> {
            addGrades.addGrades();
        });

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Student Records Menu"));

        vbox.getChildren().add(viewStudents);
        vbox.getChildren().add(addGrade);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        tab3.setContent(vbox);
        
    }
}


