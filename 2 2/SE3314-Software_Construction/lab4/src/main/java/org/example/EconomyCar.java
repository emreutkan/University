package org.example;

/**
 * Represents an economy class car, optionally hybrid.
 */
public final class EconomyCar extends Car {

    /**
     * Indicates if the car is a hybrid.
     */
    private final boolean hybrid;

    private static final int BASE_RENTAL_PRICE = 50;
    private static final int HYBRID_OPTION_PRICE = 10;

    /**
     * Constructs an EconomyCar with the specified hybrid option.
     *
     * @param hybrid true if the car is hybrid, false otherwise.
     */
    public EconomyCar(final boolean hybrid) {
        this.hybrid = hybrid;
        int rentalPrice = BASE_RENTAL_PRICE;
        if (this.hybrid) {
            rentalPrice += HYBRID_OPTION_PRICE;
        }
        setRentalPrice(rentalPrice);
    }

    /**
     * Returns true if this car is a hybrid.
     *
     * @return true if this car is hybrid, otherwise false.
     */
    public boolean isHybrid() {
        return hybrid;
    }

}
