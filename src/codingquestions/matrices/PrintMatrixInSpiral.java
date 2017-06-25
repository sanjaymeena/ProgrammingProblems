package codingquestions.matrices;

public class PrintMatrixInSpiral {

	void printMatrixClockwise(int numbers[][]) {
		int rows = numbers.length;
		int columns = numbers[0].length;

		int start = 0;

		while (columns > start * 2 && rows > start * 2) {
			printRing(numbers, start);
			++start;

		}

	}

	private void printRing(int[][] numbers, int start) {
		// TODO Auto-generated method stub
		int rows = numbers.length;
		int columns = numbers[0].length;

		int endX = columns - 1 - start;
		int endY = rows - 1 - start;

		// Print a row from left to right
		for (int i = start; i <= endX; ++i) {
			int number=numbers[start][i];
			printNumber(number);
		}

		// Print a column top down
		if(start < endY){
			for (int i = start+1; i <= endY; ++i) {
				int number=numbers[i][endX];
				printNumber(number);
			}
		}
		
		//print a row from right to left
		if(start < endX && start< endY){
			for (int i = endX-1; i >= start; --i) {
				int number=numbers[endY][i];
				printNumber(number);
			}
		}
		
		// print a column bottom up
		if(start < endX && start< endY-1){
			for (int i = endY-1; i >= start+1; --i) {
				int number=numbers[i][start];
				printNumber(number);
			}
		}

	}

	private void printNumber(int number) {
		// TODO Auto-generated method stub
		System.out.print(number + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintMatrixInSpiral pmi=new PrintMatrixInSpiral();
		pmi.test();
	}

	/**
	 * 
	 */
	private void test() {
		 int arrA[][] = { { 1, 2, 3, 4, 5 }, { 18, 19, 20, 21, 6 },
				{ 17, 28, 29, 22, 7 }, { 16, 27, 30, 23, 8 },
				{ 15, 26, 25, 24, 9 }, { 14, 13, 12, 11, 10 } };
		 printMatrixClockwise(arrA);
		 
	}

}
