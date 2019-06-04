package thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

	private int maxSize;
	private List<Date> storage;

	public EventStorage(){
		maxSize = 10;
		storage = new LinkedList<>();
	}

	public synchronized void set(){
		while (storage.size()==maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.printf("Set: %d",storage.size());
		notifyAll();
	}

	public synchronized void get(){
		while(storage.size() == 0){
			try {
				System.out.println("��ȡΪ�գ�һֱ�ڵȴ�");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		System.out.printf("Get: %d: %s",storage.
				size(),((LinkedList<?>)storage).poll());
		notifyAll();
	}


}
