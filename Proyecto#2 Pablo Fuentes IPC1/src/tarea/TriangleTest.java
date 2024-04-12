package tarea;

/**
*
* Student name:  xxxxx
* Completion date: xxxx
*
* TriangleTest.txt: the template file of TriangleTest.java
* Student tasks: 
* - Write 20 JUnit test cases for Triangle class 
* - Then run this file on the command line with the jar files provided
*
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void test1(){
		Triangle triangle = new Triangle("12","12","12");
		assertEquals("This is an equilateral triangle. ",triangle.triangleType());	
	}//end test
	
	@Test
	public void test2(){
		Triangle triangle = new Triangle("3","3","5");
		assertEquals("This is an isosceles triangle. ",triangle.triangleType());
	 	
	}//end test
	
	@Test
	public void test3(){
		Triangle triangle = new Triangle("4","5","6");
		assertEquals("This is a scalene triangle. ", triangle.triangleType());
		// expected value: "This is a scalene triangle. "  
		// value returned from the method: triangle.triangleType() 
	}//end test
	
	@Test
	public void test4(){
		// add your code below


		assertEquals(true,true);   
		// change above arguments(true, true) to (expectedValue, valueReturned)

	}//end test

	@Test
	public void test5(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test6(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test7(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test8(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test9(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test10(){
		assertEquals(true,true);
	}//end test	
	
	@Test
	public void test11(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test12(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test13(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test14(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test15(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test16(){
		assertEquals(true,true);
	}//end test	
	
	@Test
	public void test17(){
		assertEquals(true,true);
	}//end test
	
	
	@Test
	public void test18(){
		assertEquals(true,true);
	}//end test	
	
	
	@Test
	public void test19(){
		assertEquals(true,true);	
	}//end test
	
	@Test
	public void test20(){
		assertEquals(true,true);	
	}//end test

}
