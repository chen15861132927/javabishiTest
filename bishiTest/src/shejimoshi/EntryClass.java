package shejimoshi;

public class EntryClass
{
	public static void main(String[] args)
	{

		FrameSubject frame = new FrameSubject();
		FrameObserver frame2 = new FrameObserver();
		// 在Subject中注册Observer，将两者联系在一起
		frame.registerObserver(frame2);

		frame.setVisible(true);
		frame2.setVisible(true);

	}
}