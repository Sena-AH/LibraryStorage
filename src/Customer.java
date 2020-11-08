
public class Customer {

	// Kan vara bra att l�gga till ID-nr annars m�ste man ha HELA NAMNET

	// Mabey this class has to have a ArrayList customer = to add and remove
	// customers
	protected static String identifier = "c";
	private String customerName;
	private  String phoneNumber;

	public Customer(String customerName, String phoneNumber) {

		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public static Customer setCustomer(String name, String number) {
		Customer customer = new Customer(name, number);
		return customer;
		
	}
	
	
	@Override
	public String toString() {
		return "Borrowed by: Name: " + this.getCustomerName() + " Phone number: " + this.getPhoneNumber();

	}
}
