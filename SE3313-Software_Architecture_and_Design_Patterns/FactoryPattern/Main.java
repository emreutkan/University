import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            Car car;
            CarFactory factory = null;
            String carBody = null;
            String carBrand;
            Scanner scanner;

            scanner = new Scanner(System.in);

            int get_out_of_loop = 1;
            while (get_out_of_loop==1){
                System.out.println("Enter Brand Choice: " + "\n" +
                        " toyota " + "\n" +
                        " renault " + "\n" +
                        " mercedes "
                );
                carBrand = scanner.next();
                if (carBrand.equals("mercedes")){
                    factory = new Mercedes();
                    get_out_of_loop = 0;
                } else if (carBrand == "renault"){
                    factory = new Renault();
                    get_out_of_loop = 0;
                } else if (carBrand.equals("toyota")){
                    factory = new Toyota();
                    get_out_of_loop = 0;
                } else{
                    System.out.println("! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
                    System.out.println("Wrong Car Brand written (use all lower case)");
                    System.out.println("! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
                    get_out_of_loop = 1;
                }
            }


            get_out_of_loop = 1;
            while (get_out_of_loop==1){
                System.out.println("Enter Body Type: " + "\n" +
                        " sedan " + "\n" +
                        " suv " + "\n" +
                        " hatchback "
                );
                carBody = scanner.next();
                if (carBody.equals("suv") ||carBody.equals("sedan") || carBody.equals("hatchback")){
                    get_out_of_loop = 0;
                } else{
                    System.out.println("! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
                    System.out.println("Invalid Car Body Type written (use all lower case)");
                    System.out.println("! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
                    get_out_of_loop = 1;
                }
            }

            car = factory.CreateCar(carBody);
            System.out.println(
                    "\n" +"\n" + "************************************" + "\n" +
                            "Model Name: " + car.name + "\n" +
                            "Weight: " + car.weight + " kg " + "\n" +
                            "0-100 acceleration: " + car.acceleration + " sec " + "\n" +
                            "Top Speed: " + car.topSpeed + " km/h" + "\n" +
                            "Price: " + car.price + " euro" + "\n" +
                            "Origin Country: " + car.originCountry + "\n" +
                            "Production Time: " + car.productionTime + "\n" +
                            "Delivery Time: " + car.deliveryTime +
                            "\n" + "\n" + "************************************"
            );
        }
    }
}