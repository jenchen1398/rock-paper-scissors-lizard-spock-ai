import java.awt.Font;
/**
 * A StringObj has a value, x,y,xvelocity, yvelocity, and font.
 * @author jen.chen.1398
 *
 */
public class StringObj {
	private String value;
	private int x;
	private int y;
	private int xVelocity;
	private int yVelocity;
	private Font font;
	/**
	 * Constructs StringObj with value, x,y,xvelocity, yvelocity, and font.
	 * @param myValue
	 * @param myX
	 * @param myY
	 * @param myXVelocity
	 * @param myYVelocity
	 * @param myFont
	 */
	public StringObj(String myValue, int myX, int myY, int myXVelocity, int myYVelocity, Font myFont){
		font=myFont;
		value=myValue;
		x=myX;
		y=myY;
		xVelocity=myXVelocity;
		yVelocity=myYVelocity;
	}
	/**
	 * Returns font of StringObj
	 * @return font
	 */
	public Font getFont(){
		return font;
	}
	/**
	 * Returns x location
	 * @return x
	 */
	public int getX(){
		return x;
	}
	/**
	 * Returns y location
	 * @return y
	 */
	public int getY(){
		return y;
	}
	/**
	 * Returns x velocity
	 * @return xVelocity
	 */
	public int getXVel(){
		return xVelocity;
	}
	/**
	 * Returns y Velocity
	 * @return yVelocity
	 */
	public int getYVel(){
		return yVelocity;
	}
	/**
	 * Returns String value
	 * @return value
	 */
	public String getValue(){
		return value;
	}
	/**
	 * Set x to newX
	 * @param newX
	 */
	public void setX(int newX){
		x=newX;
	}
	/**
	 * Set y to newY
	 * @param newY
	 */
	public void setY(int newY){
		y=newY;
	}
	/**
	 * Set value to new value
	 * @param s
	 */
	public void setValue(String s) {
		// TODO Auto-generated method stub
		value=s;
	}


}
