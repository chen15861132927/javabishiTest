package loop;

//Note that this class may give different results in latest JDK versions as discussed above.
public class loopTest2
{
	public static void main(String s[])
	{
		long start, end;
		int[] a = new int[22500000];
		start = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++)
		{
			a[i] += i;
		}
		end = System.currentTimeMillis();
		System.out.println(end - start + " millis with i<a.length ");

		int[] b = new int[22500000];
		start = System.currentTimeMillis();
		for (int i = b.length - 1; i >= 0; i--)
		{
			b[i] += i;
		}
		end = System.currentTimeMillis();
		System.out.println(end - start + " millis with i>=0");
	}
}