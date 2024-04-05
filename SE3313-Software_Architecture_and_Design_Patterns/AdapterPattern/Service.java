import java.io.FileNotFoundException;
import java.io.IOException;

public interface Service {

    String readDataFile(String filepath) throws IOException;
}
