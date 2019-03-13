package tokickortostart;

public class TestDemo {

	public static void main(String[] args) {
		Project input = new Project(10, true, "Technology", 100000, 20, 3);
		Project [] arr = null; //READ
		Likeness.allLikeness(arr, input);
		double prob = Probability.probability(arr);
		Project best = SimilarProject.MostSimilar(arr);
		Fitness.allFitness(arr);
		System.out.println(prob);
		System.out.println(best.getURL());
		//Test
	}

}
