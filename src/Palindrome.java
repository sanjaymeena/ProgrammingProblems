
public class Palindrome {

	/* It returns 1 when number is palindrome, otherwise returns 0. */
	static int IsPalindrome_solution2(int number)
	{
	    int reversed = 0;
	    int copy = number;

	    while(number != 0)
	    {
	        reversed = reversed * 10 + number % 10;
	        number /= 10;
	    }

	    return (reversed == copy) ? 1 : 0;
	}
	

	// ==================== Test Code ====================

	static void Test(String testName, int number, int expected)
	{
	    if(testName != null)
	        System.out.println(testName + " begins: " );

	   

	    if(IsPalindrome_solution2(number) == expected)
	        System.out.println("solution 2 passed.\n");
	    else
	        System.out.println("solution 2 FAILED.\n");
	}

	public static void main(String[] args) 
	{
	    Test("Test1", 5, 1);
	    Test("Test2", 33, 1);
	    Test("Test3", 242, 1);
	    Test("Test4", 2332, 1);

	    Test("Test5", 0, 1);

	    Test("Test6", 32, 0);
	    Test("Test7", 233, 0);
	    Test("Test8", 2331, 0);
	    Test("Test9", 2322, 0);

		
	}
}
