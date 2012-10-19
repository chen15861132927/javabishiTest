package shejimoshi.Command;

import java.util.Enumeration;

//抽象的Task接口，作为回调的Command模式的主体
interface Task
{
	public void taskPerform();
}

// 具体的实现了Task接口的子类，实现特定的操作。
class BackupTask implements Task
{
	public void taskPerform()
	{
		System.out.println("Backup Task has been performed");
	}
}

// 具体的实现了Task接口的子类，实现特定的操作。
class ScanDiskTask implements Task
{
	public void taskPerform()
	{
		System.out.println("ScanDisk Task has been performed");
	}
}

// 一个封装了Task的一个封装类，提供了一些与Task相关的内容，也可以把这些内容
// 这儿不过为了突出Command模式而把它单另出来，实际上可以和Task合并。
class TaskEntry
{
	private Task task;
	private long timeInterval;
	private long timeLastDone;

	public Task getTask()
	{
		return task;
	}

	public void setTask(Task task)
	{
		this.task = task;
	}

	public void setTimeInterval(long timeInterval)
	{
		this.timeInterval = timeInterval;
	}

	public long getTimeInterval()
	{
		return timeInterval;
	}

	public long getTimeLastDone()
	{
		return timeLastDone;
	}

	public void setTimeLastDone(long timeLastDone)
	{
		this.timeLastDone = timeLastDone;
	}

	public TaskEntry(Task task, long timeInteral)
	{
		this.task = task;
		this.timeInterval = timeInteral;
	}
}

// 调度管理Task的类，继承Thread只是为了调用其sleep()方法，
// 实际上，如果真的作Task调度的话，每个Task显然应该用单独的Thread来实现。
public class TaskSchedule extends java.lang.Thread
{
	private java.util.Vector taskList = new java.util.Vector();
	private long sleeptime = 10000000000l;// 最短睡眠时间

	public void addTask(TaskEntry taskEntry)
	{
		taskList.add(taskEntry);
		taskEntry.setTimeLastDone(System.currentTimeMillis());
		if (sleeptime > taskEntry.getTimeInterval())
			sleeptime = taskEntry.getTimeInterval();
	}

	// 执行任务调度
	public void schedulePermorm()
	{
		try
		{
			sleep(sleeptime);
			Enumeration e = taskList.elements();
			while (e.hasMoreElements())
			{
				TaskEntry te = (TaskEntry) e.nextElement();
				if (te.getTimeInterval() + te.getTimeLastDone() < System.currentTimeMillis())
				{
					te.getTask().taskPerform();
					te.setTimeLastDone(System.currentTimeMillis());
				}
			}
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		TaskSchedule schedule = new TaskSchedule();
		TaskEntry taks1 = new TaskEntry(new ScanDiskTask(), 10000);
		TaskEntry taks2 = new TaskEntry(new BackupTask(), 3000);
		schedule.addTask(taks1);
		schedule.addTask(taks2);
		while (true)
		{
			schedule.schedulePermorm();
		}
	}
}