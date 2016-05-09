/**
 * @createtime: May 7, 2016 8:32:59 PM
 * @owner: kevin
 */
package kevin.algorithm.internalsort;

import org.junit.Test;

import kevin.algorithm.interfaces.Sort;
import kevin.algorithm.internalsort.SortFactory;
import kevin.util.AlgorithmUtil;

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
