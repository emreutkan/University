import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReader {
    String readFile(String path) throws IOException;
}
