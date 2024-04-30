package passingAnalytics.toBeSubmitted;

/**
 * 
 * @author gauravgupta
 * the class represents the location of a player on the pitch.
 * (0, 0) represents center of the pitch (from where kickoff happens).
 * IMPORTANT: We assume home team is near side,
 * (-BREADTH/2, -LENGTH/2) represents leftmost point on defensive goal-line.
 * (BREADTH/2, -LENGTH/2) represents rightmost point on defensive goal-line.
 * (-BREADTH/2, LENGTH/2) represents leftmost point on opposition goal-line.
 * (BREADTH/2, LENGTH/2) represents rightmost point on opposition goal-line.
 * 
 * See figure provided with specs if not clear
 */
public class Position {
	public static final int LENGTH = 100;
	public static final int BREADTH = 60;
	public static final int HALF_LENGTH = LENGTH/2;
	public static final int HALF_BREADTH = BREADTH/2;
	
	public int x, y;
	
	/**
	 * 
	 * @param _x: for instance variable x
	 * @param _y: for instance variable y
	 * 
	 * ensure the values provided are in valid range.
	 * if less than the minimum possible value, assign the minimum possible value to the instance variable.
	 * if more than the maximum possible value, assign the maximum possible value to the instance variable.
	 * See tests for input-output mappings if you don't understand the description.
	 */
	public Position(int _x, int _y) {
		if(_x < -HALF_BREADTH)
			this.x = -HALF_BREADTH;
		else if(_x > HALF_BREADTH)
			this.x = HALF_BREADTH;
		else
			this.x = _x;
		
		if(_y < -HALF_LENGTH)
			this.y = -HALF_LENGTH;
		else if(_y > HALF_LENGTH)
			this.y = HALF_LENGTH;
		else
			this.y = _y;
		
	}
	
	/**
	 * 
	 * @return distance of the current position from the goalie
	 * who's assumed to be at (0, -HALF_LENGTH)
	 */
	public double distanceFromHomeGoalie() {
		return Math.sqrt((0 - x) * (0 - x) + (-HALF_LENGTH - y) * (-HALF_LENGTH - y));
	}
	
	/**
	 * 
	 * @return
	 * -1 if on the left wing
	 * 1 if on the right wing
	 * 0 in all other cases.
	 * 
	 * see specs for definition of left, middle and right wings
	 */
	public int getWing() {
		int wingDistance = BREADTH / 3;
		
		if(x >= -HALF_BREADTH && x < -HALF_BREADTH + wingDistance)
			return -1;
		else if(x > HALF_BREADTH - wingDistance && x <= HALF_BREADTH)
			return 1;
		else
			return 0;
	}
	
	/**
	 * 
	 * @param other
	 * @return 
	 * 1 if calling object further from home goalie than parameter object
	 * -1 if calling object closer to home goalie than parameter object
	 * 0 in all other cases
	 */
	public int compareTo(Position other) {	
		if(this.distanceFromHomeGoalie() < other.distanceFromHomeGoalie())
			return -1;
		else if(this.distanceFromHomeGoalie() > other.distanceFromHomeGoalie())
			return 1;
		else
			return 0;
	}
	
	//DO NOT MODIFY
	public String toString() {
		return x+","+y;
	}
	
	//YOU ARE FREE TO ADD MORE PRIVATE, OR PUBLIC, METHODS	
}
