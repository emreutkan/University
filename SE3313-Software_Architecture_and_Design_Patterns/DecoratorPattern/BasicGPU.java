public class BasicGPU extends GPU{
    BasicGPU(){
        this.type = "Basic GPU";
        this.setPrice(0.006867);
    }
    @Override
    public double getPrice() {
        return price;
    }
}
