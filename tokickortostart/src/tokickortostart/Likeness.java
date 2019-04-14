package tokickortostart;

public class Likeness {
	public static void allLikeness(Project [] arr, Project input) {
		for (int index = 0; index < arr.length; index++) {
			likeness(arr[index], input);
		}
		return;
	}
	
	private static void likeness(Project project, Project input) {
	
		double likeness = 0;
		
		int Title = Math.abs(project.getTitleWords() - input.getTitleWords());
		if (Title == 0) {likeness += 10;}
		else if (Title < 5) {likeness += 5;}
		else {likeness += 1;}
		
		int Blurb = Math.abs(project.getBlurbWords() - input.getBlurbWords());
		if (Blurb == 0) {likeness += 10;}
		else if(Blurb < 5) {likeness += 5;}
		else {likeness += 1;}
		if (project.getCategory().equals(input.getCategory())) {likeness += 25;}
		
		double duration = Math.abs(project.getDuration() - input.getDuration());
		if (duration < 14) {likeness += 10;}
		else if (duration > 14 && duration < 28) {likeness += 5;}
		else { likeness += 1; }
		
		
		likeness *= 5 - (Math.abs(input.getGoal() - project.getGoal()) / input.getGoal());
		
		if (project.getUS() == input.getUS())
			likeness += 10;
		
		project.setLikeness(likeness);
		return;
	}
}
