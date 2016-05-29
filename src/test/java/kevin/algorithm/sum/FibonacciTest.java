/**
 * @author kevin
 * @create_time: 2016 May 16, 2016 4:31:15 PM
 * @package_name: kevin.algorithm.sum
 * @project_name: algorithm
 */
package kevin.algorithm.sum;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class FibonacciTest {
	@Test
	public void testFibonacci(){
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(fibonacci.fibonacci1(0),Integer.valueOf(0));
		Assert.assertEquals(fibonacci.fibonacci1(1),Integer.valueOf(1));
		Assert.assertEquals(fibonacci.fibonacci1(2),Integer.valueOf(1));
		Assert.assertEquals(fibonacci.fibonacci2(0),0);
		Assert.assertEquals(fibonacci.fibonacci2(1),1);
		Assert.assertEquals(fibonacci.fibonacci2(2),1);
	}
	
	@Test
	public void testFibonacciTime(){
		Fibonacci fibonacci = new Fibonacci();
		int n = 45;
		
		long start = System.currentTimeMillis();
		int res = fibonacci.fibonacci1(n);
		System.out.println(res + ": " + (System.currentTimeMillis() - start) );
		start = System.currentTimeMillis();
		res = fibonacci.fibonacci2(n);
		System.out.println(res + ": " + (System.currentTimeMillis() - start));
	}
}
