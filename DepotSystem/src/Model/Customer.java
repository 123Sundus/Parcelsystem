package Model;

import java.util.List;

public class Customer {

    private String name;
    private int customerId;
    private String address;
    private String phoneNumber;
    private String parcelId;

    public Customer(String name, int customerId, String address, String phoneNumber, String line) {
        this.name = name;
        this.customerId = customerId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.parcelId = line;
    }

    public Customer(String customerDetails, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerId=" + customerId +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", parcelId='" + parcelId + '\'' +
                '}';
    }

	public List<Parcel> getParcels() {
		// TODO Auto-generated method stub
		return null;
	}
}