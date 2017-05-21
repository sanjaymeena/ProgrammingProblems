/**
 * 
 */
package codingquestions.codility;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author sanjay
 *
 */
public class Q1 {

	public String solution(String S, String C) {
		// write your code in Java SE 8
		String delimiter = "; ";

		String space = " ";
		String emailList = "";
		String separator = "_";
		String hyphen = "-";

		StringBuilder builder = new StringBuilder();

		Map<String, Integer> emailCountMap = new LinkedHashMap<>();

		if (S == null || C == null || S.isEmpty() || C.isEmpty()) {
			return emailList;
		}

		String[] names = S.split(delimiter);
		if (names == null || names.length == 0) {
			return emailList;
		}

		C = C.toLowerCase();

		String companyEmail = "@" + C + ".com";

		List<String> nameList = new LinkedList<>();
		List<Integer> numberList = new LinkedList<>();

		for (String name : names) {

			String[] values = name.split(space);
			if (values.length < 2) {
				return emailList;
			}
			StringBuilder emailBuilder = new StringBuilder();
			String first_name = values[0];
			String last_name = "";
			String middle_name = "";
			boolean has_middle_name = true;

			if (values.length == 3) {
				middle_name = values[1];
				last_name = values[2];

			} else if (values.length == 2) {
				has_middle_name = false;
				last_name = values[1];
			}

			emailBuilder.append(last_name + separator);
			if (has_middle_name) {
				middle_name = middle_name.substring(0, 1);
				emailBuilder.append(first_name + separator + middle_name);
			} else {
				emailBuilder.append(first_name);
			}

			String email = emailBuilder.toString().replaceAll(hyphen, "").toLowerCase();

			nameList.add(email);

			// put in map

			int counter = -1;
			if (emailCountMap.containsKey(email)) {

				int count = emailCountMap.get(email);
				counter = count + 1;

				emailCountMap.put(email, counter);

			} else {
				emailCountMap.put(email, 0);
				counter = 0;
			}

			numberList.add(counter);
		}

		List<String> emails = new LinkedList<>();

		for (int i = 0; i < nameList.size(); i++) {
			String email = nameList.get(i);
			int count = numberList.get(i);
			if (count == 0) {

				email = email + companyEmail;

			} else {
				int suffix = count + 1;
				email = email + suffix + companyEmail;
			}

			if (i < nameList.size() - 1)
				builder.append(email + delimiter);
			else {
				builder.append(email);
			}

		}

		return builder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 t = new Q1();

		String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		String C = "Example";
		String ans = t.solution(S, C);

		System.out.println("ans :" + ans);

	}

}
