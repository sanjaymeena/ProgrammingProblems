package codingquestions.codility;

/**
 * You are given two passages of text that have been scanned and passed through
 * OCR software. (OCR stands for Optical Character Recognition, which is the
 * conversion of printed text into machine-readable strings.) Unfortunately, the
 * scans were of poor quality and some letters were not recognized by the OCR
 * software. Write a program to check (based on the output from the OCR
 * software) whether the two text sources might in fact be the same.
 * 
 * We assume that each text passage consists only of English letters. The OCR
 * output from each scan is given as a string in which unrecognized letters are
 * marked as follows. Firstly, let us mark each unrecognized letter by “?“. For
 * example, if the OCR software didn’t recognize the second and third letters of
 * the text “AppLe“, it would result in OCR output of “A??Le“. Then, for
 * brevity, every group of K consecutive “?” characters is replaced by the
 * decimal representation of integer K (without leading zeros). Thus, the above
 * OCR result would be represented as “A2Le“. (For the sake of clarity, such
 * numeric replacement is performed on groups of “?” characters that cannot be
 * extended either to the left or to the right.)
 * 
 * You are given two strings S and T consisting of N and M characters,
 * respectively, and you would like to check whether they might have been
 * obtained as OCR scans of the same text. For example, both strings “A2Le” and
 * “2pL1” could have been obtained as scans of the word “AppLe” (but also as
 * scans of the word “AmpLe“). Both strings “a10” and “10a” could have been
 * obtained as scans of the word “abbbbbbbbba” (but also from many other strings
 * of length 11, starting and ending with “a“).
 * 
 * On the other hand, strings “ba1” and “1Ad” could not have been obtained from
 * the same text, since the second letter of each text is different.
 * 
 * Write a function:
 * 
 * int solution(NSString *S, NSString *T);
 * 
 * that, given two strings S and T consisting of N and M characters,
 * respectively, determines whether strings S and T can be obtained as OCR
 * output from the same text.
 * 
 * For example, given “A2Le” and “2pL1“, your function should return 1, as
 * explained above. Given “a10” and “10a“, your function should return 1, as
 * explained above. Given “ba1” and “1Ad“, your function should return 0, as
 * explained above. Given “3x2x” and “8“, your function should return 0, since
 * they represent strings of different length.
 * 
 */
public class OCR {
	public static void main(String... args) {

		String S = "A2Le";
		String T = "2pL1";

		System.out.println(new OCR().solution(S, T));

		S = "a10";
		T = "10a";
		System.out.println(new OCR().solution(S, T));

		S = "ba1";
		T = "1Ad";
		System.out.println(new OCR().solution(S, T));

		S = "3x2x";
		T = "8";
		System.out.println(new OCR().solution(S, T));
	}

	public String replaceDigits(String string) {
		return string.replaceAll("[0-9]", "?");
	}

	public boolean solution(String S, String T) {

		if (S == null || T == null)
			return false;
		if (S.length() != T.length()) {
			return false;
		}

		boolean solution = true;

		String a = replaceDigits(S);
		String b = replaceDigits(T);

		for (int i = 0, n = a.length(); i < n; i++) {
			char c1 = a.charAt(i);
			char c2 = b.charAt(i);

			if (c1 != '?' && c2 != '?' && (c1 != c2))

			{
				solution = false;

			}

		}

		return solution;
	}
}
