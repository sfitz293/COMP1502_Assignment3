package model;

import exceptions.NegativePriceException;

/**
 * This class stores information about the abstract Toy Superclass.
 * It holds common information such as serial number, name, brand, price, 
 * available count, and age appropriateness. Specific types of toys should 
 * extend this class and provide additional details.
 * 
 * @author Sarah Fitzgerald 
 * @author Brett Big Swan
 */
public abstract class Toys {
	
	// The toy's serial number
	private String serialNumber;	
	// The toy's name
	private String name;			
	// The toy's brand
	private String brand;			
	// The toy's price
	private double price;			
	// The toy's available count
	private int availableCount;		
	// The toy's appropriate age
	private int ageAppropriate;		
	
	/**
	 * This Constructor constructs a new toy with the specified details. 
	 * Each toy has a unique serial number, name, brand, price, available count, 
	 * and age appropriateness.
	 * 
	 * @param serialNumber A reference to a String object containing a toy's serial number.
	 * @param name A reference to a String object containing a toy's name.
	 * @param brand A reference to a String object containing a toy's brand.
	 * @param price A reference to a double object containing a toy's price.
	 * @param availableCount A reference to an int containing a toy's available count.
	 * @param ageAppropriate A reference to an int object containing a toy's appropriate age.
	 */
	public Toys(String serialNumber, String name, String brand,
			double price, int availableCount, int ageAppropriate) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropriate = ageAppropriate;
	}
	
	
    /**
     * Sets the serial number of the toy.
     *
     * @param serialNumber A unique identifier for the toy.
     */
    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Retrieves the serial number of the toy.
     *
     * @return The toy's serial number.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the name of the toy.
     *
     * @param name The descriptive name of the toy.
     */
    public void setName(String name) {
        this.name = name;
    }
	
	
    /**
     * Retrieves the name of the toy.
     *
     * @return The name of the toy.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the brand of the toy.
     *
     * @param brand The manufacturer of the toy.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Retrieves the brand of the toy.
     *
     * @return The brand of the toy.
     */
    public String getBrand() {
        return brand;
    }
	
	
    /**
     * Sets the price of the toy as a double. Throws an exception if the price is negative.
     *
     * @param price The retail price of the toy.
     * @throws NegativePriceException If the price is set to a negative number.
     */
    public void setPrice(double price) throws NegativePriceException {
        if (price < 0) {
            throw new NegativePriceException("The price cannot be negative.");
        }
        this.price = price;
    }

    /**
     * Retrieves the price of the toy.
     *
     * @return The price of the toy.
     */
    public double getPrice() {
        return price;
    }
	
	
    /**
     * Sets the available count of the toy.
     *
     * @param availableCount The number of toys available in stock.
     */
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    
    /**
     * Retrieves the available count of the toy.
     *
     * @return The number of toys available for purchase.
     */
    public int getAvailableCount() {
        return availableCount;
    }
	
    
    /**
     * Sets the recommended minimum age for the toy user.
     *
     * @param ageAppropriate The recommended minimum age.
     */
    public void setAgeAppropriate(int ageAppropriate) {
        this.ageAppropriate = ageAppropriate;
    }

    
    /**
     * Retrieves the recommended minimum age for the toy user.
     *
     * @return The appropriate age for the toy.
     */
    public int getAgeAppropriate() {
        return ageAppropriate;
    }
	
	
    /**
     * Retrieves the generic type of the toy. 
     *
     * @return A string representing the generic type of the toy.
     */
    public String getType() {
        return "generic"; // Default type, override in subclasses
    }

    /**
     * Provides a string representation of the toy's details, including serial number,
     * name, brand, price, available count, and age appropriateness.
     *
     * @return A string representation of the toy.
     */
    public String toString() {
        return getSerialNumber() + ";" + getName() + ";" + getBrand()
                + ";" + getPrice() + ";" + getAvailableCount()
                + ";" + getAgeAppropriate();
    }
}