package shejimoshi;

import java.awt.Label;
import java.util.Observable;

import javax.swing.JFrame;

public class FrameObserver extends JFrame implements java.util.Observer
{

	// 观察的数据
	int widthInfo = 0;
	int heightInfo = 0;
	Label jLabel1 = new Label();
	Label jLabel2 = new Label();
	Label jLabel3 = new Label();
	Label jLabel4 = new Label();

	// 在update()方法中实现对数据的更新和其它必要的反应。
	public void update(Observable o, Object arg)
	{
		DateSubject subject = (DateSubject) o;
		widthInfo = subject.getWidthInfo();
		heightInfo = subject.getHeightInfo();
		jLabel1.setText("The heightInfo from subject is:  ");
		jLabel3.setText(String.valueOf(heightInfo));
		jLabel2.setText("The widthInfo from subject is:  ");
		jLabel4.setText(String.valueOf(widthInfo));
	}

}