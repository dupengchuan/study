package kevin.leetcode;

public class Solution12 {
	
	private char[] pre = new char[]{'I','X','C','M'};
	private char[] later = new char[]{'V','L','D'};
	
	public String intToRoman(int num) {
        
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4 && num != 0; i++){
			sb.insert(0,this.getStrBuff(num % 10,i));
			num /= 10;
		}
		return sb.toString();
    }
	
	private StringBuffer getStrBuff(int n, int weight){
		StringBuffer sb = new StringBuffer();
		if(n == 1 || n == 2 || n == 3){
			for(int i = 0; i < n; i++){
				sb.append(pre[weight]);
			}
			return sb;
		}
		if(n == 4){
			sb.append(pre[weight]);
			sb.append(later[weight]);
			return sb;
		}
		if(n == 5 || n == 6 || n == 7 || n == 8){
			sb.append(later[weight]);
			for(int i = 5; i < n; i++){
				sb.append(pre[weight]);
			}
			return sb;
		}
		if(n == 9){
			sb.append(pre[weight]);
			sb.append(pre[weight+1]);
			return sb;
		}
		return sb;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution12 solution = new Solution12();
		System.out.println(solution.intToRoman(3999));
		System.out.println(solution.intToRoman(1));
	}

}
