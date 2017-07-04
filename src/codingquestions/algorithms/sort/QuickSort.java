/**
 * 
 */
package codingquestions.algorithms.sort;

import java.util.Random;

/**
 * 
 * 
 * The key process in quickSort is partition(). Most practical implementations of Quick Sort use randomized version. 
 * 
 * @author Sanjay
 * 
 * 
 *         Worst case : O(n^2) . when partition does not split the array.
 *         Ironically , this happens when the array is sorted<br>
 *         Best case : O(n log n) : partitions are evenly balanced , pivot is
 *         right in the middle after partitioning. <br>
 *         Average case : O(n log n)
 *         
 *         //prefer quick sort over merge sort for arrays and merge sort for linked lists
 *         Quick sort is in-place sort does not require additional memory. Merge sort requires O(N) storage. Quick sort is also cache friendly sorting algorithm. It is also tail recursive, therefore tail call optimiziations is done. 
 * 
 */
public class QuickSort {

	private void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

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

	public void quickSort(int[] inputArr) {
		int length = inputArr.length;
		if (inputArr == null || inputArr.length == 0) {
			return;
		}

		quickSortHelper(0, length - 1, inputArr);

		printNumbers(inputArr);
	}

	private void quickSortHelper(int lowerIndex, int higherIndex, int[] array) {
		// TODO Auto-generated method stub
		int i = lowerIndex;
		int j = higherIndex;

		// calculate pivot number. Here we take randomized element as pivot
		Random rand = new Random();
        int num = lowerIndex + rand.nextInt(higherIndex - lowerIndex);
        int pivot = array[num];
		//int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

		// divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swapNumbers(i, j, array);
				// move index to next position on both sides
				i++;
				j--;

			}

			// call quick sort method recursively
			if (lowerIndex < j) {
				quickSortHelper(lowerIndex, j, array);

				if (i < higherIndex) {
					quickSortHelper(i, higherIndex, array);
				}

			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		new QuickSort().quickSort(input);

		int[] input2 = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		new QuickSort().quickSort(input2);
	}

}
