package view;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.FileIO;

public class FileEditor {
	// Constants
    final int NORMAL_EXIT = 0;
    final int FILE_CREATION_ERROR = 1;
    final int FILE_ERROR = 2;
    final int FILE_WRITE_ERROR = 3;
    
    final boolean append = true;
    final boolean autoFlush = true;
    
	static FileIO fileIO;
	ArrayList<String> strings;
	
	
    public static void main(String [] args) {

    	FileEditor me = new FileEditor();

    	me.initStringsArray();
    	
    	me.readInput();
    	 
    }
    
    private void initStringsArray() {

    	strings = new ArrayList<String>();
    	
	}

	private void readInput() {
    	
    	String selection;

        Scanner scan = new Scanner(System.in);

        System.out.println("Choose an action: (E)nter text, (S)ave text, (R)ead text, or (Q)uit.");
        System.out.print("$> ");
        
        selection = scan.next();  

        if(selection.equals("E")){
        	
//        	System.out.print("Got E");
        	handleEnter();
        	
        }
        else if(selection.equals("R")){
        	
//        	System.out.print("Got R");
        	handleRead();
        	
        }

        else if(selection.equals("S")){
        	
//        	System.out.print("Got R");
        	handleSave();
        	
        }

        else if(selection.equals("Q")){

        	handleQuit();
        	
        }
        else{

            System.out.println("Unknown selection.");
            readInput();
        	
        }
        
	}

    /*
     Save text: Saves the contents of your array or list object to a file named by the user. 
     */
	private void handleSave() { 
        
        if(fileIO != null){
        	
        	 try {
                 fileIO.createFile();
                 
                 for(String s : strings){

                     if (!fileIO.printToFile(s, append, autoFlush)) {
                         System.out.println("An error occurred writing to file: "
                                 + fileIO.getFile().getPath());
                         System.exit(FILE_WRITE_ERROR);

                     }  
                 }    
                 
             } catch (InvocationTargetException e) {
                 e.getCause().printStackTrace();    
                 System.exit(FILE_CREATION_ERROR);
                 
             } catch (Exception e) {
                 e.printStackTrace();  
                 System.exit(FILE_ERROR);
             }
             finally {
            	 
            	 //Display a message if successful.
            	 System.out.println("File saved: " + fileIO.getFile().getPath().toString() );
            	 
            	 try {
					System.out.println(fileIO.readFile());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 
            	 // Erase the fileIO object
            	 fileIO.exit();
            	 fileIO = null;
            	 
            	 // Clear the strings array
            	 this.initStringsArray();
            	 
            	 //Return to the menu and wait for the user to make another selection.
                 this.readInput();
             }
        } 
        else {

       	 // 
       	 System.out.println("Enter text before saving file." );
       	 this.readInput();
       	 
        }
        	
       
	}

	/*
	 Quit: Makes sure all file handles are closed and then exits the program.
	 */
	private void handleQuit() { 
		
		if(fileIO != null){
			fileIO.exit();
			fileIO = null;		
		}
	
        System.out.println("Application ended");
        
		// Allow execution to end.

	}

	/*
	 Enter text: Accepts user input as lines of Strings.  
	 There is no need to allow for mistake correction. What they type is what goes in 
	 the file. 
	 */
	private void handleEnter(){

		String text;

        Scanner scan = new Scanner(System.in);

        if(fileIO == null){
        	
            System.out.println("Enter file name...");
            System.out.print("$> ");
            
            scan = new Scanner(System.in);
            
            String fileName = scan.nextLine();

            fileIO = new FileIO(fileName);
            
        	handleEnter();
        	
        }
        else {
        	
            System.out.println("Enter text...");
            System.out.print("$> ");
            
            scan = new Scanner(System.in);
            
            text = scan.nextLine();
            
            if(text != null && text.length()>0){
            	// Each time the user presses the ENTER key, 
           	 	//the String should be added to an array or some type of List object.
                strings.add(text);  
            	handleEnter();
            } 
            else {

                System.out.println(strings.size() + " lines entered. Don't forget to save.");
            	
            	// If the user enters a blank line of text, the program should return to its menu 
            	//and wait for the user to make another selection. 
                this.readInput();
            }

        }
        
    }
	
	/*
	 Read text: Reads the contents of a text file named by the user. 
	 */
	private void handleRead(){

		boolean notFound = false;
		
        System.out.println("Enter file name...");
        System.out.print("$> ");
        
        Scanner scan = new Scanner(System.in);
        
        String fileName = scan.nextLine();

        fileIO = new FileIO(fileName);
        
        try {
			System.out.println(fileIO.readFile());
        } catch (FileNotFoundException e) {
            //e.getCause().printStackTrace();
        	// Set the file not found flag
        	notFound = true;
        	
        } catch (InvocationTargetException e) {
            e.getCause().printStackTrace();
            System.exit(FILE_CREATION_ERROR);
       } catch (Exception e) {
            e.printStackTrace();
            System.exit(FILE_ERROR);
        }
        finally {

        	// Erase the fileIO object
        	fileIO.exit();
        	fileIO = null;
        
        	if (notFound){
                System.out.println("File not found. Please confirm the file name.");
                this.readInput();
        	}
        	else {

            	//After the file has been displayed, display "Press Return Key". 
                System.out.println("Press Return Key");
                
                scan = new Scanner(System.in);
                
                String text = scan.nextLine();
                
                // When the user presses a key, the program should display the menu 
                //again and wait for the user to select a choice.
                if(text != null && text.length()>0){
                	this.readInput();
                } 
                else {
                	this.readInput();
                }
        	} 
        	
            
        }
                
	}
	
}
