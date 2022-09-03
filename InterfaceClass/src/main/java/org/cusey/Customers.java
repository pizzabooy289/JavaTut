package org.cusey;

public class Customers implements Pattern  {
	
	private String first_name = "";
	private String last_name  = "";
	
	public String getFirst_name() {return first_name;}
	public void setFirst_name(String first_name) {this.first_name = first_name;}

	public String getLast_name() {return last_name;}
	public void setLast_name(String last_name) {this.last_name = last_name;}

	public Customers(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Customers copy() {
		Customers copy_customer = new Customers("","");
		
		copy_customer.first_name = this.first_name;
		copy_customer.last_name= this.last_name;
		
		return copy_customer;
	}

	@Override
	public Customers clone() {
		Customers clone_customer  = this;
		return clone_customer;
	}
	@Override
	public String toString() {
		return "Customers [first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	

}
