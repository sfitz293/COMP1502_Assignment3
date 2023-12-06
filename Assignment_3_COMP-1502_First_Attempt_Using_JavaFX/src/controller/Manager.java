package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Toys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class Manager implements Initializable{

    // The file path to the inventory file
    private final String FILE_PATH = "res/toys.txt";
    
	ApplicationManager applicationManager;
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
    
    @FXML
    private Button addToyAddButton;

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
    private Text toyRemovalMessageText;

    
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
    /**
     * This method allows user to purchase their selected toy.
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     * @throws FileNotFoundException 
     */  
    @FXML
    void handleSearchPurchaseButtonAction(ActionEvent event) {
        Toys selectedToy = toyFinderListView.getSelectionModel().getSelectedItem();
        if (selectedToy != null) {
        	if (selectedToy.getAvailableCount() > 0) {
        		selectedToy.setAvailableCount(selectedToy.getAvailableCount() - 1);
        		toyFinderMessageText.setText("Purchase Successful!");
        		toyFinderMessageText.setFill(Color.GREEN);
        	}
        	else if (selectedToy.getAvailableCount() == 0) {
        		toyFinderMessageText.setText("The selected toy is no longer in stock.");
        		toyFinderMessageText.setFill(Color.RED);
        	}
            else {
            	toyFinderMessageText.setText("The selected toy does not exist in the system.");
            	toyFinderMessageText.setFill(Color.RED);
            }
        }
    }
    /**
     * This method decrements count accordingly.
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     * @throws FileNotFoundException 
     */  
    void updateCountInFile(Toys toy) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String line;
            StringBuilder newContents = new StringBuilder();   
            while ((line = reader.readLine()) != null) {
                // Find the line related to toy, update the count.
                if (line.contains(toy.getSerialNumber())) {
                    String[] parts = line.split(";");
                    int newCount = toy.getAvailableCount();
                    parts[1] = String.valueOf(newCount);
                    line = String.join(";", parts);
                }
                newContents.append(line).append("\n");
            }
            // Write the updated contents back text file.
            writer.write(newContents.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	
    /**
     * This method allows user to remove the selected toy.
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     * @throws FileNotFoundException 
     */  
    @FXML
    void handleRemoveToyButtonAction(ActionEvent event) throws FileNotFoundException {
    	ArrayList<Toys> listOfToys = null;
        String serialNumberToRemove = removeToySNTextField.getText();
        
        // Callin removeToy method from  applicationManager calss.
        applicationManager.removeToy(serialNumberToRemove);
        // Populate toyRemovalListView with the updated list of toys
        ObservableList<Toys> observableListOfToys = FXCollections.observableArrayList(listOfToys);
        toyRemovalListView.setItems(observableListOfToys);
        
        // Display a message indicating successful removal in gree
        toyRemovalMessageText.setText("Toy with Serial Number " + serialNumberToRemove + " has been removed.");
        toyRemovalMessageText.setFill(Color.GREEN);
    }




    /**
     * This method removes all information about the selected toy from the data source.
     * 
     * @param toy The toy to be removed from the data source.
     * @throws FileNotFoundException If the data source file is not found.
     */
    void removeToyFromDataSource(Toys toy) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String line;
            StringBuilder newContents = new StringBuilder();   
            while ((line = reader.readLine()) != null) {
                // Find the line related to toy and skip it (effectively removing it)
                if (!line.contains(toy.getSerialNumber())) {
                    newContents.append(line).append("\n");
                }
            }
            // Write the updated contents back to the text file.
            writer.write(newContents.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    


    
    
    @FXML
    void handleAddToyAddButtonAction(ActionEvent event) {

    }
    
    
    
    
    
    
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