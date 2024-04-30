package passingAnalytics.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import passingAnalytics.others.Time;
import passingAnalytics.toBeSubmitted.Pass;
import passingAnalytics.toBeSubmitted.Position;

public class PassTest {
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();
	
	Pass p12good, p21good, p12bad, p21bad;
	Position pos1, pos2;
	Time t1, t2;
	
	 @BeforeEach
	    public void setUp() throws Exception {
	        currentMethodName = null;
	        pos1 = new Position(10, 20);
	        pos2 = new Position(30, 15);
	        t1 = new Time(2, 0, 15, 1);
	        t2 = new Time(0, 1, 0, 0);
	        p12good = new Pass(pos1, pos2, t1, true);
	        p21good = new Pass(pos2, pos1, t1, true);
	        p12bad = new Pass(pos1, pos2, t2, false);
	        p21bad = new Pass(pos2, pos1, t2, false);
	    }
	 
	@Test @Graded(description="Pass(Position,Position,Time,boolean)", marks=2)
	public void testPass() {
		assertEquals(10, p12good.from.x);
		assertEquals(20, p12good.from.y);
		assertEquals(30, p12good.to.x);
		assertEquals(15, p12good.to.y);
		assertEquals(2, p12good.timestamp.segment);
		assertEquals(0, p12good.timestamp.hour);
		assertEquals(15, p12good.timestamp.minute);
		assertEquals(1, p12good.timestamp.second);
		assertTrue(p12good.completed);
		
		assertEquals(30, p21bad.from.x);
		assertEquals(15, p21bad.from.y);
		assertEquals(10, p21bad.to.x);
		assertEquals(20, p21bad.to.y);
		assertEquals(0, p21bad.timestamp.segment);
		assertEquals(1, p21bad.timestamp.hour);
		assertEquals(0, p21bad.timestamp.minute);
		assertEquals(0, p21bad.timestamp.second);
		assertFalse(p21bad.completed);	

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Graded(description="Pass:distance()", marks=2)
	public void testDistance() {
		assertEquals(20.6155, p12bad.distance(), 0.001);
		assertEquals(20.6155, p12good.distance(), 0.001);
		
		Position from = new Position(0, -Position.HALF_LENGTH);
		Position to = new Position(0, Position.HALF_LENGTH);
		Pass p = new Pass(from, to, t1, true);
		assertEquals(100.0, p.distance(), 0.001);
		
		from = new Position(-Position.HALF_BREADTH, -Position.HALF_LENGTH);
		to = new Position(Position.HALF_BREADTH, Position.HALF_LENGTH);
		p = new Pass(from, to, t1, true);
		assertEquals(116.619, p.distance(), 0.001);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}	
	
	@Test @Graded(description="Pass:isLongBall()", marks=2)
    public void testIsLongBall() {
		assertFalse(p12good.isLongBall());
        
        Position from = new Position(0, -Position.HALF_LENGTH);
        Position to = new Position(0, Position.HALF_LENGTH);
        Pass p = new Pass(from, to, t1, true);
        assertTrue(p.isLongBall());
                  
        p = new Pass(to, from, t1, true);
        assertFalse(p.isLongBall()); //long balls must be forward, not backward
        p = new Pass(from, to, t1, true); //reset
        
        to.y = -1;
        assertFalse(p.isLongBall());
        to.y = 0;
        assertTrue(p.isLongBall());
        
        to.y = -1;
        assertFalse(p.isLongBall());
        to.y = 1;
        assertTrue(p.isLongBall());
        
        from = new Position(-Position.HALF_BREADTH, -Position.HALF_LENGTH);
        to = new Position(Position.HALF_BREADTH, -Position.HALF_LENGTH/2);
        p = new Pass(from, to, t1, true);
        assertFalse(p.isLongBall());
        
        currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
    }

	
	@Test @Graded(description="Pass:isSuccessfulForwardPass()", marks=2)
	public void testIsSuccessfulForwardPass() {
		assertTrue(p21good.isSuccessfulForwardPass());
		assertFalse(p12good.isSuccessfulForwardPass());
		assertFalse(p21bad.isSuccessfulForwardPass());
		assertFalse(p12bad.isSuccessfulForwardPass());
		
		Position from = new Position(0, 10);
		Position to = new Position(0, 10);
		Pass p = new Pass(from, to, t1, true);
		assertFalse(p.isSuccessfulForwardPass());
		
		to.y = 11;
		assertTrue(p.isSuccessfulForwardPass());

		to.y = 9;
		assertFalse(p.isSuccessfulForwardPass());
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Graded(description="Pass:isSuccessfulSwitch()", marks=2)
	public void testIsSuccessfulSwitch() {
		assertFalse(p12good.isSuccessfulSwitch());
		assertFalse(p21good.isSuccessfulSwitch());
		
		Position from = new Position(-Position.BREADTH/6, 10);
		Position to = new Position(Position.BREADTH/6, 10);
		Pass p = new Pass(from, to, t1, true);
		assertFalse(p.isSuccessfulSwitch());
		
		from.x--; //now from is in left wing
		to.x++; //now to is in right wing
		assertTrue(p.isSuccessfulSwitch());
		
		Position temp = from;
		from = to;
		to = temp;
		
		//now from is in right wing and to in left wing
		assertTrue(p.isSuccessfulSwitch());
		
		from.x--; //now from is on the boundary -> middle
		to.x++; //now to is on the boundary -> middle
		assertFalse(p.isSuccessfulSwitch());
		
		from.x++;
		to.x--;
		assertTrue(p.isSuccessfulSwitch());
		
		p.completed = false;
		assertFalse(p.isSuccessfulSwitch());
		
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
		System.out.println("Indicative mark for Pass.java: "+score);
		System.out.println();
	}

}