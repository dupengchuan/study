/**
 * @createtime: May 7, 2016 9:52:12 PM
 * @owner: kevin
 */
package kevin.algorithm.internalsort;

import org.junit.Test;

import kevin.algorithm.interfaces.Sort;
import kevin.algorithm.internalsort.SortFactory;
import kevin.util.PrintUtil;

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
