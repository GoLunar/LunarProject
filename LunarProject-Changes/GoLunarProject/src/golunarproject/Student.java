package golunarproject;


    import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

    private final StringProperty ID;
    private final StringProperty crn;
    private final StringProperty grade;

    public Student(String id, String firstname,String grade) {
        this.ID = new SimpleStringProperty(id);
        this.crn = new SimpleStringProperty(firstname);

        this.grade = new SimpleStringProperty(grade);
    }

    public String getID() {
        return (String) this.ID.get();
    }

    public String getCRN() {
        return (String) this.crn.get();
    }
    public String getGrade() {
        return (String) this.grade.get();
    }



    public void setID(String value) {
        this.ID.set(value);
    }

    public void setFirstName(String value) {
        this.crn.set(value);
    }

    
     public void setGrade(String value) {
        this.grade.set(value);
    }

    public StringProperty idProperty() {
        return this.ID;
    }

    public StringProperty firstCRNProperty() {
        return this.crn;
    }

    
     public StringProperty gradeProperty() {
        return this.grade;
    }
}


