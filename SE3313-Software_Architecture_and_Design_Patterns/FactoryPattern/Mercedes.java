public class Mercedes extends CarFactory{

    public Mercedes(){
        this.brandName = "Mercedes ";
    }

    @Override
    public Car CreateCar(String carBodyType) {
        if (carBodyType.equals("sedan")){
            car = new mercedesSedan();
        } else if (carBodyType.equals("suv")){
            this.car = new mercedesSuv();
        } else if (carBodyType.equals("hatchback")){
            this.car = new mercedesHatchback();
        } else{
            return null;
        }
        return car;
    }
}
