package passingAnalytics.toBeSubmitted;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import passingAnalytics.others.Reader;

public class PassStats {
	public ArrayList<Pass> data; //this is the all-important collection on which all your methods will operate

	//DO NOT MODIFY
	public PassStats() {
		data = new ArrayList<Pass>();
	}
	
	//DO NOT MODIFY
	public PassStats(ArrayList<Pass> passes) {
		data = passes;
	}

	/**
	 * DO NOT MODIFY
	 * 
	 * This constructor calls Reader.readFrom(String) that in turn 
	 * reads the list of passes from the csv file and returns the
	 * ArrayList of Pass objects.
	 * 
	 * The returned list is copied in the instance variable "data"
	 * by the constructor
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public PassStats(String filename) throws FileNotFoundException {
		data = Reader.readFrom(filename);
		//details of all the passes is already in data
		
		//data.get(0) gives the details of the first pass
		//data.get(data.size()-1) gives the details of the last pass
		
		//data.get(0).completed tells us if the first pass was successful
		
		//data.get(0).from.y gives the y coordinate of the origin of the first pass
		//data.get(0).to.y gives the y coordinate of the intended destination of the first pass
		
		//using data.get(0).from.y, data.get(0).to.y; you can determine 
		//if the first pass was made forward, back or sideways
	}

	//DO NOT MODIFY
	public int countPasses() {
		return data.size();
	}

	/**
	 * 
	 * @return number of successful (completed) passes
	 */
	public int countSuccessfulPasses() {
		int successfulPasses = 0;
		
		for (Pass pass : data) {
			if(pass.completed)
				successfulPasses++;
		}
		
		return successfulPasses;
	}

	/**
	 * 
	 * @param seg
	 * @return number of passes in the passed segment
	 */
	public int countPassesInSegment(int seg) {
		int passesInSegment = 0;
		
		for (Pass pass : data) {
			if(pass.timestamp.segment == seg)
				passesInSegment++;
		}
		
		return passesInSegment;
	}

	/**
	 * 
	 * @return number of successful "forward" passes (up the field).
	 * see the specs for definition of a forward pass.
	 */
	public int countSuccessfulForwardPasses() {
		int successfulForwardPass = 0;
		
		for (Pass pass : data) {
			if(pass.isSuccessfulForwardPass())
				successfulForwardPass++;
		}
		
		return successfulForwardPass;
	}

	/**
	 * 
	 * @return number of successful "switches".
	 * see the specs for definition of a switch.
	 */
	public int countSuccessfulSwitches() {
		int successfulSwitches = 0;
		
		for (Pass pass : data) {
			if(pass.isSuccessfulSwitch())
				successfulSwitches++;
		}
		
		return successfulSwitches;
	}

	/**
	 * 
	 * @return number of successful "long balls".
	 * see the specs for definition of a long ball.
	 */
	public int countSuccessfulLongBalls() {
		int successfulLongBall = 0;
		
		for (Pass pass : data) {
			if(pass.completed && pass.isLongBall())
				successfulLongBall++;
		}
		
		return successfulLongBall;
	}

	/**
	 *
	 * @param seg
	 * @return number of successful passes in passed segment.
	 */
	public int countSuccessfulPassesInSegment(int seg) {
		int successfulPassesInSegment = 0;
		
		for (Pass pass : data) {
			if(pass.timestamp.segment == seg && pass.completed)
				successfulPassesInSegment++;
		}
		
		return successfulPassesInSegment;
	}

	/**
	 * 
	 * @return percentage of passes made that were successful (completed).
	 * return 0 if no passes were made.
	 */
	public double successfulPassPercentage() {
		if(countPasses() == 0)
			return 0;
		else
			return ((double)countSuccessfulPasses() / (double)countPasses()) * 100.0;
	}

	/**
	 * 
	 * @param seg
	 * @return percentage of passes made that were successful (completed) in passed segment.
	 * return 0 if no passes were made in the given segment.
	 */
	public double successfulPassPercentageInSegment(int seg) {
		if(countPassesInSegment(seg) == 0)
			return 0;
		else
			return ((double)countSuccessfulPassesInSegment(seg) / (double)countPassesInSegment(seg)) * 100.0;
	}

	/**
	 * 
	 * @return a list containing number of successful passes in the 4 segments 
	 * (in chronological order).
	 */
	public ArrayList<Integer> successfulPassCountInSegments() {
		ArrayList<Integer> passCountInSegment = new ArrayList<Integer>();
		
		for(int seg = 0; seg < 4; seg++)
			passCountInSegment.add(countSuccessfulPassesInSegment(seg));
		
		return passCountInSegment;
	}

	/**
	 * 
	 * @return index of the longest pass (assume at least one pass has been made)
	 * return the first of the passes in case of a tie
	 */
	public int longestPassIndex() {
		int longestPassIndex = 0;
		double longestPassDistance = 0.0;
		
		for (int index = 0; index < countPasses(); index++) {
			Pass objPass = data.get(index);
			
			if(longestPassDistance < objPass.distance())
			{
				longestPassDistance = objPass.distance();
				longestPassIndex = index;
			}
		}
		
		return longestPassIndex;
	}
	
	/**
	 * D
	 * @return a list containing the longest consecutive sequence of successful forward passes.
	 * So, if at most 8 successful forward passes were made in a row, return a list containing
	 * those passes (in order of execution).
	 * 
	 * in case of a tie, return the first sequence (in order of execution).
	 */
	public ArrayList<Pass> longestSuccessfulForwardPassSequence() {
		ArrayList<Pass> tempForwardPassSequence = new ArrayList<Pass>();
		ArrayList<Pass> successfulForwardPassSequence = new ArrayList<Pass>();
		
		for (int index = 0; index < countPasses(); index++) {
			Pass objPass = data.get(index);
			
			if(objPass.isSuccessfulForwardPass())
			{
				tempForwardPassSequence.add(objPass);
			}
			else
			{
				if(tempForwardPassSequence.size() > successfulForwardPassSequence.size())
					successfulForwardPassSequence = new ArrayList<Pass>(tempForwardPassSequence);
				
				tempForwardPassSequence.clear();
			}
		}
		
		return successfulForwardPassSequence;
	}
	
	/**
	 * D/HD
	 * @param n
	 * @return the maximum ground gained (defined as the increase in y position)
	 * over a MAXIMUM of n consecutive passes. during the course of the n passes, if any 
	 * pass is unsuccessful, the ground gained is reset to 0. you should return the
	 * highest of the sub-gains in such a situation.
	 * 
	 * For example, say the following list represents the ground gained in each pass,
	 * a cap (^) representing an unsuccessful pass:
	 * 
	 * [40, -20, 90, ^60, 30, 40, 30, 20, -10, 50, 30]
	 * 
	 * if n = 4, return 120 (30+40+30+20)
	 * if n = 2, return 90 (since on it's own, the third pass gained 90 yards)
	 * 
	 * See input-output mappings in tests if you don't understand the description
	 */
	public int maxGroundGained(int n) {
		ArrayList<Integer> groundGained = new ArrayList<Integer>();
		
		for (Pass pass : data) {
			if(pass.isSuccessfulForwardPass())
				groundGained.add(pass.to.y - pass.from.y);
			else
				groundGained.add(0);
		}
		
		int maxGround = -1;
		int tempMaxGround = 0;
		
		for (int i = 0; i <= groundGained.size() - n; i++) {
			for (int j = 0; j < n; j++) {
				tempMaxGround += groundGained.get(i + j);
			}
			
			if(tempMaxGround > maxGround)
				maxGround = tempMaxGround;
			
			tempMaxGround = 0;
		}
		
		return maxGround;
	}

	/**
	 * HD
	 * @return a list of list of passes such that each list contains 
	 * the longest consecutive sequence of successful forward passes.
	 * So, if at most 5 successful forward passes were made in a row on three separate
	 * and non-overlapping occasions, return a list containing three lists,
	 * each containing the 5 passes (in order of execution).
	 * 
	 * As an example, let 1 represent a successful forward pass, and 0 anything else.
	 * Let the pass sequence be [0,0,1,1,0,0,1,1,0,0,1,0,1,1]
	 * 
	 * You should return an arraylist containing three arraylists of Pass object.
	 * First sublist contains passes at indices 2 and 3
	 * Second sublist contains passes at indices 6 and 7
	 * Third sublist contains passes at indices 12 and 13
	 */
	public ArrayList<ArrayList<Pass>> longestSuccessfulForwardPassSequences() {
		ArrayList<ArrayList<Pass>> tempForwardPassSequences = new ArrayList<ArrayList<Pass>>();
		ArrayList<Pass> tempForwardPassSequence = new ArrayList<Pass>();
		
		int maxSize = 2;
		
		for (int index = 0; index < countPasses(); index++) {
			Pass objPass = data.get(index);
			
			if(objPass.isSuccessfulForwardPass())
			{
				tempForwardPassSequence.add(objPass);
			}
			else
			{
				if(tempForwardPassSequence.size() >= maxSize)
				{
					maxSize = tempForwardPassSequence.size();
					tempForwardPassSequences.add(new ArrayList<Pass>(tempForwardPassSequence));
				}
				
				tempForwardPassSequence.clear();
			}
		}
		
		ArrayList<ArrayList<Pass>> finalForwardPassSequences = new ArrayList<ArrayList<Pass>>();
		for (ArrayList<Pass> tempList : tempForwardPassSequences) {
			if(tempList.size() == maxSize)
				finalForwardPassSequences.add(new ArrayList<Pass>(tempList));
		}
		
		return finalForwardPassSequences;
	}
	
	//YOU ARE FREE TO ADD MORE PRIVATE, OR PUBLIC, METHODS
}
