package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class Manager implements Initializable{

	ApplicationManager applicationManager;
	
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
    private ListView<?> toyFinderListView;

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
    private Tab removeToyTabPane;

    @FXML
    private ListView<?> toyRemovalListView;

    @FXML
    private TextField removeToySNTextField;

    @FXML
    private Button removeToyButton;

    @FXML
    private Label removeToyLabel2;

    @FXML
    private Label removeToyLabel1;

    
    @FXML
    public void initialize() {

    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        setupRadioButtonListeners();
        setupComboBoxListeners();
        setupComboBoxOptions();
		applicationManager = new ApplicationManager();
		
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
                    } else {
                        searchTypeLabel.setTextFill(Color.BLACK);
                    }
                }
            }
        };
        radioButtonSearchSN.selectedProperty().addListener(radioChangeListener);
        radioButtonSearchName.selectedProperty().addListener(radioChangeListener);
        radioButtonSearchType.selectedProperty().addListener(radioChangeListener);
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
     * This method 
     * 
     * author @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     * @throws FileNotFoundException 
     */  
    @FXML
    void handleSearchSearchButtonAction(ActionEvent event) throws FileNotFoundException {
    	System.out.println("Hello");
    	if (radioButtonSearchSN.isSelected()) {
    		System.out.println("Search by SN");
    		applicationManager.searchSerialNumberNoLoadFile(searchSNTextField.getText());
    	}
    	else if (radioButtonSearchName.isSelected()) {
    		System.out.println("Search by Name");
    		applicationManager.searchNameNoLoadFile(searchNameTextField.getText());
    	}
    	else if (radioButtonSearchType.isSelected()) {
    		System.out.println("Search by Type");
    		applicationManager.searchTypeNoLoadFile(searchTypeTextField.getText());
    	}
    }
    
    @FXML
    void toyFinderListView() {
    	
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
    }



    
    
}