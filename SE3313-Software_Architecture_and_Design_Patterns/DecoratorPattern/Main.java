import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        server sv = null;
        Scanner scanner = new Scanner(System.in);
        int CPU,GPU,Memory;
        String SCPU,SGPU,SMemory;
        double cost= 0;
        System.out.println("Welcome to the Data Center Configuration Tool!");
        System.out.println("Select Serve Type:");
        System.out.println("1. High-End CPU");
        System.out.println("2. Normal CPU");
        CPU = scanner.nextInt();
        System.out.println("1. High-End GPU");
        System.out.println("2. Normal GPU");
        GPU = scanner.nextInt();
        System.out.println("1. High-End Memory");
        System.out.println("2. Normal Memory");
        Memory = scanner.nextInt();
        if (CPU == 1){
            sv = new HighEndCPU();
        }
        else if(CPU == 2){
            sv = new BasicCPU();
        }
        else{
            System.out.println("CPU not selected");
        }
        cost += sv.getPrice();
        SCPU = sv.getType();
        if (GPU == 1){
            sv = new HighEndGPU();
        }
        else if(GPU == 2){
            sv = new BasicGPU();
        }
        else{
            System.out.println("GPU not selected");
        }
        cost += sv.getPrice();
        SGPU = sv.getType();
        if (Memory == 1){
            sv = new HighEndMemory();
        }
        else if(Memory == 2){
            sv = new BasicMemory();
        }
        else{
            System.out.println("Memory not selected");
        }
        cost += sv.getPrice();
        SMemory = sv.getType();

        System.out.println("Total Price: "+cost);
        System.out.println("Description: "+SCPU+" "+SGPU+" "+ SMemory);



    }
}