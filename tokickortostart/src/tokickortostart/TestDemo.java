package tokickortostart;
import java.io.FileNotFoundException;

public class TestDemo {

	public static void main(String[] args) throws FileNotFoundException {
		Project input = new Project(10, true, "telivision", 100000, 20, 3);
		Project [] arr = Read.reading();
		Likeness.allLikeness(arr, input);
		double prob = Probability.probability(arr);
		Project best = SimilarProject.MostSimilar(arr);
		Fitness.allFitness(arr);
		System.out.println(prob);
		System.out.println(best.getURL());
		//Test
	}

}
