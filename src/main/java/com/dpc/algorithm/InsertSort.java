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

import java.util.List;

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
public abstract class InsertSort implements Sort{

  /* (non-Javadoc)
   * @see com.dpc.algorithm.Sort#sort(int[])
   */
  public int[] sort(int[] data, List<Integer> list ) {
    // TODO Auto-generated method stub
    list.add(data[0]);
    for(int i = 1; i < data.length; i++){
      for(Integer e : list){
        int index = list.indexOf(e);
        if(data[i] > e){
          if(index + 1 == list.size()){
            list.add(index + 1,data[i]);
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
}
