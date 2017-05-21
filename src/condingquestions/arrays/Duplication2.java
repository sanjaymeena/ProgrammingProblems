package condingquestions.arrays;

/**
 * 
 * @author sanjay
 *
 *         An array contains n numbers ranging from 0 to n-1. There are some
 *         numbers duplicated in the array. It is not clear how many numbers are
 *         duplicated or how many times a number gets duplicated. How do you
 *         find a duplicated number in the array? For example, if an array of
 *         length 7 contains the numbers {2, 3, 1, 0, 2, 5, 3}, the implemented
 *         function (or method) should return either 2 or 3.
 */
public class Duplication2 {
	 public static int duplicate(int numbers[]) {
	        int length = numbers.length;
	        for(int i = 0; i < length; ++i) {
	            if(numbers[i] < 0 || numbers[i] > length - 1)
	                throw new IllegalArgumentException("Invalid numbers.");
	        }

	        for(int i = 0; i < length; ++i) {
	            while(numbers[i] != i) {
	                if(numbers[i] == numbers[numbers[i]]) {
	                    return numbers[i];
	                }

	                // swap numbers[i] and numbers[numbers[i]]
	                int temp = numbers[i];
	                numbers[i] = numbers[temp];
	                numbers[temp] = temp;
	            }
	        }
	        
	        throw new IllegalArgumentException("No duplications.");
	    }

	    //================= Test Code =================
	    private static boolean contains(int array[], int number){
	        for(int i = 0; i < array.length; ++i){
	            if(array[i] == number)
	                return true;
	        }
	        
	        return false;
	    }
	    
	    private static void test(String testName, int numbers[], int expected[], boolean invalidArgument){
	        System.out.print(testName + " begins: ");
	        
	        try {
	            int duplication = duplicate(numbers);
	            
	            if(!invalidArgument && contains(expected, duplication))
	                System.out.print("Passed.\n");
	            else
	                System.out.print("FAILED.\n");
	        }
	        catch(IllegalArgumentException e){
	            if(invalidArgument)
	                System.out.print("Passed.\n");
	            else
	                System.out.print("FAILED.\n");
	        }
	    }
	    
	    // The duplicated number is the smallest number
	    private static void test1(){
	        int numbers[] = {2, 1, 3, 1, 4};
	        int duplications[] = {1};
	        test("Test1", numbers, duplications, false);
	    }
	    
	    // The duplicated number is the greatest number
	    private static void test2(){
	        int numbers[] = {2, 4, 3, 1, 4};
	        int duplications[] = {4};
	        test("Test2", numbers, duplications, false);
	    }
	    
	    // There are more than one duplicated number
	    private static void test3(){
	        int numbers[] = {2, 4, 2, 1, 4};
	        int duplications[] = {2, 4};
	        test("Test3", numbers, duplications, false);
	    }
	    
	    // no duplicated numbers
	    private static void test4(){
	        int numbers[] = {2, 1, 3, 0, 4};
	        int duplications[] = {};
	        test("Test4", numbers, duplications, true);
	    }
	    
	    // no duplicated numbers
	    private static void test5(){
	        int numbers[] = {2, 1, 3, 5, 4};
	        int duplications[] = {};
	        test("Test5", numbers, duplications, true);
	    }

	    public static void main(String[] args) {
	        test1();
	        test2();
	        test3();
	        test4();
	        test5();
	    }
	}

