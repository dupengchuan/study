/******************************************************************************
 * @file_name Solution.java
 * @create_time Apr 26, 2016 1:22:07 PM
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
 * @date Apr 26, 2016 1:22:07 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution258 {
  public int addDigits(int num) {
    String str;
    while((str=Integer.toString(num)).length() != 1){
      num = 0;
      for(int i = 0; i < str.length(); i++){
        num += str.charAt(i) - '0';
      }
    }
    return str.charAt(0) - '0';
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution258 solution = new Solution258();
    System.out.println(solution.addDigits(38));
    System.out.println(solution.addDigits(2));
    
  }
}
