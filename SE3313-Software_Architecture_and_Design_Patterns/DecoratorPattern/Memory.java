public class Memory implements server{

    String type;
    double price = 0;

    double getCost(){
        return this.price;
    }
    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

}
