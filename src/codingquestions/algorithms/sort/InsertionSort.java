/**
 * 
 */
package codingquestions.algorithms.sort;

/**
 * @author sanjay
 * 
 * Insertion Sort [Best: O(N), Worst:O(N^2)]
 *
 */
public class InsertionSort {

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
	
	public  int[] insertionSort(int[] input){
        
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                	swapNumbers(j,j-1,input);
                }
                
            }
			printNumbers(input);

        }
        
        return input;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		new InsertionSort().insertionSort(input);

		input = new int[] {10,34,2,56,7,67,88,42};
		new InsertionSort().insertionSort(input);
	}

}
