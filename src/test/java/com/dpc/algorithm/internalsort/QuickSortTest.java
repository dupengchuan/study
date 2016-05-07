/**
 * @createtime: May 7, 2016 4:56:18 PM
 * @owner: kevin
 */
package com.dpc.algorithm.internalsort;

import org.junit.Test;

import com.dpc.algorithm.internalsort.SortFactory;
import com.dpc.util.AlgorithmUtil;
import com.dpc.util.PrintUtil;

/**
 * @author kevin
 * @version 1.1
 */
public class QuickSortTest {
	@Test
	public void testSort(){
//		int[] data = new int[]{2,3,4,1,5,6};
		int[] data = AlgorithmUtil.getRandomIntArray(200000);
		PrintUtil.printIntArray(SortFactory.getQuickSort().sort(data));
	}
}
