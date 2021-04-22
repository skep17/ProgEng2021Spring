// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

public class TabooTest extends TestCase {
    public void testNoFollow1(){
        Taboo<String> tb = new Taboo<String>(Arrays.asList("a","c","a","b"));

        Set<String> test = new HashSet<String>();
        test.add("c");
        test.add("b");

        assertEquals(test,tb.noFollow("a"));
        assertEquals(Collections.emptySet(),tb.noFollow("j"));
    }

    public void testNoFollow2(){
        Taboo<String> tb = new Taboo<String>(Collections.emptyList());

        assertEquals(Collections.emptySet(),tb.noFollow("j"));
    }

    public void testReduce1(){
        Taboo<String> tb = new Taboo<String>(Arrays.asList("a","c","a","b"));
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("c");
        test.add("b");
        test.add("x");
        test.add("c");
        test.add("a");
        tb.reduce(test);
        assertEquals(Arrays.asList("a","x","c"),test);
    }

    public void testReduce2(){
        Taboo<String> tb = new Taboo<String>(Arrays.asList("a","c","a","b"));
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("x");
        test.add("b");
        test.add("x");
        test.add("c");
        test.add("b");
        tb.reduce(test);
        assertEquals(Arrays.asList("a","x","b","x","c","b"),test);
    }

    public void testReduce3(){
        Taboo<String> tb = new Taboo<String>(Arrays.asList("a","c","a","b"));
        List<String> test = new ArrayList<>();
        tb.reduce(test);
        assertEquals(Collections.emptyList(),test);
    }

    public void testReduce4(){
        Taboo<String> tb = new Taboo<String>(Collections.emptyList());
        List<String> test = new ArrayList<>();
        tb.reduce(test);
        assertEquals(Collections.emptyList(),test);
    }
}
