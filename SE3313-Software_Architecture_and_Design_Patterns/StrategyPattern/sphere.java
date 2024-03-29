public class sphere extends shapes3D implements calc2D, calc3D{
    double radius;

    public sphere (String name, String type, double radius){
        super(name,type);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double A = 4*3.14*radius;
        return A;
    }
    @Override
    public double calculatePerimeter() {
        double P = 2*3.14*radius;
        return P;
    }
    @Override
    public double calculateVolume() {
        double V =  3.0/4.0 * 3.14 * radius * radius * radius;
        return V;
    }

    @Override
    public String toString(){
        return ("Sphere Area: "+ calculateArea() + " Perimeter: " + calculatePerimeter()+" Volume: "+calculateVolume());
    }
}


