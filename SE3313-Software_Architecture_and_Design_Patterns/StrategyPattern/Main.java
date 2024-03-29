// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            circle testCircle = new circle("Circle","2D",8);
            rectangle testRectangle = new rectangle("Rectangle","2D",5,10);
            sphere testSphere = new sphere("Sphere","3D",4);
            cube testCube = new cube("Cube","3D",4);

            System.out.println(testCircle.toString());
            System.out.println(testRectangle.toString());
            System.out.println(testSphere.toString());
            System.out.println(testCube.toString());
    }
}