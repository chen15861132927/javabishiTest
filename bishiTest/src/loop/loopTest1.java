package loop;

//This class tests the loop copy versus System.arraycopy()
public class loopTest1
{
	public static void main(String s[])
	{
		long start, end;
		int[] a = new int[12500000];
		int[] b = new int[12500000];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = i;
		}
		start = System.currentTimeMillis();
		for (int j = 0; j < a.length; j++)
		{
			b[j] = a[j];
		}
		end = System.currentTimeMillis();
		System.out.println(end - start + " milli seconds for loop copy ");
		int[] c = new int[12500000];
		start = System.currentTimeMillis();
		System.arraycopy(a, 0, c, 0, c.length);
		end = System.currentTimeMillis();
		System.out.println(end - start + " milli seconds for System.arraycopy() ");
	}
}
