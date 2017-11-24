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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class viewGrade {
	 public static ObservableList<ObservableList> data;
	    public static TableView tableview;


	    
	    public static void viewGrade(String username) {
	    	con(username);
}
	    
	    
	    public static void con(String username) {
	        // Window Creation
	        Stage stage1 = new Stage();
	        GridPane root1 = new GridPane();
	        root1.setPadding(new Insets(10, 10, 10, 10));
	        root1.setVgap(10);
	        root1.setHgap(5);

	        root1.getChildren().addAll();
	        //Scene scene = new Scene(root1, 800, 600);
	        root1.setId("pane1");
	        stage1.setTitle("Concise Schedule");
	        //stage1.setScene(scene);

	        stage1.show();
	     	tableview = new TableView();
	        try {
	    		buildData(username);
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
	    
	    
	    
	    
	    
	 public static void buildData(String username) throws SQLException{
	        Connection c=null ;
	        data = FXCollections.observableArrayList();
	
	
	try {
		Connection connect = null;
		connect = sqliteConnection.dbconnector();
		
		String Signupstring = "SELECT Distinct classinfo.crn,course,credits,name,time,professor,length,room,grade FROM grade inner join classinfo on grade.crn = classinfo.crn where grade.student=?";
		PreparedStatement prepstate ;
		
		
		prepstate = connect.prepareStatement(Signupstring);
		prepstate.setString(1,username);
	    ResultSet rs = prepstate.executeQuery();
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
            col.prefWidthProperty().bind(tableview.widthProperty().multiply(0.3));
            //tableview.setColumnResizePolicy(tableview.CONSTRAINED_RESIZE_POLICY);
            tableview.setPrefSize(1000.0, 400.0);
            //ableview.get
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
      	//c.close();
      }
  }
	
	
	
	

}
