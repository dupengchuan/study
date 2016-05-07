/**
 * @createtime: May 6, 2016 10:01:05 PM
 * @owner: kevin
 */
package com.dpc.algorithm.hash;

import com.dpc.algorithm.inter.Hash;

/**
 * @author kevin
 * @version 1.1
 */
public class Time33 implements Hash {

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Hash#hash(java.lang.String)
	 */
	public int hash(String s) {
		// TODO Auto-generated method stub
		return this.computeHash(s, s.length() - 1);
	}
	
	private int  computeHash(String s, int i){
		if(i == 0){
			return s.charAt(0);
		}else{
			return computeHash(s, i-1)*33 + s.charAt(i);
		}
	}

}
