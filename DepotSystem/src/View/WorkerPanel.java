package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.Worker;
import Model.Customer;
import Model.Parcel;
import Model.ParcelMap;
import Model.QueueOfCustomers;

public class WorkerPanel extends JPanel {
    private final QueueOfCustomers customerQueue;
    private final Worker worker;
    private final JLabel currentCustomerLabel;
    private final JLabel currentParcelLabel;
    private final JButton processCustomerButton;
    private final JTextArea customerQueueTextArea;

    public WorkerPanel(QueueOfCustomers customerQueue, Worker worker) {
        this.customerQueue = customerQueue;
        this.worker = worker;

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        currentCustomerLabel = new JLabel("Current Customer: ");
        currentParcelLabel = new JLabel("Current Parcel: ");

        topPanel.add(currentCustomerLabel);
        topPanel.add(currentParcelLabel);

        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        processCustomerButton = new JButton("Process Customer");
        processCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processCustomer();
            }
        });
        centerPanel.add(processCustomerButton, BorderLayout.NORTH);

        customerQueueTextArea = new JTextArea();
        customerQueueTextArea.setEditable(false);
        centerPanel.add(customerQueueTextArea, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        updateCustomerQueue();
    }

    public WorkerPanel(QueueOfCustomers customerQueue2, ParcelMap parcelMap, ParcelPanel parcelPanel,
			CustomerPanel customerPanel) {
				this.customerQueue = null;
				this.worker = null;
				this.currentCustomerLabel = new JLabel();
				this.currentParcelLabel = new JLabel();
		// TODO Auto-generated constructor stub
				this.processCustomerButton = new JButton();
				this.customerQueueTextArea = new JTextArea();
	}

	private void updateCustomerQueue() {
		// TODO Auto-generated method stub
		
	}

	private void processCustomer() {
        Customer customer = customerQueue.removeCustomer();
        if (customer != null) {
            Parcel parcel = worker.processCustomer(customer);

            currentCustomerLabel.setText("Current Customer: " + customer.getName());
            currentParcelLabel.setText("Current Parcel: " + (parcel != null ? parcel.getDestination() : "No parcel"));

            updateCustomerQueue();
        } else {
            JOptionPane.showMessageDialog(this, "No customers in the queue.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}