import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
/**
 * Class that controls movement of StringObjects in stringObjArray.
 * @author jen.chen.1398
 *
 */
public class StringMover {
	private ArrayList<StringObj> stringObjArray;
	/**
	 * Moves the StringObj in the x direction at x velocity
	 * @param strObj
	 * @param xVel
	 */
	public void moveX(StringObj strObj, int xVel) {
		int num = strObj.getX();
		strObj.setX(num += xVel);
	}
/**
 * Moves the StringObj in y direction at y velocity
 * @param strObj
 * @param yVel
 */
	public void moveY(StringObj strObj, int yVel) {
		int num = strObj.getY();
		strObj.setY(num += yVel); 
	}
/**
 * Controls the wrapping around of StringObj around borders of the display
 * @param strObj
 * @param rect
 * @param width
 * @param height
 */
	public void wrapAround(StringObj strObj, Rectangle2D rect, int width, int height) {
		// check horizontal OR vertical wrap around
		if (Math.abs(strObj.getXVel()) != Math.abs(strObj.getYVel())) {
			if (strObj.getX() + rect.getWidth() < 0)
				strObj.setX(width);
			else if (strObj.getX() > width)
				strObj.setX(0);
			else if (strObj.getY() + rect.getHeight() < 0)
				strObj.setY(height);
			else if (strObj.getY() > height){
				strObj.setY(0);
			}
		}

		// check diagonal wrap around //torus behavior
		if (Math.abs(strObj.getXVel()) == Math.abs(strObj.getYVel())) {
			if (strObj.getX() + rect.getWidth() < 0){
				strObj.setX(width + strObj.getX());
			}
			if (strObj.getX() > width) {
				strObj.setX(0);
			}
			if (strObj.getY() + ((int)rect.getHeight()) < 0) {
				strObj.setY(height + strObj.getY());
					strObj.setY(strObj.getY());
			}
			if (strObj.getY() > height) {				
				strObj.setY(0);
			}
			

		}
	}


/**
 * Returns int direction value of a String compass value
 * @param str
 * @return int direction value of a String compass value
 */
	public int direction(String str, int speed) {
		int direction;
		switch (str) {
		case "N":
			direction = -1*speed;
			break;
		case "S":
			direction = 1*speed;
			break;
		case "W":
			direction = -1*speed;
			break;
		case "E":
			direction = 1*speed;
			break;
		default:
			direction = 0;
			break;

		}
		return direction;
	}
	/**
	 * Returns the StringObj array
	 * @return stringObjArray
	 */
	public ArrayList<StringObj> getObjArray(){
		return stringObjArray;
	}
	/**
	 *Returns index of a String value in the StringObj array
	 * @param value
	 * @return
	 */
	public int getIndexOf(String value){
		int index=-1;
		for(StringObj s: stringObjArray){			
			if(s.getValue().equals(value)){
				System.out.println("yes");
				index= stringObjArray.indexOf(s);
			}			
		}
		return index;
		
	}
	/**
	 * Creates a StringObjArray from a temp ArrayList
	 * @param numStrings
	 * @param temp
	 */
	public void createStringObjArray(int numStrings, ArrayList<StringObj> temp) {

		stringObjArray = new ArrayList<StringObj>();
		stringObjArray=temp;
	}
	/**
	 * Updates the StringObj ArrayList at numAt with newObj
	 * @param numAt
	 * @param newObj
	 */
	public void updateArrayAt(int numAt, StringObj newObj){
		stringObjArray.set(numAt, newObj);
	}
	/**
	 * Removes element of StringObj ArrayList at i
	 * @param i
	 */
	public void removeElementAt(int i){
		stringObjArray.remove(i);
	}
}
