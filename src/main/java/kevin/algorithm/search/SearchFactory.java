/**
 * @createtime: May 8, 2016 3:03:14 PM
 * @owner: kevin
 */
package kevin.algorithm.search;

import kevin.algorithm.interfaces.Search;

/**
 * @author kevin
 * @version 1.1
 */
public class SearchFactory {
	public static Search getBinarySearch(){
		return new BinarySearchSortedArray();
	}
}
