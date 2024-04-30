package passingAnalytics.others;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import passingAnalytics.toBeSubmitted.Pass;
import passingAnalytics.toBeSubmitted.PassStats;
import passingAnalytics.toBeSubmitted.Position;

@SuppressWarnings("unused")
public class Reader {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Pass> data = readFrom("in1.csv");
		data.stream().forEach(p -> System.out.println(p));
	}

	public static ArrayList<Pass> readFrom(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(filename));
		String firstLine = scanner.nextLine();
		int n = Integer.parseInt(firstLine.split(",")[1]);
		for(int i=2; i < 10; i++) {
			scanner.nextLine();
		}
		ArrayList<Pass> data = new ArrayList<Pass>();
		for(int i=0; i < n; i++) {
			String record = scanner.nextLine();
			String[] tokens = record.split(",");
			boolean completed = tokens[0].equals("Successful");
			int x1  = Integer.parseInt(tokens[2]);
			int y1  = Integer.parseInt(tokens[3]);
			int x2  = Integer.parseInt(tokens[4]);
			int y2  = Integer.parseInt(tokens[5]);
			String[] timeTokens = tokens[6].split(":");
			int h = Integer.parseInt(timeTokens[0]);
			int m = Integer.parseInt(timeTokens[1]);
			int s = Integer.parseInt(timeTokens[2]);
			String segmentDescript = tokens[7];
			int segment = 0;
			if(segmentDescript.equals("second half"))
				segment = 1;
			else if(segmentDescript.equals("first half of extra time"))
				segment = 2;
			else if(segmentDescript.equals("second half of extra time"))
				segment = 3;
			Position from = new Position(x1, y1);
			Position to = new Position(x2, y2);
			Time t = new Time(segment, h, m, s);
			Pass pass = new Pass(from, to, t, completed);
			data.add(pass);
		}
		return data;
	}

}
