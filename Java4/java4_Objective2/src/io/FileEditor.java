package io;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileEditor {
	// Constants
	final int NORMAL_EXIT = 0;
	final int FILE_CREATION_ERROR = 1;
	final int FILE_ERROR = 2;
	final int FILE_WRITE_ERROR = 3;

	final boolean append = true;
	final boolean autoFlush = true;

	static FileIO fileIO;

	/*
     Save text: Saves the contents of your array or list object to a file named by the user. 
	 */
	public void saveFile(String fileName, String [] lines) { 

		fileIO = new FileIO(fileName);

		try {
			fileIO.createFile();

			for(String line : lines){

				if (!fileIO.printToFile(line, append, autoFlush)) {
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
				e.printStackTrace();
			}

			// Erase the fileIO object
			fileIO.exit();
			fileIO = null;

		}

	}


	public void eraseFile(String fileName) { 

		fileIO = new FileIO(fileName);

		try {
			fileIO.deleteFile();
               
		} catch (Exception e) {
			e.printStackTrace();  
			System.exit(FILE_ERROR);
		}
		finally {

			// Erase the fileIO object
			fileIO.exit();
			fileIO = null;

		}

	}
	
	/*
	 Quit: Makes sure all file handles are closed and then exits the program.
	 */
	public void quitFile() { 

		if(fileIO != null){
			fileIO.exit();
			fileIO = null;		
		}

		System.out.println("Application ended");

		// Allow execution to end.

	}

	/*
	 Read text: Reads the contents of a text file named by the user. 
	 */
	public int [] readFile(String fileName){
		int [] numbers = null;

		boolean notFound = false;
		ArrayList<String> strings;

		fileIO = new FileIO(fileName);

		try {
			strings = fileIO.readFile();
			numbers = new int[strings.size()];
			int i = 0;

			for(String string : strings){
				numbers[i] = Integer.parseInt(string);
				i++;
			}

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
			}

		}

		return numbers;

	}

}
