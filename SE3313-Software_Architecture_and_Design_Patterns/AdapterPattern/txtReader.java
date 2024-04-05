import java.io.*;
import java.util.Scanner;

public class txtReader implements FileReader {
    @Override
    public String readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        String text = "";
        while (sc.hasNextLine()){
            text = text+sc.nextLine();
    }
        return text;
    }
}
