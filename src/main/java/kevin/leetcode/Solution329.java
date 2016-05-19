/**
 * @author kevin
 * @create_time: 2016 May 12, 2016 9:47:53 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution329 {
	public int longestIncreasingPath(int[][] matrix) {
		
		if(null == matrix || matrix.length == 0){
			return 0;
		}
		int[][] storage = new int[matrix.length][matrix[0].length];
		int res = -1;
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		if(storage[i][j] == 0){
        			res = Math.max(res,recurse(matrix,i,j,storage,matrix[i][j] + 1));
        		}
        	}
        }
        return res;
    }
	
	private int recurse(int[][] matrix,int i1,int j1,int[][] storage,int former){
		
		if(i1 < 0 || j1 <0 || i1 == matrix.length || j1 == matrix[0].length || matrix[i1][j1] >= former){
			return 0;
		}
		
		if(storage[i1][j1] != 0){
			return storage[i1][j1];
		}
		
		//up
		int x = i1 -1;
		int y = j1;
		int up = recurse(matrix,x,y,storage,matrix[i1][j1]);
		
		//down
		x = i1 + 1;
		y = j1;
		int down = recurse(matrix,x,y,storage,matrix[i1][j1]);
		
		//left
		x = i1;
		y = j1 - 1;
		int left = recurse(matrix,x,y,storage,matrix[i1][j1]);
		
		//right
		x = i1;
		y = j1 + 1;
		int right = recurse(matrix,x,y,storage,matrix[i1][j1]);
		
		storage[i1][j1] = Math.max(Math.max(up,down), Math.max(left,right)) + 1;
		return storage[i1][j1];
	}
	
	public static void main(String[] args){
		int[][] nums = new int[][]{
			{7,8,9},
			{9,7,6},
			{7,2,3}
		};
		
		Solution329 solution = new Solution329();
		solution.longestIncreasingPath(nums);
	}
}
