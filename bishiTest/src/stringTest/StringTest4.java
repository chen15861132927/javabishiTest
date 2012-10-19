package stringTest;

/**
 * This class shows the time taken by string concatenation using + operator and
 * StringBuffer
 */
public class StringTest4
{
	public static void main(String[] args)
	{
		// Test the String Concatenation using + operator
		long startTime = System.currentTimeMillis();
		String result = "";
		for (int i = 0; i < 50000; i++)
		{
			result += "hello";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for string concatenation using + operator : " + (endTime - startTime) + " milli seconds");
		// Test the String Concatenation using StringBuffer
		long startTime1 = System.currentTimeMillis();
		StringBuffer result1 = new StringBuffer(250000);
		for (int i = 0; i < 50000; i++)
		{
			result1.append("hello");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("Time taken for string concatenation using StringBuffer : " + (endTime1 - startTime1) + " milli seconds");
	}
}