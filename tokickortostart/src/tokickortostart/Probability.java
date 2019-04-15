package tokickortostart;

/**
 * 
 * This module contains methods for determining the likelihood of
 * the user's project being a success. The method for implementing
 * mergesort follows the method found at
 *  {@see <a href=url>https://algs4.cs.princeton.edu/22mergesort/Merge.java.html</a>}
 *
 */
public class Probability {
	/**
	 * This is the auxillary array used with merge sort
	 */
	private static Project[] aux;
	
	/**
	 * This method sorts the array of projects of the same type by their likeness
	 * to the inputted project and then uses the percentage of the top 100 of those
	 * successful to determine the probability of project success .
	 * 
	 * @param arr Array of the projects of the same category as the inputted project
	 * @return
	 */
	public static double probability(Project[] arr) {
		
		sortProj(arr, arr.length);
		
		/**
		 * If there are at least 100 projects then probability is based of the top 100 most similar. If there
		 * are less than 100 it is based off of all projects
		 */
		int length = 100;
		if (arr.length < 100 && arr.length != 0) {
			length = arr.length;
		}
		/**
		 * Summing the number of successful projects
		 */
		int sum = 0;
		for (int index = 0; index < length; index ++) {
			if (arr[index].getPledge() >= arr[index].getGoal())
			{
				sum++;
			}
		}
		
		return (double) sum / length;
	}
	
	/**
	 * This method sorts the array by likeness using the mergesort and follows the
	 * implementation found at 
	 * {@see <a href=url>https://algs4.cs.princeton.edu/22mergesort/Merge.java.html</a>}
	 * 
	 * @param arr the arry of projects to be sorted
	 * @param n The sze of the auxillary arrahy needed
	 */
	private static void sortProj(Project[] arr, int n) {
		aux = new Project[n];
		sort(arr, 0, n - 1);
	}	
	private static void sort(Project[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); 
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}
	private static void merge(Project[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[j].compareTo(aux[i]) < 0)
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}
}
