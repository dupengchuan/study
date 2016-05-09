/**
 * @createtime: May 7, 2016 2:32:47 PM
 * @owner: kevin
 */
package kevin.algorithm.internalsort;

import org.junit.Test;

import kevin.algorithm.internalsort.SortFactory;
import kevin.util.AlgorithmUtil;
import kevin.util.PrintUtil;

/**
 * @author kevin
 * @version 1.1
 */
public class HeapSortTest {
	@Test
	public void testSort(){
//		int[] data = AlgorithmUtil.getRandomIntArray(1000);
		int[] data = AlgorithmUtil.getDescIntArray(1024);
		data = SortFactory.getBubleSort().sort(data);
		PrintUtil.printIntArray(data);
	}
}
