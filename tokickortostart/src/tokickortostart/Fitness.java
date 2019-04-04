package tokickortostart;

public class Fitness {
	public static void allFitness(Project [] arr) {
		for (int index = 0; index < arr.length; index++) 
			fitness(arr[index]);
		return;
	}
	
	private static void fitness(Project project) {
		double fitness = 100 * project.getPledge() / project.getGoal();
		
		project.setFitness(fitness);
		return;
	}
}
