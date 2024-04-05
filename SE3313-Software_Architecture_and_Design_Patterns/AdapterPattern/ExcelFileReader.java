import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader implements Service {
    @Override
    public String readDataFile(String filepath) throws IOException {

           /* FileInputStream fis = new FileInputStream(filepath);
            XSSFWorkbook x  = new XSSFWorkbook(fis);
            Sheet sheet = x.getSheet("Sheet1");
            Row row = sheet.getRow(0);
            System.out.println(row.getCell(0));
            String text = String.valueOf(row.getCell(0)); */
            String text = "printing excel ...";
            return text;
    }
}
