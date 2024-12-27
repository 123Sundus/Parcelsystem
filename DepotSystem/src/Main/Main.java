package Main;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;
import Model.Customer;
import Model.Parcel;
import Model.ParcelMap;
import Model.QueueOfCustomers;
import Util.FileReaderUtil;
import Util.Log;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Main() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		QueueOfCustomers customers = FileReaderUtil.readCustomerData("customer_data.txt");
		// Process customer data
		
		// Load parcel data
		try {
			ParcelMap parcelMap = FileReaderUtil.readParcels("parcel_data.txt");
			// Process parcel data
		} catch (IOException e) {
			Log.error("Error loading parcel data: " + e.getMessage());
		}
	}
}
