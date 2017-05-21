package codingquestions.codility;


import java.util.LinkedHashSet;
import java.util.Set;

/**
 * People are waiting for an elevator in a hotel. The elevator has limited
 * capacity and you would like to analyse its movement.
 * <p>
 * The hotel has floors numbered from 0 (ground floor) to M. The elevator has a
 * maximum capacity of X people and a weight limit of Y. There are 61 people
 * gathered al the ground floor, standing in a queue for the elevator. You are
 * given every person weight A[K] and target floor B[K].(That is A[0] and B[0]
 * represent the first person in the queue).
 * <p>
 * People continue to enter the elevator, in the order of their position in the
 * queue (and push the buttons for their target floors), for as long as there is
 * room for them. (The queue order cannot be changed even if there is room in
 * the elevator for a particular person from the middle of the queue) Then
 * elevator goes up and stops at every selected floor, and finally returns to
 * the ground floor. This process is repealed until there are no more people in
 * the queue. The goal is to count the total number of times that the elevator
 * stops. For example, consider a hotel with floors numbered from 0 to M = 5,
 * with an elevator with a maximum capacity of X = 2 people and a weight limit
 * of V= 200. The weights A and target floors B are:
 * <p>
 * A[0] = 60 B[0] = 2 A[1] = 8O 5[1] = 3 A[2] = 40 5[2] = 5
 * <p>
 * The elevator will take the first two passengers together, stop at the 2nd and
 * 3rd floors, then return to the ground floor. Then, it will take the last
 * passenger stop at the 5th floor and return to the ground floor. In total, the
 * elevator will stop five times. Note that this number includes the last stop
 * at the ground floor
 * <p>
 * Write a function that, given zero-indexed arrays A and B consisting of N
 * integers, and numbers X, Y and M as described above, returns the total number
 * of times the elevator stops. For example, given the above data, the function
 * should return 5, as explained above.
 * <p>
 * For example, given M = 3, X = 5, Y = 200 and the following arrays:
 * <p>
 * A[0] = 40 B[0] = 3 A[1] = 40 B[1] = 3 A[2] = 100 B[2] = 2 A[3] = 80 B[3] = 2
 * A[4] = 20 B[4] = 3
 * <p>
 * the function should return 6, as the elevator will move in two stages: with
 * the first three people and then with the two remaining people.
 * <p>
 * Assume that :
 * <p>
 * N, M and X are integers within the range [1...100,000]; Y is an integer
 * within the range [1...1,000,000,000]; each element of array A is an integer
 * within the range [1..Y] each element of array B is an integer within the
 * range [1..M]
 * <p>
 * Complexity. expected worst-case time complexity is 0(N*log(N)+M); expected
 * worst-case space complexity is O(N+M), beyond input storage (not counting the
 * storage required for input arguments).
 * <p>
 * Elements of input arrays can be modified.
 */

public class HotelElevator {
	public static void main(String... args) {
		int A[] = { 40, 40, 100, 80, 20 };
		int B[] = { 3, 3, 2, 2, 3 };
		int people = 5;
		int weight = 200;
		System.out.println(new HotelElevator().solution2(A, B, people, weight));

		int X[] = { 60, 80, 40 };
		int Y[] = { 2, 3, 5 };
		people = 5;
		weight = 200;
		System.out.println(new HotelElevator().solution2(X, Y, people, weight));
	}

	public int solution(int[] A, int[] B, int X, int Y) {
		Set<Integer> stops = new LinkedHashSet<>();

		int totalWeight = 0;
		int noOfPeople = 0;
		int noOfStop = 0;
		for (int i = 0; i < A.length; i++) {
			noOfPeople++;
			totalWeight += A[i];
			if (noOfPeople > X || totalWeight > Y) {
				noOfStop += stops.size();
				stops.clear();
				noOfPeople = totalWeight = 0;
				i--;
				noOfStop++;
			} else {
				stops.add(B[i]);
			}
		}
		return noOfStop + 1 + stops.size();
	}
	
	public int solution2(int[] A, int[] B, int X, int Y) {
		
		
		int totalElevatorStops=0;
		
		if(A==null|| B==null){
			return totalElevatorStops;
		}
		
		Set<Integer> elevator_one_stage_stops = new LinkedHashSet<>();
		int total_Weight = 0;
		int total_People = 0;
		int total_Stops = 0;
		for (int i = 0; i < A.length; i++) {
			
			total_Weight += A[i];
			total_People++;
			if (total_Weight > Y||total_People > X ) {
				total_Stops += elevator_one_stage_stops.size();
				elevator_one_stage_stops.clear();
				
				total_People =0;
				total_Weight = 0;
				i--;
				total_Stops++;
			} else {
				elevator_one_stage_stops.add(B[i]);
			}
		}
		totalElevatorStops=total_Stops + elevator_one_stage_stops.size()+1;
		return totalElevatorStops;
	}
}
