public abstract class CarFactory {
    Car car;
    public String brandName;
    public abstract Car CreateCar(String carBodyType);
}
