/******************************************************************************
 * @file_name PrintUtil.java
 * @create_time Apr 23, 2016 1:38:28 PM
 * @package_name：com.dpc.util
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.util;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 23, 2016 1:38:28 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class PrintUtil {
    private static int width = 16;
    public static void printIntArray(int[] data){
      if(null == data || data.length == 0){
        return;
      }
      
      for(int i = 0;i < data.length;i++){
        if(i % width == 0){
          System.out.println("");
        }
        System.out.print(data[i] + " ");
      }
    }
}
