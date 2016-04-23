/******************************************************************************
 * @file_name InsertSortTest.java
 * @create_time Apr 24, 2016 12:51:34 AM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.algorithm;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.dpc.factory.SortFactory;
import com.dpc.util.AlgorithmUtil;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 24, 2016 12:51:34 AM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class LinkedListInsertSortTest {
    @Test
    public void testSortIntArray(){
      Logger logger = Logger.getLogger(getClass());
      long start = System.currentTimeMillis();
      int[] data = AlgorithmUtil.getDescIntArray(200000);
      SortFactory.getInsertSort(0).sort(data);
      logger.debug("used time: " + (System.currentTimeMillis()-start));
      
      start = System.currentTimeMillis();
      data = AlgorithmUtil.getDescIntArray(200000);
      SortFactory.getInsertSort(1).sort(data);
      logger.debug("used time: " + (System.currentTimeMillis()-start));
    }
}
