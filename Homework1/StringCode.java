import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int result = 0;
		int count = 0;
		char cmp = ' ';
		for(int j = 0; j < str.length(); j++){
			char ch = str.charAt(j);
			if(cmp == ' '){
				cmp = ch;
				result++;
				count++;
			} else if(ch == cmp){
				count++;
				if(count > result) result = count;
			} else{
				count = 1;
				cmp = ch;
			}
		}
		return result;
	}

	private static int isNum(char ch){
		int result = 0;

		switch (ch){
			case '0': return 0;
			case '1': return 1;
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;

			default: return -1;
		}
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String result = "";
		for(int j = 0; j < str.length(); j++){
			int k = isNum(str.charAt(j));
			if(k>=0){
				if(j+1<str.length()){
					for(int i = 0; i < k;i++){
						result += str.charAt(j+1);
					}
				}
			} else {
				result += str.charAt(j);
			}
		}
		return result;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> hs = new HashSet<>();
		for(int j = 0; j <= a.length() - len; j++){
			hs.add(a.substring(j,j+len));
		}
		for(int j = 0; j <= b.length() - len; j++){
			if(j+len <= b.length() && hs.contains(b.substring(j,j+len))) return true;
		}
		return false;
	}
}
