package org.example;

/**
 * class represents a customer with a name and an account.
 */
public class Customer {
    private String name;
    private Account account;

    /**
     * new customer with name and initial deposit.
     *
     * @param name the name of the customer
     * @param initialDeposit the initial deposit of the customer's account
     */
    public Customer(String name, double initialDeposit) {
        this.name = name;
        this.account = new Account(name, initialDeposit);
    }

    /**
     * returns the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * returns the account of the customer.
     *
     * @return the account of the customer
     */
    public Account getAccount() {
        return account;
    }
}