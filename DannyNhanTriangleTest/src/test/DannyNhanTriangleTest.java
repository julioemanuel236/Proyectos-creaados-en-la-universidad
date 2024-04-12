package test;

/**
*
* Student name:  Danny Nhan
* Completion date: 5/26/2023
*
* TriangleTest.txt: the template file of TriangleTest.java
* Student tasks: 
* - Write 20 JUnit test cases for Triangle class 
* - Then run this file on the command line with the jar files provided
*
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class DannyNhanTriangleTest {


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
	    Triangle triangle = new Triangle("5","5","5");
	    assertEquals("This is an equilateral triangle. ",triangle.triangleType());	
	}

	@Test
	public void test5(){
	    Triangle triangle = new Triangle("5","5","7");
	    assertEquals("This is an isosceles triangle. ",triangle.triangleType());	
	}

	@Test
	public void test6(){
	    Triangle triangle = new Triangle("7","5","5");
	    assertEquals("This is an isosceles triangle. ",triangle.triangleType());	
	}

	@Test
	public void test7(){
	    Triangle triangle = new Triangle("5","7","5");
	    assertEquals("This is an isosceles triangle. ",triangle.triangleType());	
	}

	@Test
	public void test8(){
	    Triangle triangle = new Triangle("3","4","5");
	    assertEquals("This is a scalene triangle. ",triangle.triangleType());	
	}

	@Test
	public void test9(){
	    Triangle triangle = new Triangle("-1","4","5");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test10(){
	    Triangle triangle = new Triangle("4","-1","5");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test11(){
	    Triangle triangle = new Triangle("4","5","-1");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test12(){
	    Triangle triangle = new Triangle("-1","-1","-1");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test13(){
	    Triangle triangle = new Triangle("-1","-1","5");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test14(){
	    Triangle triangle = new Triangle("-1","5","-1");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test15(){
	    Triangle triangle = new Triangle("0","0","0");
	    assertEquals("Not a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test16(){
	    Triangle triangle = new Triangle("500","500","1000");
	    assertEquals("Not a valid triangle!\nThis triangle is too big.\n",triangle.triangleType());	
	}

	@Test
	public void test17(){
	    Triangle triangle = new Triangle("1000", "1000", "1000");
	    assertEquals("This triangle is too big.\n",triangle.triangleType());
	}
	
	@Test
	public void test18(){
	    Triangle triangle = new Triangle("1.05","5","5");
	    assertEquals("The side 1 is not an integer number.\n\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test19(){
	    Triangle triangle = new Triangle("5","2.3","5");
	    assertEquals("The side 2 is not an integer number.\n\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test20(){
	    Triangle triangle = new Triangle("5","5","a");
	    assertEquals("The side 3 is not an integer number.\n\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test21(){
	    Triangle triangle = new Triangle("a","b","c");
	    assertEquals("The side 1 is not an integer number.\n\nThe side 2 is not an integer number.\n\nThe side 3 is not an integer number.\n\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test22(){
	    Triangle triangle = new Triangle("-1","b","c");
	    assertEquals("The side 2 is not an integer number.\n\nThe side 3 is not an integer number.\n\nAt least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test23(){
	    Triangle triangle = new Triangle("-1","-1","c");
	    assertEquals("The side 3 is not an integer number.\n\nAt least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test24(){
	    Triangle triangle = new Triangle("-1","-1","-1");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test25(){
	    Triangle triangle = new Triangle("0","0","0");
	    assertEquals("Not a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test26(){
	    Triangle triangle = new Triangle("500","500","1000");
	    assertEquals("Not a valid triangle!\nThis triangle is too big.\n",triangle.triangleType());	
	}

	@Test
	public void test27(){
	    Triangle triangle = new Triangle("1000", "1000", "1000");
	    assertEquals("This triangle is too big.\n",triangle.triangleType());
	}
	
	@Test
	public void test28(){
	    Triangle triangle = new Triangle("5","5","5");
	    assertEquals("This is an equilateral triangle. ",triangle.triangleType());	
	}

	@Test
	public void test29(){
	    Triangle triangle = new Triangle("6","6","7");
	    assertEquals("This is an isosceles triangle. ",triangle.triangleType());	
	}

	@Test
	public void test30(){
	    Triangle triangle = new Triangle("7","6","6");
	    assertEquals("This is an isosceles triangle. ",triangle.triangleType());	
	}

	@Test
	public void test31(){
	    Triangle triangle = new Triangle("6","7","6");
	    assertEquals("This is an isosceles triangle. ",triangle.triangleType());	
	}

	@Test
	public void test32(){
	    Triangle triangle = new Triangle("3","4","6");
	    assertEquals("This is a scalene triangle. ",triangle.triangleType());	
	}

	@Test
	public void test33(){
	    Triangle triangle = new Triangle("-2","4","5");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test34(){
	    Triangle triangle = new Triangle("4","-2","5");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test35(){
	    Triangle triangle = new Triangle("4","5","-2");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test36(){
	    Triangle triangle = new Triangle("-2","-2","-2");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

	@Test
	public void test37(){
	    Triangle triangle = new Triangle("-2","-2","5");
	    assertEquals("At least one side is negative!\nNot a valid triangle!\n",triangle.triangleType());	
	}

}