import junit.framework.TestCase;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	
	public void testSameCount3() {
		List<String> lst = Arrays.asList("Test1","Test2","Test2","Test3","Test4","Test5","Test5","Test5","Test6","Test7");
		assertEquals(3, Appearances.sameCount(lst, Arrays.asList("Test1", "Test2", "Test2", "Test2", "Test3", "Test4", "Test5")));
	}

	public void testSameCount4() {
		assertEquals(0, Appearances.sameCount(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7)));
		assertEquals(0, Appearances.sameCount(Collections.emptyList(), Arrays.asList(5, 6, 7)));
		assertEquals(0, Appearances.sameCount(Collections.emptyList(),Collections.emptyList()));
	}
}
