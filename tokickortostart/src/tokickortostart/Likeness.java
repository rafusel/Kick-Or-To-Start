package tokickortostart;
/**
 * This module is used for determining and assigning likeness
 * values to each project. These values reflect how similar the project
 * is to the users inputted project.
 */
public class Likeness {
	/**
	 * This method assigns likeness values for all the projects in the passed array
	 * 
	 * @param arr An array of project types
	 * @param input The project type holding the users inputted project information
	 */
	public static void allLikeness(Project [] arr, Project input) {
		for (int index = 0; index < arr.length; index++) {
			likeness(arr[index], input);
		}
		return;
	}
	
	/**
	 * This method calculates and assigns an individual project type
	 * a likeness value depending on how similar it is
	 * to the inputted project
	 * 
	 * @param project The project to assign the likeness of
	 * @param input The project type holding the users inputted project information
	 */
	private static void likeness(Project project, Project input) {
	
		/**
		 * Initalizing likeness to zero
		 */
		double likeness = 0;
		
		/**
		 * Incrementing likeness based off of how similar in length the project titles are 
		 */
		int Title = Math.abs(project.getTitleWords() - input.getTitleWords());
		if (Title == 0) {likeness += 10;}
		else if (Title < 5) {likeness += 5;}
		else {likeness += 1;}
		
		/**
		 * Incrementing likeness based off of how similar in length the project blurbs are 
		 */
		int Blurb = Math.abs(project.getBlurbWords() - input.getBlurbWords());
		if (Blurb == 0) {likeness += 10;}
		else if(Blurb < 5) {likeness += 5;}
		else {likeness += 1;}
		if (project.getCategory().equals(input.getCategory())) {likeness += 25;}
		
		/**
		 * Incrementing likeness based off of how similar in length the project durations are 
		 */
		double duration = Math.abs(project.getDuration() - input.getDuration());
		if (duration < 14) {likeness += 10;}
		else if (duration > 14 && duration < 28) {likeness += 5;}
		else { likeness += 1; }
		
		/**
		 * Incrementing likeness based off of how similar in length the project goals are 
		 */
		likeness *= 5 - (Math.abs(input.getGoal() - project.getGoal()) / input.getGoal());
		
		/**
		 * Incrementing likeness based off of if the project is USA based or not
		 */
		if (project.getUS() == input.getUS())
			likeness += 10;
		
		
		
		project.setLikeness(likeness);
		return;
	}
}
