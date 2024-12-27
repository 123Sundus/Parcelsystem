package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import Model.Parcel;
import Model.ParcelMap;
import Model.QueueOfCustomers;
import Util.Log;

/**
 * The Worker class represents a depot worker who processes customer orders.
 */
public class Worker {

    private QueueOfCustomers customerQueue;
    private ParcelMap parcelMap;

    /**
     * Constructs a Worker object with a customer queue and a parcel map.
     *
     * @param customerQueue The queue of customers waiting to be processed.
     * @param parcelMap The map containing all the parcels.
     */
    public Worker(QueueOfCustomers customerQueue, ParcelMap parcelMap) {
        this.customerQueue = customerQueue;
        this.parcelMap = parcelMap;
    }

    /**
     * Processes the next customer in the queue, handling their parcel order.
     *
     * @return A list of the parcels that were processed.
     */
    public List<Parcel> processNextCustomer() {
        List<Parcel> processedParcels = new ArrayList<>();

        if (!customerQueue.isEmpty()) {
            Customer currentCustomer = customerQueue.removeCustomer();
            Log.getInstance().append("Customer " + currentCustomer.getName() + " removed from queue.");

            List<Parcel> customerParcels = currentCustomer.getParcels();
            for (Parcel parcel : customerParcels) {
                if (parcelMap.containsParcel(parcel.getParcelID())) {
                    parcelMap.removeParcel(parcel.getParcelID());
                    processedParcels.add(parcel);
                    Log.getInstance().append("Parcel " + parcel.getParcelID() + " processed for customer " + currentCustomer.getName() + ".");
                } else {
                    Log.getInstance().append("Error: Parcel " + parcel.getParcelID() + " not found for customer " + currentCustomer.getName() + ".");
                }
            }
        }

        return processedParcels;
    }

	public Parcel processCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
