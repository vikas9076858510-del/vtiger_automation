package abc;

import org.testng.annotations.Test;

public class AddToNumber {

	@Test
	public static void swapingProgram() {
		int a=10;
		int b=20;
		System.out.println("Before Swaping A =" +a+ " b ="+b);
		// First logic with third variable using 
		
	 /* int x=0;
		x = a;     /// x=10
		a=b;      /// a=20
		b=x;      /// b=20    */

		//  Second logic without third variable use in (+ -)
		
	/*	a = a+b;       /// a=10 +20=30
		b = a-b;       /// b=30-20=10
        a = a-b;       /// a=30-10=20  */
		
		// Third logic without using third variable use in (* /)
		
    /*    a =a*b;  /// 10x20=200
		b =a/b;  /// 200/20=10
		a =a/b;   /// 200/10=20  */
		
		// Fourth logic without using third variable use in single line
		
	/*	b= a-b-(a=b);   /// 10+20-(a=20)
		                /// 30-20
		                /// 10      */
		
		// Fifth logic without using third variable use in Bitwise or XOR
		
		a =a^b;    /// 1010 ^ 10100 = 1111 = 30
		b =a^b;   /// 11110 ^ 10100 = 1010 = 10
		a =a^b;   /// 11110 ^ 1010 = 10100 = 20

		System.out.println("After Swaping A =" +a+ " b ="+b);
		
	}
}