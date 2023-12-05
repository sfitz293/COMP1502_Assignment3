package model;

/**
 * This class represents a subclass of toys categorized as figures. 
 * It stores information about the figures toy Subclass.
 * It extends the Toys class and includes additional properties
 * specific to figures toys such as the classification of type.
 * 
 * @author Sarah Fitzgerald 
 * @author Brett Big Swan
 */
public class Figures extends Toys{

	private String classification;	// The classification of the Figures toy.
	
	/**
     * This Constructor constructs a new Figures instance with specified details.
     *
     * @param serialNumber The unique identifier for the toy.
     * @param name The name of the toy.
     * @param brand The brand of the toy.
     * @param price The retail price of the toy.
     * @param availableCount The number of toys available in stock.
     * @param ageAppropriate The recommended age for the toy.
     * @param classification The specific classification of the Figures toy.
     */
	public Figures(String serialNumber, String name, String brand,
				double price, int availableCount, int ageAppropriate, 
				String classification) {
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.classification = classification;
	}
	
	    
    /**
     * Sets the classification of this Figures toy.
     * 
     * @param classification A String representing the classification of the toy.
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }
    
    
    /**
     * Returns the classification of this Figures toy.
     * 
     * @return A String representing the classification of the toy.
     */
    public String getClassification() { 
        return classification;
    }
    
    
    /**
	 * Returns the type category of this toy. 
	 * In this case, it categorizes the toy as a "figure".
     * 
     * @return A String specifying the type of the toy.
     */
    @Override
    public String getType() {
        return "figures";
    }
    
    

    /**
     *  The toString method that provides a string representation of the figure toy including
     *  its serial number, name, brand, price, available count, appropriate age, material, classification and 
     *  type.
     * 
     * @return A string representation of the toy's details.
     */
    @Override
    public String toString() {
        
        return super.getSerialNumber() + ";" + super.getName() + ";" + super.getBrand() +
                ";" + super.getPrice() + ";" + super.getAvailableCount() + ";" +
                super.getAgeAppropriate() + ";" + classification;
    }
}