package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalManagementTest {

    private RentalManagement rentalManagement;
    private Car testCar;

    @BeforeEach
    public void setUp() {
        rentalManagement = new RentalManagement();

        testCar = new Car() {
            {
                setRentalPrice(100);
            }
        };

        Calendar start = Calendar.getInstance();
        start.set(2023, Calendar.JANUARY, 1);
        testCar.setRentalStart(start.getTime());

        Calendar end = Calendar.getInstance();
        end.set(2023, Calendar.JANUARY, 6); // 5 days later
        testCar.setRentalEnd(end.getTime());

        rentalManagement.addRental(testCar);
    }

    @Test
    public void testAddRental() {
        assertTrue(rentalManagement.getAtRentalList().contains(testCar),
                "The car should be added to the rental list.");
    }

    @Test
    public void testGetRentalDays() {
        assertEquals(5, rentalManagement.getRentalDays(testCar),
                "The rental days should be correctly calculated.");
    }

    @Test
    public void testGetTotalRentalPrice() {
        assertEquals(500, rentalManagement.getTotalRentalPrice(testCar),
                "The total rental price should be correctly calculated.");
    }
}
