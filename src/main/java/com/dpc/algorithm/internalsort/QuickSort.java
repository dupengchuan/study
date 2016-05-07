/**
 * @createtime: May 7, 2016 4:01:26 PM
 * @owner: kevin
 */
package com.dpc.algorithm.internalsort;

import com.dpc.algorithm.inter.Sort;
import com.dpc.util.AlgorithmName;

/**
 * @author kevin
 * @version 1.1
 */
public class QuickSort implements Sort{

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#sort(int[])
	 */
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		quickSort(data,0,data.length-1);
		return data;
	}
	
	private void quickSort(int[] data, int p, int r){
		if(p < r){
			int mid = partition(data,p,r);
			quickSort(data,p,mid - 1);
			quickSort(data,mid+1,r);
		}
	}
	
	private int partition(int[] data, int p, int r){
		int i = p;
		while(p<=r){
			if(data[p] <= data[r]){
				int temp = data[i];
				data[i] = data[p];
				data[p] = temp;
				i++;
			}
			p++;
		}
		return i - 1;
	}

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return AlgorithmName.QUICK_SORT;
	}

}
