/******************************************************************************
 * @file_name BubleSortTest.java
 * @create_time Apr 23, 2016 1:34:15 PM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package com.dpc.algorithm;

import org.junit.Test;

import com.dpc.util.AlgorithmUtil;
import com.dpc.util.PrintUtil;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 23, 2016 1:34:15 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class BubleSortTest {
    @Test
    public void testSort(){
      int[] data = SortFactory.getBubleSort().sort(AlgorithmUtil.getRandomIntArray(4096));
      //PrintUtil.printIntArray(data);
    }
}
