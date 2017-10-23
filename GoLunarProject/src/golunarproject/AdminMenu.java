package golunarproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminMenu {

    static Tab tab, tab2, tab3;
    static Group root = new Group();
    static Scene scene = new Scene(root, 800, 600, Color.WHITE);
    static TabPane tabPane = new TabPane();
    static BorderPane borderPane = new BorderPane();
    private TextField id;
    private TextField firstname;
    private TextField lastname;
    private TextField email;
    private DatePicker dob;
    private TableView<Student> studenttable;
    private TableColumn<Student, String> idcolumn;
    private TableColumn<Student, String> firstnamecolumn;
    private TableColumn<Student, String> lastnamecolumn;
    private TableColumn<Student, String> emailcolumn;
    private TableColumn<Student, String> dobcolumn;
    private Button loadbutton;
    private ObservableList<Student> data;
    private sqliteConnection dc;

    /**
     *
     */
    public static void startA() {
        Stage stage = new Stage();
        stage.setTitle("GoLunar");       // name of program
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        tab = new Tab("Main");    // name of tabs
        tab2 = new Tab("Registration");
        tab3 = new Tab("Student Records");

        tabPane.getTabs().add(tab);
        home();
        tabPane.getTabs().add(tab2);
        registration();
        tabPane.getTabs().add(tab3);
        records();

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void home() {
        HBox hbox = new HBox();//horizontal box to allign
        hbox.getChildren().add(new Label("Welcome to GoLunar!"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);

    }

    public static void registration() {

        Hyperlink classRegister = new Hyperlink();
        classRegister.setText("Add/Drop/Withdraw Classes");
        classRegister.setOnAction((ActionEvent event) -> {
            classLookUp.classLookUp();
        });

        Hyperlink classLookup = new Hyperlink();
        classLookup.setText("Look-Up Classes to Add");
        classLookup.setOnAction((ActionEvent event) -> {
            AddDrop.AddDrop();
        });

        Hyperlink conciseSch = new Hyperlink();
        conciseSch.setText("View Concise Student Schedule");
        conciseSch.setOnAction((ActionEvent event) -> {
            conSchedule.conSchedule();
        });

        Hyperlink weeklySch = new Hyperlink();
        weeklySch.setText("View Weekly Student Schedule");
        weeklySch.setOnAction((ActionEvent event) -> {
            weekSchedule.weekSchedule();
        });

        Hyperlink courseInfo = new Hyperlink();
        courseInfo.setText("View Basic Course Information");

        //vertical box to allign
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Registration Menu"));
        vbox.getChildren().add(classRegister);
        vbox.getChildren().add(classLookup);
        vbox.getChildren().add(conciseSch);
        vbox.getChildren().add(weeklySch);
        vbox.getChildren().add(courseInfo);
        vbox.setPadding(new Insets(50, 50, 50, 50));

        tab2.setContent(vbox);
    }

    public static void records() {
        Hyperlink holds = new Hyperlink();
        holds.setText("View Holds");

        Hyperlink finalGrades = new Hyperlink();
        finalGrades.setText("View Final Grades");

        Hyperlink myGPA = new Hyperlink();
        myGPA.setText("My Grade Point Average");

        Hyperlink myWithdraw = new Hyperlink();
        myWithdraw.setText("My Withdrawal History");

        Hyperlink applyToGrad = new Hyperlink();
        applyToGrad.setText("Apply to Graduate");

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Student Records Menu"));
        vbox.getChildren().add(holds);
        vbox.getChildren().add(finalGrades);
        vbox.getChildren().add(myGPA);
        vbox.getChildren().add(myWithdraw);
        vbox.getChildren().add(applyToGrad);
        vbox.setAlignment(Pos.TOP_LEFT);
        tab3.setContent(vbox);
    }

    private void loadStudentData() {
        try {
            Connection conn = sqliteConnection.dbconnector();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                this.data.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        }

    }
}
