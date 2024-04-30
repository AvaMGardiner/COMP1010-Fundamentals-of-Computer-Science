package passingAnalytics.toBeSubmitted;

import passingAnalytics.others.Time;

public class Pass {
	public Position from, to; //the pass is made from "from" Position, to "to" Position
	public Time timestamp; //time at which the pass is made
	public boolean completed; //true indicates pass successful, false indicates great shame

	/**
	 * 
	 * @param loc1: from
	 * @param loc2: to
	 * @param t: timestamp
	 * @param outcome: completed
	 */
	public Pass(Position loc1, Position loc2, Time t, boolean outcome) {
		from = loc1;
		to = loc2;
		timestamp = t;
		completed = outcome;
	}

	/**
	 * 
	 * @return the distance of the pass
	 */
	public double distance() {
		return Math.sqrt((to.x - from.x) * (to.x - from.x) + (to.y - from.y) * (to.y - from.y));
	}

	/**
	 * 
	 * @return true if its a successful forward pass, false otherwise
	 */
	public boolean isSuccessfulForwardPass() {
		if(this.completed && from.y < to.y)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @return true if its a successful switch, false otherwise
	 */
	public boolean isSuccessfulSwitch() {
		if(this.completed)
		{
			if((from.getWing() == 1 && to.getWing() == -1) || (from.getWing() == -1 && to.getWing() == 1))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @return true if it's an attempted long ball (forward pass at least 
	 * with y difference half the field length or more), false otherwise
	 */
	public boolean isLongBall() {
		if(from.y < to.y)
		{
			if(to.y - from.y >= Position.HALF_LENGTH)
				return true;
			else
				return false;
		}
		else
			return false;
		
	}

	//DO NOT MODIFY
	public String toString() {
		if(completed) {
			if(from.y < to.y) {
				return "Successful,Forward,"+from+","+to+","+timestamp;
			}
			else {
				if(from.y > to.y) {
					return "Successful,Backward,"+from+","+to+","+timestamp;
				}
				else {
					return "Successful,Sideways,"+from+","+to+","+timestamp;
				}
			}
		}
		else { 
			if(from.y < to.y) {
				return "Unsuccessful,Forward,"+from+","+to+","+timestamp;
			}
			else {
				if(from.y > to.y) {
					return "Unsuccessful,Backward,"+from+","+to+","+timestamp;
				}
				else {
					return "Unsuccessful,Sideways,"+from+","+to+","+timestamp;
				}
			}
		}
	}

	
	//YOU ARE FREE TO ADD MORE PRIVATE, OR PUBLIC, METHODS	
}
