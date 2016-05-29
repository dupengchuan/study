/**
 * @createtime: May 7, 2016 7:57:30 PM
 * @owner: kevin
 */
package kevin.algorithm.prime;

import org.junit.Test;

import junit.framework.Assert;
import kevin.algorithm.prime.Prime;
import kevin.util.PrintUtil;

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
