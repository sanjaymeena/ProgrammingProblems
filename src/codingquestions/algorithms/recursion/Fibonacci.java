/**
 * 
 */
package codingquestions.algorithms.recursion;

import java.math.BigInteger;

/**
 * @author sanja
 *
 */
public class Fibonacci {

	/**
	 * Recursive solution. Exponential running time
	 * 
	 * @param n
	 * @return
	 */
	static long Fibonacci_Solution1(int n) {

		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);

	}

	/**
	 * Iterative solution O(n) running time
	 * 
	 * @param n
	 * @return
	 */
	static long Fibonacci_Solution2(int n) {
		long fibN = 0;
		int result[] = { 0, 1 };

		long fibminusOne = 1;
		long fibminusTwo = 0;

		if (n < 2)
			return result[n];

		for (int i = 2; i < n; i++) {
			fibN = fibminusOne + fibminusTwo;

			fibminusTwo = fibminusOne;
			fibminusOne = fibN;
		}

		return fibN;
	}

	/**
	 * function to generate nth fibonacci number Best solution using matrix
	 * O(logn) running time
	 **/
	static public BigInteger Fibonacci_Solution3(long n) {
		BigInteger arr1[][] = { { BigInteger.ONE, BigInteger.ONE }, { BigInteger.ONE, BigInteger.ZERO } };
		if (n == 0)
			System.out.println("\nFirst Fibonacci number = 0");
		else {
			power(arr1, n - 1);
			System.out.println("\n" + n + " th Fibonacci number = " + arr1[0][0]);
		}

		return arr1[0][0];
	}

	/** function raise matrix to power n recursively **/
	private static void power(BigInteger arr1[][], long n) {
		if (n == 0 || n == 1)
			return;
		BigInteger arr2[][] = { { BigInteger.ONE, BigInteger.ONE }, { BigInteger.ONE, BigInteger.ZERO } };
		power(arr1, n / 2);
		multiply(arr1, arr1);
		if (n % 2 != 0)
			multiply(arr1, arr2);
	}

	/** function to multiply two 2 d matrices **/
	private static void multiply(BigInteger arr1[][], BigInteger arr2[][]) {
		BigInteger x = (arr1[0][0].multiply(arr2[0][0])).add(arr1[0][1].multiply(arr2[1][0]));
		BigInteger y = (arr1[0][0].multiply(arr2[0][1])).add(arr1[0][1].multiply(arr2[1][1]));
		BigInteger z = (arr1[1][0].multiply(arr2[0][0])).add(arr1[1][1].multiply(arr2[1][0]));
		BigInteger w = (arr1[1][0].multiply(arr2[0][1])).add(arr1[1][1].multiply(arr2[1][1]));
		arr1[0][0] = x;
		arr1[0][1] = y;
		arr1[1][0] = z;
		arr1[1][1] = w;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test("Fibnoacci", 0, 0);
		Test("Fibnoacci", 1, 1);
		Test("Fibnoacci", 2, 1);
		Test("Fibnoacci", 3, 2);
		Test("Fibnoacci", 4, 3);
		Test("Fibnoacci", 5, 5);
		Test("Fibnoacci", 6, 8);
		Test("Fibnoacci", 7, 13);
		Test("Fibnoacci", 8, 21);
		Test("Fibnoacci", 9, 34);
		Test("Fibnoacci", 10, 55);

		Test("Fibnoacci", 40, 102334155);

		Test2("Big Fibonacci", 1000);
		
	}

	static void Test(String testName, int number, int answer) {
		if (testName != null)
			System.out.println(testName + " begins: ");

		if (Fibonacci_Solution2(number) == answer)
			System.out.println("solution 2 passed.\n");
		else
			System.out.println("solution 2 FAILED.\n");

	}

	static void Test2(String testName, long number) {
		if (testName != null)
			System.out.println(testName + " begins: ");

		System.out.println(Fibonacci_Solution3(number));

	}

}
