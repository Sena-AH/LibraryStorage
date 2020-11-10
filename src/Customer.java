
public class Customer {

	// This class handles the Customer object

	private String customerName;
	private String phoneNumber;

	public Customer(String customerName, String phoneNumber) {

		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "Borrowed by: Name: " + this.getCustomerName() + " Phone number: " + this.getPhoneNumber();

	}
}
