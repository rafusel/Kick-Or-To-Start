package tokickortostart;

public class Probability {
	private static Project[] aux;
	
	public static double probability(Project[] arr) {
		sortProj(arr, arr.length);
		int length = 100;
		if (arr.length < 100 && arr.length != 0) {
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
