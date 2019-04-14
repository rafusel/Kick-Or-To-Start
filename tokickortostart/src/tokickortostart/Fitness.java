package tokickortostart;
/**
 * 
 * This class is used to determine how successful projects 
 * are, based off of amount of money received
 *
 */
public class Fitness {
	/**
	 * Assigns fitness values to all projects in an inputted array
	 * @param arr The array of project types to assign the fitness of
	 */
	public static void allFitness(Project [] arr) {
		for (int index = 0; index < arr.length; index++) 
			fitness(arr[index]);
		return;
	}
	
	/**
	 * Assigning a fitness value to an individual project 
	 * @param project The project to assign the fitness of
	 */
	private static void fitness(Project project) {
		double fitness = 100 * project.getPledge() / project.getGoal();
		
		project.setFitness(fitness);
		return;
	}
}
