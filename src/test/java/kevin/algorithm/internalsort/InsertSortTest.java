/******************************************************************************
 * @file_name InsertSortTest.java
 * @create_time Apr 24, 2016 12:51:34 AM
 * @package_name：com.dpc.algorithm
 * @project_name：algorithm
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package kevin.algorithm.internalsort;

import org.apache.log4j.Logger;
import org.junit.Test;

import kevin.algorithm.internalsort.SortFactory;
import kevin.util.AlgorithmUtil;

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
public class InsertSortTest {
    @Test
    public void testSortIntArray(){
      Logger logger = Logger.getLogger(getClass());
      long start = System.currentTimeMillis();
      int[] data = AlgorithmUtil.getRandomIntArray(200000);
      SortFactory.getInsertSort().sort(data);
      logger.debug("used time: " + (System.currentTimeMillis()-start));
      
      start = System.currentTimeMillis();
      data = AlgorithmUtil.getRandomIntArray(200000);
      SortFactory.getBinaryInsertSort().sort(data);
      logger.debug("used time: " + (System.currentTimeMillis()-start));
    }
}
