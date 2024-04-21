package org.example;

import java.util.ArrayList;

/**
 * Manages the rental of cars.
 **/
public class RentalManagement {

    /**
     * List of cars currently rented.
     */
    private final ArrayList<Car> atRentalList = new ArrayList<>();


    /**
     * Adds a car to the list of current rentals.
     *
     * @param car the car to add to the rental list
     */
    public void addRental(final Car car) {
        atRentalList.add(car);
    }

    /**
     * Returns the list of cars currently rented.
     *
     * @return the list of cars currently rented
     */
    public ArrayList<Car> getAtRentalList() {
        return atRentalList;
    }

    /**
     * Calculates the number of days a car has been rented.
     *
     * @param car the car to calculate the rental days for
     * @return the number of rental days
     */
    public int getRentalDays(final Car car) {
        final long millisecondsPerDay = 1000 * 60 * 60 * 24;
        long diff = car.getRentalEnd().getTime() - car.getRentalStart().getTime();
        return (int) (diff / millisecondsPerDay);
    }

    /**
     * Calculates the total rental price for a car.
     *
     * @param car the car to calculate the rental price for
     * @return the total rental price
     */
    public int getTotalRentalPrice(final Car car) {
        return getRentalDays(car) * car.getRentalPrice();
    }
}
