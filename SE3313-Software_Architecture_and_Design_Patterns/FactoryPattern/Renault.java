public class Renault extends CarFactory{

    public Renault(){
        this.brandName = "Renault ";
    }


    @Override
    public Car CreateCar(String carBodyType) {
        if (carBodyType.equals("sedan")){
            this.car = new renaultSedan();
        } else if (carBodyType.equals("suv")){
            this.car = new renaultSuv();
        } else if (carBodyType.equals("hatchback")){
            this.car = new renaultHatchback();
        } else{
            return null;
        }

        return this.car;
    }
}
