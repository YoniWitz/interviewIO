package hw0104;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import introImpl.FindKSmallestInArrayFirst;


public class SelectionAlgorithmTests {
	@Test
	public void testSwap() {
		int[] a = { 1, 2 };
		FindKSmallestInArrayFirst.swap(a, 0, 1);
		assertTrue(a[0] == 2);
	}

	@Test
	public void testPartition() {
		int[] beforePartition = { 2, 4, 1, 4, 7, 3, 9 };
		int[] afterPartition = { 3, 2, 1, 4, 4, 7, 9 };
		int index = 1;
		FindKSmallestInArrayFirst.partition(beforePartition, index);
		for (int i = 0; i < beforePartition.length; i++) {
			assertEquals(beforePartition[i], afterPartition[i]);
		}
	}

	@Test
	public void testKThSmallest() {
		int[] beforePartition = { 5, 7, 4, 6, 5, 3, 3 };
		int k = 3;
		assertEquals(4, FindKSmallestInArrayFirst.kThSmallestHelper(beforePartition, k));
	}
}
