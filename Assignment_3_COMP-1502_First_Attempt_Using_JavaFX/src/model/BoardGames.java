package model;

/**
 * This class represents a subclass of toys categorized as boardgames. 
 * It stores information about the boardgames toy Subclass.
 * It extends the Toys class and includes additional properties
 * specific to boardgames such as designer, as well as minimum 
 * and maximum number of players.
 * 
 * @author Brett Big Swan 
 * @author Sarah Fitzgerald
 */
public class BoardGames extends Toys{

	private int minNumberOfPlayers;	// The minimum number of players needed for the Board game.
	private int maxNumberOfPlayers;	// The maximum number of players needed for the Board game.
	private String numOfPlayers;	// Another variable to store the min and max number of players.
	private String designers;		// The designer(s) of the Board game.
	
	/**
	 * This Constructor constructs a new board game with detailed information.
	 *  
	 * @param serialNumber A reference to a String object containing a toy's serial number.
	 * @param name A reference to a String object containing a toy's name.
	 * @param brand A reference to a String object containing a toy's brand.
	 * @param price A reference to a double object containing a toy's price.
	 * @param availableCount A reference to an int containing a toy's available count.
	 * @param ageAppropriate A reference to an int object containing a toy's appropriate age.
	 * @param minNumberOfPlayers A reference to an int object containing a toy's min number of players.
	 * @param maxNumberOfPlayers A reference to an int object containing a toy's max number of players.
	 * @param designers A reference to a String object containing a toy's designers.
	 */
	public BoardGames(String serialNumber, String name, String brand,
				double price, int availableCount, int ageAppropriate,
				int minNumberOfPlayers, int maxNumberOfPlayers,
				String designers){
		
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.minNumberOfPlayers = minNumberOfPlayers;
		this.maxNumberOfPlayers = maxNumberOfPlayers;
		this.designers = designers;
	}

	public BoardGames(String serialNumber, String name, String brand,
				double price, int availableCount, int ageAppropriate,
				String numOfPlayers, String designers) {
		
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.numOfPlayers = numOfPlayers;
		String[] ageRange = numOfPlayers.split("-");
		int minPlayers = Integer.parseInt(ageRange[0]);
		int maxPlayers = Integer.parseInt(ageRange[1]);
		this.minNumberOfPlayers = minPlayers;
		this.maxNumberOfPlayers = maxPlayers;
		this.designers = designers;
	}
	
	/**
	 * A reference to an int object that sets a toy's min number of players.
	 * 
	 * @param minNumberOfPlayers
	 */
	public void setMinNumberOfPlayers(int minNumberOfPlayers) {
		this.minNumberOfPlayers = minNumberOfPlayers;
	}
	
	
	/**
	 * An int object that gets a toy's min number of players.
	 * 
	 * @return minNumberOfPlayers
	 */	
	public int getMinNumberOfPlayers() {		
		return minNumberOfPlayers;
	}
	
	
	/**
	 * A reference to an int object that sets a toy's max number of players.
	 * 
	 * @param maxNumberOfPlayers
	 */	
	public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {		
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}

	
	/**
	 * An int object that gets a toy's max number of players.
	 * 
	 * @return maxNumberOfPlayers
	 */	
	public int getMaxNumberOfPlayers() {		
		return maxNumberOfPlayers;
	}
	
	
	/**
	 * A reference to a String object that sets a toy's designers.
	 * 
	 * @param designers
	 */	
	public void setDesigners(String designers) {		
		this.designers = designers;
	}
	
	
	/**
	 * A string object that gets a toy's designers.
	 * 
	 * @return designers
	 */	
	public String getDesigners() {
		return designers;
	}	
	
	
    /**
	 * Returns the type category of this toy. 
	 * In this case, it categorizes the toy as a "board game".
     * 
     * @return A String specifying the type of the toy.
     */
    @Override
    public String getType() {    	
        return "board games";
    }

    
	/**
	 * The toString method
	 * 
	 * @return A string object containing the toy's serial number, name, brand, price, available count,
	 * 			appropriate age, the minimum number of players, the maximum number of players, and the
	 * 			designers.
	 */
	@Override
    public String toString() {
		return super.getSerialNumber() + ";" + super.getName() + ";" + super.getBrand() +
				";" + super.getPrice() + ";" + super.getAvailableCount() + ";" +
				super.getAgeAppropriate() + ";" + getMinNumberOfPlayers() + "-"+ getMaxNumberOfPlayers() +
				";" + designers;
	}
}