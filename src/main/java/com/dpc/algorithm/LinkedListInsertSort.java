/******************************************************************************
 * @file_name InsertSort.java
 * @create_time Apr 23, 2016 1:32:25 PM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.algorithm;

import java.util.LinkedList;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 23, 2016 1:32:25 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class LinkedListInsertSort implements Sort {

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
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addLast(data[0]);
    for(int i = 1; i < data.length; i++){
      for(Integer e : list){
        int index = list.indexOf(e);
        if(data[i] > e){
          if(index + 1 == list.size()){
            list.addLast(data[i]);
            break;
          }
          continue;
        }else{
          list.add(index,data[i]);
          break;
        }
      }
    }
    
    int i = 0;
    for(Integer e : list){
      data[i++] = e;
    }
    return data;
  }

  /* (non-Javadoc)
   * @see com.dpc.algorithm.Sort#sort(long[])
   */
  public long[] sort(long[] data) {
    // TODO Auto-generated method stub
    return null;
  }

}
