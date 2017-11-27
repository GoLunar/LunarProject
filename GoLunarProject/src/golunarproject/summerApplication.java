package golunarproject;
import java.awt.Desktop;
import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.Stage;



/**
 *
 * @author Andres
 */
class summerApplication {

    public static void Application() {
       
        /*WebView webView = new WebView();
        webView.getEngine().load("https://www.youtube.com/");
    */
        
        Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);
      
        Label appointment = new Label("This option is currently unavailable");
        appointment.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD,14));
        //appointment.setTextFill(Color.RED);
        root1.add(appointment,0,1);
        
        Scene scene = new Scene(root1, 600, 300);
        root1.setId("pane1");
        stage1.setTitle("Summer Application");
        stage1.setScene(scene);

        stage1.show();


    }
    
}
