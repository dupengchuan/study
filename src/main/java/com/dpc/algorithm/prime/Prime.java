/**
 * @createtime: May 7, 2016 7:14:12 PM
 * @owner: kevin
 */
package com.dpc.algorithm.prime;

import java.util.Arrays;

/**
 * @author kevin
 * @version 1.1
 */
public class Prime {
	
	private int[] primes;
	private int index;
	
	public Prime(){
		this.primes = new int[100000];
		this.primes[0] = 2;
		this.index = 0;
	}
	
	public int[] getPrimes(int n){
		if(n <= primes[index]){
			int i = index;
			while(i >= 0 && primes[i] > n){
				i--;
			}
			if(i < 0){
				return null;
			}else{
				return Arrays.copyOfRange(primes,0,i + 1);
			}
		}else{
			int offset = primes[index];
			int[] temp = new int[n-offset];
			for(int i = offset + 1; i <= n; i++){
				if(temp[i - offset - 1] == 1){
					continue;
				}
				if(isPrime(i)){
					primes[++index] = i;
					for(int p = i*i; p <= n; p += i){
						temp[p - offset - 1] = 1;
					}
				}
			}
			return Arrays.copyOfRange(primes, 0, index+1);
		}
	}
	
	public boolean isPrime(int n){
		if(n < 2){
			return false;
		}
		int q = (int)Math.sqrt(n) + 1;
		for(int i = 2; i < q; i++){
			if(n % 2 == 0){
				return false;
			}
		}
		return true;
	}
}
