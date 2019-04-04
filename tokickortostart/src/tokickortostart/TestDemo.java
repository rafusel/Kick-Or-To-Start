package tokickortostart;
import java.io.FileNotFoundException;

public class TestDemo {

	public static void main(String[] args) throws FileNotFoundException {
		Project input = new Project(60, true, "telivision", 100000, 15, 3);
		Project [] arr = Read.reading();
		Likeness.allLikeness(arr, input);
		double prob = Probability.probability(arr);
		Project best = SimilarProject.MostSimilar(arr);
		Fitness.allFitness(arr);
		Project bestest = Score.BestProject(arr);
		System.out.println(prob);
		System.out.println(best.getURL());
		System.out.println(bestest.getURL());
		//Test
		
	}

}
