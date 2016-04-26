/******************************************************************************
 * @file_name Solution.java
 * @create_time Apr 26, 2016 11:53:11 PM
 * @package_name：dpc.leetcode
 * @project_name：leetcode
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package dpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 26, 2016 11:53:11 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution345 {
  public static Set<Character> set = new HashSet<Character>();
  
  static{
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');
  }
  
  public String reverseVowels(String s) {
    if(null == s || s.isEmpty()){
      return s;
    }
    char[] c = new char[s.length()];
    for(int i = 0,j = s.length() - 1; i <= j;){
      while(i < j && !set.contains(s.charAt(i))){
        c[i] = s.charAt(i);
        i++;
      }
      while(i < j && !set.contains(s.charAt(j))){
        c[j] = s.charAt(j);
        j--;
      }
      if(i < j){
        c[i] = s.charAt(j);
        c[j] = s.charAt(i);
        i++;
        j--;
      }else{
        c[i] = s.charAt(i);
        break;
      }
    }
    
    return new String(c);
  }
  
  public static void main(String[] srgs){
     Solution345 solution = new Solution345();
   
     System.out.println(solution.reverseVowels("leetcode"));
     System.out.println(solution.reverseVowels(" "));
     System.out.println(solution.reverseVowels("a."));
  }
}
