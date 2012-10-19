package xiancheng;

import java.util.concurrent.TimeUnit;

class mMyObject implements Runnable {
    private mMonitor mMonitor;

    public mMyObject(mMonitor mMonitor) {
      this.mMonitor = mMonitor;
    }

    public void run() {
      try {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("i'm going.");
        mMonitor.gotMessage();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
}

class mMonitor implements Runnable {
    private volatile boolean go = false;

    public synchronized void gotMessage() throws InterruptedException {
      go = true;
      notify();
    }

    public synchronized void watching() throws InterruptedException {
      while (go == false)
        wait();
      System.out.println("He has gone.");
    }

    public void run() {
      try {
        watching();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
}

public class Wait {
    public static void main(String[] args) {
      mMonitor mMonitor = new mMonitor();
      mMyObject o = new mMyObject(mMonitor);
      new Thread(o).start();
      new Thread(mMonitor).start();
    }
}
