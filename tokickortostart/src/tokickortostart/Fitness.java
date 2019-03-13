package tokickortostart;

public class Fitness {
	public static void allFitness(Project [] arr) {
		int length = 1000;
		if (arr.length < 1000)
			length = arr.length;
		for (int index = 0; index < length; index++) {
			fitness(arr[index]);
		}
		return;
	}
	
	private static void fitness(Project project) {
		double fitness = project.getPledge() / project.getGoal();
		if (project.getStaffPick())
			fitness += 20;
		
		project.setFitness(fitness);
		return;
	}
}
