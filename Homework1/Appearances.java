import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap< Integer, Integer > A = new HashMap< Integer, Integer>();
		HashMap< Integer, Integer > B = new HashMap< Integer, Integer>();

		for(T item : a ){
			Integer key = item.hashCode();
			Integer val = 0;
			if(A.containsKey(key)){
				val = A.get(key);
			}
			val++;
			A.put(key,val);
		}
		for(T item : b ){
			Integer key = item.hashCode();
			Integer val = 0;
			if(B.containsKey(key)){
				val = B.get(key);
			}
			val++;
			B.put(key,val);
		}

		int result = 0;
		for( int key : A.keySet()){
			if(B.containsKey(key) && A.get(key).equals(B.get(key))) result++;
		}

		return result;
	}
	
}
