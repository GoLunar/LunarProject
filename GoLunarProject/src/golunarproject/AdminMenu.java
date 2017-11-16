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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminMenu {

    static Tab tab, tab2, tab3;
    static Group root = new Group();
    static Scene scene = new Scene(root, 800, 600, Color.WHITE);
    static TabPane tabPane = new TabPane();
    static BorderPane borderPane = new BorderPane();

    public static void startA(String username) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("GoLunar");       // name of program
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

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
        stage.setScene(scene);
        stage.show();
    }

    public static void home() {
        HBox hbox = new HBox();//horizontal box to allign
        hbox.getChildren().add(new Label("Welcome to GoLunar!"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);

    }

    public static void registration(String username) {


    		Hyperlink addStudent = new Hyperlink();
        addStudent.setText("Add Student");
        addStudent.setOnAction((ActionEvent event) -> {
            studentAdd.startaddStudent();
        });


        //vertical box to allign
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Registration Menu"));
        
        vbox.getChildren().add(addStudent);

        vbox.setPadding(new Insets(50, 50, 50, 50));

        tab2.setContent(vbox);
    }

    public static void records() {
    	
        Hyperlink holds = new Hyperlink();
        holds.setText("View Holds");


        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Student Records Menu"));

        vbox.getChildren().add(holds);
        vbox.setPadding(new Insets(50, 50, 50, 50));
        tab3.setContent(vbox);
    }}


    























