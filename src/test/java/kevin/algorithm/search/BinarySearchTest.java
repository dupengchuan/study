/**
 * @createtime: May 8, 2016 3:01:59 PM
 * @owner: kevin
 */
package kevin.algorithm.search;

import org.junit.Assert;
import org.junit.Test;

import kevin.algorithm.interfaces.Search;
import kevin.algorithm.search.SearchFactory;
import kevin.util.AlgorithmUtil;

/**
 * @author kevin
 * @version 1.1
 */
public class BinarySearchTest {
	@Test
	public void testSearch(){
		int[] data = AlgorithmUtil.getAscIntArray(1024);
		Search search = SearchFactory.getBinarySearch();
		Assert.assertTrue(search.search(data, 0));
		Assert.assertTrue(search.search(data, 1023));
		Assert.assertTrue(search.search(data, 512));
	}
}
