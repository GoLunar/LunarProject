package golunarproject;


    import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class admin {

    private final StringProperty ID;
    private final StringProperty password;



    public admin(String id,String password) {
        this.ID = new SimpleStringProperty(id);
        this.password = new SimpleStringProperty(password);

    }



	/**
	* Returns value of ID
	* @return
	*/
	public StringProperty getID() {
		return ID;
	}

	/**
	* Returns value of password
	* @return
	*/
	public StringProperty getPassword() {
		return password;
	}

	/*
	* Create string representation of admin for printing
	* @return
	*/
	@Override
	public String toString() {
		return "admin [ID=" + ID + ", password=" + password + "]";
	}
}
