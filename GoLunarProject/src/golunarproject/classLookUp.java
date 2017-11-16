package golunarproject;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Sadat
 */
public class classLookUp {
	public static ObservableList<ObservableList> data;
    public static TableView tableview;
    public static void classLookUp() {
        // Window Creation
        /*Stage stage1 = new Stage();
        GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        // created labels
        Label termSelect = new Label("Select a Term: ");

        // combo box for selecting terms
        final ComboBox termBox = new ComboBox();
        termBox.getItems().addAll(
                "Spring Semester 2018",
                "Summer 2018"
        );

        termBox.setPromptText("Select a Term");

        Button submit = new Button();
        submit.setText("Submit");

        //alligns fields, buttons, labels
        GridPane.setConstraints(termSelect, 10, 5);
        GridPane.setConstraints(termBox, 11, 5);
        GridPane.setConstraints(submit, 11, 7);

        root1.getChildren().addAll(termSelect, termBox, submit);
        Scene scene = new Scene(root1, 400, 200);
        root1.setId("pane1");
        stage1.setTitle("Select a Term");
        stage1.setScene(scene);

        stage1.show();

        //basically triggers button actions and also hides the term window.
        submit.setOnAction((ActionEvent e) -> {
            if (termBox.getValue() != null && !termBox.getValue().toString().isEmpty()) {
                
                stage1.hide();
            }
        });
*/
    	lookup();
    }

    public static void lookup() {
        // Window Creation
       Stage stage1 = new Stage();
       stage1.setResizable(false);
       /* GridPane root1 = new GridPane();
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setVgap(10);
        root1.setHgap(5);

        root1.getChildren().addAll();
        Scene scene = new Scene(tableview, 800, 600);
        root1.setId("pane1");
        stage1.setTitle("Look-Up Classes");
        stage1.setScene(scene);
        tableview = new TableView();
        buildData();

        //Main Scene
        //Scene scene1 = new Scene(tableview);        

       // stage.setScene(scene);
     */
        
        
        
        stage1.show();
        
    	
    	tableview = new TableView();
        try {
    		buildData();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        //Main Scene
        Scene scene = new Scene(tableview);        
       
        stage1.setScene(scene);
        scene.getWindow().centerOnScreen();
        stage1.show();
    	
    	
    	
    	
    	
    	
    	
    }
    public static void buildData() throws SQLException{
        Connection c=null ;
        data = FXCollections.observableArrayList();
        try{
          c = sqliteConnection.dbconnector();
          //SQL FOR SELECTING ALL OF CUSTOMER
          String SQL = "SELECT * from class";
          //ResultSet
          ResultSet rs = c.createStatement().executeQuery(SQL);

         
          for(int i=0; i<rs.getMetaData().getColumnCount(); i++){
              //We are using non property style for making dynamic table
              final int j = i;                
              TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
              col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                  public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                      return new SimpleStringProperty(param.getValue().get(j).toString());                        
                  }                    
              });

              tableview.getColumns().addAll(col); 
              tableview.setPrefSize(1000.0, 400.0);
             // tableview.setColumnResizePolicy(tableview.CONSTRAINED_RESIZE_POLICY);
              System.out.println("Column ["+i+"] ");
          }

          
          while(rs.next()){
              //Iterate Row
              ObservableList<String> row = FXCollections.observableArrayList();
              for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                  //Iterate Column
                  row.add(rs.getString(i));
              }
              System.out.println("Row [1] added "+row );
              data.add(row);

          }

          //FINALLY ADDED TO TableView
          tableview.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");             
        } finally {
        	c.close();
        }
    }

    
    
    

}
