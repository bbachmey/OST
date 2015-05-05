import java.io.File;
import java.io.IOException;
      
public class FileIO {
    File myFile;
    
    public FileIO(String path) {
        myFile = new File(path);
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            //exit with an exit code. Exit code 0 indicates normal exit.
            System.exit(1);
        }
    }
    
    public static void main(String [] args) {
        FileIO fileTest = new FileIO("filetest.txt");
    }
}
