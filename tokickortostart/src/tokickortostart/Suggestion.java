package tokickortostart;
import java.util.ArrayList;

/**
 * 
 * This module is used for outputting suggestions to the user on how they can improve
 * the chances of their projects success
 *
 */
public class Suggestion {
	/**
	 * This module uses the data from the inputted project to create an array of
	 * suggestions on how the project could have a greater likelihood of success.
	 * 
	 * @param input Project type created out of users inputted project
	 * @return Array of strings each of which is a suggestion
	 */
	public static String[] getSuggestions(Project input) {
		ArrayList<String> suggestions = new ArrayList<String>();
		
		/**
		 * Our observations indicate projects are much more likely to be successful with a goal below $10000
		 */
		if (input.getGoal() > 10000) {
			suggestions.add("Considering lowering your goal amount to less than $10000.");
		}
		/**
		 * Our observations indicate projects are more likely to be successful with a shorter title than 10 words
		 */
		if (input.getTitleWords() > 10) {
			suggestions.add("A title should be no more than 10 words, consider shortening your title.");
		}
		/**
		 * Our observations indicate projects are more likely to be successful with a duration above 14 days
		 */
		if (input.getDuration() < 14) {
			suggestions.add("Consider extending your end date if possible.");
		}
		/**
		 * Our observations indicate projects are more likely to be successful with a duration below 365 days
		 */
		if (input.getDuration() > 365) {
			suggestions.add("Consider shortening your end date if possible.");
		}
		/**
		 * Our observations indicate projects are more likely to be successful with a blurb above 15 words
		 */
		if (input.getBlurbWords() < 15) {
			suggestions.add("Try and increase the detail in your description for maximum results.");
		}
		
		/**
		 * Turning the ArrayList to an array
		 */
		String[] suggs = new String[suggestions.size()];
		for (int i = 0; i < suggestions.size(); i++) {
			suggs[i] = suggestions.get(i);
		}
		return suggs;
	}
}
