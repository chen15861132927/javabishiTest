package shejimoshi.Command;

class Tank
{
	int howFull = 0;

	Tank()
	{
		this(0);
	}

	Tank(int fullness)
	{
		howFull = fullness;
	}

	void sayHowFull()
	{
		if (howFull == 0)
			System.out.println("Tank is empty!");
		else
			System.out.println("Tank filling status : " + howFull);
	}

	void empty()
	{
		howFull = 0;
	}

	protected void finalize()
	{
		if (howFull != 0)
		{
			System.out.println("Error: Tank not empty." + this.howFull);
		}
		// Normally,you'll also do this:
		// Super.finalize(); //call the base-class version
	}
}

public class TankTest
{
	public static void main(String[] args)
	{
		Tank tank1 = new Tank();
		Tank tank2 = new Tank(3);
		Tank tank3 = new Tank(5);
		tank2.empty();
		// Drop the reference,forget to cleanup:
		new Tank(6);
		new Tank(7);
		System.out.println("Check tanks:");
		System.out.println("tank1:");
		tank1.sayHowFull();
		System.out.println("tank2:");
		tank2.sayHowFull();
		System.out.println("tank3");
		tank3.sayHowFull();
		System.out.println("first forced gc()");
		System.gc();
		System.out.println("try deprecated runFinalizerOnExit(true)");
		System.runFinalizersOnExit(true);
		System.out.println("last forced gc():");
		System.gc();
	}
}