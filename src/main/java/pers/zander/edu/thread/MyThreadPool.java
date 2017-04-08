package pers.zander.edu.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池
 * @author zhaozhao
 * @time 2016-4-18 上午11:18:10
 */
public class MyThreadPool {

//	public static void main(String[] args) {
//		MyThreadPool bean = new MyThreadPool();
//		bean.test();
//		
//	}
	
	public void test(){
		//corePoolSize： 线程池维护线程的最少数量 
				//maximumPoolSize：线程池维护线程的最大数量 
				//keepAliveTime： 线程池维护线程所允许的空闲时间 
				//unit： 线程池维护线程所允许的空闲时间的单位 
				//workQueue： 线程池所使用的缓冲队列 
				//handler： 线程池对拒绝任务的处理策略 
				int threadNum = 3;
				ThreadPoolExecutor threadPool = new ThreadPoolExecutor(threadNum, threadNum+1, 10, TimeUnit.SECONDS,
						new ArrayBlockingQueue<Runnable>(threadNum+1),
		                new ThreadPoolExecutor.DiscardOldestPolicy());
				for (int i = 0; i < threadNum; i++) {
					threadPool.execute(new ThreadPoolTest());
				}
				return;
	}
	
	class ThreadPoolTest extends Thread{
		@Override
		public void run() {
			for (int i=0; i < 10; i++) {
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
}
