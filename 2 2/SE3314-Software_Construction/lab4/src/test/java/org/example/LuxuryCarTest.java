package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LuxuryCarTest {
    private LuxuryCar carWithBoth;
    private LuxuryCar carWithGPSOnly;
    private LuxuryCar carWithLeatherOnly;
    private LuxuryCar carWithNone;

    @BeforeEach
    public void setUp() {
        // Initialize cars with different configurations for each test
        carWithBoth = new LuxuryCar(true, true);
        carWithGPSOnly = new LuxuryCar(true, false);
        carWithLeatherOnly = new LuxuryCar(false, true);
        carWithNone = new LuxuryCar(false, false);
    }

    @Test
    public void testGpsAndLeatherSeatsOptionsIncluded() {
        assertTrue(carWithBoth.isGpsIncluded(), "GPS should be included");
        assertTrue(carWithBoth.isLeatherSeats(), "Leather seats should be included");
        assertEquals(150, carWithBoth.getRentalPrice(), "Rental price should be correctly calculated with both options");
    }

    @Test
    public void testGpsOptionOnly() {
        assertTrue(carWithGPSOnly.isGpsIncluded(), "GPS should be included");
        assertFalse(carWithGPSOnly.isLeatherSeats(), "Leather seats should not be included");
        assertEquals(120, carWithGPSOnly.getRentalPrice(), "Rental price should be correctly calculated with only GPS option");
    }

    @Test
    public void testLeatherSeatsOptionOnly() {
        assertFalse(carWithLeatherOnly.isGpsIncluded(), "GPS should not be included");
        assertTrue(carWithLeatherOnly.isLeatherSeats(), "Leather seats should be included");
        assertEquals(130, carWithLeatherOnly.getRentalPrice(), "Rental price should be correctly calculated with only leather seats option");
    }

    @Test
    public void testNoOptions() {
        assertFalse(carWithNone.isGpsIncluded(), "GPS should not be included");
        assertFalse(carWithNone.isLeatherSeats(), "Leather seats should not be included");
        assertEquals(100, carWithNone.getRentalPrice(), "Rental price should be the base price with no options");
    }
}
