/**
 * @createtime: May 7, 2016 9:22:20 PM
 * @owner: kevin
 */
package kevin.algorithm.internalsort;

import kevin.algorithm.interfaces.Sort;
import kevin.util.AlgorithmName;

/**
 * @author kevin
 * @version 1.1
 */
public class MergeSort implements Sort {

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#sort(int[])
	 */
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		int[] res = new int[data.length];
		mergeSort(data,res,0,data.length-1);
		return res;
	}
	
	private void mergeSort(int[] data, int[] res, int start, int end){
		if(start >= end){
			return;
		}
		
		//sort
		int mid = start + ((end - start) >> 1);
		mergeSort(data,res,start,mid);
		mergeSort(data,res,mid+1,end);
		
		//merge
		int i = start;
		int j = mid + 1;
		int pos = start;
		while(i <= mid && j <= end){
			res[pos++] = data[i] < data[j] ? data[i++] : data[j++];
		}
		while(i <= mid){
			res[pos++] = data[i++];
		}
		while(j <= end){
			res[pos++] = data[j++];
		}
		
		for(int k = start; k <= end; k++){
			data[k] = res[k];
		}
	}

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return AlgorithmName.MERGE_SORT;
	}

}
