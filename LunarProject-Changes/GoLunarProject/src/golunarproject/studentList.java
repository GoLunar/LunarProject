package golunarproject;


import static golunarproject.AdminMenu.root;
import static golunarproject.conSchedule.con;
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class studentList {
    public static ObservableList<ObservableList> data;
    public static TableView tableview;
    public static void start() {
        lookup();
    }

    public static void lookup() {
        // Window Creation
       Stage stage1 = new Stage();
       stage1.setResizable(false);

        
        
        stage1.show();
        
    	
    	tableview = new TableView();
        try {
    		buildData();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        //Main Scene
       // Group root = new Group();
        Scene scene = new Scene(tableview, 800, 600);
       // root.getChildren().add(tableview);
       
        stage1.setScene(scene);
        scene.getWindow().centerOnScreen();
        stage1.show();
    	
    	
    	
    	
    	
    	
    	
    }
    public static void buildData() throws SQLException{
        Connection c=null ;
        data = FXCollections.observableArrayList();
        try{
          c = sqliteConnection.dbconnector();
          //SQL FOR SELECTING ALL OF CLASS
          String SQL = "SELECT * from School";
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



