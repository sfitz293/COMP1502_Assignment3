package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;



public class Manager {

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
    private Label addToyBrandLabel;

    @FXML
    private Label addToyPriceLabel;

    @FXML
    private Label addToyAvailableCountLabel;

    @FXML
    private Label addToyAgeAppropriateLabel;

    @FXML
    private Label addToyAgeAppropriateLabel1;

    @FXML
    private Label addToyAgeAppropriateLabel11;

    @FXML
    private Label addToyAgeAppropriateLabel111;

    @FXML
    private Label addToyAgeAppropriateLabel1111;

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
    private Label addToyGameMinPLyrsLabel;

    @FXML
    private Label addToyGameMaxPLyrsLabel;

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
    private Tab removeToyTabPane;

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
        setupRadioButtonListeners();
        setupComboBoxOptions();
    }
    
    
    /**
     * This method is to ensure the correct label is highlighted in red 
     * when the corresponding radio button is selected. 
     * 
     * This code was not auto generated, but instead written 
     * by @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */
    private void setupRadioButtonListeners() {
        // Listener for Serial Number Radio Button.
        radioButtonSearchSN.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                	// Change to red when selected.
                    searchSNLabel.setTextFill(Color.RED); 
                } 
                else {
                	// Black until selected.
                    searchSNLabel.setTextFill(Color.BLACK);
                }
            }
        });
     // Listener for Name Radio Button.
        radioButtonSearchName.selectedProperty().addListener(new ChangeListener<Boolean>() {
            // Implementation
        	@Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                	// Change to red when selected.
                	searchNameLabel.setTextFill(Color.RED); // Change to desired color
                } 
                else {
                	// Black until selected.
                	searchNameLabel.setTextFill(Color.BLACK); // Default color
                }
            }
        });
     // Listener for Type Radio Button.
        radioButtonSearchType.selectedProperty().addListener(new ChangeListener<Boolean>() {
        	@Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                	// Change to red when selected.
                	searchTypeLabel.setTextFill(Color.RED); 
                } 
                else {
                	// Black until selected.
                	searchTypeLabel.setTextFill(Color.BLACK);
                }
            }
        });
    }
    



    /**
     * This method sets up the Combo Box to allow selection of toy types.
     * 
     * This code was not auto generated, but instead written 
     * by @Sarah_Fitzgerald do not delete when pasting new 
     * JavaFX auto generated code in.
     */
    private void setupComboBoxOptions() {
        ObservableList<String> options = FXCollections.observableArrayList(
            "Animals", "Figures", "Puzzles", "Board Games"
        );
        addToyCategoryComboBox.setItems(options);
    }

}
