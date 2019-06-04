package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EventLock {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private double value = 0d;
	private int addTimes = 0;
	
	
	public void addValue(double v){
		Lock writeLock = lock.writeLock();
		writeLock.lock();
		System.out.println("ReadWriteLockTest to addValue: " + v + "   "  
                + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			this.value+=v;
			this.addTimes++;
		} finally{
			writeLock.unlock();
		}
	}
	
	public String getValue(){
		Lock readLock = lock.readLock();
		readLock.lock();
		 System.out.println("ReadWriteLockTest to getInfo   "  
                 + System.currentTimeMillis());  
         try {  
             Thread.sleep(1000);  
         } catch (InterruptedException e) {  
         }  
         try {  
             // 做读的工作  
             return this.value + " : " + this.addTimes;  
         } finally {  
             // 释放readLock  
             readLock.unlock();  
         }  
	}

}
