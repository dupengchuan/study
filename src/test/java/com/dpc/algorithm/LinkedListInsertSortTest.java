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

import org.junit.Test;

import com.dpc.factory.SortFactory;
import com.dpc.util.AlgorithmUtil;
import com.dpc.util.PrintUtil;

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
      int[] data = AlgorithmUtil.getDescIntArray(2048);
      SortFactory.getLinkedListInsertSort().sort(data);
      PrintUtil.printIntArray(data);
    }
}
