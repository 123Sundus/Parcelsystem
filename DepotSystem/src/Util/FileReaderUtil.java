package Util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import Model.Parcel;

public class FileReaderUtil {
    public static List<Parcel> readParcels(String filePath) {
        List<Parcel> parcels = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                parcels.add(new Parcel(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5])));
            }
        } catch (Exception e) {
            System.out.println("Error reading parcel file: " + e.getMessage());
        }
        return parcels;
    }

    public static List<Customer> readCustomers(String filePath) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                customers.add(new Customer(data[0], data[1], line));
            }
        } catch (Exception e) {
            System.out.println("Error reading customer file: " + e.getMessage());
        }
        return customers;
    }
}