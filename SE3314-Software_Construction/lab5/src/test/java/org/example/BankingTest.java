package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankingTest {
    private Banking banking;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setUp() {
        banking = new Banking();
        customer1 = new Customer("emre", 1000.0);
        customer2 = new Customer("irfan", 2000.0);
    }

    @Test
    public void testCreateCustomer() {
        banking.createCustomer(customer1.getName(), customer1.getAccount().getBalance());
        assertEquals(1, banking.getCustomers().size());
    }

    @Test
    public void testDepositAndWithdraw() {
        banking.createCustomer(customer1.getName(), customer1.getAccount().getBalance());
        assertTrue(banking.deposit(customer1.getName(), 500.0));
        assertEquals(1500.0, banking.getCustomerBalance(customer1.getName()));
        assertTrue(banking.withdraw(customer1.getName(), 200.0));
        assertEquals(1300.0, banking.getCustomerBalance(customer1.getName()));
    }

    @Test
    public void testTransfer() {
        banking.createCustomer(customer1.getName(), customer1.getAccount().getBalance());
        banking.createCustomer(customer2.getName(), customer2.getAccount().getBalance());
        assertTrue(banking.transfer(customer1.getName(), customer2.getName(), 300.0));
        assertEquals(700.0, banking.getCustomerBalance(customer1.getName()));
        assertEquals(2300.0, banking.getCustomerBalance(customer2.getName()));
    }
}