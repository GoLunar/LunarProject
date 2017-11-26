
package golunarproject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GPA {
	static Label trys = new Label();
	static Label trys1 = new Label();
	static int sum;
public static void GPA(String username) throws SQLException {
	
	System.out.println("here it goes123");
	getGpa(username);
	System.out.println("here it goes");
	
	
}


public static void getGpa(String username) throws SQLException {
	
	
	Connection connect = null;
	connect = sqliteConnection.dbconnector();
	
	String Signupstring = "SELECT grade,grade.crn,credits FROM grade inner join classinfo on grade.crn = classinfo.crn where grade.student=?";
	PreparedStatement prepstate ;
	prepstate = connect.prepareStatement(Signupstring);
	prepstate.setString(1, username);
	ResultSet reset = prepstate.executeQuery();
	if(!reset.isBeforeFirst()) {
		System.out.println("no entries");
		Label noinfo = new Label("Please update information in Refund Options");
		Label noinfo1 = new Label("No Address Found");
		Font font = new Font("Arial",24);
		noinfo.setFont(font);
		noinfo1.setFont(font);
		//root1.setTop(noinfo1);
		//root1.setCenter(noinfo);
		BorderPane.setAlignment(noinfo,Pos.CENTER);
		BorderPane.setAlignment(noinfo1, Pos.CENTER);
		Button ok = new Button("Accept");
		prepstate.close();
		connect.close();
		ok.setOnAction((ActionEvent event) -> {
			//stage2.hide();
		});
		//root1.setBottom(ok);
		BorderPane.setAlignment(ok, Pos.CENTER);
	}
	ArrayList<String> grade = new ArrayList<String>();
	ArrayList<Integer> credit = new ArrayList<Integer>();
     sum =0;
	while (reset.next()) { 
	   // credit.add(reset.getString("crn"));
	    grade.add(reset.getString("grade"));
	    for(int i=0;i<100;i++) {
	    int c = reset.getInt("credits");
	    
			credit.add(i,c);
	    }
		System.out.println(Arrays.toString(credit.toArray()));
		System.out.println("sum = "+ sum);
	}
	double totalCredit=0.0;
		double realGrade=0.0;
 		double result=0.0;
	for(int i=0;i<grade.size();i++){
					
		 			if(grade.get(i).equals("A+")){
		 				realGrade=4.0;				
	 			}
		 			else if(grade.get(i).equals("A")){
		 				realGrade=4.0;
		 			}
		 			else if(grade.get(i).equals("A-")){
		 				realGrade=3.67;			
		 			}
		 			else if(grade.get(i).equals("B+")){
		 				realGrade=3.33;			
		 			}
		 			else if(grade.get(i).equals("B")){
		 				realGrade=3.00;			
		 			}
		 			else if(grade.get(i).equals("B-")){
		 				realGrade=2.67;			
		 			}
		 			else if(grade.get(i).equals("C+")){
		 				realGrade=2.33;			
		 			}
		 			else if(grade.get(i).equals("C")){
		 				realGrade=2.00;			
 			}
		 			else if(grade.get(i).equals("C-")){
		 				realGrade=1.67;			
		 			}		
		 			else if(grade.get(i).equals("D+")){
		 				realGrade=1.33;			
		 			}
	 			else if(grade.get(i).equals("D")){
		 				realGrade=1.00;			
		 			}
		 			else if(grade.get(i).equals("D-")){
		 				realGrade=0.67;			
		 			}			
		 			else if(grade.get(i).equals("F")){
		 				realGrade=0.00;			
		 			}			
		 
		 
		 			result = result+realGrade*credit.get(i);
	 			//totalCredit=totalCredit+credit.get(i);
		 		}	
	double total = result;
	             System.out.println("Gpa = " + total);
	Stage stage2 = new Stage();
	BorderPane root1 = new BorderPane();
	stage2.setTitle("Refund: Paper Check");
	root1.setTop(trys);
	root1.setCenter(trys1);
	Scene sc = new Scene(root1,500,400);
	stage2.setScene(sc);
	stage2.show();
	
	
	
}
}
