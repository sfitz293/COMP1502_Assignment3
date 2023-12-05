package model;

/**
 * This class represents a subclass of toys categorized as puzzles. 
 * It stores information about the puzzles toy Subclass.
 * It extends the Toys class and includes additional properties
 * specific to puzzles toys such as the classification of type.
 * 
 * @author Brett Big Swan 
 * @author Sarah Fitzgerald
 */
public class Puzzles extends Toys {

	private String puzzleType;	// The puzzle type of the puzzles toy.
	
	/**
	 * This Constructor constructs an puzzle object with specified details.
	 * 
	 * @param serialNumber A reference to a String object containing a toy's serial number.
	 * @param name A reference to a String object containing a toy's name.
	 * @param brand A reference to a String object containing a toy's brand.
	 * @param price A reference to a double object containing a toy's price.
	 * @param availableCount A reference to an int containing a toy's available count.
	 * @param ageAppropriate A reference to an int object containing a toy's appropriate age.
	 * @param puzzleType A reference to a String object containing a toy's puzzle type.
	 */
	public Puzzles(String serialNumber, String name, String brand,
				double price, int availableCount, int ageAppropriate,
				String puzzleType) {
		
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.puzzleType = puzzleType;
	}
	
	
	/**
	 * Sets puzzle type.
	 * 
	 * @param puzzleType
	 */
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	
	/**
	 * Gets puzzle type.
	 * 
	 * @return puzzleType
	 */
	public String getPuzzleType() {
		return puzzleType;
	}


	/**
	 * Returns the type category of this toy. 
	 * In this case, it categorizes the toy as a "puzzle".
	 *
	 * @return A string "puzzles" that represents the type of toy this is.
	 */
	@Override
	public String getType() {
	    return "puzzles";
	}


    /**
     *  The toString method that provides a string representation of the puzzle toy including
     *  its serial number, name, brand, price, available count, appropriate age, and the 
     *  type of puzzle, all separated by semicolons.
	 *
     * @return A string representation of the toy's details.
     */
	@Override
	public String toString() {
	    return super.getSerialNumber() + ";" + super.getName() + ";" + super.getBrand() +
	            ";" + super.getPrice() + ";" + super.getAvailableCount() + ";" +
	            super.getAgeAppropriate() + ";" + puzzleType;
	}
}