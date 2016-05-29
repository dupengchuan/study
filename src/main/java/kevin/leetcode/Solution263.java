/******************************************************************************
 * @file_name Solution.java
 * @create_time Apr 26, 2016 12:48:04 PM
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
 * @date Apr 26, 2016 12:48:04 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution263 {
  
  public boolean isUgly(int num) {
    if(num < 1){
      return false;
    }
  
    while(num%2==0){
      num /= 2;
    }
    while(num%3==0){
      num /= 3;
    }
    while(num%5==0){
      num /= 5;
    }
    if(num==1){
      return true;
    }else{
      return false;
    }
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution263 solution = new Solution263();
    System.out.println(solution.isUgly(6));
    System.out.println(solution.isUgly(8));
    System.out.println(solution.isUgly(1));
    System.out.println(solution.isUgly(4));
    System.out.println(solution.isUgly(14));
  }

}
