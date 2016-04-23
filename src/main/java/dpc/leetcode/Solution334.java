/******************************************************************************
 * @file_name Solution334.java
 * @create_time Apr 24, 2016 2:32:07 AM
 * @package_name：dpc.leetcode
 * @project_name：leetcode
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package dpc.leetcode;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 24, 2016 2:32:07 AM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution334 {
  
    public String reverseString(String s) {
      if(null == s || s.isEmpty()){
        return s;
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i = s.length() - 1; i > -1; i--){
        sb.append(s.charAt(i));
      }
      
      return sb.toString();
    }
    public static void main(String[] args){
      Solution334 solution = new Solution334();
      String s = "hello world!";
      System.out.println(solution.reverseString(s));
    }
}
