package codingquestions.algorithms.recursion;

/**
 * 
 * 
 * 
 * 
 * @author sanjay
 *
 *
 *
 *         There is a stair with n levels. A frog can jump up 1, 2, …, n-1, n
 *         levels at each step on the stair. aHow many approaches are there for
 *         this frog to jump from the bottom of the stair to the top? For
 *         example, there are four approaches for the frog to jump on a stair
 *         with three levels: (1) it jumps with three steps, one level for each
 *         step; (2) it jumps with two steps, one level for the first step and
 *         two levels for the second step; (3) it jumps with two steps, two
 *         levels for the first step and one level for the second step; or (4)
 *         it jumps in only one step from the bottom to the top directly.
 * 
 *         A function f(n) can be defined for the number of choices on a stair
 *         with n levels. Inspired by the solution of the previous problem, it
 *         is easy to get f(n) = f(n-1)+f(n-2)+…+f(1)+1. Since f(n-
 *         1)=f(n-2)+…+f(1)+1, f(n)=2f(n-1).
 * 
 *         It is not difficult to get f(n) =2^(n-1)
 * 
 */
public class Fib2 {

	/**
	 * Bit based power function
	 * 
	 * @param n
	 * @return
	 */
	static long powerUsingBit(int n) {
		
		if (n <= 1) return 1; 
		long result = 1 << (n-1);

		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powerUsingBit(5));
		
	}
}
