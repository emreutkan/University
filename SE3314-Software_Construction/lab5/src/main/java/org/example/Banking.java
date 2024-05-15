package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * banking class manages customers and their accounts.
 */
public class Banking {
    private Map<String, Customer> customers;

    /**
     * constructor
     */
    public Banking() {
        this.customers = new HashMap<>();
    }

    /**
     * returns the map of customers.
     *
     * @return the map of customers
     */
    public Map<String, Customer> getCustomers() {
        return customers;
    }

    /**
     * creates a new customer with the specified username, and initial balance.
     *
     * @param username the username of the customer's account
     * @param initialBalance the initial balance of the customer's account
     */
    public void createCustomer(String username, double initialBalance) {
        Customer customer = new Customer(username, initialBalance);
        customers.put(username, customer);
    }

    /**
     * returns the current balance of the account of the specified customer.
     *
     * @param username the username of the customer's account
     * @return the current balance of the account, or -1 if the customer does not exist
     */
    public double getCustomerBalance(String username) {
        Customer customer = customers.get(username);
        if (customer != null) {
            return customer.getAccount().checkBalance();
        }
        return -1;
    }

    /**
     * deposits the specified amount into the account of the specified customer.
     *
     * @param username the username of the customer's account
     * @param amount the amount to deposit
     * @return true if the deposit was successful, false otherwise
     */
    public boolean deposit(String username, double amount) {
        Customer customer = customers.get(username);

        if (customer == null) {
            return false;
        }

        customer.getAccount().deposit(amount);
        return true;
    }
    /**
     * transfers the specified amount from the account of the sender customer to the account of the receiver customer.
     *
     * @param senderUsername the username of the sender customer's account
     * @param receiverUsername the username of the receiver customer's account
     * @param amount the amount to transfer
     * @return true if the transfer was successful, false otherwise
     */
    public boolean transfer(String senderUsername, String receiverUsername, double amount) {
        Customer sender = customers.get(senderUsername);
        Customer receiver = customers.get(receiverUsername);

        if (sender == null || receiver == null) {
            return false;
        }

        if (sender.getAccount().getBalance() < amount) {
            return false;
        }

        boolean withdrawalSuccessful = sender.getAccount().withdraw(amount);
        if (withdrawalSuccessful) {
            receiver.getAccount().deposit(amount);
            return true;
        }

        return false;
    }
    /**
     * withdraws the specified amount from the account of the specified customer.
     *
     * @param username the username of the customer's account
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(String username, double amount) {
        Customer customer = customers.get(username);

        if (customer == null) {
            return false;
        }

        if (customer.getAccount().getBalance() < amount) {
            return false;
        }

        customer.getAccount().withdraw(amount);
        return true;
    }
}