public class CarFactory implements VehicleFactory{

    Car car = new Car();
    ElectricEngine electricEngine = new ElectricEngine();

    @Override
    public Engine createEngine() {
        return electricEngine;
    }

    @Override
    public Vehicle createVehicle() {
        return car;
    }
}
