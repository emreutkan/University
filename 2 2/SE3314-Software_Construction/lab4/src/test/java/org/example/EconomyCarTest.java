package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EconomyCarTest {
    private EconomyCar hybridCar;
    private EconomyCar nonHybridCar;

    @BeforeEach
    public void setUp() {
        // Initialize an EconomyCar instance as hybrid and another as non-hybrid
        hybridCar = new EconomyCar(true);
        nonHybridCar = new EconomyCar(false);
    }

    @Test
    public void testHybridCarRentalPrice() {
        assertTrue(hybridCar.isHybrid(), "The car should be marked as a hybrid.");
        assertEquals(60, hybridCar.getRentalPrice(), "The rental price for a hybrid car should include the hybrid option price.");
    }

    @Test
    public void testNonHybridCarRentalPrice() {
        assertFalse(nonHybridCar.isHybrid(), "The car should not be marked as a hybrid.");
        assertEquals(50, nonHybridCar.getRentalPrice(), "The rental price for a non-hybrid car should be the base price without the hybrid option price.");
    }

}
