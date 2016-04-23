/******************************************************************************
 * @file_name AlgorithmUtil.java
 * @create_time Apr 23, 2016 11:59:44 PM
 * @package_name：com.dpc.util
 * @project_name：algorithm Copyright © Beijing Congruence Technology Inc. 2016 All Rights Reserved.
 *                         *
 * ***************************************************************************
 */

package com.dpc.util;

import java.util.Random;

/******************************************************************************
 * @function：
 * 
 * @author kevin
 * @date Apr 23, 2016 11:59:44 PM
 * @version 1.1 email:dupengchuan@gmail.com
 *          **************************************************************************** 修改人 修改时间
 *          修改内容
 * 
 *          ****************************************************************************
 */
public class AlgorithmUtil {
  
  /**
   * get a int array 
   * 
   * @param len 
   * @return
   */
  public static int[] getRandomIntArray(int len) {
    Random random = new Random();
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      res[i] = random.nextInt();
    }

    return res;
  }
  
  /**
   * ASC int array ,the begin is 0
   * @param len
   * @return
   */
  public static int[] getAscIntArray(int len){
    int[] res = new int[len];
    for(int i = 0; i < len; i++){
      res[i] = i;
    }
    
    return res;
  }

  /**
   * 
   * @param len
   * @return int array desc
   */
  public static int[] getDescIntArray(int len){
    int[] res = new int[len];
    int temp = len - 1;
    for(int i = 0; i < len; i++){
      res[i] = temp - i;
    }
    
    return res;
  }
}
