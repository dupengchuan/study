/**
 * @author kevin
 * @create_time: 2016 May 17, 2016 10:54:34 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution121 {
	public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0){
        	return 0;
        }
        int low = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] < low){
        		low = prices[i];
        	}else{
        		if(prices[i] - low > res){
        			res = prices[i] - low;
        		}
        	}
        }
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
