package TestCollection;

//This class gives the List classes  benchmarks for adding objects at  end,middle and first
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class ListAddTest
{
	private static final int NUM = 50000;
	private static String[] objs = null;

	public void addLast(List list)
	{
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < NUM; i++)
		{
			list.add(objs[i]);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for adding Objects at End: " + (endTime - startTime));
	}

	public void addFirst(List list)
	{
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < NUM; i++)
		{
			list.add(0, objs[i]);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for adding Objects at First : " + (endTime - startTime));
	}

	public void addMiddle(List list)
	{
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < NUM; i++)
		{
			list.add(i / 2, objs[i]);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for adding Objects at Middle : " + (endTime - startTime));
	}

	public void doTest(List list)
	{
		addLast(list);
		clear(list);
		addMiddle(list);
		clear(list);
		addFirst(list);
		clear(list);
	}

	public void clear(List col)
	{
		if (!col.isEmpty())
			col.clear();
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		objs = new String[NUM];
		for (int i = 0; i < NUM; i++)
		{
			objs[i] = "Object" + i;
		}
		ListAddTest col = new ListAddTest();
		ArrayList collection1 = new ArrayList();
		col.doTest(collection1);
		ArrayList collection1A = new ArrayList(NUM);
		col.doTest(collection1A);
		Vector collection2 = new Vector();
		col.doTest(collection2);
		Vector collection2A = new Vector(NUM);
		col.doTest(collection2A);
		LinkedList collection4 = new LinkedList();
		col.doTest(collection4);
	}
}