package shejimoshi;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.util.Observable;

import javax.swing.JFrame;

public class FrameSubject extends JFrame
{
	TextField jTextField1 = new TextField();
	TextField jTextField2 = new TextField();
	// 因为无法使用多重继承，这儿就只能使用对象组合的方式来引入一个
	// java.util.Observerable对象了。
	DateSubject subject = new DateSubject();

	// 这个方法转发添加Observer消息到DateSubject。
	public void registerObserver(java.util.Observer o)
	{
		subject.addObserver(o);
	}

	// 数据改变，事件被触发后调用notifyObservers()来通知Observer。
	void jButton1_actionPerformed(ActionEvent e)
	{
		subject.setWidthInfo(Integer.parseInt(jTextField1.getText()));
		subject.setHeightInfo(Integer.parseInt(jTextField2.getText()));
		subject.notifyObservers();
	}

}
