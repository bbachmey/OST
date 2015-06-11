package exceptionTesting;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Dad {
	
   public void parentalCollaboration() {
	   
      Mom spouse = new Mom();
      
      try{
          spouse.getToDoHomework();
      }
      catch(IOException e){
    	  System.out.println("Dad caught the I/O Exception.");    
      } 
   }
	
   public static void main(String [] args)  {
      Dad dad = new Dad();
      dad.parentalCollaboration();
   }
   
}