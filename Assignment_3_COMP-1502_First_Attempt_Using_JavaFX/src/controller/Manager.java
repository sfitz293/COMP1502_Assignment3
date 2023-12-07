package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class Manager implements Initializable{
	
	


    // The file path to the inventory file
    private final String FILE_PATH = "res/toys.txt";
    
	ApplicationManager applicationManager;
	ArrayList<Toys> listOfToys = null;
	private ArrayList<Toys> listOfEveryToy = new ArrayList<>();
	private ObservableList<String> messages = FXCollections.observableArrayList();

	
    @FXML
    private Tab homeTabPane;

    @FXML
    private RadioButton radioButtonSearchSN;

    @FXML
    private ToggleGroup Group1;

    @FXML
    private RadioButton radioButtonSearchName;

    @FXML
    private RadioButton radioButtonSearchType;

    @FXML
    private Label searchSNLabel;

    @FXML
    private TextField searchSNTextField;

    @FXML
    private Label searchNameLabel;

    @FXML
    private TextField searchNameTextField;

    @FXML
    private Label searchTypeLabel;

    @FXML
    private TextField searchTypeTextField;

    @FXML
    private Button searchSearchButton;

    @FXML
    private Button searchClearButton;

    @FXML
    private ListView<Toys> toyFinderListView;

    @FXML
    private Button searchPurchaseButton;

    @FXML
    private Tab addToyTabPane;

    @FXML
    private Label addToyCategoryLabel;

    @FXML
    private ComboBox<String> addToyCategoryComboBox;

    @FXML
    private Label addToySNLabel;

    @FXML
    private TextField addToySNTextField;

    @FXML
    private Label addToyNameLabel;

    @FXML
    private TextField addToyNameTextField;

    @FXML
    private Label addToyBrandLabel;

    @FXML
    private TextField addToyBrandTextField;

    @FXML
    private Label addToyPriceLabel;

    @FXML
    private TextField addToyPriceTextField;

    @FXML
    private Label addToyAvailableCountLabel;

    @FXML
    private TextField addToyAvailableCountTextField;

    @FXML
    private Label addToyAgeAppropriateLabel;

    @FXML
    private TextField addToyAgeAppropriateTextField;

    @FXML
    private Label addToyPuzzleLabel;

    @FXML
    private Label addToyAnimalLabel;

    @FXML
    private Label addToyFigureLabel;

    @FXML
    private Label addToyBoardGameLabel;

    @FXML
    private Label addToyFigureClassificationLabel;

    @FXML
    private TextField addToyFigureClassificationTextField;

    @FXML
    private Label addToyAnimalMaterialLabel;

    @FXML
    private Label addToyAnimalSizeLabel;

    @FXML
    private Label addToyPuzzleTypeLabel;

    @FXML
    private Label addToyGameMinPlayersLabel;

    @FXML
    private Label addToyGameMaxPlayersLabel;

    @FXML
    private Label addToyGameDesignersLabel;

    @FXML
    private TextField addToyAnimalMaterialTextBox;

    @FXML
    private TextField addToyAnimalSizeTextBox;

    @FXML
    private TextField addToyPuzzleTypeTextBox;

    @FXML
    private TextField addToyGameMinPLyrsTextField;

    @FXML
    private TextField addToyGameDesignersTextField;

    @FXML
    private TextField addToyGameMaxPLyrsTextField;

    @FXML
    private Button addToyClearButton;
    // Note revisit
    @FXML
    private Button addToyButton;
    
    @FXML
    private Label toyAnimalInfoLabel;

    @FXML
    private Label toyFigureInfoLabel;

    @FXML
    private Label toyPuzzleInfoLabel;

    @FXML
    private Label toyBoardGameInfoLabel;

    @FXML
    private Tab removeToyTabPane;

    @FXML
    private ListView<Toys> toyRemovalListView;

    @FXML
    private TextField removeToySNTextField;

    @FXML
    private Button removeToyButton;

    @FXML
    private Label removeToyLabel2;

    @FXML
    private Label removeToyLabel1;
    
    @FXML
    private Label searchTypeTypesLabel;
    
    @FXML
    private Text toyFinderMessageText;
   
    @FXML
    private Label addToyMaterialLabel;

    @FXML
    private Label addToySizeLabel;

    @FXML
    private Label addToyClassificationLabel;

    
    @FXML
    public void initialize() {
    }   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        setupRadioButtonListeners();
        setupComboBoxListeners();
        setupComboBoxOptions();
		applicationManager = new ApplicationManager();
		
	    // Bind the toyFinderListView to a selection model
	    toyFinderListView.getSelectionModel().selectedItemProperty().addListener(
	        (observable, oldValue, newValue) -> {
	            // Handle selection change here
	        }
	    );
		loadFromFile(FILE_PATH);

	}
    /**
     * This method is to ensure the correct label is highlighted in red 
     * when the corresponding radio button is selected. 
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */  
    private void setupRadioButtonListeners() {
        ChangeListener<Boolean> radioChangeListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (observable == radioButtonSearchSN.selectedProperty()) {
                    // Logic for Serial Number Radio Button
                    if (newValue) {
                        searchSNLabel.setTextFill(Color.RED);
                    } else {
                        searchSNLabel.setTextFill(Color.BLACK);
                    }
                } else if (observable == radioButtonSearchName.selectedProperty()) {
                    // Logic for Name Radio Button
                    if (newValue) {
                        searchNameLabel.setTextFill(Color.RED);
                    } else {
                        searchNameLabel.setTextFill(Color.BLACK);
                    }
                } else if (observable == radioButtonSearchType.selectedProperty()) {
                    // Logic for Type Radio Button
                    if (newValue) {
                        searchTypeLabel.setTextFill(Color.RED);
                        searchTypeTypesLabel.setTextFill(Color.RED);
                    } else {
                        searchTypeLabel.setTextFill(Color.BLACK);
                        searchTypeTypesLabel.setTextFill(Color.BLACK);
                    }
                }
            }
        };
        radioButtonSearchSN.selectedProperty().addListener(radioChangeListener);
        radioButtonSearchName.selectedProperty().addListener(radioChangeListener);
        radioButtonSearchType.selectedProperty().addListener(radioChangeListener);
    }
    /**
     * This method is to ensure the correct label is highlighted in red 
     * when the corresponding option in the addToy Combo Box is selected. 
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */  
    private void setupComboBoxListeners() {
        // Ensure your ComboBox is of type String
        addToyCategoryComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Reset all labels to black (or default color)
            addToyPuzzleLabel.setTextFill(Color.BLACK);
            addToyAnimalLabel.setTextFill(Color.BLACK);
            addToyFigureLabel.setTextFill(Color.BLACK);
            addToyBoardGameLabel.setTextFill(Color.BLACK);

            // Check if newValue is not null and is a String
            if (newValue != null && newValue instanceof String) {
                switch ((String) newValue) { // Cast newValue to String
                    case "Puzzles":
                        addToyPuzzleLabel.setTextFill(Color.RED);
                        break;
                    case "Animals":
                        addToyAnimalLabel.setTextFill(Color.RED);
                        break;
                    case "Figures":
                        addToyFigureLabel.setTextFill(Color.RED);
                        break;
                    case "Board Games":
                        addToyBoardGameLabel.setTextFill(Color.RED);
                        break;
                        }
                }
        }
        );
    }
    /**
     * This method sets up the Combo Box to allow selection of toy types.
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */  
    private void setupComboBoxOptions() {
        ObservableList<String> options = FXCollections.observableArrayList(
            "Animals", "Figures", "Puzzles", "Board Games"
        );
        addToyCategoryComboBox.setItems(options);
    }
    /**
     * This method handles the SEARCHE functionality based on 
     * user selected criteria.
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     * @throws FileNotFoundException 
     */  
    @FXML
    void handleSearchSearchButtonAction(ActionEvent event) throws FileNotFoundException {
    	ArrayList<Toys> listOfToys = null;
    	if (radioButtonSearchSN.isSelected()) {
    		System.out.println("Search by SN");
    		listOfToys = applicationManager.searchSerialNumberNoLoadFile(searchSNTextField.getText());
    	}
    	else if (radioButtonSearchName.isSelected()) {
    		System.out.println("Search by Name");
    		listOfToys = applicationManager.searchNameNoLoadFile(searchNameTextField.getText());
    	}
    	else if (radioButtonSearchType.isSelected()) {
    		System.out.println("Search by Type");
    		listOfToys = applicationManager.searchTypeNoLoadFile(searchTypeTextField.getText());
        }
        else {
            return; 
        }
        ObservableList<Toys> observableSearchResults = FXCollections.observableArrayList(listOfToys);
        toyFinderListView.setItems(observableSearchResults);
    }
    
    
    @FXML
    void handleSearchPurchaseButtonAction(ActionEvent event) {
    	
        Toys selectedToy = toyFinderListView.getSelectionModel().getSelectedItem();
        
        if (selectedToy != null) {
        	
        	
        	/**
        	 * 
        	 * SARAH MAKE NOTE OF BRETTS ALERTS!
        	 */
        	if (selectedToy.getAvailableCount() > 0) {
        		selectedToy.setAvailableCount(selectedToy.getAvailableCount() - 1);
        		toyFinderMessageText.setText("Purchase Successful!");
        	}
        	else if (selectedToy.getAvailableCount() == 0) {
        		toyFinderMessageText.setText("The selected toy is no llonger in stock.");
        	}
            else {
            	toyFinderMessageText.setText("The selected toy does not exist in the system.");
            }
        }
    }
    
    void updateCountInFile(Toys toy) {
       
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            
            String line;
            StringBuilder newContents = new StringBuilder();
            
            while ((line = reader.readLine()) != null) {
                // Find the line related to the toy and update its count
                if (line.contains(toy.getSerialNumber())) {
                    String[] parts = line.split(";");
                    int newCount = toy.getAvailableCount();
                    parts[1] = String.valueOf(newCount);
                    line = String.join(";", parts);
                }
                newContents.append(line).append("\n");
            }
            
            // Write the updated contents back to the file
            writer.write(newContents.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleAddToyButtonAction(ActionEvent event) {
    	
        String serialNumber = addToySNTextField.getText();
        String name = addToyNameTextField.getText();
        String brand = addToyBrandTextField.getText();
        double price = Double.parseDouble(addToyPriceTextField.getText());
        int availableCount = Integer.parseInt(addToyAvailableCountTextField.getText());
        int ageAppropriate = Integer.parseInt(addToyAgeAppropriateTextField.getText());
        String toyType = addToyCategoryComboBox.getValue(); // Type from ComboBox
        String additionalInfo1 = ""; // Additional info based on toy type
        String additionalInfo2 = ""; // Additional info for certain toy types

        // Determine additionalInfo based on toyType
        if (toyType.equalsIgnoreCase("figures")) {
        	
            additionalInfo1 = addToyFigureClassificationTextField.getText();
            
        } else if (toyType.equalsIgnoreCase("animals")) {
        	
            additionalInfo1 = addToyAnimalMaterialTextBox.getText();
            additionalInfo2 = addToyAnimalSizeTextBox.getText();
            
        } else if (toyType.equalsIgnoreCase("puzzles")) {
        	
            additionalInfo1 = addToyPuzzleTypeTextBox.getText();
            
        } else if (toyType.equalsIgnoreCase("board games")) {
        	
            additionalInfo1 = addToyGameMinPLyrsTextField.getText() + "-" + addToyGameMaxPLyrsTextField.getText();
            additionalInfo2 = addToyGameDesignersTextField.getText();
        }

//        addToy(serialNumber, name, brand, price, availableCount, ageAppropriate, toyType, additionalInfo1, additionalInfo2);

        boolean isAdded = addToy(serialNumber, name, brand, price, availableCount, ageAppropriate, toyType, additionalInfo1, additionalInfo2);

        if (isAdded) {
        	
            // Show success alert
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("The toy has been successfully added!");
            alert.showAndWait();
            
        } else {
        	
            // Show error alert
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("There was an error adding the toy.");
            alert.showAndWait();
        }
        
    }
    
    public boolean addToy(String serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String type, String additionalInfo1, String additionalInfo2) {
        Toys newToy = null;

        switch (type.toLowerCase()) {
        
            case "figures":
                // For Figures, additionalInfo1 is classification
                newToy = new Figures(serialNumber, name, brand, price, availableCount, ageAppropriate, additionalInfo1);
                break;
                
            case "animals":
                // For Animals, additionalInfo1 is material, additionalInfo2 is size
                newToy = new Animals(serialNumber, name, brand, price, availableCount, ageAppropriate, additionalInfo1, additionalInfo2);
                break;
                
            case "puzzles":
                // For Puzzles, additionalInfo1 is puzzleType
                newToy = new Puzzles(serialNumber, name, brand, price, availableCount, ageAppropriate, additionalInfo1);
                break;
                
            case "board games":
                // For BoardGames, additionalInfo1 contains min-max players range, additionalInfo2 is designers
                String[] playerRange = additionalInfo1.split("-");
                int minPlayers = Integer.parseInt(playerRange[0]);
                int maxPlayers = Integer.parseInt(playerRange[1]);
                newToy = new BoardGames(serialNumber, name, brand, price, availableCount, ageAppropriate, minPlayers, maxPlayers, additionalInfo2);
                break;
                
            default:
                // If toy type is unknown, return false immediately
                return false;
        }

        if (newToy != null) {
        	
            listOfEveryToy.add(newToy);
            // save the updated list to a file
            saveToFile(FILE_PATH);
            return true;
        }
		return false;
		}

    

    public void saveToFile(String FILE_PATH) {
    	
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
        	
            for (Toys toy : listOfEveryToy) {
            	
                writer.println(toy.toString()); // Assuming your toy's toString method returns a line in the format needed for the file
            }
        } catch (IOException e) {
        	
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


    public void loadFromFile(String FILE_PATH) {
    	
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
        	
            while (scanner.hasNextLine()) {
            	
                String line = scanner.nextLine();
                Toys toy = parseToy(line);
                if (toy != null) {
                    listOfEveryToy.add(toy);
                }
            }
        } catch (FileNotFoundException e) {
        	
            System.err.println("File not found: " + e.getMessage());

        }
    }
    
    private Toys parseToy(String line) {
        String[] temp = line.split(";");

        String serialNumber = temp[0];
        char firstChar = serialNumber.charAt(0);

        switch (firstChar) {
        
            case '0': 
            case '1': 
                // Parse as Figures
                return new Figures(serialNumber, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6]);
           
            case '2': 
            case '3': 
                // Parse as Animals
                return new Animals(serialNumber, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6], temp[7]);
            
            case '4': 
            case '5': 
            case '6': 
                // Parse as Puzzles
                return new Puzzles(serialNumber, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6]);
            
            case '7': 
            case '8': 
            case '9': 
                // Parse as BoardGames
                String[] playerRange = temp[6].split("-");
                int minPlayers = Integer.parseInt(playerRange[0]);
                int maxPlayers = Integer.parseInt(playerRange[1]);
                return new BoardGames(serialNumber, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), minPlayers, maxPlayers, temp[7]);
            
            default:
            	
                throw new IllegalArgumentException("Invalid or unknown serial number: " + serialNumber);
        }
    }
    
	
    
    @FXML
    void handleSearchRemoveToyButtonAction(ActionEvent event) throws FileNotFoundException {
        String searchSerialNumber = removeToySNTextField.getText();
        listOfToys = applicationManager.searchSerialNumberNoLoadFile(searchSerialNumber);
        ObservableList<Toys> observableSearchResults = FXCollections.observableArrayList(listOfToys);
        toyRemovalListView.setItems(observableSearchResults);
    }

    @FXML
    void handleRemoveToyButtonAction(ActionEvent event) throws FileNotFoundException {
        Toys selectedToy = toyRemovalListView.getSelectionModel().getSelectedItem();
        
        if (selectedToy != null && selectedToy.getAvailableCount() > 0) {
            // Remove the selected toy from the ArrayList
            listOfToys.remove(selectedToy);
            
            
            // Immediately update the .txt file after removal from the list
            removeToyFromFile(selectedToy);

            // Update the ObservableList and ListView
            ObservableList<Toys> observableSearchResults = FXCollections.observableArrayList(listOfToys);
            toyRemovalListView.setItems(observableSearchResults);
            // Update the .txt file
            removeToyFromFile(selectedToy);
        }
    }
    
    private void removeToyFromFile(Toys toyToRemove) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("tempfile.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.trim().split(";");
                if (!parts[0].equals(toyToRemove.getSerialNumber())) { 
                    writer.println(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Better error handling should be implemented
        }

        // Check if the temp file has been written correctly before deleting original file
        if (tempFile.exists() && tempFile.length() > 0) {
            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Could not rename temp file to original file name");
                }
            } else {
                System.out.println("Could not delete original file");
            }
        } else {
            System.out.println("Temp file is empty or does not exist");
        }
    }


    //		0011123456;gerry giraffe;hasbro;9.99;15;4;plush;s

/**
 * 
 * Searach SN
 * use ".remove" to remove the item at that index in the array
 * to find the index of the searched SN, start at 0, have count incremement by 1
 */




    
    
    
    
    
    /**
     * This method Clears the fields and radioButtons in the Home tab. 
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */  
    @FXML
    void handleSearchClearButtonAction(ActionEvent event) {
        searchSNTextField.setText("");
        searchNameTextField.setText("");
        searchTypeTextField.setText("");
        radioButtonSearchSN.setSelected(false);
        radioButtonSearchName.setSelected(false);
        radioButtonSearchType.setSelected(false);
    }

    /**
     * This method Clears the fields and radioButtons in the Add Toy tab. 
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */  
    @FXML
    void handleAddToyClearButtonAction (ActionEvent event) {
    	// General Toy Attributes
    	addToySNTextField.setText("");
    	addToyNameTextField.setText("");
    	addToyBrandTextField.setText("");
    	addToyPriceTextField.setText("");
    	addToyAvailableCountTextField.setText("");
    	addToyAgeAppropriateTextField.setText("");
    	// Animal Toy Attributes
    	addToyAnimalMaterialTextBox.setText("");
    	addToyAnimalSizeTextBox.setText("");
    	// Figure Toy Attributes
    	addToyFigureClassificationTextField.setText("");
    	// Puzzle Toy Attributes
    	addToyPuzzleTypeTextBox.setText("");
    	// Board Game Toy Attributes
    	addToyGameMinPLyrsTextField.setText("");
    	addToyGameMaxPLyrsTextField.setText("");
    	addToyGameDesignersTextField.setText("");
        // Reset ComboBox
        addToyCategoryComboBox.setValue(null);
        addToyCategoryComboBox.setPromptText("Toy Type");
    }
}
