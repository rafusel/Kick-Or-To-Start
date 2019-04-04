package tokickortostart;

import java.util.ArrayList;

public class Suggestion {
	public static String[] getSuggestions(Project input) {
		ArrayList<String> suggestions = new ArrayList<String>();
		if (input.getGoal() > 10000) {
			suggestions.add("Considering lowering your goal amount to less than $10000.");
		}
		if (input.getTitleWords() > 10) {
			suggestions.add("A title should be no more than 10 words, consider shortening your title.");
		}
		if (input.getDuration() < 14) {
			suggestions.add("Consider extending your end date if possible.");
		}
		if (input.getDuration() > 365) {
			suggestions.add("Consider shortening your end date if possible.");
		}
		if (input.getBlurbWords() < 15) {
			suggestions.add("Try and increase the detail in your description for maximum results.");
		}
		String[] suggs = new String[suggestions.size()];
		for (int i = 0; i < suggestions.size(); i++) {
			suggs[i] = suggestions.get(i);
		}
		return suggs;
	}
}
