/**
 * @createtime: May 7, 2016 9:52:12 PM
 * @owner: kevin
 */
package com.dpc.algorithm.internalsort;

import org.junit.Test;

import com.dpc.algorithm.inter.Sort;
import com.dpc.util.PrintUtil;

/**
 * @author kevin
 * @version 1.1
 */
public class MergeSortTest {
	
	@Test
	public void testSort(){
		//int[] data = AlgorithmUtil.getDescIntArray(1024);
		int[] data = new int[]{2,1,3};
		Sort mergeSort = SortFactory.getMergeSort();
		PrintUtil.printIntArray(mergeSort.sort(data));
	}
}
