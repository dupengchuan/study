/**
 * @createtime: May 7, 2016 8:32:59 PM
 * @owner: kevin
 */
package com.dpc.algorithm.internalsort;

import org.junit.Test;

import com.dpc.algorithm.inter.Sort;
import com.dpc.util.AlgorithmUtil;

/**
 * @author kevin
 * @version 1.1
 */
public class ShellSortTest {

	@Test
	public void testShellSort(){
		Sort sort = SortFactory.getShellSort();
		int[] data = AlgorithmUtil.getRandomIntArray(200000);
		//int[] data = AlgorithmUtil.getDescIntArray(1024);
		long start = System.currentTimeMillis();
		sort.sort(data);
		//PrintUtil.printIntArray(sort.sort(data));
		System.out.println(sort.getName() + " : " + (System.currentTimeMillis()-start));
	}
}
