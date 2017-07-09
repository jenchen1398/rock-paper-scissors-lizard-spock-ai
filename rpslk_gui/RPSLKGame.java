import java.util.ArrayList;

/**
 * RPSLKGame class handles the objects used in RPSLKGame. It instantiates an
 * ArrayList<String> to store the objects used in the game, keeps track of the
 * possibilities of the game in a 2D array, and stores the verbs used between
 * objects in a 2D array. It has methods to determine which object won, to
 * return the index in the ArrayList of the winning object, and can return a
 * String sentence of why an object won over another object.
 * 
 * 
 * @author Jenny Chen jc4686
 */

public class RPSLKGame {
	private String ROCK;
	private String PAPER;
	private String SCISSORS;
	private String LIZARD;
	private String SPOCK;
	private ArrayList<String> objArray;
	private int[][] possibilitiesArray;
	private String[][] verbArray;

	/**
	 * Constructs an instance of RPSLKGame. Stores the String constants ROCK,
	 * PAPER, SCISSORS, LIZARD, and SPOCK in an ArrayList<String> objArray.
	 * Constructs a 2D array possibilitiesArray that stores 0 if the 2 indexes
	 * indicate a tie, stores 1 if the object corresponding to the row index
	 * wins, and stores -1 if the object corresponding to the column index wins.
	 * Constructs a 2D array verbArray that stores the appropriate verb
	 * corresponding to the 2 indexes the objects refer to.
	 */
	public RPSLKGame() {
		ROCK = "R";
		PAPER = "P";
		SCISSORS = "S";
		LIZARD = "L";
		SPOCK = "K";
		objArray = new ArrayList<String>();
		objArray.add(ROCK);
		objArray.add(PAPER);
		objArray.add(SCISSORS);
		objArray.add(LIZARD);
		objArray.add(SPOCK);
		possibilitiesArray = new int[][] { { 0, -1, 1, 1, -1 }, { 1, 0, -1, -1, 1 }, { -1, 1, 0, 1, -1 },
				{ -1, 1, -1, 0, 1 }, { 1, -1, 1, -1, 0 } };
		verbArray = new String[][] { { "ties with", "covers", "crushes", "crushes", "vaporizes" },
				{ "covers", "ties with", "cuts", "eats", "disproves" },
				{ "crushes", "cuts", "ties with", "decapitates", "smashes" },
				{ "crushes", "eats", "decapitates", "ties with", "poisons" },
				{ "vaporizes", "disproves", "smashes", "poisons", "ties with" } };
	}

	/**
	 * Returns the ArrayList of the String constant objects. *
	 * 
	 * @return objArray ArrayList of String constant objects used in the RPS
	 *         game.
	 */
	public ArrayList<String> getObjArray() {
		return objArray;
	}

	/**
	 * Returns the int[][] 2D array possibilitiesArray
	 * 
	 * @return possibilitiesArray a 2D int[][] array that stores an int 1, -1,
	 *         or 0 to indicate whether there is a tie, or if the object
	 *         corresponding to the row or column index won
	 */
	public int[][] getPossibilitiesArray() {
		return possibilitiesArray;
	}

	/**
	 * Returns the String[][] 2D array that stores the appropriate verb to what
	 * objects the 2 indexes refer to
	 * 
	 * @return verbArray a String[][] 2D array that stores the appropriate verb
	 *         to what objects the 2 indexes refer to
	 */
	public String[][] getVerbArray() {
		return verbArray;
	}

	/**
	 * Returns String of the object that won. Uses method returnWinIndex to
	 * get the index of the winning object. Returns the String object at the index the
	 * method determines to be equal to the winIndex. Used by determineObjWon()
	 * method in Talker class to get the object that wins.
	 * 
	 * @param obj1 
	 * @param obj2
	 * @return String "Tie" if obj1 is equal to obj2, otherwise returns
	 *         the String at the winIndex of objArray (ArrayList<String>)
	 */
	public String whichObjWon(String obj1, String obj2) {

		int obj1Index = objArray.indexOf(obj1);
		int obj2Index = objArray.indexOf(obj2);
		int winIndex;
		if (obj1Index == obj2Index)
			return "Tie";
		winIndex = returnWinIndex(obj1Index, obj2Index);
		
		if (winIndex == obj1Index)
			return objArray.get(obj1Index);
		else // if(winIndex==compObjIndex)
			return objArray.get(obj2Index);

	}
	public String whichObjLost(String obj1, String obj2) {

		int obj1Index = objArray.indexOf(obj1);
		int obj2Index = objArray.indexOf(obj2);
		int winIndex;
		if (obj1Index == obj2Index)
			return "Tie";
		winIndex = returnWinIndex(obj1Index, obj2Index);
		
		if (winIndex == obj1Index)
			return objArray.get(obj2Index);
		else // if(winIndex==compObjIndex)
			return objArray.get(obj1Index);

	}

	/**
	 * Returns which index in the possibilitiesArray refers to the winning
	 * object
	 * 
	 * @param index1
	 * @param index2
	 * @return index1 if the corresponding int at coordinates (index1, index2)
	 *         of the 2D array possibilitiesArray is 1. Otherwise returns
	 *         index2.
	 */
	public int returnWinIndex(int index1, int index2) {
		int possibilityInt = possibilitiesArray[index1][index2];
		if (possibilityInt == 1)
		{
			return index1;
		}
		else // if(possibilityInt==-1)
		{
			return index2;
		}
	}

	/**
	 * Gets the String verb at the corresponding indexes
	 * 
	 * @param index1
	 * @param index2
	 * @return verbArray[index1][index2] String verb at the corresponding
	 *         coordinate (index1, index2) of the 2D array verbArray
	 */
	public String getVerb(int index1, int index2) {

		return verbArray[index1][index2];
	}

	/**
	 * Returns String sentence that gives reason for why an object won
	 * 
	 * @param winningObj String of the winning object
	 * @param losingObj String of the losing object
	 * @return whyWonSent a String sentence that gives the reason for why the winningObj won
	 */

	public String whyWonSentence(String winningObj, String losingObj) {
		String whyWonSent;
		int winObjIndex = objArray.indexOf(winningObj);
		int loseObjIndex = objArray.indexOf(losingObj);
		whyWonSent = winningObj + " " + getVerb(winObjIndex, loseObjIndex) + " " + losingObj;
		return whyWonSent;

	}

}
