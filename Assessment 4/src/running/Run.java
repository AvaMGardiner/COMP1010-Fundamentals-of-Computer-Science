package running;

public class Run {
	public double distance; //in kms
	public int time; //in seconds

	public Run prev;
	public Run next;

	//DO NOT MODIFY - Parameterized constructor
	public Run(double d, int t) {
		distance = Math.max(0, d);
		time = Math.max(1, t);
	}
	
	//DO NOT MODIFY - Copy Constructor to create an instance copy
	//NOTE: Only the data section should be copied over, not the links
	public Run(Run source) {
		this(source.distance, source.time);
	}

	//DO NOT MODIFY (return speed in kmph)
	public double speed() {
		return distance*3600/time;
	}

	/**
	 * add an INSTANCE COPY of the passed object (using the copy constructor)
	 * at the end of the list in which the calling object exists. 
	 * @param run
	 */
	public void addToEnd(Run run) {
		if(this.next != null)
			this.next.addToEnd(run);
		else
		{
			this.next = new Run(run);
			this.next.prev = this;
		}
	}

	/**
	 * add an INSTANCE COPY of the passed object (using the copy constructor)
	 * at the front of the list in which the calling object exists
	 * @param run
	 */
	public void addToFront(Run run) {
		if(this.prev != null)
			this.prev.addToFront(run);
		else
		{
			this.prev = new Run(run);
			this.prev.next = this;
		}
	}

	/**
	 * 
	 * @return number of objects in the list in which the calling object exists
	 */
	public int size() {
		Run temp = this;
		int size = 0;
		
		if(temp.next != null) {
			size = temp.next.size();
		}
		else{
			size = temp.getIndex() + 1;
		}
		
		return size;
	}

	/**
	 * 
	 * @return the index of the calling object in the list.
	 * the index of the first object in the list is 0.
	 */
	public int getIndex() {
		int index = 1;
		Run temp = this;
		
		if(temp.prev == null)
			return 0;
		
		if(temp.prev != null) {
			index = index + temp.prev.getIndex();
		}
		
		return index;
	}

	/**
	 * 
	 * @param idx
	 * @return the object that exists in the list at the passed index.
	 * return null if there is no object at that index
	 */
	public Run get(int idx) {
		Run temp = this;
		int currIndex = temp.getIndex();
		
		if(idx < 0 || idx >= temp.size())
			return null;
		
		if(currIndex == idx)
			return temp;
		else
		{
			if(currIndex < idx)
				temp = this.next.get(idx);
			else
				temp = this.prev.get(idx);
		}
		
		return temp;
	}
	
	/**
	 * return a text version of the list in which the calling object exists.
	 * use "->" as the separator.
	 */

	public String toString() {
                      Run temp = this;
                      String msg = temp.toStringIndividual();
                      if(temp.next != null)
                      {
                                    msg = msg + "->" + temp.next.toString();
                      }
                      return msg;
         }

	
	//DO NOT MODIFY
	public String toStringIndividual() {
		return distance+" in "+time;
	}
	
	/**
	 * insert an INSTANCE COPY of the second parameter (using the copy constructor)
	 * at index idx, thereby pushing all subsequent items one place higher 
	 * (in terms of index).
	 * @param idx
	 * @param run
	 * @return true if an INSTANCE COPY was successfully added at 
	 * the given index in the list, false otherwise.
	 */
	public boolean add(int idx, Run run) {
		Run temp = this;
		boolean isSuccess = true;
		int currIndex = temp.getIndex();
		
		if(idx < 0 || idx >= temp.size())
		{
			isSuccess = false;
			return isSuccess;
		}
		
		if(currIndex == idx)
		{
			this.next.prev = new Run(run);
			this.next.prev.next = this.next;
					
			this.next = this.next.prev;
			this.next.prev = this;
			
			isSuccess = true;
		}
		else
		{
			if(currIndex < idx)
				isSuccess = this.next.add(idx, run);
			else
				isSuccess = this.prev.add(idx, run);
		}
		
		return isSuccess;
	}

	/**
	 * 
	 * @param thresholdSpeed
	 * @return the highest number of consecutive items in the list
	 * (to which the calling object belongs) that have a speed more than
	 * the thresholdSpeed.
	 */
	public int longestSequenceOver(double thresholdSpeed) {
		Run temp = this;

		int sequence = 0;
		double s = temp.speed();
		if(s>=thresholdSpeed)
		{
			if(temp.next != null)
			{
				sequence = temp.size()+temp.next.longestSequenceOver(s);
			}
		}
		return sequence;
	}

	/**
	 * 
	 * @param thresholdSpeed
	 * @return an array containing representations of the runs (in order of sequence)
	 * in the list to which the calling object belongs, that have a speed more than
	 * the thresholdSpeed. return null if no such item exists in the list.
	 */
	public String getRunsOver(double thresholdSpeed) {
		Run temp = this;
		Run temp2 =temp;
		int sequence = temp.longestSequenceOver(thresholdSpeed);
		if(sequence>0)
		{

			return temp2.toString();
		}
		else
		{
			return null;
		}
	}
}
