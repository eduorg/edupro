package pers.zander.edu.thread;
/**
 * 测试Runable实现多线程
 * @author zhaozhao
 * @time 2016-4-18 上午10:55:51
 */
public class MyRunable {
//	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Thread.currentThread().getName()+"  "+i);
//			if(i==5){
//				TestRunable r = new TestRunable();
//				Thread t1 = new Thread(r);//创建线程
//				Thread t2 = new Thread(r);//创建线程
//				Thread t3 = new Thread(r);//创建线程
//				Thread t4 = new Thread(r);//创建线程
//				Thread t5 = new Thread(r);//创建线程
//				t1.start();//线程准备就绪
//				t2.start();//线程准备就绪
//				t3.start();//线程准备就绪
//				t4.start();//线程准备就绪
//				t5.start();//线程准备就绪
//			}
//		}
//	}
}
class TestRunable implements Runnable{
	TestRunable(){};
	public void run(){
		for (int i = 0; i < 5; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
	}
}