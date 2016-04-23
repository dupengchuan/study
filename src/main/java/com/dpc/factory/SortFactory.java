/******************************************************************************
 * @file_name SortFactory.java
 * @create_time Apr 23, 2016 12:58:05 PM
 * @package_name：com.dpc.internal
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.factory;

import com.dpc.algorithm.ArrayListInsertSort;
import com.dpc.algorithm.BubleSort;
import com.dpc.algorithm.LinkedListInsertSort;
import com.dpc.algorithm.Sort;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 23, 2016 12:58:05 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class SortFactory {
  
  public static Sort getBubleSort(){
    return new BubleSort();
  }
  
  public static Sort getInsertSort(int type){
    if(type == 0){
      return new LinkedListInsertSort();
    }
    if(type == 1){
      return new ArrayListInsertSort();
    }
    return null;
  }

}
