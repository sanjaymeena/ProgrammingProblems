/**
 * 
 */
package codingquestions.algorithms.sort;

/**
 * @author Sanjay
 *
 *
 *         Heap sort is an in-place algorithm.
 *
 *
 *         Time complexity of heapify is O(Logn). Time complexity of
 *         createAndBuildHeap() is O(n) and overall time complexity of Heap Sort
 *         is O(nLogn).
 * 
 * 
 * 
 * 
 */
public class HeapSort {

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

	public void heapSort(int[] inputArr) {
		int length = inputArr.length;
		if (inputArr == null || inputArr.length == 0) {
			return;
		}

		for (int i = (length / 2) - 1; i >= 0; i--) {
			heapify(inputArr, length, i);
		}

		// now extract element from heap one by one
		for (int i = length - 1; i >= 0; i--) {
			swapNumbers(0, i, inputArr);

			// call max heapify on the reduced heap
			heapify(inputArr, i, 0);
		}

		printNumbers(inputArr);

	}

	private void heapify(int[] inputArr, int n, int i) {
		int largest = i; // initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		if (l < n && inputArr[l] > inputArr[largest]) {
			largest = l;

		} // If right child is larger than largest so far
		if (r < n && inputArr[r] > inputArr[largest])
			largest = r;

		if (largest != i) {
			swapNumbers(i, largest, inputArr);
			heapify(inputArr, n, largest);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		new HeapSort().heapSort(input);

		int[] input2 = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		new HeapSort().heapSort(input2);

		int[] input3 = { 12, 11, 13, 5, 6, 7 };
		new HeapSort().heapSort(input3);
	}

}
