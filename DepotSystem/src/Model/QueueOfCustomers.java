package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.Log;

public class QueueOfCustomers {
    
    private Queue<Customer> customerQueue;
	private Log Log;

    public QueueOfCustomers(List<Customer> customers) {
        customerQueue = new LinkedList<>();
    }

    public QueueOfCustomers() {
		// TODO Auto-generated constructor stub
	}

	// Method to add a customer to the queue
    public synchronized void addCustomer(Customer customer) {
        customerQueue.add(customer);
        Util.Log.getInstance().append("Customer added to queue: " + customer.getName());
    }

    // Method to remove a customer from the queue
    public synchronized Customer removeCustomer() {
        Customer removedCustomer = customerQueue.poll();
        if (removedCustomer != null) {
            Log.getInstance().append("Customer removed from queue: " + removedCustomer.getName());
        }
        return removedCustomer;
    }

    // Method to get the current list of customers in the queue.
    public synchronized Queue<Customer> getCustomers() {
        return new LinkedList<>(customerQueue);
    }

    // A process to check if the queue is empty.
    public synchronized boolean isEmpty() {
        return customerQueue.isEmpty();
    }

    // A process to get the size of the customers into the queue
    public synchronized int size() {
        return customerQueue.size();
    }

    // A process to display the current queue of customers (for debugging purposes)
    private void displayQueue() {
        System.out.println("Current Queue of Customers:");
        for (Customer customer : customerQueue) {
            System.out.println(customer);
        }
    }

	public void add(Customer customer) {
		// TODO Auto-generated method stub
		
	}
}