
public class Customer {

	// Kan vara bra att l�gga till ID-nr annars m�ste man ha HELA NAMNET

	// Mabey this class has to have a ArrayList customer = to add and remove
	// customers
	protected static String identifier = "c";
	private static String customerName;
	private static String phoneNumber;

	public Customer(String customerName, String phoneNumber) {

		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public static String getCustomerName() {
		return customerName;
	}

	public static String getPhoneNumber() {
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
