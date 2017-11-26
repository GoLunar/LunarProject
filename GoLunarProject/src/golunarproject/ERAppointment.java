package golunarproject;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Andres
 */
class ERAppointment {

    static void Appointment() {
          // Window Creation
        Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);
      
        Label appointment = new Label("Please call  '1-877-532-8945'  to check available times for your appointment");
        appointment.setFont(Font.font("Tahoma",FontWeight.BOLD,14));
        appointment.setTextFill(Color.RED);
        root1.add(appointment,0,1);
        
        Scene scene = new Scene(root1, 600, 300);
        root1.setId("pane1");
        stage1.setTitle("Appointment ");
        stage1.setScene(scene);

        stage1.show();
        
    }
    
}

