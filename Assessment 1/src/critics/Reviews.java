package critics;
//Student ID: 46410961
//Student name (as on eStudent): AVA GARDINER
//[X] Declaration from student that they haven't viewed another person's code for this assignment. Add a x between the brackets

//No built-in library can be used can be used (apart from file reading, which is already done)

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reviews {
	public int nCharacters = 0; 	//number of characters in the spreadsheet
	public int nCritics = 0; 	//number of critics in the spreadsheet
	public String[] characters; 	//holds the list of characters, as read from the file
	public int[][] ratings; 		//holds the ratings by 1 or more critics for the characters

	//ratings[0][0] gives the rating for FIRST character by FIRST critic
	//ratings[0][1] gives the rating for FIRST character by SECOND critic
	//...
	//ratings[0][nCritics-1] gives the rating for FIRST character by LAST critic
	//...
	//...
	//ratings[nCharacters-1][0] gives the rating for LAST character by FIRST critic
	//ratings[nCharacters-1][1] gives the rating for LAST character by SECOND critic
	//...
	//ratings[nCharacters-1][nCritics-1] gives the rating for LAST character by LAST critic

	//in general, ratings[i][k] gives rating for character at index i as given by critic at index k

	/**
	 * DO NOT MODIFY
	 * @param fileBaseName
	 * @throws FileNotFoundException 
	 */
	public Reviews(String fileBaseName) throws FileNotFoundException {
		getRatings(fileBaseName+".csv");
	}

	/**
	 * DO NOT MODIFY
	 * This function reads the data from the file supplied and populates the two arrays: characters, ratings
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void getRatings(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(filename));
		String[] tokens = scanner.nextLine().split(",+"); //ignore header
		nCritics = tokens.length - 1;
		while(scanner.hasNextLine()) {
			scanner.nextLine();
			nCharacters++;
		}
		characters = new String[nCharacters];
		ratings = new int[nCharacters][nCritics];

		scanner = new Scanner(new FileReader(filename));
		scanner.nextLine();
		for(int i=0; i < characters.length; i++) {
			tokens = scanner.nextLine().split(",+");
			characters[i] = tokens[0];
			for(int k=1; k < tokens.length; k++) {
				ratings[i][k-1] = Integer.parseInt(tokens[k]);
			}
		}
	}

	/**************************************
	 * YOUR JOB BEGINS BELOW THIS COMMENT *
	 **************************************/

	/**
	 * P/CR
	 * Let's start easy :)
	 * @return the total number of ratings in the spreadsheet
	 */
	public int totalRatingsCount() {
		return nCritics*nCharacters; 
	}

	/**
	 * P/CR
	 * @param idx
	 * @return the average rating for the character at given index, 0 being the first character's index
	 * return -1 if index is invalid (no character at that index)
	 */
	public double averageRating(int idx) {
		double sum = 0;
		
		if (idx < 0 || idx >= nCharacters)
			return -1;
		
		for(int i = 0; i < nCritics; i++)
		{
			sum = sum + ratings[idx][i];
		}
		
		return sum / nCritics;
	}

	/**
	 * P/CR
	 * @param target
	 * @return index at which target exists, -1 if it doesn't exist.
	 * NOTE: use String1.equalsIgnoreCase(String2) to compare two Strings
	 */
	public int getIndex(String target) {
		int index = -1;
		
		for(int i = 0; i<nCharacters; i++) {
			if (target.equalsIgnoreCase(characters[i]))
			{
				index = i;
			}
		}
		return index; 
	}

	/**
	 * P/CR
	 * @param character
	 * @return average rating for given character (case-insensitive)
	 */
	public double averageRating(String character) {
		int index = getIndex(character);
		double average = averageRating(index);
		
		return average; 
	}

	/**
	 * P/CR
	 * @param criticIndex
	 * @return average rating given by the critic at given index, 0 being the first critic's index
	 * return -1 if the critic index provided is invalid
	 */
	public double averageRatingBy(int criticIndex) {
		
		double sum = 0;
		
		if(criticIndex < 0 || criticIndex >= nCritics)
		return -1;
		
		for (int i = 0; i<nCharacters; i++)
		{
			 sum = sum + ratings[i][criticIndex];
		}
		
		return sum/nCharacters;
	}

	/**
	 * P/CR
	 * @return the percentage of total ratings that are perfect (10)
	 */
	public double percentagePerfectRatings() {
		
		
		double count=0;
		
		for (int rows = 0; rows<nCharacters; rows++) {
			for (int columns = 0; columns<nCritics;columns++) {
				if(ratings[rows][columns]==10)
					count++;
			}
		}; 
		
		
		return count/(totalRatingsCount())*100;
	}

	/**
	 * P/CR
	 * @return the favorite character of the critics. That is, the character with the highest rating.
	 * in case of tie, return the character that exists earliest (above others)
	 */
	public String favoriteCharacter() {
		
		
		
		double oldRating = 0;
		String favouriteCharacter = "";
		 
		for (int i = 0; i<nCharacters;i++) 
		{
			double newRating = averageRating(characters[i]);
			if(oldRating < newRating) {
				oldRating = newRating;
				favouriteCharacter = characters[i];	
			}
				
		}
		
		
		
		
		return favouriteCharacter; 
	}

	/**
	 * P/CR
	 * @return the index of the critic who has given the lowest average rating
	 */
	public int harshestCriticIndex() {
		double lowestRating = averageRatingBy(0);
		int harshestCriticIndex = -1;
		
		for(int i = 1; i < nCritics; i++) {
			double lowest = averageRatingBy(i);
			if(lowestRating > lowest)	{
				lowestRating = lowest;
				harshestCriticIndex = i;
			}
			
		}

		return harshestCriticIndex; 
	}

	/**
	 * D/HD
	 * @return the critic who gives the flattest ratings as explained below.
	 * return lowest index in case of tie.
	 * 1. for each critic:
	 * 		a. determine the average rating given by a critic.
	 * 		b. add the sum of positive difference between each rating and the average.
	 * 2. return the critic with the lowest sum of positive differences
	 * 
	 * For example: 
	 * First critic (index 0) ratings: 10, 8, 5, 7 (average 7.5; differences: 2.5, 0.5, 2.5, 0.5 sum = 6.0)
	 * Second critic (index 1) ratings: 6, 5, 6, 5 (average 5.5; differences: 0.5, 0.5, 0.5, 0.5; sum = 2.0)
	 * return 0
	 */
	public int flattestCritic() {
		double[] sum = new double [nCritics];
		
		for (int i = 0; i < nCritics; i++) {
			double averageRating = averageRatingBy(i);
			for(int a = 0; a<nCharacters; a++) {
				double difference = Math.abs(ratings[a][i] - averageRating);
				sum[i] = difference + sum[i];
			}
		}
		
		double lowest = sum[0];
		int sumIndex = 0;
		
		for (int c = 0; c < nCritics; c++) {
			if (lowest > sum[c])
			{
				lowest = sum[c];
				sumIndex = c;
			}
		}
		
		return sumIndex; 
	}

	/**
	 * D/HD
	 * @param idx
	 * @return details of characters nicely formatted.
	 * Assume the length of the longest character name (amongst all the characters) is maxLength.
	 * Assume the length of the character at index idx is currentLength
	 * You should display the name of character at index idx 
	 * followed by (maxLength - currentLenght + 1) spaces 
	 * followed by a colon (:) followed by a space.
	 * 
	 * See expected output sample for further details
	 * 
	 * Use diffchecker.com to compare your output against expected output. 
	 */
	public String getDetails(int idx) {
		int maxLength = getMaximumLength();
		
		String name = characters[idx];
		name = String.format("%1$-" + maxLength + "s", name);
		
		String rating = "";
		
		for(int i = 0; i < nCritics; i++) {
			String currRating = String.format("%1$3s", ratings[idx][i]);
			rating = rating + currRating + ",";
		}
		
		String allRating = rating.substring(0, rating.length() - 1);
		
		double average = averageRating(idx);
		
		return name + " :" + allRating + " (Average rating: " + average + ")"; 
	}

	/**
	 * D/HD
	 * @param idx
	 * @return get average rating with one instance of highest rating and one instance of lowest rating discarded
	 * For example, if a character gets ratings 6, 8, 10, 4, 10, 7, 4, 4   4,4,4,6,8,10,10
	 * You should remove one 10 and one 4, remaining ratings being 6, 8, 10, 7, 4, 4,
	 * and the average 39/6 = 6.5
	 * return -1 if index is invalid
	 */
	public double olympicStyleRating(int idx) {
		
		if(idx < 0|| idx >= nCharacters)
			return -1;
		
		int characterRating[] = new int [nCritics];
		
		for(int i=0; i<nCritics; i++) {
			characterRating[i]=ratings[idx][i];
		}
		
		int[] characterRatingSorted = sort(characterRating);
		
		double remove = 0;
		for(int a = 1; a < nCritics - 1; a++) {
			remove = characterRatingSorted[a]+remove;
		}
		
		
		return remove/(nCritics-2); 
	}

	/**
	 * D/HD
	 * @return an array of character names, in order of highest to lowest average ratings
	 */
	public String[] mostToLeastFavorite() {
		
		double[] average = new double[nCharacters];
		String[] name = new String[nCharacters];
		
		for(int idx = 0; idx < nCharacters; idx++) {
			average[idx] = averageRating(idx);
			name[idx] = characters[idx];
		}
		
		for (int i=0; i<nCharacters; i++)
		{
			for(int c = i+1; c<nCharacters; c++) {
				if (average[i] >= average[c])
				{
					double tempRating = average[c];
					average[c] = average[i];
					average[i] = tempRating;
					
					String tempName = name[c];
					name[c]=name[i];
					name[i]=tempName;
				}
			}
		}
		
		
		return reverseSort(name);
	}

	/**
	 * D/HD
	 * @return a two dimensional array that contains 11 sub-arrays.
	 * sub-array i contains characters (in order of appearance) 
	 * with average ratings between i (inclusive) and (i+1) exclusive.
	 * 
	 * A sub-array shall be empty if there are no characters in that range.
	 * 
	 * The last sub-array will contain characters that have an
	 * average rating of exactly 10.
	 */
	public String[][] groupByRatings() {
		
		String groupRatings[][] = new String[11][0];
		
		
		double[] averageRating = new double[nCharacters];
		String[] name = new String[nCharacters];
		
		
		for(int idx = 0; idx < nCharacters; idx++) {
			averageRating[idx] = averageRating(idx); 
			name[idx] = characters[idx];
		}
		
		for (int i=0; i<nCharacters; i++)
		{
			for(int c = i+1; c<nCharacters; c++) {
				if ((int) averageRating[i] >= (int) averageRating[c])
				{
					double tempRating = averageRating[c];
					averageRating[c] = averageRating[i];
					averageRating[i] = tempRating;
					
					String tempName = name[c];
					name[c]=name[i];
					name[i]=tempName;
				}
			}
		}
		
	
		ArrayList<String> storeCharacters = new ArrayList<String>();
		int previousRatings = (int) averageRating[0];
		
		for(int i = nCharacters-1; i >= 0 ; i--) {
			int wholeNumber = (int) averageRating[i];
			
			if(wholeNumber == previousRatings)
			{
				storeCharacters.add(name[i]);
				previousRatings = wholeNumber;
			}
			else {
				groupRatings[previousRatings] = new String[storeCharacters.size()];
				
				for(int d = 0; d<storeCharacters.size(); d++) {
					groupRatings[previousRatings][d] = storeCharacters.get(d);
				}
				
				storeCharacters.clear();
				storeCharacters.add(name[i]);
				previousRatings = wholeNumber;
			}
		}
		
		groupRatings[previousRatings] = new String[storeCharacters.size()];
		
		for(int d = 0; d<storeCharacters.size(); d++) {
			groupRatings[previousRatings][d] = storeCharacters.get(d);
		}
		
		return groupRatings;

	}
	
	/**
	 * HD
	 * @param criticIndex
	 * @return an array of characters in order of highest to lowest ratings by the critic at given index
	 * return null if critic index is invalid
	 */
	public String[] mostToLeastFavoriteByCritic(int criticIndex) {
		
		if(criticIndex < 0 || criticIndex >= nCritics)
			return null;
		
		double[] charCritic = new double[nCharacters];
		String[] name = new String[nCharacters];
		
		
		for(int idx = 0; idx < nCharacters; idx++) {
			charCritic[idx] = ratings[idx][criticIndex]; 
			name[idx] = characters[idx];
		}
		
		for (int i=0; i<nCharacters; i++)
		{
			for(int c = i+1; c<nCharacters; c++) {
				if (charCritic[i] >= charCritic[c])
				{
					double tempRating = charCritic[c];
					charCritic[c] = charCritic[i];
					charCritic[i] = tempRating;
					
					String tempName = name[c];
					name[c]=name[i];
					name[i]=tempName;
				}
			}
		}
	
		
		return reverseSort(name); 
	}
	
	
	//**** HELPER METHODS ****//
	public int getMaximumLength() {
		int maxLength = 0;
		
		for(int i = 0; i < nCharacters; i++) {
			String name = characters[i];
			if(maxLength < name.length())
				maxLength = name.length();
		}
		
		return maxLength;
	}
	
	
	public int[] sort(int sortArray[]) {
		for (int i=0; i<sortArray.length; i++)
		{
			for(int c = i+1; c<sortArray.length; c++) {
				if (sortArray[i]>sortArray[c])
				{
					int temp = sortArray[c];
					sortArray[c] = sortArray[i];
					sortArray[i] = temp;
				}
			}
		}
		
		return sortArray;
	}
	
	public String[] reverseSort(String reverseArray[]) {
		for (int i = 0; i<reverseArray.length/2; i++) {
			String temp = reverseArray[i];
			reverseArray[i] = reverseArray[reverseArray.length-i-1];
			reverseArray[reverseArray.length-i-1] = temp;
		}
		
		return reverseArray;
			
	}
	
}

