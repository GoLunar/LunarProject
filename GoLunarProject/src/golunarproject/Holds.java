package golunarproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Holds{

    public static void Holds() {
        try {
            Stage stage1 = new Stage();
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 800, 600);
            stage1.setScene(scene);
            Font f1 = new Font("Arial", 24);
            stage1.setTitle("View Holds");
            Label hold = new Label("All Holds");
            hold.setFont(f1);
            Hyperlink pay = new Hyperlink();
            pay.setText("Payments Hold");
            Hyperlink personal = new Hyperlink();
            personal.setText("Personal Information Hold");
            //Label personal = new Label("Personal Information Hold");
            BorderPane bp1 = new BorderPane();
            Scene bp2 = new Scene(bp1, 800, 600);
            VBox vb = new VBox(30);

            bp1.setTop(hold);
            BorderPane.setAlignment(hold, Pos.CENTER);

            bp1.setCenter(personal);
            BorderPane.setAlignment(pay, Pos.CENTER_LEFT);
            BorderPane.setAlignment(personal, Pos.CENTER_LEFT);
            vb.getChildren().addAll(pay, personal);
            bp1.setCenter(vb);
            stage1.setScene(bp2);
            stage1.show();

            personal.setOnAction((ActionEvent e) -> {
                try {
                    zeroresultset();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block

                }
            });

        } catch (Exception e) {
        }
    }

    public static void holdtrue() {
        Stage st1 = new Stage();
        st1.setTitle("Hold");
        BorderPane sp1 = new BorderPane();
        Label loginacc = new Label("You have a Personal information Hold\n Please go to personal information section and update personal information");
        HBox login1 = new HBox(loginacc);
        login1.setAlignment(Pos.CENTER);
        Scene Bpane = new Scene(sp1, 600, 200);
        Button loginbut = new Button("OK");
        sp1.setId("hbox");
        //sp1.getStylesheets().add("Style.css");
        sp1.setBottom(loginbut);
        sp1.setCenter(login1);
        BorderPane.setAlignment(loginbut, Pos.CENTER);
        sp1.setPrefSize(700, 400);
        st1.setScene(Bpane);
        st1.show();
        st1.setAlwaysOnTop(true);
        loginbut.setOnAction((ActionEvent event) -> {
            st1.hide();
        });
    }

    public static void holdfalse() {
        Stage st1 = new Stage();
        st1.setTitle("No Hold");
        BorderPane sp1 = new BorderPane();
        Label loginacc = new Label("You do not have any personal information holds");
        HBox login1 = new HBox(loginacc);
        login1.setAlignment(Pos.CENTER);
        Scene Bpane = new Scene(sp1, 400, 200);
        Button loginbut = new Button("OK");
        sp1.setId("hbox");
        //sp1.getStylesheets().add("Style.css");
        sp1.setBottom(loginbut);
        sp1.setCenter(login1);
        BorderPane.setAlignment(loginbut, Pos.CENTER);
        sp1.setPrefSize(600, 400);
        st1.setScene(Bpane);
        st1.show();
        st1.setAlwaysOnTop(true);
        loginbut.setOnAction((ActionEvent event) -> {
            st1.hide();
        });
    }

    public static boolean zeroresultset() throws SQLException {
        //Connection connect = null;
        //connect = sqliteconnection.dbconnector();
        String displaystring = "select * FROM personal";
        PreparedStatement stmt = sqliteConnection.dbconnector().prepareStatement(displaystring);
        ResultSet resset = stmt.executeQuery();
        //while(resset.next()) {	
        //System.out.println(resset.getString("username") +"   " + resset.getString("password"));
        if (!resset.next()) {
            holdtrue();
            return true;
        } else {
            holdfalse();
            return false;
        }

    }
}
