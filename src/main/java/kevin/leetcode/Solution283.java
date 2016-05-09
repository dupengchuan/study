/******************************************************************************
 * @file_name Solution.java
 * @create_time Apr 24, 2016 1:49:43 PM
 * @package_name：dpc.leetcode
 * @project_name：leetcode
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package kevin.leetcode;

import java.util.Arrays;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 24, 2016 1:49:43 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */
public class Solution283 {

  public void moveZeroes(int[] nums) {
      if(null == nums || 0 == nums.length){
        return;
      }
      
      for(int i = 0,j = -1; i < nums.length; i++){
        if(nums[i] == 0){
          if(j < i){
            j = i;
          }
          while(j < nums.length && nums[j] == 0){
            j++;
          }
          if(j != nums.length){
            nums[i] = nums[j];
            nums[j] = 0;
          }else{
            break;
          }
        }
      }
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] data = new int[]{4,2,4,0,0,3,0,5,1,0};
    Solution283 solution = new Solution283();
    solution.moveZeroes(data);
    System.out.println(Arrays.toString(data));
  }

}
