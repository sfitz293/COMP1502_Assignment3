package model;


/**
 * This class represents a subclass of toys categorized as animals. 
 * It stores information about the animals toy Subclass.
 * It extends the Toys class and includes additional properties
 * specific to animal toys such as material and size.
 * 
 * @author Sarah Fitzgerald 
 * @author Brett Big Swan
 */
public class Animals extends Toys{

	private String material;	// The material of the Animal toy.
	private String size;		// The size of the Animal toy.
	
    /**
     * This Constructor constructs an Animals object with specified details.
     * 
     * @param serialNumber The serial number of the toy.
     * @param name The name of the toy.
     * @param brand The brand of the toy.
     * @param price The price of the toy.
     * @param availableCount The number of available units.
     * @param ageAppropriate The appropriate age for using the toy.
     * @param material The material of the toy.
     * @param size The size of the toy.
     */
	public Animals (String serialNumber, String name, String brand,
				double price, int availableCount, int ageAppropriate,
				String material, String size) {
		
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.material = material;
		this.size = size;
	}
	
	
    
    /**
     * Sets the material of this animal toy.
     * 
     * @param material The material to set for this toy.
     */
    public void setMaterial(String material) {
        
        this.material = material;
    }
    
    
    /**
     * Returns the material of this animal toy.
     * 
     * @return The material of this toy.
     */
    public String getMaterial() { 
        return material;
    }
    
    
    /**
     * Sets the size of this animal toy.
     * 
     * @param size The size to set for this toy.
     */
    public void setSize(String size) {
        
        this.size = size;
    }
    
    
    /**
     * Returns the size of this animal toy.
     * 
     * @return The size of this toy.
     */
    public String getSize() {    
        return size;
    }
    
    
    /**
	 * Returns the type category of this toy. 
	 * In this case, it categorizes the toy as a "animal".
     * 
     * @return A String specifying the type of the toy.
     */
    @Override
    public String getType() {  
        return "animals";
    }
	

    /**
     *  The toString method that provides a string representation of the animal toy including
     *  its serial number, name, brand, price, available count, appropriate age, material, and 
     *  size.
     * 
     * @return A string representation of the toy's details.
     */
    @Override
    public String toString() {
        
        return super.getSerialNumber() + ";" + super.getName() + ";" + super.getBrand() +
                ";" + super.getPrice() + ";" + super.getAvailableCount() + ";" +
                super.getAgeAppropriate() + ";" + material + ";" + size;
    }
}