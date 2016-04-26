/******************************************************************************
 * @file_name Solution.java
 * @create_time Apr 24, 2016 7:25:30 AM
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
 * @date Apr 24, 2016 7:25:30 AM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution299 {
  
  public String getHint(String secret, String guess) {
    int countBulls = 0;
    int countCows = 0;
    int[] count = new int[10];
    for(int i = 0; i < secret.length(); i++){
      if(secret.charAt(i) == guess.charAt(i)){
          countBulls++;
      }else{
          count[secret.charAt(i) - '0']++;
          if(count[secret.charAt(i) - '0'] <= 0){
            countCows++;
          }
          count[guess.charAt(i) - '0']--;
          if(count[guess.charAt(i) - '0'] >= 0){
            countCows++;
          }
      }
    }
    
    return countBulls + "A" + countCows + "B";
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution299 solution = new Solution299();
    String secret = "1234";
    String guess = "0111";
    System.out.println(solution.getHint(secret, guess));
    
    secret = "11";
    guess = "11";
    System.out.println(solution.getHint(secret, guess));
  }

}

/*
 
 */
