import java.io.FileNotFoundException;
import java.io.IOException;

public class ServiceAdapter implements FileReader {
    private Service s;

    public ServiceAdapter(Service s){
        this.s = s;
    }

    @Override
    public String readFile(String path) throws IOException {
        return s.readDataFile(path);
    }
}
