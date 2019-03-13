package tokickortostart;

import java.util.Arrays;

public class Probability {
	public static double probability(Project [] arr) {
		sortProj(arr);
		int length = 100;
		if (arr.length < 100) {
			length = arr.length;
		}
		int sum = 0;
		for (int index = 0; index < length; index ++) {
			if (arr[index].getPledge() >= arr[index].getGoal())
			{
				sum++;
			}
		}
		
		return (double) sum / length;
	}
	
	private static void sortProj(Project [] arr) {
		Arrays.sort(arr);
	}
}
