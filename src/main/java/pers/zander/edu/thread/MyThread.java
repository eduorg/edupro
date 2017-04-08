package pers.zander.edu.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试多线程j集成Thread类
 * 
 * @author zhaozhao
 * @time 2016-4-18 上午10:33:45
 */
public class MyThread{
	static List<String> list1 = new ArrayList<String>();
	
	static List<String> list2 = new ArrayList<String>();
//	public static void main(String[] args) throws InterruptedException {
//		for (int i = 0; i < 10; i++) {
//			MyThread.list1.add("a"+i);
//			MyThread.list2.add("b"+i);
//		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Thread.currentThread().getName() + " " + i);
//			Thread.currentThread().sleep(2000);
//			if (i == 5) {
//				Thread myThread1 = new TestMyThread(); // 创建一个新的线程 myThread1
//													// 此线程进入新建状态
//				Thread myThread2 = new TestMyThread(); // 创建一个新的线程 myThread2
//													// 此线程进入新建状态
//				myThread1.start(); // 调用start()方法使得线程进入就绪状态
//				myThread2.start(); // 调用start()方法使得线程进入就绪状态
//			}
//		}
//	}
	

}

class TestMyThread extends Thread {
	private int i = 0;

	
	@Override
	public void run() {
		for (; i < 10; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + i+"  >>>"+MyThread.list1.get(i));
		}
	}
}
