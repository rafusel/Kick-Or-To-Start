package tokickortostart;

public class Likeness {
	public static void allLikeness(Project [] arr, Project input) {
		for (int index = 0; index < arr.length; index++) {
			likeness(arr[index], input);
		}
		return;
	}
	
	private static void likeness(Project project, Project input) {
		//Needs to be changed to include blurb and title words
		double likeness = 100;
		likeness *= 1 - (Math.abs(input.getGoal() - project.getGoal()) / input.getGoal());
		likeness *= 1 - (Math.abs(input.getDuration() - project.getDuration()) / input.getDuration());
		if (project.getUS() == input.getUS())
			likeness += 10;
		
		project.setLikeness(likeness);
		return;
	}
}
