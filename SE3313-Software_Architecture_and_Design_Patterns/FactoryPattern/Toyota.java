public class Toyota extends CarFactory{
    public Toyota(){
        this.brandName = "Toyota ";
    }

    @Override
    public Car CreateCar(String carBodyType) {
        if (carBodyType.equals("sedan")){
            this.car = new toyotaSedan();
        } else if (carBodyType.equals("suv")){
            this.car = new toyotaSuv();
        } else if (carBodyType.equals("hatchback")){
            this.car = new toyotaHatchback();
        } else{
            return null;
        }
        return this.car;
    }
}
