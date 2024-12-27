package Model;

public class Parcel {
    private String parcelID;
    private String destination;
    private double weight;
    private double fee;
    private boolean processed;

    // Constructor
    public Parcel(String parcelID, String destination, double weight) {
        this.parcelID = parcelID;
        this.destination = destination;
        this.weight = weight;
        this.fee = 0.0; // Initialize fee to 0
        this.processed = false;
    }

    public Parcel(String string, String string2, int int1, double double1) {
		// TODO Auto-generated constructor stub
	}

	public Parcel(String string, int int1, int int2, int int3, int int4, int int5) {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getParcelID() {
        return parcelID;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double getFee() {
        return fee;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // Method to calculate the fee based on weight (you can modify this logic)
    public void calculateFee() {
        if (weight <= 1.0) {
            this.fee = 5.0;
        } else if (weight <= 5.0) {
            this.fee = 10.0;
        } else {
            this.fee = 20.0 + (weight - 5.0) * 5.0;
        }
    }

    // toString method for displaying parcel details
    @Override
    public String toString() {
        return "Parcel{" +
                "parcelID=" + parcelID +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                ", fee=" + fee +
                ", processed=" + processed +
                '}';
    }

	public String getRecipient() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCost() {
		// TODO Auto-generated method stub
		return null;
	}
}
