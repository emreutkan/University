public class GPU implements server {

    String type;
    double price = 0;

    @Override
    public void setType(String type) {
        this.type = type;
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


}
