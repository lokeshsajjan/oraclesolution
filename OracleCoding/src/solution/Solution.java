package solution;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		String input = "chill out";
		input = input.replace(" ", "");
		int L = input.length();// length of a input after removing spaces
		double R = getPRESQRT(L);
		double C = getPOSTSQRT(L);
		Map<Integer, String> mp = new HashMap<Integer, String>();
		while (R <= C) {
			if (R * C >= L) {
				break;
			}
			R++;
		}
		System.out.println("R:"+R);
		System.out.println("C:"+C);
	    if (R * C >= L) {
			int position = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (position < L) {
						System.out.print(input.charAt(position) + " ");
						if (mp.get(j) != null) {
							mp.put(j, mp.get(j) + (input.charAt(position)));
						} else {
							mp.put(j, String.valueOf(input.charAt(position)));
						}
					}
					position++;
				}
				System.out.println("");
			}
			// loop in to map
			for (Entry<Integer, String> en : mp.entrySet()) {
				System.out.print(en.getValue() + " ");
			}

		} else {
			System.out.println("RXC combination is not correct");
		}

	}

	private static double getPRESQRT(int L) {
		int value = -1;
		for (int i = 1; i < L; i++) {
			if (checkPerfectSquareRoot(i)) {
				value = Math.max(i, value);
			}
		}		
		return Math.sqrt(value);
	}

	private static boolean checkPerfectSquareRoot(double i) {
		double sqrtValue = Math.round(Math.sqrt(i));
		if (i == (sqrtValue * sqrtValue)) {
			return true;
		}
		return false;
	}

	private static double getPOSTSQRT(int L) {
		int value = Integer.MAX_VALUE;
		while (true) {
			if (checkPerfectSquareRoot(L)) {
				value = Math.min(L, value);
				break;
			}
			L++;
		}		
		return Math.sqrt(value);
	}

}
