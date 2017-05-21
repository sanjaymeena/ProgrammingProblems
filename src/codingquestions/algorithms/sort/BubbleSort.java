/**
 * 
 */
package codingquestions.algorithms.sort;

/**
 * @author sanjay
 *
 *         Bubble sort (also known as Sinking sort) has worst-case and average
 *         complexity both О(n^2) . Best case is O(n) when array is already
 *         sorted
 */
public class BubbleSort {

	private void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private void printNumbers(int[] input) {

		for (int i = 0; i < input.length; i++) {
			if(i==input.length-1){
				System.out.print(input[i]);
			}
			else{
				System.out.print(input[i] + ", ");
			}
			
		}
		System.out.println("\n");
	}

	// logic to sort the elements
	public int[] bubble_sort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1] > array[j]) {
					swapNumbers(j - 1, j, array);
				}
			}
			printNumbers(array);
		}
		return array;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		new BubbleSort().bubble_sort(input);

		input = new int[] { 5, 90, 35, 45, 150, 3 };
		new BubbleSort().bubble_sort(input);
	}
}
