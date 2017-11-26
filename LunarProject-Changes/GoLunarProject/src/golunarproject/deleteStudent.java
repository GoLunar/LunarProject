
package golunarproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


public class deleteStudent {
    public static ObservableList<ObservableList> data;
    
    public static ListView list;
    public static TextField username;
 //   public static Label grade1,student1,crn1;
    public static Button deleteB,update;
    public static ResultSet rs = null;
    public static Connection connect = sqliteConnection.dbconnector();
    public static PreparedStatement prepstate = null;
    
    public static void removeStudent() {
        // Window Creation
       Stage stage1 = new Stage();
       stage1.setResizable(false);

        
        
        stage1.show();
        
        
        

  //      crn1.setText("CRN: ");
        username = new TextField();
        username.setPromptText("Student ID");
        username.setMaxWidth(200);
        username.setEditable(false);
        
        deleteB = new Button("Delete");
        
        
    

        
        try {
    		buildData();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        //Main Scene
        GridPane root = new GridPane();
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(username,deleteB);
        

        root.getChildren().addAll(list, vbox);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(15);
        root.setHgap(15);
        

        GridPane.setConstraints(list, 1, 0);
        //GridPane.setConstraints(vbox1, 3, 0);
        GridPane.setConstraints(vbox, 2, 0);
        

        
        Scene scene = new Scene(root, 500, 500);

       
        stage1.setScene(scene);
        stage1.show();
    	
    	
    	
    	
    }
    public static void buildData() throws SQLException{
        Connection c=null ;
        data = FXCollections.observableArrayList();
        
        try{
          c = sqliteConnection.dbconnector();
          //SQL FOR SELECTING ALL OF CLASS
          String SQL = "SELECT * FROM School";
          //ResultSet
          rs = c.createStatement().executeQuery(SQL);

         
          for(int i=0; i<rs.getMetaData().getColumnCount(); i++){
              //We are using non property style for making dynamic table
              final int j = i;                
              TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
              col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                  public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                      return new SimpleStringProperty(param.getValue().get(j).toString());                        
                  }                    
              });

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

          
          //FINALLY ADDED TO ListView
          list = new ListView();
          
          for (int i = 0; i < data.size(); i++){
                list.getItems().add((String)data.get(i).get(0));
           }
          
          
          list.setOnMouseClicked(e ->{
              
          try{
                String s= (String) list.getSelectionModel().getSelectedItem();

                System.out.println(s);


                String query = "select * from School where username = ?";
               
                prepstate = connect.prepareStatement(query);
                prepstate.setString(1, s);
                rs = prepstate.executeQuery();
                

               // while(rs.next()){
                    username.setText(rs.getString("username"));

                
                
                prepstate.close();
     
                
            }catch(Exception exc){
                
            }
          
         
          });
          
          deleteB.setOnAction(e ->{
            try{
                String query = "delete from School where username=?";
                prepstate = connect.prepareStatement(query);
                prepstate.setString(1, username.getText());

                prepstate.execute();
                prepstate.close();
                

            }catch(Exception exc){
                
            }
        });
          
          
        

        }catch(Exception exe){
                  
         }
    }
 
}
