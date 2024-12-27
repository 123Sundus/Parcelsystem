package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;

public class ParcelPanel extends JPanel {
    private JLabel parcelIdLabel;
    private JLabel recipientLabel;
    private JLabel addressLabel;
    private JLabel weightLabel;
    private JLabel costLabel;
    private JLabel statusLabel;

    public ParcelPanel(ParcelMap parcelMap, QueueOfCustomers customerQueue, WorkerPanel workerPanel) {
        setLayout(new GridLayout(6, 2));
        setBorder(BorderFactory.createTitledBorder("Parcel Details"));

        parcelIdLabel = new JLabel("Parcel ID: ");
        recipientLabel = new JLabel("Recipient: ");
        addressLabel = new JLabel("Address: ");
        weightLabel = new JLabel("Weight: ");
        costLabel = new JLabel("Cost: ");
        statusLabel = new JLabel("Status: ");

        add(parcelIdLabel);
        add(new JLabel("")); // Empty label for spacing
        add(recipientLabel);
        add(new JLabel("")); // Empty label for spacing
        add(addressLabel);
        add(new JLabel("")); // Empty label for spacing
        add(weightLabel);
        add(new JLabel("")); // Empty label for spacing
        add(costLabel);
        add(new JLabel("")); // Empty label for spacing
        add(statusLabel);
        add(new JLabel("")); // Empty label for spacing
    }

    public void updateParcelDetails(Parcel parcel) {
        parcelIdLabel.setText("Parcel ID: " + parcel.getId());
        recipientLabel.setText("Recipient: " + parcel.getRecipient());
        addressLabel.setText("Address: " + parcel.getAddress());
        weightLabel.setText("Weight: " + parcel.getWeight() + " kg");
        costLabel.setText("Cost: $" + String.format("%.2f", parcel.getCost())); // Format cost to two decimal places
        statusLabel.setText("Status: " + (parcel.isProcessed() ? "Processed" : "Unprocessed"));
    }
}
