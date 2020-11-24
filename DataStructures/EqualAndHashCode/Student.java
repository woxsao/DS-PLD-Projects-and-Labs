/**
*  Student class with a registrationNumber as a field
*
*/


public class Student {
	private String registrationNumber;

	// please complete a default constructor
	public Student(){
		registrationNumber = "0000";
	}


	// overloaded constructor that takes in the number as a String
	public Student(String number){
		registrationNumber = number;
	}


	// accessor
	public String getRegistrationNumber(){
		return registrationNumber;
	}

	//modifier
	public void setRegistrationNumber(String newNumber){
		registrationNumber= newNumber;
	}

	@Override
	public String toString(){
		return registrationNumber;
	}

	@Override
	public boolean equals(Object b){
		if(b instanceof Student){
			Student a = (Student) b;
			return(this.getRegistrationNumber().equals(a.getRegistrationNumber()));
		}
		else{
			return false;
		}
	}
/*

	@Override
	public int hashCode(){
		return this.registrationNumber.hashCode();
	}
*/




}
