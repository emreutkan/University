package org.example;

/**
 * bank account with a username, balance.
 */
public class Account {
    private String username;
    private double balance;

    /**
     * a new Account with the specified username, and initial balance.
     *
     * @param username the username of the account
     * @param initialBalance the initial balance of the account
     */
    public Account(String username, double initialBalance) {
        this.username = username;
        this.balance = initialBalance;
    }

    /**
     * returns the balance of the account.
     *
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * deposits the amount into the account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    /**
     * withdraws the amount from the account.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * returns the balance of the account.
     *
     * @return the balance of the account
     */
    public double checkBalance() {
        return balance;
    }
}