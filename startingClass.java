import java.io.*;
import java.util.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import serpapi.GoogleSearch;
import serpapi.SerpApiSearchException;


/**
 * Problem: we saw an issue with students staying engage in online lectures
 * To increase retention and engagement, we created an external source
 * to increase engagement using external links and keywords
 *
 * @author Adam Deehring, Chloe Tang, Jaylon Nelson-Sellers, Yash Varde
 * @file startingClass r
 * @brief runs and executes the file
 */
public class startingClass {

	//class variables
	static ArrayList<String> wordsToSkip = new ArrayList<String>();
	static ArrayList<Keyword> keywords = new ArrayList<Keyword>();
	static serpapi.GoogleSearch search;
	private static String serp_api_key = "5024dae6490ecf85c3892d6d50d0cad881887f55614a372733bdb1e9cad0778b";

	/**
	 * Main method
	 * starts and runs the program
	 * @param args args being passed in
	 */
	public static void main(String[] args) {

		search = new GoogleSearch();
		ArrayList<String> testArray = new ArrayList<>();
		try {
			VttObject testObject = new VttObject(new BufferedReader(new FileReader("Avengers_Endgame.vtt")));
			testArray = testObject.getLines();

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}

		try {
			fillInWordsToSkip(new File("mostCommonWords.txt"));
			findMostFrequentKeywords(testArray);

			//iterates through keywords
			for (Keyword k : keywords) {
				System.out.println(k);
				//creates map to store strings
				Map<String, String> parameter = new HashMap<>();
				parameter.put("q", k.getName());
				parameter.put("location", "Bothell, Washington");
				search = new GoogleSearch(parameter, startingClass.serp_api_key);
				JsonObject searchResults = search.getJson();
				String searchResult = (searchResults.get("organic_results").toString());
				JsonElement organicRes = searchResults.get("organic_results");
				JsonObject firstLink = (JsonObject) organicRes.getAsJsonArray().get(0);
				System.out.println( firstLink.get("link").getAsString().replaceAll("\"",""));
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The specified file cannot be found");
		} catch (SerpApiSearchException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * findMostFrequentKeywords
	 * finds tme most common keywords
	 * @param transcript string
	 */
	public static void findMostFrequentKeywords(String[] transcript) {
		//convert the transcript array to a string 
		String transcriptString = "";
		for (int i = 0; i < transcript.length; i++) {
			//separate lines using a space
			transcriptString += transcript[i] + " ";
		}

		//convert the string to an array of strings where each string is a distinct word
		String[] transcriptArray = transcriptString.split(" ");


		//length of the string
		for (int i = 0; i < transcriptArray.length; i++) {
			String word1 = transcriptArray[i];
			//if the word is a word to skip,
			// or if the word already exists in the list of keywords, continue to the next word
			if (wordsToSkipContains(word1) || keywordContains(word1)) {
				continue;
			}
			//otherwise, find its number of occurrences within the array, and add it as an object into the keyword list
			else {
				int occurrences = 1;
				for (int j = i + 1; j < transcriptArray.length; j++) {
					String word2 = transcriptArray[j];
					if (word1.equals(word2)) {
						occurrences++;
					}
				}
				keywords.add(new Keyword(word1, occurrences));
			}
		}

		//sort the keywords based on how often they occur within the transcript
		Collections.sort(keywords);
	}

	/**
	 * findsMostFrequentKeywords
	 * locates the most common keywords
	 * @param transcript transcript using an arraylist
	 */
	public static void findMostFrequentKeywords(ArrayList<String> transcript) {
		//convert the transcript array to a string
		String transcriptString = "";
		for (int i = 0; i < transcript.size(); i++) {
			//separate lines using a space
			transcriptString += transcript.get(i) + " ";
		}

		//convert the string to an array of strings where each string is a distinct word
		String[] transcriptArray = transcriptString.split(" ");


		//length of the string
		for (int i = 0; i < transcriptArray.length; i++) {
			String word0 = transcriptArray[i].toLowerCase();
			String word1 = removePunc(word0);

			//if the word is a word to skip,
			// or if the word already exists in the list of keywords, continue to the next word
			if (wordsToSkipContains(word1) || keywordContains(word1) || word1.length() == 0) {
				continue;
			}
			//otherwise, find its number of occurrences within the array,
			// and add it as an object into the keyword list
			else {
				int occurrences = 1;
				for (int j = i + 1; j < transcriptArray.length; j++) {
					String word2 = transcriptArray[j];
					if (word1.equals(word2)) {
						occurrences++;
					}
				}
				keywords.add(new Keyword(word1, occurrences));
			}
		}

		//sort the keywords based on how often they occur within the transcript
		Collections.sort(keywords);
	}

	/**
	 * removePunc
	 * Removes punctuation from the string
	 * @param word word to be examined
	 * @return a cleaned up string
	 */
	private static String removePunc(String word) {
		String strRetVal = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c >= 'a' && c <= 'z') {
				strRetVal += c;
			}
		}
		return strRetVal;
	}

	/**
	 * wordsToSkipContains
	 * checks if a word is contained in the words to skip
	 * @param word word to be examined
	 * @return a boolean representing if it should be fixed
	 */
	public static boolean wordsToSkipContains(String word) {
		for (String s : wordsToSkip) {
			if (s.equals(word)) {
				return true;
			}
		}

		return false;
	}


	/**
	 * keywordContains
	 * Checks to see whether or not the given word is already in the key words lists
	 * @param word string to be examined
	 * @return a boolean represenitn if the keyword was found
	 */
	public static boolean keywordContains(String word) {
		for (Keyword s : keywords) {
			if (s.getName().equals(word)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * fillInWordsToSkips
	 * reads from the file all the common words that can be skipped
	 * @param f
	 * @throws FileNotFoundException
	 */
	public static void fillInWordsToSkip(File f) throws FileNotFoundException {
		Scanner wordReader = new Scanner(f);
		while (wordReader.hasNextLine()) {
			String word = wordReader.nextLine();
			if (!wordsToSkip.contains(word)) {
				wordsToSkip.add(word);
			}
		}
	}
}


