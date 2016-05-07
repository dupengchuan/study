/**
 * @createtime: May 7, 2016 5:26:27 PM
 * @owner: kevin
 */
package com.dpc.algorithm.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.dpc.algorithm.inter.Sort;
import com.dpc.algorithm.internalsort.SortFactory;
import com.dpc.util.AlgorithmUtil;

/**
 * @author kevin
 * @version 1.1
 */
public class SortTest {
	@Test
	public void testSort() {
		Logger logger = Logger.getLogger(getClass());
		int length = 200000;
		int[] data = AlgorithmUtil.getRandomIntArray(length);
		int[] temp = new int[length];
		long start;

		System.arraycopy(data, 0, temp, 0, data.length);
		start = System.currentTimeMillis();
		Sort heapSort = SortFactory.getHeapSort();
		heapSort.sort(temp);
		logger.debug(heapSort.getName() + " : " + (System.currentTimeMillis() - start));

		System.arraycopy(data, 0, temp, 0, data.length);
		start = System.currentTimeMillis();
		Sort quickSort = SortFactory.getQuickSort();
		quickSort.sort(temp);
		logger.debug(quickSort.getName() + " : " + (System.currentTimeMillis() - start));

		System.arraycopy(data, 0, temp, 0, data.length);
		start = System.currentTimeMillis();
		Sort mergeSort = SortFactory.getMergeSort();
		mergeSort.sort(temp);
		logger.debug(mergeSort.getName() + " : " + (System.currentTimeMillis() - start));

		System.arraycopy(data, 0, temp, 0, data.length);
		start = System.currentTimeMillis();
		Sort binaryInsertSort = SortFactory.getBinaryInsertSort();
		binaryInsertSort.sort(temp);
		logger.debug(binaryInsertSort.getName() + " : " + (System.currentTimeMillis() - start));

		System.arraycopy(data, 0, temp, 0, data.length);
		start = System.currentTimeMillis();
		Sort bubleSort = SortFactory.getBubleSort();
		bubleSort.sort(temp);
		logger.debug(bubleSort.getName() + " : " + (System.currentTimeMillis() - start));

		System.arraycopy(data, 0, temp, 0, data.length);
		start = System.currentTimeMillis();
		Sort shellSort = SortFactory.getShellSort();
		shellSort.sort(temp);
		logger.debug(shellSort.getName() + " : " + (System.currentTimeMillis() - start));

		System.arraycopy(data, 0, temp, 0, data.length);
		Sort insertSort = SortFactory.getInsertSort();
		start = System.currentTimeMillis();
		insertSort.sort(temp);
		logger.debug(insertSort.getName() + " : " + (System.currentTimeMillis() - start));
	}
}
