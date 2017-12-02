package golunarproject;



public class teacher {
    private String fname, lname, email, username, id;
    int crn, crn2, crn3, num;




	/**
	* Default empty teacher constructor
	*/
	public teacher() {
		super();
	}

	/**
	* Default teacher constructor
	*/
	public teacher(String fname, String lname, String email, String username, String id, int crn, int crn2, int crn3) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.id = id;
                this.crn = crn;
                this.crn2 = crn2;
                this.crn3 = crn3;
	}
        
	/*
	* Returns value of fname
	* @return
	*/
	public String getFname() {
		return fname;
	}

	/*
	* Sets new value of fname
	* @param
	*/
	public void setFname(String fname) {
		this.fname = fname;
	}

	/*
	* Returns value of lname
	* @return
	*/
	public String getLname() {
		return lname;
	}

	/*
	* Sets new value of lname
	* @param
	*/
	public void setLname(String lname) {
		this.lname = lname;
	}

	/*
	* Returns value of email
	* @return
	*/
	public String getEmail() {
		return email;
	}
        
	/*
	* Sets new value of email
	* @param
	*/
	public void setEmail(String email) {
		this.email = email;
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
	* Returns value of id
	* @return
	*/
	public String getId() {
		return id;
	}

	/*
	* Sets new value of id
	* @param
	*/
	public void setId(String id) {
		this.id = id;
	}

  /*
	* Sets new value of crn
	* @param
	*/
	public void setCrn(int crn) {
		this.crn = crn;
	}
  /*
  * Sets new value of crn2
  * @param
  */
  public void setCrn2(int crn2) {
    this.crn2 = crn2;
  }
  /*
  * Sets new value of crn3
  * @param
  */
  public void setCrn3(int crn3) {
    this.crn3 = crn3;
  }

}
