package IO;

//This class shows the different bench marks using default behavior, buffered streams and custom buffering 
import java.io.*;

public class IOTest
{
	public static void main(String[] args)
	{
		try
		{
			long startTime = System.currentTimeMillis();
			IOTest.readWrite("c:/temp/Bookmarks.html", "c:/temp/Bookmarks1.html");
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken for reading and writing using default behaviour : " + (endTime - startTime) + " milli seconds");

			long startTime1 = System.currentTimeMillis();
			IOTest.readWriteBuffer("c:/temp/Bookmarks.html", "c:/temp/Bookmarks2.html");
			long endTime1 = System.currentTimeMillis();
			System.out.println("Time taken for reading and writing using buffered streams : " + (endTime1 - startTime1) + " milli seconds");

			long startTime2 = System.currentTimeMillis();
			IOTest.readWriteArray("c:/temp/Bookmarks.html", "c:/temp/Bookmarks3.html");
			long endTime2 = System.currentTimeMillis();
			System.out.println("Time taken for reading and writing using custom buffering : " + (endTime2 - startTime2) + " milli seconds");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void readWrite(String fileFrom, String fileTo) throws IOException
	{
		InputStream in = null;
		OutputStream out = null;
		try
		{
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			while (true)
			{
				int bytedata = in.read();
				if (bytedata == -1)
					break;
				out.write(bytedata);
			}
		} finally
		{
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	public static void readWriteBuffer(String fileFrom, String fileTo) throws IOException
	{
		InputStream inBuffer = null;
		OutputStream outBuffer = null;
		try
		{
			InputStream in = new FileInputStream(fileFrom);
			inBuffer = new BufferedInputStream(in);
			OutputStream out = new FileOutputStream(fileTo);
			outBuffer = new BufferedOutputStream(out);
			while (true)
			{
				int bytedata = inBuffer.read();
				if (bytedata == -1)
					break;
				out.write(bytedata);
			}
		} finally
		{
			if (inBuffer != null)
				inBuffer.close();
			if (outBuffer != null)
				outBuffer.close();
		}
	}

	public static void readWriteArray(String fileFrom, String fileTo) throws IOException
	{
		InputStream in = null;
		OutputStream out = null;
		try
		{
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			int availableLength = in.available();
			byte[] totalBytes = new byte[availableLength];
			int bytedata = in.read(totalBytes);
			if (bytedata != -1)
				out.write(totalBytes);

		} finally
		{
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}