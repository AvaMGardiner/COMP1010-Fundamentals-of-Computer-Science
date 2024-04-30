package passingAnalytics.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import passingAnalytics.toBeSubmitted.*;
import passingAnalytics.others.*;

@SuppressWarnings("unused")
public class PassStatsTest{
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();
	
	PassStats stats1, stats2, stats3;

	@BeforeEach
	public void setUp() throws Exception {
		currentMethodName = null;
		stats1 = new PassStats("in1.csv");
		stats2 = new PassStats("in2.csv");
		stats3 = new PassStats("in3.csv");
	}

	@Test @Graded(description="PassStats:countSuccessfulPasses()", marks=5)
	public void testCountSuccessfulPasses() {
		assertEquals(408, stats1.countSuccessfulPasses());
		assertEquals(398, stats2.countSuccessfulPasses());
		assertEquals(402, stats3.countSuccessfulPasses());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:countPassesInSegment(int)", marks=5)
	public void testCountPassesInSegment() {
		assertEquals(143, stats1.countPassesInSegment(0));
		assertEquals(175, stats1.countPassesInSegment(1));
		assertEquals(56, stats1.countPassesInSegment(2));
		assertEquals(61, stats1.countPassesInSegment(3));
		assertEquals(180, stats2.countPassesInSegment(0));
		assertEquals(180, stats2.countPassesInSegment(1));
		assertEquals(55, stats2.countPassesInSegment(2));
		assertEquals(52, stats2.countPassesInSegment(3));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:countSuccessfulForwardPasses()", marks=5)
	public void testCountSuccessfulForwardPasses() {
		assertEquals(216, stats1.countSuccessfulForwardPasses());
		assertEquals(203, stats2.countSuccessfulForwardPasses());
		assertEquals(200, stats3.countSuccessfulForwardPasses());
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();		
	}

	@Test @Graded(description="PassStats:countSuccessfulSwitches()", marks=5)
	public void testCountSuccessfulSwitches() {
		assertEquals(86, stats1.countSuccessfulSwitches());
		assertEquals(74, stats2.countSuccessfulSwitches());
		assertEquals(79, stats3.countSuccessfulSwitches());
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();		
	}

	@Test @Graded(description="PassStats:countSuccessfulLongBalls()", marks=5)
	public void testCountSuccessfulLongBalls() {
		assertEquals(55, stats1.countSuccessfulLongBalls());
		assertEquals(50, stats2.countSuccessfulLongBalls());
		assertEquals(60, stats3.countSuccessfulLongBalls());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:countSuccessfulPassesInSegment(int)", marks=5)
	public void testCountSuccessfulPassesInSegment() {
		assertEquals(133, stats1.countSuccessfulPassesInSegment(0));
		assertEquals(162, stats1.countSuccessfulPassesInSegment(1));
		assertEquals(53, stats1.countSuccessfulPassesInSegment(2));
		assertEquals(60, stats1.countSuccessfulPassesInSegment(3));
		assertEquals(160, stats2.countSuccessfulPassesInSegment(0));
		assertEquals(150, stats2.countSuccessfulPassesInSegment(1));
		assertEquals(44, stats2.countSuccessfulPassesInSegment(2));
		assertEquals(44, stats2.countSuccessfulPassesInSegment(3));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:successfulPassPercentage()", marks=5)
	public void testSuccessfulPassPercentage() {
		assertEquals(93.7931, stats1.successfulPassPercentage(), 0.01);
		assertEquals(85.2248, stats2.successfulPassPercentage(), 0.01);
		assertEquals(83.4024, stats3.successfulPassPercentage(), 0.01);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:successfulPassPercentageInSegment(int)", marks=5)
	public void testSuccessfulPassPercentageInSegment() {
		assertEquals(88.8888, stats2.successfulPassPercentageInSegment(0), 0.01);
		assertEquals(83.3333, stats2.successfulPassPercentageInSegment(1), 0.01);
		assertEquals(80, stats2.successfulPassPercentageInSegment(2), 0.01);
		assertEquals(84.6153, stats2.successfulPassPercentageInSegment(3), 0.01);
		assertEquals(86.5168, stats3.successfulPassPercentageInSegment(0), 0.01);
		assertEquals(85.2631, stats3.successfulPassPercentageInSegment(1), 0.01);
		assertEquals(71.6666, stats3.successfulPassPercentageInSegment(2), 0.01);
		assertEquals(79.6296, stats3.successfulPassPercentageInSegment(3), 0.01);

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:successfulPassCountInSegments()", marks=5)
	public void testSuccessfulPassCountInSegments() {
		assertEquals("[133, 162, 53, 60]", stats1.successfulPassCountInSegments().toString());
		assertEquals("[160, 150, 44, 44]", stats2.successfulPassCountInSegments().toString());
		assertEquals("[154, 162, 43, 43]", stats3.successfulPassCountInSegments().toString());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="PassStats:longestPassIndex()", marks=5)
	public void testLongestPassIndex() {
		assertEquals(244, stats1.longestPassIndex());
		assertEquals(105, stats2.longestPassIndex());
		assertEquals(407, stats3.longestPassIndex());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Graded(description="PassStats:longestSuccessfulForwardPassSequence()", marks=10)
	public void testLongestSuccessfulForwardPassSequence() {
		ArrayList<Pass> forwardPassSequence = new ArrayList<Pass>();
		forwardPassSequence = stats1.longestSuccessfulForwardPassSequence();
		
		int passData[][] = new int[][] 
		{
			{-18, -35, -27, -20},
			{-6, 21, -20, 38},
			{-21, -22, 29, 37},
			{3, -43, -18, 44},
			{10, -13, 19, -7},
			{-27, 16, -9, 49},
			{-6, -45, -1, 12}
		}; 
		
		assertEquals(passData.length, forwardPassSequence.size());
		
		for (int index = 0; index < forwardPassSequence.size(); index++){
			assertEquals(passData[index][0], forwardPassSequence.get(index).from.x);
			assertEquals(passData[index][1], forwardPassSequence.get(index).from.y);
			assertEquals(passData[index][2], forwardPassSequence.get(index).to.x);
			assertEquals(passData[index][3], forwardPassSequence.get(index).to.y);
		}
		
		
		forwardPassSequence = stats2.longestSuccessfulForwardPassSequence();
		
		passData = new int[][] 
		{
			{-11, 10, 7, 29},
			{-22, -43, 13, -38},
			{10, -3, -24, 26},
			{-1, 17, -11, 32},
			{-20, 12, 5, 45},
			{-13, -12, 20, 25}
		}; 
		
		assertEquals(passData.length, forwardPassSequence.size());
		
		for (int index = 0; index < forwardPassSequence.size(); index++){
			assertEquals(passData[index][0], forwardPassSequence.get(index).from.x);
			assertEquals(passData[index][1], forwardPassSequence.get(index).from.y);
			assertEquals(passData[index][2], forwardPassSequence.get(index).to.x);
			assertEquals(passData[index][3], forwardPassSequence.get(index).to.y);
		}
		
		forwardPassSequence = stats3.longestSuccessfulForwardPassSequence();
		
		passData = new int[][] 
		{
			{-24, -25, 17, -9},
			{3, -18, 18, 14},
			{-19, 20, -15, 43},
			{2, -37, 11, 13},
			{-2, -6, -14, 18}
		};

		assertEquals(passData.length, forwardPassSequence.size());
		
		for (int index = 0; index < forwardPassSequence.size(); index++){
			assertEquals(passData[index][0], forwardPassSequence.get(index).from.x);
			assertEquals(passData[index][1], forwardPassSequence.get(index).from.y);
			assertEquals(passData[index][2], forwardPassSequence.get(index).to.x);
			assertEquals(passData[index][3], forwardPassSequence.get(index).to.y);
		}
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Graded(description="PassStats:longestSuccessfulForwardPassSequences()", marks=10)
	public void testLongestSuccessfulForwardPassSequences() {
		ArrayList<ArrayList<Pass>> forwardPassSequence = new ArrayList<ArrayList<Pass>>();
		
		forwardPassSequence = stats1.longestSuccessfulForwardPassSequences();
		
		int passData[][] = new int[][] 
		{
			{-18, -35, -27, -20},
			{-6, 21, -20, 38},
			{-21, -22, 29, 37},
			{3, -43, -18, 44},
			{10, -13, 19, -7},
			{-27, 16, -9, 49},
			{-6, -45, -1, 12},
			
			{-20, 5,-6, 22},
			{-18, 0, 21, 45},
			{-13, -24, 24, 6},
			{-29, -32, -7, 46},
			{-28, -46, 12, 36},
			{-14, -22, 2, 45},
			{27, -36, 21, 34},
			
			{13, 18, -10, 23},
			{13, 4, 11, 22},
			{-29, 19, 16, 35},
			{-19, 28, 2, 34},
			{-23, -28, 28, 46},
			{26, -18, 24, 34},
			{12, -21, 0, 6}
		}; 
		
		assertEquals(3, forwardPassSequence.size());
		assertEquals(7, forwardPassSequence.get(0).size());
		assertEquals(7, forwardPassSequence.get(1).size());
		assertEquals(7, forwardPassSequence.get(2).size());
		
		int row = 0;
		for (int listIndex = 0; listIndex < forwardPassSequence.size(); listIndex++)
		{
			ArrayList<Pass> passList = forwardPassSequence.get(listIndex);
			
			for (int passIndex = 0; passIndex < forwardPassSequence.get(listIndex).size(); passIndex++) 
			{
				assertEquals(passData[row][0], passList.get(passIndex).from.x);
				assertEquals(passData[row][1], passList.get(passIndex).from.y);
				assertEquals(passData[row][2], passList.get(passIndex).to.x);
				assertEquals(passData[row][3], passList.get(passIndex).to.y);
				
				row++;
			}
		}
		
		//////////////////
		
		forwardPassSequence = stats2.longestSuccessfulForwardPassSequences();
		passData = new int[][] 
		{
			{-11, 10, 7, 29},
			{-22, -43, 13, -38},
			{10, -3, -24, 26},
			{-1, 17, -11, 32},
			{-20, 12, 5, 45},
			{-13, -12, 20, 25},

			{11, -2, 7, -1},
			{28, 40, -10, 42},
			{1, -8, 27, 4},
			{13, -36, 12, 10},
			{0, -15, -18, 5},
			{0, -24, 28, 44}
		}; 
		
		assertEquals(2, forwardPassSequence.size());
		assertEquals(6, forwardPassSequence.get(0).size());
		assertEquals(6, forwardPassSequence.get(1).size());
		
		row = 0;
		for (int listIndex = 0; listIndex < forwardPassSequence.size(); listIndex++)
		{
			ArrayList<Pass> passList = forwardPassSequence.get(listIndex);
			
			for (int passIndex = 0; passIndex < forwardPassSequence.get(listIndex).size(); passIndex++) 
			{
				assertEquals(passData[row][0], passList.get(passIndex).from.x);
				assertEquals(passData[row][1], passList.get(passIndex).from.y);
				assertEquals(passData[row][2], passList.get(passIndex).to.x);
				assertEquals(passData[row][3], passList.get(passIndex).to.y);
				
				row++;
			}
		}
		
		//////////////////
		
		forwardPassSequence = stats3.longestSuccessfulForwardPassSequences();
		
		passData = new int[][] 
		{
			{-24, -25, 17, -9},
			{3, -18, 18, 14},
			{-19, 20, -15, 43},
			{2, -37, 11, 13},
			{-2, -6, -14, 18},
			
			{27, -14, 18, 4},
			{-13, 10, -4, 49},
			{-23, -22, 8, 49},
			{2, -47, 8, -41},
			{2, -24, -5, 22},
			
			{-23, -34, 13, 4},
			{-16, -35, 12, -4},
			{-3, -40, -17, -18},
			{-8, -46, -2, 15},
			{16, -1, -8, 16}
		};
				
		assertEquals(3, forwardPassSequence.size());
		assertEquals(5, forwardPassSequence.get(0).size());
		assertEquals(5, forwardPassSequence.get(1).size());
		assertEquals(5, forwardPassSequence.get(2).size());
		
		row = 0;
		for (int listIndex = 0; listIndex < forwardPassSequence.size(); listIndex++)
		{
			ArrayList<Pass> passList = forwardPassSequence.get(listIndex);
			
			for (int passIndex = 0; passIndex < forwardPassSequence.get(listIndex).size(); passIndex++) 
			{
				assertEquals(passData[row][0], passList.get(passIndex).from.x);
				assertEquals(passData[row][1], passList.get(passIndex).from.y);
				assertEquals(passData[row][2], passList.get(passIndex).to.x);
				assertEquals(passData[row][3], passList.get(passIndex).to.y);
				
				row++;
			}
		}
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if(currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score+=graded.marks();
			result+=graded.description()+" passed. Marks awarded: "+graded.marks()+"\n";
		}
	}
	
	@AfterAll
	public static void wrapUp() throws IOException {
		if(result.length() != 0) {
			result = result.substring(0, result.length()-1); //remove the last "\n"
		}
		System.out.println(result);
		System.out.println("Indicative mark for PassStats.java: "+score);
		System.out.println();
	}
}