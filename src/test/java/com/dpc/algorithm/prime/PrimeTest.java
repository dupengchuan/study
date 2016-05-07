/**
 * @createtime: May 7, 2016 7:57:30 PM
 * @owner: kevin
 */
package com.dpc.algorithm.prime;

import org.junit.Test;

import com.dpc.util.PrintUtil;

import junit.framework.Assert;

/**
 * @author kevin
 * @version 1.1
 */
public class PrimeTest {
	@Test
	public void testIsPrime(){
		Prime prime = new Prime();
		Assert.assertEquals(true, prime.isPrime(2));
		Assert.assertEquals(true, prime.isPrime(3));
		PrintUtil.printIntArray(prime.getPrimes(10000));
	}
}
