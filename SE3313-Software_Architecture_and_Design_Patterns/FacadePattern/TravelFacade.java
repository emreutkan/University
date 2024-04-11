import java.io.Reader;
import java.util.Scanner;

public class TravelFacade {

    HotelReservationSystem hotelReservationSystem;
    CarRentalSystem carRentalSystem;
    ActivityBookingSystem activityBookingSystem;
    InsuranceSystem insuranceSystem;
    NotificationService notificationService;

    public TravelFacade (){
        hotelReservationSystem = new HotelReservationSystem();
        carRentalSystem = new CarRentalSystem();
        activityBookingSystem = new ActivityBookingSystem();
        insuranceSystem = new InsuranceSystem();
        notificationService = new NotificationService();
    }

    Scanner scanner = new Scanner(System.in);
    public void BookTrip(String Departurecity, String DestinationCity, String DepartureDate, String TravelTime) {

        notificationService.check(Departurecity,DepartureDate);
        hotelReservationSystem.reserve(DestinationCity,TravelTime,DepartureDate);
        carRentalSystem.reserve(DestinationCity,TravelTime,DepartureDate);
        activityBookingSystem.book(DestinationCity,DepartureDate);
        insuranceSystem.set(DepartureDate,TravelTime);

        }
    }
