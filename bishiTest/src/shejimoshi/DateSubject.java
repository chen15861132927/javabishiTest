package shejimoshi;

import java.util.Observable;

public class DateSubject extends Observable
{
	// 封装被观察的数据
	private int widthInfo;
	private int heightInfo;

	public int getWidthInfo()
	{
		return widthInfo;
	}

	public void setWidthInfo(int widthInfo)
	{
		this.widthInfo = widthInfo;
		// 数据改变后，setChanged()必须被调用，否则notifyObservers()方法会不起作用
		this.setChanged();
	}

	public void setHeightInfo(int heightInfo)
	{
		this.heightInfo = heightInfo;
		this.setChanged();
	}

	public int getHeightInfo()
	{
		return heightInfo;
	}
}