/******************************************************************************
 * @file_name ArrayListInsertSort.java
 * @create_time Apr 24, 2016 1:14:36 AM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.algorithm;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 24, 2016 1:14:36 AM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class ArrayListInsertSort extends InsertSort {

  /* (non-Javadoc)
   * @see com.dpc.algorithm.Sort#sort(byte[])
   */
  public byte[] sort(byte[] data) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.dpc.algorithm.Sort#sort(short[])
   */
  public short[] sort(short[] data) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.dpc.algorithm.Sort#sort(int[])
   */
  public int[] sort(int[] data) {
    // TODO Auto-generated method stub
    if(null == data || data.length == 0){
      return null;
    }
    List<Integer> list = new ArrayList<Integer>();
    return super.sort(data, list);
  }

  /* (non-Javadoc)
   * @see com.dpc.algorithm.Sort#sort(long[])
   */
  public long[] sort(long[] data) {
    // TODO Auto-generated method stub
    return null;
  }

}
