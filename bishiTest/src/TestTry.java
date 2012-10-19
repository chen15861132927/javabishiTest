public class TestTry
{
	@SuppressWarnings("finally")
	public static int getss()
	{
		int res = 5;
		try
		{
			System.exit(0);
			return res;
		} catch (Exception e)
		{
			// TODO: handle exception
		} finally
		{
			res = 10;
			return res;
		}
	}

	public static void main(String[] a)
	{
		System.out.print(System.getProperties());
		System.out.print(System.getProperty("user.dir"));
		//System.out.print(getss());
		
		
		
	}
}
