import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
/**
 * CollisionDetector detects collisions and returns the names of objecst that collided.
 * @author jen.chen.1398
 *
 */
public class CollisionDetector {
	/**
	 * Returns true if there is a collision between rect1 and rect2
	 * @param rect1
	 * @param rect2
	 * @return true if there is a collision between rect1 and rect2
	 */
	public boolean detectCollision(Rectangle2D rect1, Rectangle2D rect2) {
		return rect1.getBounds().intersects(rect2.getBounds());
	}
/**
 * Returns a String of both collided obj names with a space in between
 * @param objArray
 * @param rectArray
 * @return String of both collided obj names with a space in between
 */
	public String getCollidedObjNames(ArrayList<StringObj> objArray, ArrayList<Rectangle2D.Double> rectArray) {
		int num;
		String objNames = "";
		boolean hasCollided;
		for (num = 0; num < rectArray.size()-1; num++) {
			for (int i = num + 1; i < rectArray.size(); i++) {
				hasCollided = detectCollision(rectArray.get(num), rectArray.get(i));
				if (hasCollided) {
					objNames = objArray.get(num).getValue() + " " + objArray.get(i).getValue();
				}
			}
		}
		return objNames;
	}
	
}
