package critics;

import static org.junit.jupiter.api.Assertions.*;

//import java.io.File;
//import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReviewsTest {
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();
	
	public static Reviews avatar;
	public static Reviews hp;
	
	@BeforeEach
	public void run() throws FileNotFoundException {
		currentMethodName = null;
		avatar = new Reviews("avatar");
		hp = new Reviews("harryPotter");
	}

	@Test @Graded(description="totalRatingsCount", marks=9)
	public void testTotalRatingsCount() {
		assertEquals(40, avatar.totalRatingsCount());
		assertEquals(75, hp.totalRatingsCount());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="averageRating", marks=9)
	public void testAverageRatingInt() {
		assertEquals(-1, avatar.averageRating(-1), 0.01);
		assertEquals(-1, avatar.averageRating(5), 0.01);
		assertEquals(6.12, avatar.averageRating(0), 0.01);
		assertEquals(5.12, avatar.averageRating(1), 0.01);
		assertEquals(7.37, avatar.averageRating(4), 0.01);
		assertEquals(-1, hp.averageRating(-1), 0.01);
		assertEquals(-1, hp.averageRating(15), 0.01);
		assertEquals(8.4, hp.averageRating(0), 0.01);
		assertEquals(6.6, hp.averageRating(13), 0.01);
		assertEquals(6.2, hp.averageRating(14), 0.01);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="getIndex", marks=9)
	public void testGetIndex() {
		assertEquals(0, avatar.getIndex("AANG"));
		assertEquals(4, avatar.getIndex("zUKo"));
		assertEquals(-1, avatar.getIndex("BumI"));
		assertEquals(8, hp.getIndex("LUNA LOVEGOOD"));
		assertEquals(1, hp.getIndex("VOLDERMORT"));
		assertEquals(-1, hp.getIndex("Fred"));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="averageRating", marks=9)
	public void testAverageRatingString() {
		assertEquals(-1, avatar.averageRating(-1), 0.01);
		assertEquals(-1, avatar.averageRating(5), 0.01);
		assertEquals(6.12, avatar.averageRating("AANG"), 0.01);
		assertEquals(5.12, avatar.averageRating("katara"), 0.01);
		assertEquals(7.37, avatar.averageRating("Zuko"), 0.01);
		assertEquals(-1, hp.averageRating(-1), 0.01);
		assertEquals(-1, hp.averageRating(15), 0.01);
		assertEquals(8.4, hp.averageRating("hARRY pOTTER"), 0.01);
		assertEquals(6.2, hp.averageRating("bARTY CROUCH JR."), 0.01);

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="averageRatingBy", marks=9)
	public void testAverageRatingBy() {
		assertEquals(-1, avatar.averageRatingBy(-1), 0.01);
		assertEquals(-1, avatar.averageRatingBy(8), 0.01);
		assertEquals(5.8, avatar.averageRatingBy(0), 0.01);
		assertEquals(7.0, avatar.averageRatingBy(1), 0.01);
		assertEquals(3.4, avatar.averageRatingBy(7), 0.01);
		assertEquals(-1, hp.averageRatingBy(-1), 0.01);
		assertEquals(-1, hp.averageRatingBy(5), 0.01);
		assertEquals(7.6, hp.averageRatingBy(0), 0.01);
		assertEquals(7.13, hp.averageRatingBy(3), 0.01);
		assertEquals(8.06, hp.averageRatingBy(4), 0.01);

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="percentagePerfectRatings", marks=9)
	public void testPercentagePerfectRatings() {
		assertEquals(17.5, avatar.percentagePerfectRatings(), 0.01);
		assertEquals(18.66, hp.percentagePerfectRatings(), 0.01);

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="favoriteCharacter", marks=9)
	public void testFavoriteCharacter() {
		assertEquals("Zuko", avatar.favoriteCharacter());
		assertEquals("Luna Lovegood", hp.favoriteCharacter());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="harshestCriticIndex", marks=9)
	public void testHarshestCriticIndex() {
		assertEquals(7, avatar.harshestCriticIndex());
		assertEquals(2, hp.harshestCriticIndex());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="flattestCritic", marks=5)
	public void testFlattestCritic() {
		assertEquals(4, avatar.flattestCritic());
		assertEquals(0, hp.flattestCritic());

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="getDetails", marks=3)
	public void testGetDetails() {
		assertEquals("Aang         :  6,  8,  8,  5,  8,  5,  6,  3 (Average rating: 6.125)", avatar.getDetails(0));
		assertEquals("Zuko         :  3, 10, 10, 10,  8, 10,  6,  2 (Average rating: 7.375)", avatar.getDetails(4));
		assertEquals("Snape               :  7, 10,  9,  7, 10 (Average rating: 8.6)", hp.getDetails(3));
		assertEquals("Bellatrix Lestrange :  4, 10,  5,  5,  8 (Average rating: 6.4)", hp.getDetails(12));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="olympicStyleRating", marks=5)
	public void testOlympicStyleRating() {
		assertEquals(-1, avatar.olympicStyleRating(-1),0.01);
		assertEquals(-1, avatar.olympicStyleRating(5),0.01);
		assertEquals(6.33, avatar.olympicStyleRating(0),0.01);
		assertEquals(7.83, avatar.olympicStyleRating(4),0.01);
		assertEquals(-1, hp.olympicStyleRating(-1),0.01);
		assertEquals(-1, hp.olympicStyleRating(15),0.01);
		assertEquals(8.66, hp.olympicStyleRating(6),0.01);
		assertEquals(6.0, hp.olympicStyleRating(11),0.01);

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="mostToLeastFavorite", marks=5)
	public void testMostToLeastFavorite() {
		assertEquals("[Zuko, Toph Beifong, Aang, Sokka, Katara]", Arrays.toString(avatar.mostToLeastFavorite()));
		assertEquals("[Luna Lovegood, Snape, Lily Potter, Harry Potter, Voldermort, Draco Malfoy, Dumbledore, Sirius Black, Hermione Granger, Ron Weasley, Cho Chang, Lucius Malfoy, Bellatrix Lestrange, Barty Crouch Jr., Peter Pettigrew]", Arrays.toString(hp.mostToLeastFavorite()));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="mostToLeastFavoriteByCritic", marks=5)
	public void testMostToLeastFavoriteByCritic() {
		assertEquals(null, avatar.mostToLeastFavoriteByCritic(-1));
		assertEquals(null, avatar.mostToLeastFavoriteByCritic(8));
		assertEquals("[Sokka, Toph Beifong, Aang, Katara, Zuko]", Arrays.toString(avatar.mostToLeastFavoriteByCritic(0)));
		assertEquals("[Toph Beifong, Sokka, Aang, Katara, Zuko]", Arrays.toString(avatar.mostToLeastFavoriteByCritic(4)));
		assertEquals(null, hp.mostToLeastFavoriteByCritic(-1));
		assertEquals(null, hp.mostToLeastFavoriteByCritic(5));
		assertEquals("[Dumbledore, Draco Malfoy, Luna Lovegood, Lily Potter, Harry Potter, Sirius Black, Ron Weasley, Hermione Granger, Barty Crouch Jr., Voldermort, Snape, Peter Pettigrew, Lucius Malfoy, Cho Chang, Bellatrix Lestrange]", Arrays.toString(hp.mostToLeastFavoriteByCritic(0)));
		assertEquals("[Snape, Lily Potter, Luna Lovegood, Cho Chang, Harry Potter, Voldermort, Sirius Black, Draco Malfoy, Hermione Granger, Lucius Malfoy, Bellatrix Lestrange, Ron Weasley, Barty Crouch Jr., Dumbledore, Peter Pettigrew]", Arrays.toString(hp.mostToLeastFavoriteByCritic(4)));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description="groupByRatings", marks=5)
	public void testGroupByRatings() {
		String[][] buckets = avatar.groupByRatings();
		assertNotNull(buckets);
		assertEquals(11, buckets.length);
		
		assertEquals(0, buckets[0].length);
		assertEquals(0, buckets[1].length);
		assertEquals(0, buckets[2].length);
		assertEquals(0, buckets[3].length);
		assertEquals(0, buckets[4].length);
		assertEquals(2, buckets[5].length);
		assertEquals("[Katara, Sokka]", Arrays.toString(buckets[5]));

		assertEquals(2, buckets[6].length);
		assertEquals("[Aang, Toph Beifong]", Arrays.toString(buckets[6]));

		assertEquals(1, buckets[7].length);
		assertEquals("[Zuko]", Arrays.toString(buckets[7]));

		assertEquals(0, buckets[8].length);
		assertEquals(0, buckets[9].length);
		assertEquals(0, buckets[10].length);
		
		buckets = hp.groupByRatings();
		assertNotNull(buckets);
		assertEquals(11, buckets.length);
		
		assertEquals(0, buckets[0].length);
		assertEquals(0, buckets[1].length);
		assertEquals(0, buckets[2].length);
		assertEquals(0, buckets[3].length);
		assertEquals(0, buckets[4].length);
		assertEquals(1, buckets[5].length);
		assertEquals("[Peter Pettigrew]", Arrays.toString(buckets[5]));

		assertEquals(5, buckets[6].length);
		assertEquals("[Ron Weasley, Lucius Malfoy, Bellatrix Lestrange, Cho Chang, Barty Crouch Jr.]", Arrays.toString(buckets[6]));

		assertEquals(0, buckets[7].length);
		
		assertEquals(8, buckets[8].length);
		assertEquals("[Harry Potter, Voldermort, Dumbledore, Snape, Lily Potter, Sirius Black, Draco Malfoy, Hermione Granger]", Arrays.toString(buckets[8]));

		assertEquals(0, buckets[9].length);
		assertEquals(1, buckets[10].length);
		assertEquals("[Luna Lovegood]", Arrays.toString(buckets[10]));
		
		
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
		System.out.println("Indicative mark: "+score);
//		String name = "NAME_ME_HERE".replace("./","");
//		String markMessage = name.substring(0, 8)+","+score;
//		System.out.println(markMessage+",\""+result+"\"\n");
//		File file = new File(name.substring(0, 8)+".txt");
//		FileWriter writer = new FileWriter(file);
//		writer.write(markMessage+",\""+result+"\"\n");
//		writer.flush();
//		writer.close();
	}
}
