
public class Customer {
	
	// Kan vara bra att l�gga till ID-nr annars m�ste man ha HELA NAMNET

	private String customerName;
	private String phoneNumber;
	
	public Customer(String customerName, String phoneNumber) {
		
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
