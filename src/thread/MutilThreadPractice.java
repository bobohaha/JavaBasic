package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.Callback;

public class MutilThreadPractice {
	private static Thread firstThread;
	private static Thread secondThread;
	
	public static void main(String[] args) {
		
		Thread mainThread = new Thread(mainTask);
		firstThread = new Thread(firstTask);
		secondThread = new Thread(secondTask);
		mainThread.start();
//		firstThread.start();
//		secondThread.start();
	}
	
	
//	public static Runnable mainTask = new Runnable() {
//		
//		@Override
//		public void run() {
//				System.out.println("主线程开始执行了");
//				try {
//					firstThread.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("主线程执行结束了");
//			}
//	};
//	
//	public static Runnable firstTask = new Runnable() {
//		
//		@Override
//		public void run() {
//			System.out.println("子线程-1-开始执行了");
//			try {
//				secondThread.join();
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//			for(int i = 0;i<3;i++){
//				System.out.println("子线程-1-执行过程："+i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	};
//	
//	public static Runnable secondTask = new Runnable() {
//		
//		@Override
//		public void run() {
//			System.out.println("子线程-2-开始执行了");
//			for(int i = 0;i<3;i++){
//				System.out.println("子线程-2-执行过程："+i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	};
	
	
	
	
public static Runnable mainTask = new Runnable() {
		
		@Override
		public void run() {
				System.out.println("主线程开始执行了");
				ExecutorService service = Executors.newFixedThreadPool(2);
				service.execute(firstTask);
				service.execute(secondTask);
//				service.shutdownNow();
				try {
					service.awaitTermination(6000, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("主线程执行结束了");
//				try {
//					firstThread.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
	};
	
	public static Runnable firstTask = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("子线程-1-开始执行了");
			for(int i = 0;i<3;i++){
				System.out.println("子线程-1-执行过程："+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			this.notify();
		}
	};
	
	public static Runnable secondTask = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("子线程-2-开始执行了");
			for(int i = 0;i<3;i++){
				System.out.println("子线程-2-执行过程："+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			this.notify();
		}
	};
	
	
	
	
	
	

}
