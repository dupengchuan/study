/**
 * @createtime: May 8, 2016 10:02:29 PM
 * @owner: kevin
 */
package kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        this.quickSort(nums, 0, nums.length-1);
        if(nums.length != 0){
        	this.subsets(res,nums,nums.length-1);
        }
        return res;
    }
	
	private void quickSort(int[] data, int p, int r){
		if(p < r){
			int mid = partition(data,p,r);
			quickSort(data,p,mid - 1);
			quickSort(data,mid+1,r);
		}
	}
	
	private int partition(int[] data, int p, int r){
		int i = p;
		while(p<=r){
			if(data[p] <= data[r]){
				int temp = data[i];
				data[i] = data[p];
				data[p] = temp;
				i++;
			}
			p++;
		}
		return i - 1;
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
