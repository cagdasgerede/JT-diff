package jtdiff.util.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

/**
 * 
 * Tests <code>ancestorIterator</code> method of <code>Tree</code> class
 *
 */
public class TestAncestorIterator extends TestTree {
	private Integer[] toArray(ArrayList<Integer> arrayList) {
		return arrayList.toArray(new Integer[arrayList.size()]);
	}
	
	/**
	 * Iterate from intermediate or leaf nodes upwards
	 */
	@Test
	public void testSuccess() {
		
		ArrayList<Integer> ancestorPreorderPositions = new ArrayList<>();
		Iterator<Integer> iterator = treeTwo.ancestorIterator(4);
		while(iterator.hasNext()) {
			ancestorPreorderPositions.add(iterator.next());
		}
		Integer[] expected = new Integer[] {4, 3, 1};
		assertArrayEquals(expected, toArray(ancestorPreorderPositions));
		
		ancestorPreorderPositions = new ArrayList<>();
		iterator = treeTwo.ancestorIterator(2);
		while(iterator.hasNext()) {
			ancestorPreorderPositions.add(iterator.next());
		}
		expected = new Integer[] {2, 1};
		assertArrayEquals(expected, toArray(ancestorPreorderPositions));		
	}
	
	/**
	 * Iterating from the root upwards
	 */
	@Test
	public void testFromTheRoot() {
		ArrayList<Integer> ancestorPreorderPositions = new ArrayList<>();
		Iterator<Integer> iterator = treeTwo.ancestorIterator(1);
		while(iterator.hasNext()) {
			ancestorPreorderPositions.add(iterator.next());
		}
		Integer[] expected = new Integer[] {1};
		assertArrayEquals(expected, toArray(ancestorPreorderPositions));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFromNonExistingPosition() {
		
		Iterator<Integer> iterator = treeTwo.ancestorIterator(100);
		while(iterator.hasNext()) {
			fail("Should not return anyhting");
		}
	}
}
