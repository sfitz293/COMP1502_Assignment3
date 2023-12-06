package controller;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;
/**
 * This class is the behind the scenes class that runs the Toy Inventory program.
 * 
 * @author Brett Big Swan 
 * @author Sarah Fitzgerald
 */
public class ApplicationManager {						
    // Initializing the ArrayList of Toys
    private ArrayList<Toys> listOfEveryToy;		
    // The file path to the inventory file
    private final String FILE_PATH = "res/toys.txt";
    /**
     * This Constructor constructs an ApplicationManager object.
     * It initializes the scanner, ArrayList, and loads data from 
     * a file if available.
     */
    public ApplicationManager(){
    	listOfEveryToy = new ArrayList<>();
        try {
			loadFromFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    /**
     * This is the method used to load toy data from a file called "Toys.txt' 
     * and populate the ArrayList.
     * 
     * @throws FileNotFoundException If the file is not found.
     */
	public void loadFromFile() throws FileNotFoundException{
		FileReader file = new FileReader(FILE_PATH);	// Create a new file reader
		Scanner scanner = new Scanner(file);			// Create a new file scanner   
		String tempLine;		// String with which to scan the file by
		String[] currentToys;	// Array which to separate the line that was read
		char firstChar;			// Character which is compared to the array
        while (scanner.hasNextLine()){     	
			// Setting user input by keyboard to a variable
			tempLine = scanner.nextLine();
			System.out.println(tempLine);
			// Setting a variable to read the file line by line, changing it to lower-case, and splitting by semicolon
			currentToys = tempLine.toLowerCase().split(";");
			// Does the read file have greater than 6 objects
			if (currentToys.length > 6) {	
			// Setting a variable to compare to the scanned file
			firstChar = currentToys[0].charAt(0);

				if (firstChar == '0' || firstChar == '1') {
					Figures tempFigures = new Figures((currentToys[0]), currentToys[1], currentToys[2],
							Double.parseDouble(currentToys[3]), Integer.parseInt(currentToys[4]), 
							Integer.parseInt(currentToys[5]),currentToys[6]);
					listOfEveryToy.add(tempFigures);

				}else if (firstChar == '2' || firstChar == '3') {
					Animals tempAnimals = new Animals((currentToys[0]), currentToys[1], currentToys[2],
							Double.parseDouble(currentToys[3]), Integer.parseInt(currentToys[4]),
							Integer.parseInt(currentToys[5]), currentToys[6], currentToys[7]);
					listOfEveryToy.add(tempAnimals);

				}else if (firstChar == '4' || firstChar == '5' || firstChar == '6') {
					Puzzles tempPuzzles = new Puzzles((currentToys[0]), currentToys[1], currentToys[2],
							Double.parseDouble(currentToys[3]), Integer.parseInt(currentToys[4]),
							Integer.parseInt(currentToys[5]), currentToys[6]);
					listOfEveryToy.add(tempPuzzles);

				}else if (firstChar == '7' || firstChar == '8' || firstChar == '9') {
					BoardGames tempBoardGames = new BoardGames((currentToys[0]), currentToys[1], currentToys[2],
							Double.parseDouble(currentToys[3]), Integer.parseInt(currentToys[4]),
							Integer.parseInt(currentToys[5]), (currentToys[6]), (currentToys[7]));
					listOfEveryToy.add(tempBoardGames);
    			}
    		}
    	}
    	scanner.close();	// Close the File Reader Scanner
    }  
	/**
     * This method allows users to search by SERIAL NUMBER
     * and return the results.
     * 
     * @return A list of toys found by SERIAL NUMBER.
     */
	public ArrayList<Toys> searchSerialNumberNoLoadFile(String SN) throws FileNotFoundException {
		ArrayList <Toys> listOfToys = new ArrayList<>();
		for (Toys searchToy : listOfEveryToy) {		
			if(searchToy.getSerialNumber().equals(SN)) {			
				listOfToys.add(searchToy);
			}
		}
		System.out.println(listOfToys);
		return listOfToys;
	}
	/**
     * This method allows users to search by NAME
     * and return the results.
     * 
     * @return A list of toys found by NAME.
     */
	public ArrayList<Toys> searchNameNoLoadFile(String Name){	
		ArrayList<Toys> listOfToys = new ArrayList<>();
		for (Toys searchToy : listOfEveryToy) {			
			if(searchToy.getName().equalsIgnoreCase(Name)) {				
				listOfToys.add(searchToy);
			}
		}
		System.out.println(listOfToys);
		return listOfToys;
	}	
	/**
     * This method allows users to search by TYPE
     * and return the results.
     * 
     * @return A list of toys found by TYPE.
     */
	public ArrayList<Toys> searchTypeNoLoadFile(String Type){	
		ArrayList<Toys> listOfToys = new ArrayList<>();
	    for (Toys temp : listOfEveryToy) { 	
	        if (temp.getType().equalsIgnoreCase(Type)) {
	            listOfToys.add(temp);   
	        }
	    }
		System.out.println(listOfToys);
	    return listOfToys;
	}
	
	
	
	
	/**
	 * This method allows you to remove a toy from the list of toys based on its serial number.
	 * It prompts the user for the serial number and removes the matching toy if found.
	 * After removal, it saves the changes to the file.
	 */
	public void removeToy(String SN) {

	    boolean found = false;
	    Iterator<Toys> iterator = listOfEveryToy.iterator();
	    while (iterator.hasNext()) {
	        Toys toy = iterator.next();
	        if (toy.getSerialNumber().equals(SN)) {
	            iterator.remove();
	            found = true;
	            break;
	        }
	    }
	    if (found) {
	        saveToFile(); // Save changes after removal
	        System.out.println("\nToy successfully removed from the system.");
	    } else {
	        System.out.println("\nToy with the given serial number not found.");
	    }

	}	
	
	
	
	/**
	 * This method saves the current list of toys to a file.
	 * It iterates through the list and writes each toy's data to the file.
	 * Ensure that the `toString()` method of Toys returns the data in the correct file format.
	 */
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Toys toy : listOfEveryToy) {
                String toyData = toy.toString(); 	// Ensure that the toString() method of Toys returns the data in correct file format
                writer.println(toyData); 			// Write the toy data followed by a new line
            }
        } catch (IOException e) {
            System.err.println("\nAn error occurred while updating the file: " + e.getMessage());
        }
    }	
    /**
     * This method is used to close the application.
     * It saves the current list of toys to a file using the `saveToFile()` method
     * and then closes the scanner used for user input.
     */
    public void closeApplication() {
        saveToFile();
        System.exit(0); // Terminate the application
    }
}
    
    
    
   