/**
 * @createtime: May 7, 2016 3:21:50 PM
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
public class BinaryInsertSortTest {
	@Test
	public void testSort(){
		int[] data = AlgorithmUtil.getRandomIntArray(1024);
		//int[] data = AlgorithmUtil.getAscIntArray(1024);
		PrintUtil.printIntArray(SortFactory.getBinaryInsertSort().sort(data));
	}
}
