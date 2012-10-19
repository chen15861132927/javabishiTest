package serialization;

import java.util.Vector;
import java.io.*;

public class SerializationTest
{
	static long start, end;
	OutputStream out = null;
	InputStream in = null;
	OutputStream outBuffer = null;
	InputStream inBuffer = null;
	ObjectOutputStream objectOut = null;
	ObjectInputStream objectIn = null;

	public Person getObject()
	{
		Person p = new Person("SID", "austin");
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < 7000; i++)
		{
			v.addElement("StringObject" + i);
		}
		p.setData(v);
		return p;
	}

	public static void main(String[] args)
	{
		SerializationTest st = new SerializationTest();
		start = System.currentTimeMillis();
		//st.writeObject();
		st.readObject();
		end = System.currentTimeMillis();
		System.out.println("Time taken for writing and reading :" + (end - start) + "milli seconds");
	}

	public void readObject()
	{
		try
		{
			in = new FileInputStream("c:/temp/test.txt");
			inBuffer = new BufferedInputStream(in);
			objectIn = new ObjectInputStream(inBuffer);
			Object object= new Object();
			System.out.println(objectIn.readObject());
			//Person tePerson=(Person) objectIn.readObject();
			//System.out.println(tePerson.toString());
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (objectIn != null)
				try
				{
					objectIn.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	}

	public void writeObject()
	{
		try
		{
			out = new FileOutputStream("c:/temp/test.txt");
			outBuffer = new BufferedOutputStream(out);
			objectOut = new ObjectOutputStream(outBuffer);
			objectOut.writeObject(getObject());
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (objectOut != null)
				try
				{
					objectOut.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	}
}

class Person implements java.io.Serializable
{
	private String name;
	private Vector<?> data;
	private String address;

	public Person(String name, String address)
	{
		this.name = name;
		this.address = address;
	}

	public String getAddress()
	{
		return address;
	}

	public Vector<?> getData()
	{
		return data;
	}

	public String getName()
	{
		return name;
	}

	public void setData(Vector<?> data)
	{
		this.data = data;
	}
}