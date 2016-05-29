/******************************************************************************
 * @file_name BubleSortTest.java
 * @create_time Apr 23, 2016 1:34:15 PM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package kevin.algorithm.internalsort;

import org.junit.Test;

import kevin.algorithm.internalsort.SortFactory;
import kevin.util.AlgorithmUtil;

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
    public void testSortIntArray(){
      SortFactory.getBubleSort().sort(AlgorithmUtil.getRandomIntArray(4096));
    }
}
