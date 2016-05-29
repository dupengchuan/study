/******************************************************************************
 * @file_name Solution342.java
 * @create_time Apr 24, 2016 2:46:04 AM
 * @package_name：dpc.leetcode
 * @project_name：leetcode
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package kevin.leetcode;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 24, 2016 2:46:04 AM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution342 {
  
  public boolean isPowerOfFour(int num) {
    if(num < 1){
      return false;
    }
    
    int count0 = 0;
    int count1 = 0;
    for(int i = 0; i < 32; i++){
      count1 += (num >> i)&0x01;
      if(count1 == 0){
        count0++;
      }
    }
    if(count1 != 1 || count0 % 2 != 0){
      return false;
    }else{
      return true;
    }
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution342 sollution = new Solution342();
  
    int i = 16;
    System.out.println(sollution.isPowerOfFour(i));
    
    i = 1;
    System.out.println(sollution.isPowerOfFour(i));
  
  }

}
