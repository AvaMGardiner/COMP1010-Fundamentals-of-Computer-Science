//DO NOT MODIFY THIS CLASS

package passingAnalytics.others;

import java.text.DecimalFormat;

public class Time {
	public int segment; 
	//0 - first half, 
	//1 - second half, 
	//2 - first half of extra time, 
	//3 - second half of extra time
	
	public int hour, minute, second;
	
	public Time (int seg, int h, int m, int s) {
		segment = Math.max(0,  Math.min(3,  seg));
		int seconds = Math.max(0, Math.min(3600, h*3600 + m*60 + s));
		//System.out.println(seconds);
		if(segment < 2) {
			hour = seconds/3600;
			seconds = seconds%3600;
			minute = seconds/60;
			second = seconds%60;
		}
		else {
			seconds = Math.min(1200,  seconds);
			hour = 0;
			minute = seconds/60;
			second = seconds%60;
		}
	}
	
	public String toString() {
		DecimalFormat dfHourMinute = new DecimalFormat("##");
		DecimalFormat dfSec = new DecimalFormat("00");
		String result;
		result = dfHourMinute.format(hour)+":"+dfHourMinute.format(minute)+":"+dfSec.format(second);
		if(segment == 0) {
			return result + ",first half";
		}
		if(segment == 1) {
			return result + ",second half";
		}
		if(segment == 2) {
			return result + ",first half of extra time";
		}
		return result + ",second half of extra time";
	}
}
