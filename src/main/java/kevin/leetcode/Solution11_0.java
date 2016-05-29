package kevin.leetcode;

public class Solution11_0 {
	public int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int maxWater = -1;
		int water = -1;
		while(l < r){
			water = Math.min(height[l], height[r]) * (r - l);
			if(water > maxWater){
				maxWater = water;
			}
			if(height[l] < height[r]){
				l++;
			}else{
				r--;
			}
		}
		return maxWater;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
