package Controller;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.ParcelMap;
import Model.QueueOfCustomers;
import View.CustomerPanel;
import View.ParcelPanel;
import View.WorkerPanel;

public class Manager {

	private JFrame frame;
	private CustomerPanel customerPanel;
	private ParcelPanel parcelPanel;
	private WorkerPanel workerPanel;
	private QueueOfCustomers customerQueue;
	private ParcelMap parcelMap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager window = new Manager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Throwable 
	 */
	@SuppressWarnings("removal")
	public Manager() throws Throwable {
		finalize();
		// Initialize and load data for customers and parcels
		customerQueue = new QueueOfCustomers(null);
		parcelMap = new ParcelMap();
		loadCustomerData("customer.txt");
		loadParcelData("parcel.txt");

		// Initialize panels
		customerPanel = new CustomerPanel(customerQueue);
		parcelPanel = new ParcelPanel(parcelMap, customerQueue, workerPanel);
		workerPanel = new WorkerPanel(customerQueue, parcelMap, parcelPanel, customerPanel);

		// Set up the frame and add panels
		frame.getContentPane().add(customerPanel);
		frame.getContentPane().add(parcelPanel);
		frame.getContentPane().add(workerPanel);

		// Initial update of panels
		customerPanel.updateUI();
		parcelPanel.updateUI();
		workerPanel.updateUI();
	}

	private void loadParcelData(String string) {
		// TODO Auto-generated method stub
		
	}

	private void loadCustomerData(String string) {
		// TODO Auto-generated method stub
		
	}
}