/******************************************************************************
 * @file_name BubleSort.java
 * @create_time Apr 23, 2016 12:46:50 PM
 * @package_name：com.dpc.internal
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.algorithm;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 23, 2016 12:46:50 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class BubleSort implements Sort {

  /* (non-Javadoc)
   * @see com.dpc.internal.Sort#sort(byte[])
   */
  public byte[] sort(byte[] data) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.dpc.internal.Sort#sort(short[])
   */
  public short[] sort(short[] data) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.dpc.internal.Sort#sort(int[])
   */
  public int[] sort(int[] data) {
    // TODO Auto-generated method stub
    int temp;
    int j;
    for(int i = data.length-1; i > 0;i-- ){
        j = i;
        while( j < data.length && data[j-1] > data[j]){
          temp = data[j-1];
          data[j-1] = data[j];
          data[j] = temp;
          j++;
        }
    }
    return data;
  }

  /* (non-Javadoc)
   * @see com.dpc.internal.Sort#sort(long[])
   */
  public long[] sort(long[] data) {
    // TODO Auto-generated method stub
    return null;
  }

}
