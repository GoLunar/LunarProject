/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunarproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Sadat
 */
public class Login extends Application{
    public static void main(String[] args){
           sqliteConnection gr2 = new sqliteConnection();
           Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GoLunar");
       
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(10, 10, 10, 10));
		root1.setVgap(10);
		root1.setHgap(5);
     

		root1.getChildren().addAll();
		Scene scene = new Scene(root1, 400, 300);
		root1.setId("pane1");
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		
		primaryStage.show();
    }
    
}
