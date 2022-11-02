package users;

public class customer extends user {
	
	protected String customer_id,address;

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		address = address;
	}

	public customer(String name, String password, String customer_id, String address) {
		super(name, password);
		this.customer_id = customer_id;
		address = address;
	}



}
