package org.example;

import java.util.Date;

/**
 * Represents the abstract concept of a car available for rental.
 * This class provides the structure for rental pricing and rental period tracking.
 */
public abstract class Car {

    private int rentalPrice; // dollars per day
    private Date rentalStart;
    private Date rentalEnd;

    /**
     * Gets the start date of the rental period.
     *
     * @return The start date of the rental.
     */
    public Date getRentalStart() {
        return rentalStart;
    }

    /**
     * Sets the start date of the rental period.
     *
     * @param rentalStart The start date to set for the rental.
     */
    public void setRentalStart(final Date rentalStart) {
        this.rentalStart = rentalStart;
    }

    /**
     * Gets the end date of the rental period.
     *
     * @return The end date of the rental.
     */
    public Date getRentalEnd() {
        return rentalEnd;
    }

    /**
     * Sets the end date of the rental period.
     *
     * @param rentalEnd The end date to set for the rental.
     */
    public void setRentalEnd(final Date rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    /**
     * Gets the daily rental price.
     *
     * @return The daily rental price in dollars.
     */
    public int getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Sets the daily rental price.
     *
     * @param rentalPrice The daily rental price in dollars to set.
     */
    public void setRentalPrice(final int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
