/******************************************************************************
 * @file_name Solution.java
 * @create_time Apr 26, 2016 1:32:54 PM
 * @package_name：dpc.leetcode
 * @project_name：leetcode
 * Copyright © Beijing Congruence Technology Inc. 2016 
 *                    All Rights Reserved.
 * ****************************************************************************
 */

package dpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 * @function：
 * @author kevin
 * @date Apr 26, 2016 1:32:54 PM
 * @version 1.1
 * email:dupengchuan@gmail.com
 * ****************************************************************************
 * 修改人  修改时间  修改内容
 * 
 * ****************************************************************************
 */;
public class Solution257 {
  private static List<String> list = new ArrayList<String>();
  
  public List<String> binaryTreePaths(TreeNode root) {
    list.clear();
    if(root == null){
      return list;
    }
    this.recursive(root,root.val + "");
    return list;
  }
  
  private void recursive(TreeNode root,String path){
    if(root.left == null && root.right == null){
      list.add(path);
      return;
    }
    if(root.left != null){
      recursive(root.left,path+"->" + root.left.val);
    }
    if(root.right != null){
      recursive(root.right,path+"->" + root.right.val);
    }
    
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
  }

}

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x){
    this.val = x;
  }
}
