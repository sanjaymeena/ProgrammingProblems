package codingquestions.algorithms.sort;

/**
 * Time complexity of Merge Sort is O(nLogn) in all 3 cases (worst, average and
 * best) as merge sort always divides the array in two halves and take linear
 * time to merge two halves.
 * 
 * Auxiliary Space: O(n) Algorithmic Paradigm: Divide and Conquer Sorting In
 * Place: No in a typical implementation Stable: Yes
 * 
 * 
 * 
 * @author Sanjay
 *
 */
public class MergeSort {

	private void printNumbers(int[] input) {

		for (int i = 0; i < input.length; i++) {
			if (i == input.length - 1) {
				System.out.print(input[i]);
			} else {
				System.out.print(input[i] + ", ");
			}

		}
		System.out.println("\n");
	}

	public void mergeSort(int[] inputArr) {
		int length = inputArr.length;
		if (inputArr == null || inputArr.length == 0) {
			return;
		}

		sort(inputArr, 0, length - 1);

		printNumbers(inputArr);
	}

	// main sorting function
	private void sort(int[] inputArr, int l, int r) {

		if (l < r) {

			// find the middle point
			int m = (l + r) / 2;

			// sort first and second halves
			sort(inputArr, l, m);
			sort(inputArr, m + 1, r);

			// merge the sorted halves
			merge(inputArr, l, m, r);

		}
	}

	/**
	 * Merges two subarrays of inputArr. First subarray is arr[1..m] second
	 * subarray is arr[m+1..r]
	 * 
	 * 
	 * @param inputArr
	 * @param l
	 * @param m
	 * @param r
	 */
	private void merge(int arr[], int l, int m, int r) {

		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		new MergeSort().mergeSort(input);

		int[] input2 = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		new MergeSort().mergeSort(input2);

		int[] input3 = { 12, 11, 13, 5, 6, 7 };
		new MergeSort().mergeSort(input3);

	}
}
