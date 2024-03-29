 public class rectangle extends shapes2D implements calc2D {
        double length;
        double width;

        public rectangle(String name, String type, double length,double width){
            super(name,type);
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            double A = length*width;
            return A;
        }
        @Override
        public double calculatePerimeter() {
            double P = 2*(length+width);
            return P;
        }

     @Override
     public String toString(){
         return ("Rectangle" + " Area: " + calculateArea() + " Perimeter: " + calculatePerimeter());
     }
    }

