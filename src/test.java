import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pattern.singleton.SingletonWithNoSyn;



public class test {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {





		//		int size = 3;
		//		//		List<Integer> data = new ArrayList<>();
		//		//		String tempUrl = "http://114.2.2.2/abc/aaaa.jpg";
		//		//		System.out.println(getUrl(tempUrl, "bbbb"));
		//
		//		//		String temp = "wuxi,songshui,banjia,baojie,bmu,bijibenweixiu,cuirushi,bangonghuishou,diannaohuishou,dianqihuishou	,dianzihs,fangzhipige,jiajuhuishou,feijiuhuishou,jinshuhuishou,lipinhuishou,huishoushebei,shechiphs,ershoushichang,dianzichanpin,dakong,dengjuwx,dianlu,fangshui,fenshuafangfu,menchweixiu,shuiguan,weiyuwx,fuwuqiweixiu,shutong,dalao,gycwx,gongyegd,fencist,weijust,szgdqy,xiashuidao,bgjjwx,kaisuo,shafahuli,zhongbiaowx,leihu,paotui,pijuyanghu,ipadpingbanweixiu,sewai,pgshj,shujuhuifu,dandianwx,danfanwx	daohangyiwx	lysbwxiu	shexiangjiwx	shumaxiangjiwx	youxijiwx	shucai	songmi	songqi	taishidiannao	wangluoweixiu	lipinxianhua	ganxi	yibaogaizhi	yuesao	yuyingshi	zhongdiangong";
		//		//	    temp = temp.replaceAll("	", ",");
		//		//	    System.out.println(temp);
		//		//		String ss[] = new String[]{"dfd","ds","sdf"};
		//		//		ss = Arrays.copyOf(ss, 2*size+1);
		//		//		for (int i = 0; i < ss.length; i++) {
		//		//			System.out.println(ss[i]);
		//		//		}
		//		//		System.out.println(ss.length);
		//		//		Set<String> s = new TreeSet<String>();
		//		Set<String> s = new HashSet<>();   
		//		String sss = "hello";
		//		String qwe = "hello";
		//		String sss1 = new String("hello");
		//		s.add("hello");
		//		s.add("bdfd");
		//		s.add("adf");
		//		s.add("adf");
		//		s.add(sss);
		//		s.add(qwe);
		//		s.add(sss1);
		//		
		//
		//		System.out.println(s);
		//
		//		List<String> list = new ArrayList<>();
		//		for (int i = 0; i < 22; i++) {
		//			String ss = "sdfdf="+i;
		//			list.add(ss);
		//		}
		//		List<String> ssss = list.subList(3, 6);
		//		for (int i = 0; i < ssss.size(); i++) {
		//			System.out.println(ssss.get(i));
		//		}
		//		
		//		int d = 1431944020;
		////		long time = (long)d*1000;
		////		System.out.println(time);
		//		long lastTime = d-8*24*60*60;
		//		System.out.println(lastTime);
		//		Date date = new Date(lastTime*1000);
		//		Calendar cal = Calendar.getInstance();
		//		cal.setTimeInMillis(lastTime*1000);
		//		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		//		System.out.println(cal.get(Calendar.MONTH));
		//		System.out.println(cal.get(Calendar.YEAR));

		//		String name = "[user:111:@ddd ]";
		//		int startIndex = name.indexOf("[user:");
		//		int endIndex = name.indexOf("@");
		//		System.out.println(name.substring(startIndex+6, endIndex-1));
		////		System.out.println(hexToStringGBK("3134342e706e67"));
		//		System.out.println(toHexString("X ray")+toHexString(".db"));

		//		Base a = new ObjectD();
		//		a.fm();
		//		int count = 12;
		//		System.out.println(11%count);
		//		String ss = "1+322-121+1-1+98";
		//		int sum = 0;
		//		List<String> temp = getNumbers(ss);
		//		for (int i = 0; i < temp.size(); i++) {
		//			System.out.println(temp.get(i));
		//			sum+=Integer.parseInt(temp.get(i));
		//		}
		//		System.out.println(sum);
		//		
		//		int[] num = {6,4,1,2,5,3};
		//		maopao(num);
		//		
		//		Object a = new Object();
		//		Object b = new Object();
		//		Object c = new Object();
		//		MyThread aThread = new MyThread("a", c, a);
		//		MyThread bThread = new MyThread("b", a, b);
		//		MyThread cThread = new MyThread("c", b, c);
		//		new Thread(aThread).start();
		//		try {
		//			Thread.sleep(1000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}
		//		new Thread(bThread).start();
		//		try {
		//			Thread.sleep(1000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}
		//		new Thread(cThread).start();
		//		try {
		//			Thread.sleep(1000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}

		//		Singleton.getInstance();
		//		Singleton ton = new Singleton();

		//		Thread thread1 = new Thread(tast);
		//		Thread thread2 = new Thread(tast);
		//		Thread thread3 = new Thread(tast);
		//		Thread thread4 = new Thread(tast);
		//		thread1.start();
		//		thread2.start();
		//		thread3.start();
		//		thread4.start();
		//		String spanStr = "图查看链接";
		//		String URL = "";
		//		String message = "www.qq@126.com";
		//		Pattern p = Pattern.compile(URL, Pattern.CASE_INSENSITIVE);
		//        Matcher matcher = p.matcher(message);
		//        while (matcher.find()) { //替换文本中的链接为 spanStr 并保存URL
		//            String url = matcher.group();
		//            message = message.replace(url, spanStr);
		//            System.out.println(message);
		//        }
		//		float s = 0.01f;
		//		System.out.println(s*10);

		//	Date date1 = new Date(System.currentTimeMillis());
		//	Date date2 = new Date(System.currentTimeMillis()-25*60*60*1000);
		//	System.out.println(areSomeDay(date1, date2));
		//	
		//		ChildClass temp = new ChildClass();
		//		try {
		//			FileWriter writer = new FileWriter(new File("test.txt"));
		//			long beginTime = System.currentTimeMillis();
		//			int circle = 100000;
		//			for (int i = 0; i < circle; i++) {
		//				writer.write(i);
		//			}
		//			writer.close();
		//			System.out.println("testFileWriter spend:"+(System.currentTimeMillis()-beginTime));
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//		
		//		try {
		//			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("test.txt")));
		//			long beginTime = System.currentTimeMillis();
		//			int circle = 100000;
		//			for (int i = 0; i < circle; i++) {
		//				writer.write(i);
		//			}
		//			writer.close();
		//			System.out.println("testFileBufferedWriter spend:"+(System.currentTimeMillis()-beginTime));
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//		String sss = "a;b;c;d;s;d;s;a;we;t;asdf;fa;;s;fsd;fs;f;sdf;df;";
		//		String str1 = "abc";
		//		String str2 = "abc";
		//		String str3 = new String("abc");
		//		System.out.println(str1 == str2);
		//		System.out.println(str1 == str3);
		//		System.out.println(str1 == str3.intern());
		//		StringTokenizer str = new StringTokenizer(sss);
		//		while (str.hasMoreTokens()) {
		//			System.out.println(str.nextToken(";"));
		//		}
		//		StringBuffer
//		copyFile();
		
//		MyObject obj = new MyObject();
//		ReferenceQueue<MyObject> softQueue = new ReferenceQueue<MyObject>();
//		SoftReference<MyObject> softRef = new SoftReference<MyObject>(obj,softQueue);
		int numb =8;
		for (int i=0; i<numb/2; i++) {
			for (int j = 0;j < 2;j++){				
				System.out.println(i*2+j);
			}
		}
	}


	private static void copyFile(){
		try {
			FileInputStream fis = new FileInputStream(new File("test.txt"));
			FileOutputStream fos = new FileOutputStream(new File("copy_test.txt"));
			FileChannel readChannel = fis.getChannel();
			FileChannel writeChannel = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			try {
				while (true) {
					buffer.clear();

					int len = readChannel.read(buffer);
					if(len == -1){
						break;
					}
					buffer.flip();
					writeChannel.write(buffer);
				}
				readChannel.close();
				writeChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean areSomeDay(Date dateA, Date dateB) {
		Calendar calDateA = Calendar.getInstance();
		calDateA.setTime(dateA);

		Calendar calDateB = Calendar.getInstance();
		calDateB.setTime(dateB);

		return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
				&& calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
				&& calDateA.get(Calendar.DAY_OF_MONTH) == calDateB
				.get(Calendar.DAY_OF_MONTH);
	}


	public static Runnable tast = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				SingletonWithNoSyn.getInstance();
			}
		}
	};


	private static void maopao(int[] numbers){
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length-i-1; j++) {
				if(numbers[j]>numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	public static class MyThread implements Runnable{
		private String name;
		private Object pre;
		private Object self;
		public MyThread(String name,Object a,Object b){
			this.name = name;
			this.pre = a;
			this.self = b;
		}
		@Override
		public void run() {
			int count = 10;
			while(count>0){
				synchronized (this.pre) {
					synchronized (this.self) {
						System.out.println(this.name);
						count--;
						this.self.notify();
					}
					try {
						this.pre.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static List<String> getNumbers(String s){
		List<String> numbers = new ArrayList<String>();
		String[] addNumber = s.split("\\+");
		for(int i = 0;i<addNumber.length;i++){
			String temp = addNumber[i];
			String[] delNumber = temp.split("-");
			if(delNumber!=null&&delNumber.length>1){
				for (int j = 0; j < delNumber.length; j++) {
					String number = null;
					if(j != 0){
						number = "-"+delNumber[j];
					}else{
						number = delNumber[j];
					}
					numbers.add(number);
				}
			}else{
				numbers.add(delNumber[0]);
			}
		}
		return numbers;
	}

	public static String getUrl(String tempUrl,String addStr){
		StringBuffer url = new StringBuffer();
		int tempIndex = tempUrl.lastIndexOf("/");
		url.append(tempUrl.substring(0,tempIndex+1));
		url.append(addStr+"_"+tempUrl.substring(tempIndex+1,tempUrl.length()));
		return url.toString();
	}
	public static String getString(String strs){
		try {
			strs = new String(strs.getBytes("utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strs;
	}

	public static String hexToStringGBK(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		try {
			s = new String(baKeyword, "GBK");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
			return "";
		}
		return s;
	}
	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	//	@Test
	//	public void test throws Exception{
	//		Singleton s1 = null;
	//		Singleton s = Singleton.getInstance();
	//		//先将实例串行化到文件
	//		FileOutputStream fos = new FileOutputStream("serSingleton.txt");
	//		ObjectOutputStream oos = new ObjectOutputStream(fos);
	//		oos.writeObject(s);
	//		oos.flush();
	//		oos.close();
	//		//从文件读出原有的单例类
	//		FileInputStream fis = new FileInputStream("serSingleton.txt");
	//		ObjectInputStream ois = new ObjectInputStream(fis);
	//		s1 = (Singleton) ois.readObject();
	//		Assert.assertEquals(s1,s);
	//	}
}
