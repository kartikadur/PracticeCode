import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class NodeListTest {
	
	@Test
	public void testNodeList() {
		NodeList n = new NodeList();
		assertTrue(n.isEmpty());
		assertEquals(n.size(), 0);
	}
	
	@Test
	public void testAddVal() {
		NodeList n = new NodeList();

		assertEquals("Size when empty", 0, n.size());
		assertEquals("Size when empty", true, n.isEmpty());
		
		assertEquals("Adding 3", 3, n.add(3));
		assertEquals("Size when empty", 1, n.size());
		//System.out.println(n.toString());
		
		assertEquals("Adding 1", 1, n.add(1));
		assertEquals("Size when empty", 2, n.size());
		//System.out.println(n.toString());
		
		assertEquals("Adding 3", 3, n.add(3));
		assertEquals("Size when empty", 3, n.size());
		//System.out.println(n.toString());
		
		assertEquals("Adding 2", 2, n.add(2));
		assertEquals("Size when empty", 4, n.size());
		//System.out.println(n.toString());
		
		assertEquals("Adding 2", 2, n.add(2));
		assertEquals("Size when empty", 5, n.size());
		//System.out.println(n.toString());
		
		assertEquals("Adding 4", 4, n.add(4));
		assertEquals("Size when empty", 6, n.size());
		//System.out.println(n.toString());
	}
	
	@Test
	public void testRemVal() {
		NodeList n = new NodeList();
		
		assertEquals("Size when empty", 0, n.size());
		assertEquals("Size when empty", true, n.isEmpty());
		
		assertEquals("removing from empty list", -1, n.rem(4));
		
		n.add(1);
		n.add(2);
		n.add(2);
		n.add(3);
		n.add(3);
		n.add(5);
		
		assertEquals("Size when empty", 6, n.size());
		
		assertEquals("removing from list a number that does not exist", 2, n.rem(2));
		assertEquals("Size when empty", 5, n.size());
		//System.out.println(n.toString());
		
		assertEquals("removing from list a number that does not exist", 1, n.rem(1));
		assertEquals("Size when empty", 4, n.size());
		//System.out.println(n.toString());
		
		assertEquals("removing from list a number that does not exist", 5, n.rem(5));
		assertEquals("Size when empty", 3, n.size());
		//System.out.println(n.toString());
	}
	
	@Test public void testMedianVal() {
		NodeList n = new NodeList();
		
		assertEquals("Size when empty", 0, n.size());
		assertEquals("Size when empty", true, n.isEmpty());
		
		n.add(1);
		assertEquals("Median for 1 entry", "1", n.median());
		n.add(2);
		assertEquals("Median for 2 entries", "1.5", n.median());
		n.add(2);
		assertEquals("Median for 2 entries", "2", n.median());
		n.add(3);
		assertEquals("Median for 2 entries", "2", n.median());
		n.add(3);
		assertEquals("Median for 2 entries", "2", n.median());
		n.add(5);
		assertEquals("Median for 2 entries", "2.5", n.median());
	}
	
	@Test public void testCase1() {

		NodeList n = new NodeList();
		
		System.out.println(n.median());
	}
}
