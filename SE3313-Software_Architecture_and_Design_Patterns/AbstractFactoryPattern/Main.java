public class Main {
    public static void main(String[] args) {
VehicleFactory CarFactory = new CarFactory();
Vehicle Car = CarFactory.createVehicle();
Engine CarEngine = CarFactory.createEngine();
        Car.startEngine();
        CarEngine.start();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        Vehicle Motor = motorcycleFactory.createVehicle();
        Engine MotorEngine = motorcycleFactory.createEngine();
        Motor.startEngine();
        MotorEngine.start();
    }
}