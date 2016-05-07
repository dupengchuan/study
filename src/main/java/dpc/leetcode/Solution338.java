/**
 * @createtime: May 7, 2016 11:32:12 AM
 * @owner: kevin
 */
package dpc.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution338 {

	private int[] array = new int[1000000];
	private int pos = 0;
	
	public int[] countBits(int num) {
        if(num > pos){
        	for(;pos <= num;pos++){
        		array[pos] = countBit(pos);
        	}
        }
        int[] res = new int[num + 1];
        System.arraycopy(array, 0, res, 0, num + 1);
        return res;
    }
	
	private int countBit(int num){
		int count = 0;
		for(int i = 0; i < 32; i++){
			count += (num >> i)&0x01;
		}
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
