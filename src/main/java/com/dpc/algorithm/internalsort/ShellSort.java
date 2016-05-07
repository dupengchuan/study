/**
 * @createtime: May 7, 2016 6:39:27 PM
 * @owner: kevin
 */
package com.dpc.algorithm.internalsort;

import com.dpc.algorithm.inter.Sort;
import com.dpc.util.AlgorithmName;

/**
 * @author kevin
 * @version 1.1
 */
public class ShellSort implements Sort {

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#sort(int[])
	 */
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		//int increment = data.length / 100;
		int[] incres = new int[]{269,211,173,131,101,79,53,31,19,11,5,2};
		for(int increment : incres){
			for(int i = 0; i < increment; i++){
				for(int j = increment + i; j < data.length; j += increment){
					for(int k = i; k < j; k += increment){
						if(data[k] > data[j]){
							int temp = data[j];
							for(int m = j; m > k; m -= increment){
								data[m] = data[m - increment];
							}
							data[k] = temp;
						}
					}
				}
			}
		}
		return data;
	}

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return AlgorithmName.SHELL_SORT;
	}

}
