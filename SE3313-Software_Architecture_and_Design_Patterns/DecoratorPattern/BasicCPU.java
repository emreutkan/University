public class BasicCPU extends CPU {

    BasicCPU(){
        this.type = "Basic CPU";
        this.setPrice(0.01484);
    }
    @Override
    public double getPrice() {
        return price;
    }



}
