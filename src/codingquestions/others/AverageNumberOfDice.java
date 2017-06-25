package codingquestions.others;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 */

/**
 * @author sanjay
 *
 */
public class AverageNumberOfDice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AverageNumberOfDice dices = new AverageNumberOfDice();
		dices.test();

	}

	/**
	 * 
	 */
	private void test() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int max = 6;

		int totalturns = 1000;

		int gameLength = 0;
		for (int i = 0; i < totalturns; i++) {

			Set<Integer> turnSet = new HashSet<>();

			boolean allSeen = false;
			int diceRoll = 0;
			while (!allSeen) {
				diceRoll++;
				int turn = random.nextInt(max) + 1;
				turnSet.add(turn);
				if (turnSet.size() == 6) {
					allSeen = true;

				} 

			}
			gameLength += diceRoll;

		}
		double avgTurns = (gameLength * 1.0) / totalturns;
		System.out.println(avgTurns);
	}

}
