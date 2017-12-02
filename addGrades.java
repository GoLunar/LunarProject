

import static golunarproject.classLookUp.tableview;
import static golunarproject.conSchedule.data;
import static golunarproject.conSchedule.tableview;
import static golunarproject.deleteStudent.deleteB;
import static golunarproject.deleteStudent.list;
import static golunarproject.deleteStudent.username;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


public class addGrades {
    public static ObservableList<ObservableList> data;
    public static TableView tableview;
    public static ListView list;
    public static TextField grade,student,crn;
 //   public static Label grade1,student1,crn1;
    public static Button gradeb,update;
    public static ResultSet rs = null;
    public static Connection connect = sqliteConnection.dbconnector();
    public static PreparedStatement prepstate = null;
    
    public static void addGrades() {
        // Window Creation
       Stage stage = new Stage();
       stage.setResizable(false);

        
        stage.show();
        
        
  //      grade1.setText("Grade: ");
        grade = new TextField();
        grade.setPromptText("Grade");
        grade.setMaxWidth(200);
        
        
  //      student1.setText("StudentID: ");
        student = new TextField();
        student.setPromptText("Student ID");
        student.setMaxWidth(200);
        student.setEditable(false);
        
  //      crn1.setText("CRN: ");
        crn = new TextField();
        crn.setPromptText("CRN");
        crn.setMaxWidth(200);
        crn.setEditable(false);
        
        gradeb = new Button("Grade");
        
        tableview = new TableView();
        list = new ListView();
        
        
        try {
    		buildData();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    	
        


        
        GridPane root = new GridPane();
        
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(student,crn, grade, gradeb);
        
        

        root.getChildren().addAll(list, vbox);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(15);
        root.setHgap(15);
        

        GridPane.setConstraints(list, 1, 0);
        GridPane.setConstraints(vbox, 2, 0);
        GridPane.setConstraints(tableview,3,0);
        

        
        Scene scene = new Scene(root, 500, 500);

       
        stage.setScene(scene);
        stage.show();

        
       
    	
    }
    public static void buildData() throws SQLException{
        Connection c=null ;
        data = FXCollections.observableArrayList();
        
        try{
          c = sqliteConnection.dbconnector();
          //SQL FOR SELECTING ALL OF CLASS
          String SQL = "SELECT * FROM classesadded";
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

              tableview.getColumns().addAll(col); 

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

          tableview.setItems(data);
          
          //FINALLY ADDED TO ListView
          
          
          for (int i = 0; i < data.size(); i++){
              String x = (String)data.get(i).get(1);
              String y = (String)data.get(i).get(0);
              list.getItems().add(x+", "+y);
           }
          
          
          list.setOnMouseClicked( e ->{
              
          try{
               String s= (String) list.getSelectionModel().getSelectedItem();
                
               String[] parts = s.split(", ");
               String part1 = parts[0]; // student id
               String part2 = parts[1]; // crn
                
               int n = Integer.parseInt(part2);
               System.out.println(n);


                String query = "select * from classesadded where student= ? and crn= ?";
               
                prepstate = connect.prepareStatement(query);
                prepstate.setString(1, part1);
                prepstate.setInt(2, n);
                rs = prepstate.executeQuery();
                

               // while(rs.next()){
                    crn.setText(rs.getString("crn"));
                    student.setText(rs.getString("student"));
                    grade.setText(rs.getString("grade"));
               // }
                
                
               prepstate.close();
     
                
            }catch(Exception exc){
                
            }
          
         
          });
          
          gradeb.setOnAction(e ->{
            try{
                String query = "update classesadded set grade=? where student='"+student.getText()+"' and crn='"+crn.getText()+"' ";
                prepstate = connect.prepareStatement(query);

                prepstate.setString(1, grade.getText());
                

                prepstate.execute();
                prepstate.close();
                

            }catch(Exception exc){
                
            }
        });
          
        }catch(Exception exe){
                  
         }
    }
 
}
