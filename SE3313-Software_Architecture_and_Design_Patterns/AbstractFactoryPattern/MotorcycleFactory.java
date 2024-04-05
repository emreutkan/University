public class MotorcycleFactory implements VehicleFactory{

    Motorcycle Motor = new Motorcycle();
    Engine MotorEngine = new GasolineEngine();
    @Override
    public Engine createEngine() {
        return MotorEngine;
    }

    @Override
    public Vehicle createVehicle() {
        return Motor;
    }
}
