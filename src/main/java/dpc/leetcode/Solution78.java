/**
 * @createtime: May 8, 2016 10:02:29 PM
 * @owner: kevin
 */
package dpc.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length != 0){
        	this.subsets(res,nums,nums.length-1);
        }
        for(int i = 0; i < res.size(); i++){
        	res.get(i).sort(new Compares());
        }
        return res;
    }
	
	private void subsets(List<List<Integer>> res,int[] nums,int n){
		if(n == 0){
			List<Integer> list = new ArrayList<Integer>();
			List<Integer> empty = new ArrayList<Integer>();
			list.add(nums[0]);
			res.add(empty);
			res.add(list);
			return;
		}
		subsets(res,nums,n-1);
		int len = res.size();
		for(int i = 1; i < len; i++){
			List<Integer> list = new ArrayList<Integer>(res.get(i));
			list.add(nums[n]);
			res.add(list);
		}
		List<Integer> l = new ArrayList<Integer>();
		l.add(nums[n]);
		res.add(l);
	}
	
	public static void main(String[] args){
		int[] data = new int[]{0};
		Solution78 solution = new Solution78();
		solution.subsets(data);
	}
}
class Compares implements Comparator<Integer>{
	public int compare(Integer a, Integer b){
		return a - b;
	}
}
