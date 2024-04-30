package passingAnalytics.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

import passingAnalytics.toBeSubmitted.Position;

public class PositionTest {
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();
	
	Position p, q, r;
	
	@BeforeEach
	public void setUp() throws Exception {
		currentMethodName = null;
		p = new Position(0, -Position.HALF_LENGTH);
		q = new Position(-Position.HALF_BREADTH, Position.HALF_LENGTH/2);
		r = new Position(Position.HALF_BREADTH/3, Position.HALF_LENGTH/3);
	}

	@Test @Graded(description="Position(int,int)", marks=4)
	public void testPosition() {
		assertEquals(0, p.x);
        assertEquals(-Position.HALF_LENGTH, p.y);

        assertEquals(-Position.HALF_BREADTH, q.x);
        assertEquals(Position.HALF_LENGTH/2, q.y);

        assertEquals(Position.HALF_BREADTH/3, r.x);
        assertEquals(Position.HALF_LENGTH/3, r.y);

        Position invalid = new Position(-Position.HALF_BREADTH-1, 0);
        assertEquals(-Position.HALF_BREADTH, invalid.x);
        assertEquals(0, invalid.y);

        invalid = new Position(Position.HALF_BREADTH+1, 0);
        assertEquals(Position.HALF_BREADTH, invalid.x);
        assertEquals(0, invalid.y);

        invalid = new Position(0, -Position.HALF_LENGTH-1);
        assertEquals(0, invalid.x);
        assertEquals(-Position.HALF_LENGTH, invalid.y);

        invalid = new Position(0, Position.HALF_LENGTH+1);
        assertEquals(0, invalid.x);
        assertEquals(Position.HALF_LENGTH, invalid.y);

        invalid = new Position(-Position.HALF_BREADTH-1, -Position.HALF_LENGTH-1);
        assertEquals(-Position.HALF_BREADTH, invalid.x);
        assertEquals(-Position.HALF_LENGTH, invalid.y);

        invalid = new Position(Position.HALF_BREADTH+1, Position.HALF_LENGTH+1);
        assertEquals(Position.HALF_BREADTH, invalid.x);
        assertEquals(Position.HALF_LENGTH, invalid.y);

        //incorrect order (assuming LENGTH > BREADTH)
        p = new Position(Position.HALF_LENGTH, Position.HALF_BREADTH);
        assertEquals(Position.HALF_BREADTH, p.x);
        assertEquals(Position.HALF_BREADTH, p.y);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="Position:distanceFromHomeGoalie()", marks=2)
	public void testDistanceFromHomeGoalie() {
		assertEquals(0, p.distanceFromHomeGoalie(), 0.01);
		assertEquals(80.777, q.distanceFromHomeGoalie(), 0.01);
		assertEquals(66.753, r.distanceFromHomeGoalie(), 0.01);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="Position:getWing()", marks=2)
	public void testGetWing() {
		assertEquals(0, p.getWing());
		assertEquals(-1, q.getWing());
		assertEquals(0, r.getWing());
		
		Position s = new Position(-11, 0);
		assertEquals(-1, s.getWing());
		
		s = new Position(-10, 0);
		assertEquals(0, s.getWing());
		
		s = new Position(11, 0);
		assertEquals(1, s.getWing());
		
		s = new Position(10, 0);
		assertEquals(0, s.getWing());
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="Position:compareTo(Position)", marks=2)
	public void testCompareTo() {
		assertEquals(-1, p.compareTo(q));
		assertEquals(1, q.compareTo(r));
		Position s1 = new Position(1, -Position.HALF_LENGTH + 7);
		Position s2 = new Position(5, -Position.HALF_LENGTH + 5);
		assertEquals(0, s1.compareTo(s2));
		
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
		System.out.println("Indicative mark for Position.java: "+score);
		System.out.println();
	}

}
