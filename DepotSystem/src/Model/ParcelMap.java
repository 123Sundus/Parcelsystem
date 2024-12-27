package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *  This class uses a HashMap to store parcel objects
 */
public class ParcelMap {

    private Map<String, Parcel> parcelMap;

    /**
     * Constructor for the ParcelMap class
     */
    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    /**
     * Adds a parcel to the parcelMap
     *
     * @param parcel the parcel to add
     */
    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelID(), parcel);
    }

    /**
     * Removes a parcel from the parcelMap
     *
     * @param parcelID the ID of the parcel to remove
     * @return the removed parcel, or null if the parcel was not found
     */
    public Parcel removeParcel(String parcelID) {
        return parcelMap.remove(parcelID);
    }

    /**
     * Gets a parcel from the parcelMap
     *
     * @param parcelID the ID of the parcel to get
     * @return the parcel, or null if the parcel was not found
     */
    public Parcel getParcel(String parcelID) {
        return parcelMap.get(parcelID);
    }

    /**
     * Checks if a parcel exists in the parcelMap
     *
     * @param parcelID the ID of the parcel to check
     * @return true if the parcel exists, false otherwise
     */
    public boolean containsParcel(String parcelID) {
        return parcelMap.containsKey(parcelID);
    }

    /**
     * Gets the size of the parcelMap
     *
     * @return the size of the parcelMap
     */
    public int size() {
        return parcelMap.size();
    }

	public void add(Parcel parcel) {
		// TODO Auto-generated method stub
		
	}
}