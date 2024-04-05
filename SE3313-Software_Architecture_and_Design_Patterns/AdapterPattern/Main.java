import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Service ExcelFileAdapter = new ExcelFileReader();
        Service JsonFileAdapter = new JsonFileReader();
        FileReader TXTreader = new txtReader();
        FileReader ExcelReader = new ServiceAdapter(ExcelFileAdapter);
        FileReader JsonReader = new ServiceAdapter(JsonFileAdapter);

        String text = TXTreader.readFile("txt.txt");
        System.out.println(text);

        text = ExcelReader.readFile("ASD.xlsx"); // ERROR StatusLogger Log4j2 could not find a logging implementation
        // switched the Excelreader to sout... commented out non working code;
        System.out.println(text);

        text = JsonReader.readFile("asd.json");
        System.out.println(text);

    }
}