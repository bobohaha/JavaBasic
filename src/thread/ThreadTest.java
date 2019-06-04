package thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

	private static boolean ready;
	private static int number;

	public static void main(String[] args) {
		//		new ReadThread().start();
		//		PrimeGenerator thread = new PrimeGenerator();
		//		thread.start();
		//		try {
		//			Thread.sleep(5000);
		//		} catch (Exception e) {
		//		}
		//		thread.interrupt();
		//		ready = true;
		//		number = 24;

		//		DataSourceLoader loader = new DataSourceLoader();
		//		Thread thread1 = new Thread(loader,"DataSourcesThread");
		//		NetworkConnectionsLoader networkLoader = new NetworkConnectionsLoader();
		//		Thread thread2 = new Thread(networkLoader, "networkSourcesThread");
		//		thread1.start();
		//		thread2.start();
		//		try {
		//			thread1.join(1000);
		//			thread2.join(1000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}
		//		System.out.printf("Main: configuration has been loaded:%s\n",new Date());

		//		Deque<Event> deque = new ArrayDeque<Event>();
		//		WriteTask writer = new WriteTask(deque);
		//		for (int i = 0; i < 3; i++) {
		//			Thread thread = new Thread(writer);
		//			thread.start();
		//		}
		//		CleanerTask cleaner = new CleanerTask(deque);
		//		cleaner.start();
		//		Thread thread = new Thread(new Task());
		////		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		//		thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		//		thread.start();
		//		UnSafeTask task = new UnSafeTask();
		//		SafeTask task = new SafeTask();
		//		for (int i = 0; i < 10; i++) {
		//			Thread thread = new Thread(task);
		//			thread.start();
		//			try {
		//				TimeUnit.SECONDS.sleep(2);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//		}

		//		ThreadGroup group = new ThreadGroup("Searcher");
		//		Result result = new Result();
		//		SearchTask searchTask = new SearchTask(result);
		//		for (int i=0; i<5; i++) {
		//			Thread thread=new Thread(group, searchTask);
		//			thread.start();
		//			try {
		//				TimeUnit.SECONDS.sleep(1);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//		}
		//		System.out.printf("Number of Threads: %d\n",group.
		//			       activeCount());
		//		System.out.printf("Information about the Thread Group\n");
		//		group.list();
		//		//这样可以复制group里面的thread信息  
		//        Thread[] threads = new Thread[group.activeCount()];  
		//        group.enumerate(threads);  
		//        for (int i = 0; i < group.activeCount(); i++) {  
		//            System.out.printf("Thread %s: %s\n", threads[i].getName(),  
		//                    threads[i].getState());  
		//        }  
		//          
		//        waitFinish(group);  
		//        //将group里面的所有线程都给interpet  
		//        group.interrupt();  

		//		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		//		Task task = new Task();
		//		Thread thread;
		//		System.out.printf("Starting the Threads\n");
		//		for (int i = 0; i < 10; i++) {
		//			thread= factory.newThread(task);
		//			thread.start();
		//		}
		//		System.out.printf("Factory stats:\n");
		//        System.out.printf("%s\n",factory.getStats());
//		Account account = new Account();
//		account.setBalance(1000);
//		Bank bank = new Bank(account);
//		Thread bankThread = new Thread(bank);
//		Company company = new Company(account);
//		Thread companyThread = new Thread(company);
//		System.out.printf("Account : Initial Balance: %f\n",account.
//				getBalance());
//		bankThread.start();
//		companyThread.start();
//		try {
//			bankThread.join();
//			companyThread.join();
//			System.out.printf("Account : Final Balance: %f\n",account.
//					getBalance());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		EventStorage storage = new EventStorage();
//		Producer producer = new Producer(storage);
//		Consumer consumer = new Consumer(storage);
//		Thread thread1 = new Thread(producer);
//		Thread thread2 = new Thread(consumer);
//		thread1.start();
//		thread2.start();
//		try {
//			testReadWriteLockTest();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Map<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	}

	private static class PrimeGenerator extends Thread{
		@Override
		public void run() {
			//			super.run();
			long number = 1l;
			while (true) {
				if (isPrime(number)) {
					System.out.printf("number %d is Prime\n",number);
				}
				if (isInterrupted()) {
					System.out.printf("The Prime Generator has bean Interrupted");
					return;
				}
				number++;
			}


		}

		private boolean isPrime(long number){
			if (number<2) {
				return true;
			}
			for (long i = 2; i < number; i++) {
				if ((number%2) == 0) {
					return false;
				}
			}
			return true;
		}

	}

	private static class DataSourceLoader implements Runnable{
		@Override
		public void run() {
			System.out.printf("Beginning data sources loading : %s\n",new Date());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Data sources loading has finished:%s\n",new Date());
		}
	}
	private static class NetworkConnectionsLoader implements Runnable{
		@Override
		public void run() {
			System.out.printf("Beginning Network Connection loading : %s\n",new Date());
			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Data Network Connection has finished: %s\n",new Date());
		}
	}

	private static class WriteTask implements Runnable{

		private Deque<Event> deque;

		public WriteTask(Deque<Event> deque){
			this.deque = deque;
		}
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				Event event = new Event();
				event.setDate(new Date());
				event.setEvent(String.format("the thread %s has generated an event", Thread.currentThread().getId()));
				deque.addFirst(event);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class CleanerTask extends Thread{
		private Deque<Event> deque;
		public CleanerTask(Deque<Event> deque){
			this.deque = deque;
			setDaemon(true);
		}
		@Override
		public void run() {
			while (true) {
				Date date = new Date();
				clean(date);
			}
		}

		private void clean(Date date){
			long difference;
			boolean delete;
			if(deque.size() == 0){
				return;
			}
			delete = false;
			do {
				Event e = deque.getLast();
				difference = date.getTime() - e.getDate().getTime();
				if (difference >10000) {
					System.out.printf("Cleaner:%s\n",e.getEvent());
					deque.removeLast();
					delete = true;
				}
			} while (difference >10000);
			if (delete) {
				System.out.printf("Cleaner:Size of the queue:%d\n",deque.size());
			}
		}
	}

	private static class Task implements Runnable{
		@Override
		public void run() {
			int numero = Integer.parseInt("123");
			System.out.println(numero);
		}
	}

	public static class ExceptionHandler implements UncaughtExceptionHandler{
		public void uncaughtException(Thread t, Throwable e) {
			System.out.printf("An exception has been captured\n");
			System.out.printf("Thread: %s\n",t.getId());
			System.out.printf("Exception: %s: %s\n",e.getClass().
					getName(),e.getMessage());
			System.out.printf("Stack Trace: \n");
			e.printStackTrace(System.out);
			System.out.printf("Thread status: %s\n",t.getState());
		}
	}

	public static class UnSafeTask implements Runnable{

		private Date startDate;
		@Override
		public void run() {
			startDate = new Date();
			synchronized (startDate) {
				System.out.printf("Starting Thread: %s : %s\n",Thread.
						currentThread().getId(),startDate);
				try {
					TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("Thread Finished: %s : %s\n",Thread.
						currentThread().getId(),startDate);
			}
		}
	}

	public static class SafeTask implements Runnable{

		private ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
			protected Date initialValue() {
				return new Date();
			};
		};
		@Override
		public void run() {
			System.out.printf("Starting Thread: %s : %s\n",Thread.
					currentThread().getId(),startDate.get());
			try {
				TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Thread Finished: %s : %s\n",Thread.
					currentThread().getId(),startDate.get());
		}
	}

	private static class SearchTask implements Runnable{
		private Result result;

		public SearchTask(Result result){
			this.result = result;
		}
		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.printf("Thread %s:start\n", name);
			try {
				doTask();
			} catch (InterruptedException e) {
				System.out.printf("Thread %s: Interrupted\n",name);
				return;
			}
			System.out.printf("Thread %s: End\n",name);
		}

		private void doTask() throws InterruptedException{
			Random random = new Random((new Date()).getTime());
			int value = (int)(random.nextDouble()*100);
			System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
			TimeUnit.SECONDS.sleep(value);
		}
	}
	private static void waitFinish(ThreadGroup threadGroup) {  
		while (threadGroup.activeCount() > 4) {  
			try {  
				TimeUnit.SECONDS.sleep(1);  
			} catch (InterruptedException e) {  
				e.printStackTrace();  
			}  
		}  
	}  

	private static class MyThreadFactory implements ThreadFactory{

		private int counter;
		private String name;
		private List<String> stats;

		public MyThreadFactory(String name){
			counter = 0;
			this.name = name;
			stats = new ArrayList<String>();
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r,name+"-Thread_"+counter);
			counter++;
			stats.add(String.format("Created thread %d with name %s on %s\n", thread.getId(),thread.getName(),new Date()));
			return thread;
		}

		public String getStats(){
			StringBuffer buffer = new StringBuffer();
			Iterator<String> it = stats.iterator();
			while (it.hasNext()) {
				buffer.append(it.next());
				buffer.append("\n");
			}
			return buffer.toString();
		}
	}

	private static class Bank implements Runnable{
		private Account account;
		public Bank(Account account){
			this.account = account;
		}
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				this.account.subtractAmount(1000);
			}
		}
	}

	private static class Company implements Runnable{
		private Account account;
		public Company(Account account){
			this.account = account;
		}
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				this.account.addAmount(1000);
			}
		}
	}

	private static class Producer implements Runnable{

		private EventStorage storage;
		public Producer(EventStorage storage){
			this.storage=storage;
		}

		@Override
		public void run() {
			for (int i=0; i<100; i++){
				storage.set();
			}
		}

	}
	private static class Consumer implements Runnable {
		private EventStorage storage;
		public Consumer(EventStorage storage){
			this.storage=storage;
		}
		@Override
		public void run() {
			for (int i=0; i<100; i++){
				storage.get();
			}
		}
	}
	
	public static void testReadWriteLockTest()throws Exception{
		final EventLock event = new EventLock();
		Runnable task1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				event.addValue(55.55);
			}
		};
		Runnable task2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				event.getValue();
			}
		};
		ExecutorService cacheService = Executors.newCachedThreadPool();
		Future future1 = null;
		for (int i = 0; i < 2; i++) {
			future1 = cacheService.submit(task1);
		}
		for (int i = 0; i < 2; i++) {
			future1 = cacheService.submit(task2);
		}
		future1 = cacheService.submit(task1);
		// 这5个任务的执行顺序应该是：  
        // 第一个task_1先执行，第二个task_1再执行；这是因为不能同时写，所以必须等。  
        // 然后2个task_2同时执行；这是因为在写的时候，就不能读，所以都等待写结束，  
        // 又因为可以同时读，所以它们同时执行  
        // 最后一个task_1再执行。这是因为在读的时候，也不能写，所以必须等待读结束后，才能写。  
          
        // 等待最后一个task_2被执行完  
		future1.get();
		cacheService.shutdown();
	}


}
