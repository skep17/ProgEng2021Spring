
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	public void testCharArea3(){
		char[][] grid = new char[][] {
				{'t','e','s','t'},
				{'c','h','a','r'},
				{'a','r','e','a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('q'));
		assertEquals(0,cg.charArea(' '));
	}

	public void testPlus1(){
		char[][] grid = new char[][] {
				{'t','e','s','t',' '},
				{' ','h',' ','r',' '},
				{'a','r','e','a','l'},
				{' ','r',' ','a',' '},
				{'a',' ','e','a',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0,cg.countPlus());
	}

	public void testPlus2(){
		char[][] grid = new char[][] {
				{' ',' ','s',' ',' ',' ',' ',' ',' '},
				{' ',' ','s',' ',' ',' ',' ','i',' '},
				{'s','s','s','s','s',' ','i','i','i'},
				{' ',' ','s',' ',' ','j',' ','i',' '},
				{' ',' ','s',' ','j','j','j',' ',' '},
				{'k','k','k','k','k','j','k','k','k'},
				{' ',' ','i','i',' ','j',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(2,cg.countPlus());
	}

	public void testPlus3(){
		char[][] grid = new char[][] {
				{' ',' ','s',' ',' ',' ',' ',' ',' '},
				{' ',' ','s',' ',' ',' ',' ','i',' '},
				{'s','s','s','s','s',' ','i','i','i'},
				{' ',' ','s',' ',' ','j',' ','i',' '},
				{' ',' ','s',' ','j','j','j',' ',' '},
				{'k','k','k','k','k','j','k','k','k'},
				{' ',' ','i','i',' ','i',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(3,cg.countPlus());
	}

	public void testPlus4(){
		char[][] grid = new char[][] {
				{' ',' ','s',' ',' ',' ',' ',' ',' '},
				{' ',' ','s',' ',' ',' ',' ','i',' '},
				{'s','s','l','s','s',' ','i','l','i'},
				{' ',' ','s',' ',' ','j',' ','i',' '},
				{' ',' ','s',' ','j','l','j',' ',' '},
				{'k','k','k','k','k','j','k','k','k'},
				{' ',' ','i','i',' ','i',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0,cg.countPlus());
	}

	public void testPlus5(){
		char[][] grid = new char[][] {
				{' ','+',' '},
				{'+','+','+'},
				{' ','+',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1,cg.countPlus());
	}

	public void testPlus6(){
		char[][] grid = new char[][] {
				{' ','+'},
				{'+','+'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0,cg.countPlus());
	}
	
}
