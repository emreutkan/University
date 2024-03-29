 class circle extends shapes2D implements calc2D {
        double radius;

        public circle(String name, String type, double radius){
            super(name,type);
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            double A = 3.14 * radius * radius;
            return A;
        }

        @Override
        public double calculatePerimeter() {
            double P = 2*3.14*radius;
            return P;
        }

     @Override
     public String toString(){
         return ("Circle" + " Area: " + calculateArea() + " Perimeter: " + calculatePerimeter());
     }
    }

