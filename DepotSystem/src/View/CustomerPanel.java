package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Queue;

import Controller.Manager;
import Model.Customer;
import Model.Parcel;
import Model.ParcelMap;
import Model.QueueOfCustomers;

public class CustomerPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel customerLabel;
    private JTextArea customerTextArea;
    private JButton processCustomerButton;
    private QueueOfCustomers manager;
    private Queue<Customer> customerQueue;

    public CustomerPanel(QueueOfCustomers customerQueue2) {
        this.manager = customerQueue2;
        this.customerQueue = customerQueue2.getCustomers();
        setLayout(new BorderLayout());

        customerLabel = new JLabel("Customers in Queue:");
        add(customerLabel, BorderLayout.NORTH);

        customerTextArea = new JTextArea();
        customerTextArea.setEditable(false);
        customerTextArea.setLineWrap(true);
        customerTextArea.setWrapStyleWord(true);
        add(new JScrollPane(customerTextArea), BorderLayout.CENTER);

        processCustomerButton = new JButton("Process Customer");
        processCustomerButton.addActionListener(this);
        add(processCustomerButton, BorderLayout.SOUTH);

        updateCustomerTextArea();
    }

    public CustomerPanel(QueueOfCustomers customerQueue2, ParcelMap parcelMap) {
		// TODO Auto-generated constructor stub
	}

	public void updateCustomerTextArea() {
        customerTextArea.setText("");
        if (customerQueue.isEmpty()) {
            customerTextArea.append("No customers in queue.\n");
        } else {
            for (Customer customer : customerQueue) {
                customerTextArea.append(customer.toString() + "\n");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == processCustomerButton) {
            if (!customerQueue.isEmpty()) {
                Customer customer = customerQueue.poll();
                manager.addCustomer(customer);
                updateCustomerTextArea();
            } else {
                JOptionPane.showMessageDialog(this, "No customers in queue.");
            }
        }
    }
}
