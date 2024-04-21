package org.example;

/**
 * Represents a luxury car with options for GPS and leather seats.
 */
public final class LuxuryCar extends Car {

    /**
     * Indicates if GPS is included.
     */
    private boolean gpsIncluded;

    /**
     * Indicates if leather seats are included.
     */
    private boolean leatherSeats;
    private static final int BASE_RENTAL_PRICE = 100;
    private static final int LEATHER_OPTION_PRICE = 30;
    private static final int GPS_OPTION_PRICE = 20;

    /**
     * Constructs a LuxuryCar with specified options.
     *
     * @param gps Whether GPS is included.
     * @param leather Whether leather seats are included.
     */
    public LuxuryCar(final boolean gps, final boolean leather) {
        this.gpsIncluded = gps;
        this.leatherSeats = leather;
        int rentalPrice = BASE_RENTAL_PRICE;
        if (this.leatherSeats) {
            rentalPrice += LEATHER_OPTION_PRICE;
        }
        if (this.gpsIncluded) {
            rentalPrice += GPS_OPTION_PRICE;
        }
        setRentalPrice(rentalPrice);
    }

    /**
     * Returns whether GPS is included.
     *
     * @return true if GPS is included, false otherwise.
     */
    public boolean isGpsIncluded() {
        return gpsIncluded;
    }


    /**
     * Returns whether leather seats are included.
     *
     * @return true if leather seats are included, false otherwise.
     */
    public boolean isLeatherSeats() {
        return leatherSeats;
    }
}
