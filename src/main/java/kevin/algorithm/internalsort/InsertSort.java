/******************************************************************************
 * @file_name InsertSort.java
 * @create_time Apr 23, 2016 1:32:25 PM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package kevin.algorithm.internalsort;

import kevin.algorithm.interfaces.Sort;
import kevin.util.AlgorithmName;

/******************************************************************************
 * @function：
 * 
 * @author kevin
 * @date Apr 23, 2016 1:32:25 PM
 * @version 1.1 email:dupengchuan@gmail.com
 *          ********************************************************************
 *          ******** 修改人 修改时间 修改内容
 * 
 *          *
 * ***************************************************************************
 */
public class InsertSort implements Sort {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dpc.algorithm.Sort#sort(int[])
	 */
	public int[] sort(int[] data) {
		for(int i = 1; i < data.length; i++){
			for(int j = 0; j < i; j++){
				if(data[j] > data[i]){
					int temp = data[i];
					for(int p = i; p > j; p--){
						data[p] = data[p - 1];
					}
					data[j] = temp;
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
		return AlgorithmName.INSERT_SORT;
	}
}
