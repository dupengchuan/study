/**
 * @createtime: May 7, 2016 2:57:30 PM
 * @owner: kevin
 */
package kevin.algorithm.internalsort;

import kevin.algorithm.interfaces.Sort;
import kevin.util.AlgorithmName;

/**
 * @author kevin
 * @version 1.1
 */
public class BinaryInsertSort implements Sort{

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#sort(int[])
	 */
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		for(int i = 1; i < data.length; i++){
			
			//search the pos
			int start = 0;
			int end = i;
			while(start < end){
				int mid = (start + end)/2;
				if(data[mid] <= data[i]){
					start = mid + 1;
				}else if(data[mid] > data[i]){
					end = mid - 1;
				}
			}
			
			// move the element
			int temp = data[i];
			for(int p = i; p > start; p--){
				data[p] = data[p-1];
			}
			
			//replace
			data[start] = temp;
		}
		
		
		return data;
	}

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return AlgorithmName.BINARY_INSER_SORT;
	}

}
