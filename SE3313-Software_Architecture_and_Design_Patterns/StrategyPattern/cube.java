public class cube extends shapes3D implements calc3D{

    double edge;

    public cube(String name, String type, double edge){
        super(name, type);
        this.edge = edge;
    }

    @Override
    public double calculateVolume() {
        double V = edge * edge * edge;
        return V;
    }
    @Override
    public String toString(){
        return ("Cube Volume: "+calculateVolume());
    }

}
