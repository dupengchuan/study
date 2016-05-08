/**
 * @createtime: May 8, 2016 11:25:13 AM
 * @owner: kevin
 */
package dpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution22 {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		generate(res,n,n,"");
		return res;
    }

	private void generate(List<String> list,int left,int right,String s){
		if(left > right ){
			return;
		}
		
		if(left == 0 && right == 0){
			list.add(s);
		}
		
		if(left > 0){
			generate(list,left-1,right,s+"(");
		}
		if(right > 0){
			generate(list,left,right-1,s+")");
		}
	}
}
