package controller;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

      
public class FileIO {
    File myFile;
    
    public FileIO(String path) {
        myFile = new File(path);
    }

    public boolean deleteFile() {
        return myFile.delete();
    }
    
    public File getFile() {
        return myFile;
    }
    
    public void setFile(String path) {
        myFile = new File(path);
    }

    public String readFile() throws Exception {
        FileReader fReader;
        BufferedReader bReader;
        String txtLine = "";
        String returnText = "";
        try {
        	
            fReader = new FileReader(myFile);
            bReader = new BufferedReader(fReader);
            
            while ((txtLine = bReader.readLine()) != null) {
                returnText += txtLine + "\n";
            }

            fReader.close();
            bReader.close();
            
            return returnText;
        } catch (FileNotFoundException e) {
        	throw e;

        } catch (IOException e) {
            throw new InvocationTargetException(e);
        }
    }
    
    public boolean printToFile(String text, boolean append, boolean autoFlush)
            throws InvocationTargetException {
        FileWriter fWriter;
        PrintWriter pWriter;
        boolean successFlag = true;
        try {
            fWriter = new FileWriter(myFile, append);
        } catch (IOException e) {
            throw new InvocationTargetException(e);
        }
        pWriter = new PrintWriter(fWriter, autoFlush);

        pWriter.println(text);
        if (pWriter.checkError()) {
            successFlag = false;
        }
        // The file streams should close and flush on method exit
        // but to be safe, always explicitly close():
        pWriter.close();
        
        try {
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return successFlag;
    }
    
    public void createFile() throws InvocationTargetException{
        try {
            File dirFile = myFile.getParentFile();
            if (dirFile != null) {
                dirFile.mkdirs();
            }
            myFile.createNewFile();
        }
        catch(IOException e) {
            throw new InvocationTargetException(e);
        }
    }
    
    public void exit() {
    	//
    }
    
}
