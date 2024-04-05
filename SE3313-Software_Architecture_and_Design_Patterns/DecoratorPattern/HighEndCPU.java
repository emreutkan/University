public class HighEndCPU extends CPU {
    HighEndCPU(){
        this.type = "High End CPU";
        this.setPrice(0.049468);

    }

    @Override
    public double getPrice() {
        return price;
    }
}
