package golunarproject;



public class Student {
    private String username, password, emailaddress, firstname, lastname, phone, emergency, dob, enroll;



	/*
	* Default empty constructor
	*/
	public Student() {
		super();
	}


	/*
	* Default constructor
	*/
	public Student(String username, String password, String emailaddress, String firstname, String lastname, String phone, String emergency, String dob, String enroll) {
		super();
		this.username = username;
		this.password = password;
		this.emailaddress = emailaddress;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.emergency = emergency;
		this.dob = dob;
		this.enroll = enroll;
	}

	/*
	* Returns value of username
	* @return
	*/
	public String getUsername() {
		return username;
	}

        
	/*
	* Sets new value of username
	* @param
	*/
	public void setUsername(String username) {
		this.username = username;
	}

        
	/*
	* Returns value of password
	* @return
	*/
	public String getPassword() {
		return password;
	}

        
	/*
	* Sets new value of password
	* @param
	*/
	public void setPassword(String password) {
		this.password = password;
	}

        
	/*
	* Returns value of emailaddress
	* @return
	*/
	public String getEmailaddress() {
		return emailaddress;
	}

        
	/*
	* Sets new value of emailaddress
	* @param
	*/
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

        
	/*
	* Returns value of firstname
	* @return
	*/
	public String getFirstname() {
		return firstname;
	}

        
	/*
	* Sets new value of firstname
	* @param
	*/
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

        
	/*
	* Returns value of lastname
	* @return
	*/
	public String getLastname() {
		return lastname;
	}

        
	/*
	* Sets new value of lastname
	* @param
	*/
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

        
	/*
	* Returns value of phone
	* @return
	*/
	public String getPhone() {
		return phone;
	}

        
	/*
	* Sets new value of phone
	* @param
	*/
	public void setPhone(String phone) {
		this.phone = phone;
	}

        
	/*
	* Returns value of emergency
	* @return
	*/
	public String getEmergency() {
		return emergency;
	}

        
	/*
	* Sets new value of emergency
	* @param
	*/
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

        
	/*
	* Returns value of dob
	* @return
	*/
	public String getDob() {
		return dob;
	}

        
	/*
	* Sets new value of dob
	* @param
	*/
	public void setDob(String dob) {
		this.dob = dob;
	}

        
	/*
	* Returns value of enroll
	* @return
	*/
	public String getEnroll() {
		return enroll;
	}

        
	/*
	* Sets new value of enroll
	* @param
	*/
	public void setEnroll(String enroll) {
		this.enroll = enroll;
	}

        
	public static class Builder {
		 private static String username;
		 private static String password;
		 private static String emailaddress;
		 private static String firstname;
		 private static String lastname;
		 private static String phone;
		 private static String emergency;
		 private static String dob;
		 private static String enroll;

		 public static Builder username(String username) {
		//	 this.username = username;
//			 return this;
                     return null;
		}

		 public static Builder password(String password) {
			// this.password = password;
//			 return this;
                     return null;
		}

		 public static Builder emailaddress(String emailaddress) {
                     return null;
			// this.emailaddress = emailaddress;
			// return this;
		}

		 public static Builder firstname(String firstname) {
                     return null;
			// this.firstname = firstname;
			// return this;
		}

		 public static Builder lastname(String lastname) {
                     return null;
			// this.lastname = lastname;
			// return this;
		}

		 public static Builder phone(String phone) {
                     return null;
			// Builder.phone = phone;
			// return this;
		}

		 public static Builder emergency(String emergency) {
                     return null;
			// Builder.emergency = emergency;
			// return this;
		}

		 public static Builder dob(String dob) {
                     return null;
			//this.dob = dob;
			// return this;
		}

		 public static Builder enroll(String enroll) {
                     return null;
			 //this.enroll = enroll;
			 //return this;
		}

		public teacher create() {
                     return null;

		}
	}

	/**
	* Create string representation of teacher for printing
	* @return
	*/
	@Override
	public String toString() {
		return "teacher [username=" + username + ", password=" + password + ", emailaddress=" + emailaddress + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", emergency=" + emergency + ", dob=" + dob + ", enroll=" + enroll + "]";
	}
}
